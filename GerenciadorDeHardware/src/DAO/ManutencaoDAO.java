package DAO;

import DTO.ManutencaoDTO;
import Tela.TelaManutencao;
import java.sql.*;
import javax.swing.JOptionPane;

public class ManutencaoDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    
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

    public void excluirManutencaoPorId(int id) {
    String sql = "DELETE FROM Manutencao WHERE id = ?";
    conexao = ConexaoDAO.conector();

    try {
        pst = conexao.prepareStatement(sql);
        pst.setInt(1, id);
        int deletado = pst.executeUpdate();
        
        if (deletado > 0) {
            JOptionPane.showMessageDialog(null, "Manutenção excluída com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao excluir manutenção.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao excluir manutenção: " + e.getMessage());
    } finally {
        try {
            if (pst != null) pst.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar recursos: " + e.getMessage());
        }
    }
}
    
    public void limparCampos() {
        TelaManutencao.txtDescricao.setText(null);
        TelaManutencao.cbNomeTec.setSelectedItem("Selecione");
        TelaManutencao.cbTipo.setSelectedItem("Selecione");
        TelaManutencao.cbNomeMaquina.setSelectedItem("Selecione");
    }
}

