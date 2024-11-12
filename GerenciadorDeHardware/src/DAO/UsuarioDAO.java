package DAO;

import DTO.UsuarioDTO;
import Tela.TelaPrincipal;
import Tela.TelaUsuario;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
                pesquisaAuto();
            }
        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, " Método Inserir " + erro);
        }
    }

    public void pesquisaAuto() {

        String sql = "select * from usuario";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) TelaUsuario.tbUsu.getModel();
            model.setNumRows(0);

            while (rs.next()) {
                String id = rs.getString("Id");
                String nome = rs.getString("nome");
                String perfil = rs.getString("perfil");
                model.addRow(new Object[]{id, nome, perfil});
            }
            conexao.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Método Pesquisar Automático " + e);
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
                pesquisaAuto();
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

                if (perfil.equals("Técnico")) {
                    TelaPrincipal principal = new TelaPrincipal();
                    principal.setVisible(true);
                    TelaPrincipal.bntCadastroCli.setEnabled(false);
                    conexao.close();
                } else {
                    TelaPrincipal principal = new TelaPrincipal();
                    principal.setVisible(true);
                    conexao.close();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuário e/ou senha invalidos");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "** tela Login ***" + e);
        }
    }

    public void limparCampos() {
        TelaUsuario.txtId.setText(null);
        TelaUsuario.txtNome.setText(null);
        TelaUsuario.txtSenha.setText(null);
        TelaUsuario.cbPerfil.setSelectedItem("Selecione");
    }
}
