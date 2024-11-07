package DAO;

import DTO.LaboratorioDTO;
import Tela.TelaLaboratorio;
import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;

public class LaboratorioDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public void cadastrarLaboratorio(LaboratorioDTO lab1){
        String sql = "INSERT INTO Laboratorio (nome)" + "VALUES (?)";
        conexao = ConexaoDAO.conector();
        try {
            pst = conexao.prepareStatement(sql);                      
            pst.setString(1, lab1.getNome());
            
            int add  = pst.executeUpdate();
            if (add > 0) {
                pst.close();
                limparCampos();
                JOptionPane.showMessageDialog(null, "Laboratório inserido com sucesso! ");
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
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
                conexao.close();
                limparCampos();
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, " Método deletar " + e);
        }
    }
     
     public void editar(LaboratorioDTO lab1) {
        String sql = "update Laboratorio set nome = ?";
        conexao = ConexaoDAO.conector();
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, lab1.getNome());
            
            int add = pst.executeUpdate();
            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Laboratório editado com sucesso!");
                conexao.close();
                limparCampos();
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, " Método editar " + e);
        }
    }
     
     public void pesquisar(LaboratorioDTO lab1) {
        String sql = "select * from laboratorio where nome = ?";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, lab1.getNome());
            rs = pst.executeQuery();

            if (rs.next()) {
                TelaLaboratorio.txtNome.setText(rs.getString(2));
                JOptionPane.showMessageDialog(null, "Laboratório encontrado");
                conexao.close();
            } else {
                JOptionPane.showMessageDialog(null, "Laboratório não cadastrado!");
            }

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, " Método Pesquisar" + e);
        }
    }
    public void limparCampos() {
        TelaLaboratorio.txtNome.setText(null);
    }
}
    



            
                       

         
        
    



