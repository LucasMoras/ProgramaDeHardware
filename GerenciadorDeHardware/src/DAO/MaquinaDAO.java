package DAO;

import DTO.MaquinaDTO;
import Tela.TelaMaquina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class MaquinaDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public void cadastrarMaquina(MaquinaDTO maquina){
        String sql = "INSERT INTO Maquina (nome, laboratorioNome, processador, ram, armazenamento, statuss) VALUES (?, ?, ?, ?, ?, ?)";
        conexao = ConexaoDAO.conector();
        
        try {          
            pst = conexao.prepareStatement(sql);
            pst.setString(1, maquina.getNome());
            pst.setString(2, maquina.getLaboratorioNome());
            pst.setString(3, maquina.getCpu());
            pst.setString(4, maquina.getRam());
            pst.setString(5, maquina.getArmazenamento());
            pst.setString(6, maquina.getStatus());
            pst.executeUpdate();  
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);   
        }
    }
    
        public void pesquisar(MaquinaDTO maquina) {
        String sql = "select * from Maquina where nome = ?";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);                      
            pst.setString(1, maquina.getNome());        
            rs = pst.executeQuery();
            
            if (rs.next()) {
                TelaMaquina.txtNome.setText(rs.getString(1));
                TelaMaquina.txtCPU.setText(rs.getString(2));
                TelaMaquina.txtRAM.setText(rs.getString(3));
                TelaMaquina.txtROM.setText(rs.getString(4));
                TelaMaquina.cbLabin.setSelectedItem(rs.getString(5));
                TelaMaquina.cbStatus.setSelectedItem(rs.getString(6));
                conexao.close();
            } else {
                JOptionPane.showMessageDialog(null, "Maquina não cadastrada!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Método Pesquisar" + e);
        }
    }
}

