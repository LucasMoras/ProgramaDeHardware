package DAO;

import DTO.LaboratorioDTO;
import Tela.TelaLaboratorio;
import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class LaboratorioDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void cadastrarLaboratorio(LaboratorioDTO lab1) {
        String sql = "INSERT INTO Laboratorio (nome)" + "VALUES (?)";
        conexao = ConexaoDAO.conector();
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, lab1.getNome());

            int add = pst.executeUpdate();
            if (add > 0) {
                pesquisaAuto();
                pst.close();
                limparCampos();
                JOptionPane.showMessageDialog(null, "Laboratório inserido com sucesso! ");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void pesquisaAuto() {

        String sql = "select * from Laboratorio";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) TelaLaboratorio.tbLabin.getModel();
            model.setNumRows(0);

            while (rs.next()) {
                String id = rs.getString("Id");
                String nome = rs.getString("nome");
                model.addRow(new Object[]{id, nome});
            }
            conexao.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Método Pesquisar Automático " + e);
        }
    }

    public void deletar(LaboratorioDTO lab1) {
        String sql = "delete from Laboratorio where nome = ?";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, lab1.getNome());
            int del = pst.executeUpdate();
            if (del > 0) {
                JOptionPane.showMessageDialog(null, " Laboratório deletado com sucesso!");
                pesquisaAuto();
                conexao.close();
                limparCampos();
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, " Método deletar " + e);
        }
    }

    public void editar(LaboratorioDTO lab1) {
        String sql = "update Laboratorio set nome = ? where id = ?";
        conexao = ConexaoDAO.conector();
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, lab1.getNome());
            pst.setInt(2, lab1.getId());

            int add = pst.executeUpdate();
            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Laboratório editado com sucesso!");
                pesquisaAuto();
                conexao.close();
                limparCampos();
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, " Método editar " + e);
        }
    }

    public void limparCampos() {
        TelaLaboratorio.txtId.setText(null);
        TelaLaboratorio.txtNome.setText(null);
    }
}
