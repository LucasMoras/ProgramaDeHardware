package DAO;

import java.sql.*;
import DTO.MaquinaDTO;
import Tela.TelaMaquina;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class MaquinaDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void cadastrarMaquina(MaquinaDTO maquina) {
        String sql = "INSERT INTO Maquina (nome, LaboratorioNome, processador, ram, armazenamento, statuss) VALUES ( ?, ?, ?, ?, ?, ?)";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, maquina.getNome());
            pst.setString(2, maquina.getLaboratorioNome());
            pst.setString(3, maquina.getCpu());
            pst.setString(4, maquina.getRam());
            pst.setString(5, maquina.getArmazenamento());
            pst.setString(6, maquina.getStatus());

            int add = pst.executeUpdate();
            if (add > 0) {

                pst.close();
                limparCampos();
                JOptionPane.showMessageDialog(null, "Maquina inserida com sucesso! ");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "cadastrar" + e.getMessage());
        }
    }

    public void editar(MaquinaDTO maq1) {
        String sql = "update Maquina set nome = ?, processador = ?, ram = ?, armazenamento = ?, laboratorioNome = ?, statuss = ? where id = ?";
        conexao = ConexaoDAO.conector();
        try {

            pst = conexao.prepareStatement(sql);
            pst.setString(1, maq1.getNome());
            pst.setString(2, maq1.getCpu());
            pst.setString(3, maq1.getRam());
            pst.setString(4, maq1.getArmazenamento());
            pst.setString(5, maq1.getLaboratorioNome());
            pst.setString(6, maq1.getStatus());
            pst.setInt(7, maq1.getId());
            int add = pst.executeUpdate();

            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Maquina editada com sucesso!");
                conexao.close();
                limparCampos();
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, " Método editar " + erro);
        }
    }

    public ResultSet listarLabins() {

        String sql = "select nome from laboratorio";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "hum" + erro.getMessage());
        }
        return rs;
    }

    public void pesquisar(MaquinaDTO maquina) {

        String sql = "select * from Maquina where nome = ?";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, maquina.getNome());
            rs = pst.executeQuery();

            if (rs.next()) {
                TelaMaquina.txtNome.setText(rs.getString("nome"));
                TelaMaquina.txtCPU.setText(rs.getString("processador"));
                TelaMaquina.txtRAM.setText(rs.getString("ram"));
                TelaMaquina.txtROM.setText(rs.getString("armazenamento"));
                TelaMaquina.cbLabin.setSelectedItem(rs.getString("laboratorioNome"));
                TelaMaquina.cbStatus.setSelectedItem(rs.getString("statuss"));
                TelaMaquina.txtId.setText(rs.getString("id"));
                conexao.close();
            } else {
                JOptionPane.showMessageDialog(null, "Maquina não cadastrada!");
            }

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, " Método Pesquisar" + e);
        }
    }

    public void deletar(MaquinaDTO ma1) {
        String sql = "delete from Maquina where nome = ?";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, ma1.getNome());
            int del = pst.executeUpdate();
            if (del > 0) {
                JOptionPane.showMessageDialog(null, " Maquina deletada com sucesso!");
                conexao.close();
                limparCampos();
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, " Método deletar " + e);
        }
    }

    public void limparCampos() {
        TelaMaquina.txtNome.setText(null);
        TelaMaquina.txtCPU.setText(null);
        TelaMaquina.txtRAM.setText(null);
        TelaMaquina.txtROM.setText(null);
        TelaMaquina.cbLabin.setSelectedItem("Selecione");
        TelaMaquina.cbStatus.setSelectedItem("Selecione");
        TelaMaquina.txtId.setText(null);
    }
}
