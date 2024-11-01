package DAO;

import DTO.LaboratorioDTO;
import java.sql.*;
import javax.swing.JOptionPane;

public class LaboratorioDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public void cadastrarLaboratorio(LaboratorioDTO lab1) throws SQLException {
        String sql = "INSERT INTO Laboratorio (nome)" + "VALUES (?)";
        conexao = ConexaoDAO.conector();
        try {
            pst = conexao.prepareStatement(sql);                      
            pst.setString(1, lab1.getNome());
            
            int add  = pst.executeUpdate();
            if (add > 0) {
                pst.close();
                JOptionPane.showMessageDialog(null, "Laboratório inserido com sucesso! ");
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}

