package DAO;

import DTO.ManutencaoDTO;
import Tela.TelaManutencao;
import java.sql.*;
import javax.swing.JOptionPane;

public class ManutencaoDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public int getIdNome(String nome) {

        String sql = "SELECT id FROM manutencao WHERE maquinaNome = ?";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, nome);
            if (rs.next()) {
                int getId;
                getId = rs.getInt("id");
            }
        }  catch(SQLException erro){
            
        } 
        return getId;
    }
    
    public void cadastrarManutencao(ManutencaoDTO manutencao) {
        String sql = "INSERT INTO Manutencao (maquinaNome, tecnicoNome, tipo, descricao) VALUES (?, ?, ?, ?)";
        conexao = ConexaoDAO.conector();
        try {

            pst = conexao.prepareStatement(sql);
            pst.setString(1, manutencao.getMaquinaNome());
            pst.setString(2, manutencao.getTecnicoNome());
            pst.setString(3, manutencao.getTipo());
            pst.setString(4, manutencao.getDescricao());

            int add = pst.executeUpdate();
            if (add > 0) {

                pst.close();
                limparCampos();
                JOptionPane.showMessageDialog(null, "Manutenção cadastrada com sucesso! ");
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "cadastrar" + erro.getMessage());
        }
    }

    public ResultSet listarMaquinas() {
        String sql = "SELECT nome FROM Maquina";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar máquinas: " + erro.getMessage());
        }
        return rs;
    }

    public ResultSet listarUsuarios() {
        String sql = "SELECT nome FROM Usuario";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar usuários: " + erro.getMessage());
        }
        return rs;
    }

    public void limparCampos() {
        TelaManutencao.txtDescricao.setText(null);
        TelaManutencao.cbNomeTec.setSelectedItem("Selecione");
        TelaManutencao.cbTipo.setSelectedItem("Selecione");
        TelaManutencao.cbNomeMaquina.setSelectedItem("Selecione");
    }
}

