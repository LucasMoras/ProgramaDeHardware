package DAO;

import DTO.UsuarioDTO;
import Tela.TelaPrincipal;
import Tela.TelaUsuario;
import java.sql.*;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void inserirUsuario(UsuarioDTO UsuDTO) {
        String sql = "insert into Usuario (nome, senha, perfil)" + "values (?, ?, ?)";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, UsuDTO.getNome());
            pst.setString(2, UsuDTO.getSenha());
            pst.setString(3, UsuDTO.getPerfil());

            int add = pst.executeUpdate();
            if (add > 0) {
                pst.close();
                limparCampos();
                JOptionPane.showMessageDialog(null, "Usuário inserido com sucesso! ");
            }
        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, " Método Inserir " + erro);
        }
    }

    public void deletar(UsuarioDTO usu1) {
        String sql = "delete from usuario where nome = ?";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, usu1.getNome());
            int del = pst.executeUpdate();
            if (del > 0) {
                JOptionPane.showMessageDialog(null, " Usuario deletado com sucesso!");
                conexao.close();
                limparCampos();
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, " Método deletar " + erro);
        }
    }

    public void editar(UsuarioDTO usu1) {
        String sql = "update usuario set nome = ?, senha = ?, perfil = ? where id = ?";
        conexao = ConexaoDAO.conector();
        try {

            pst = conexao.prepareStatement(sql);
            pst.setString(1, usu1.getNome());
            pst.setString(2, usu1.getSenha());
            pst.setString(3, usu1.getPerfil());
            pst.setInt(4, usu1.getId());
            int add = pst.executeUpdate();

            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Usuario editado com sucesso!");
                conexao.close();
                limparCampos();
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, " Método editar " + erro);
        }
    }

    public void pesquisar(UsuarioDTO UsuDTO) {
        String sql = "select * from usuario where nome = ?";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, UsuDTO.getNome());
            rs = pst.executeQuery();
            if (rs.next()) {
                TelaUsuario.txtId.setText(rs.getString(1));
                TelaUsuario.txtSenha.setText(rs.getString(3));
                TelaUsuario.cbPerfil.setSelectedItem(rs.getString(4));
                conexao.close();
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não cadastrado!");
                limparCampos();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Método Pesquisar" + e);
        }
    }

    public void logar(UsuarioDTO UsuDTO) {
        String sql = "select * from Usuario where nome = ? and senha = ?";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, UsuDTO.getNome());
            pst.setString(2, UsuDTO.getSenha());

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
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "tela Login" + erro);
        }
    }

    public void limparCampos() {
        TelaUsuario.txtId.setText(null);
        TelaUsuario.txtNome.setText(null);
        TelaUsuario.txtSenha.setText(null);
        TelaUsuario.cbPerfil.setSelectedItem("Selecione");
    }
}
