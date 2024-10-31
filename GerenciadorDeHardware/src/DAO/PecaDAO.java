package DAO;

import DTO.PecaDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PecaDAO {


    public void cadastrarPeca(PecaDTO peca) throws SQLException {
        String sql = "INSERT INTO Peca (tipo, fabricante, quantidade) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoDAO.conector();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, peca.getTipo());
            stmt.setString(2, peca.getFabricante());
            stmt.setInt(3, peca.getQuantidade());
            stmt.executeUpdate();
        }
    }

    public List<PecaDTO> listarPecas() throws SQLException {
        List<PecaDTO> pecas = new ArrayList<>();
        String sql = "SELECT * FROM Peca";

        try (Connection conn = ConexaoDAO.conector();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                PecaDTO peca = new PecaDTO(
                        rs.getString("tipo"),
                        rs.getString("fabricante"),
                        rs.getInt("quantidade")
                );
                peca.setId(rs.getInt("id"));
                pecas.add(peca);
            }
        }
        return pecas;
    }

    public void atualizarQuantidade(int id, int novaQuantidade) throws SQLException {
        String sql = "UPDATE Peca SET quantidade = ? WHERE id = ?";

        try (Connection conn = ConexaoDAO.conector();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, novaQuantidade);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }
}

