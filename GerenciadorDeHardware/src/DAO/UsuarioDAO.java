package DAO;

import DTO.UsuarioDTO;
import Tela.TelaPrincipal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class UsuarioDAO {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void logar(UsuarioDTO objusuarioDTO) {
        String sql = "select * from Usuario where nome = ? and senha = ?";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, objusuarioDTO.getLogin_usuario());
            pst.setString(2, objusuarioDTO.getSenha_usuario());

            rs = pst.executeQuery();

            if (rs.next()) {
                String perfil = rs.getString(4);
               System.out.println(perfil);

                    TelaPrincipal principal = new TelaPrincipal();
                    principal.setVisible(true);
                    conexao.close();                

            } else {
                JOptionPane.showMessageDialog(null, "Usuário e/ou senha invalidos");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "* tela Login *" + e);
        }
    }
}
