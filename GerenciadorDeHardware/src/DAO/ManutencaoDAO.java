package DAO;

import DTO.ManutencaoDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManutencaoDAO {

    public void cadastrarManutencao(ManutencaoDTO manutencao) throws SQLException {
        String sql = "INSERT INTO Manutencao (maquina_id, tipo, descricao, data) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoDAO.conector();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, manutencao.getMaquinaId());
            stmt.setString(2, manutencao.getTipo());
            stmt.setString(3, manutencao.getDescricao());
            stmt.setDate(4, new java.sql.Date(manutencao.getData().getTime()));
            stmt.executeUpdate();
        }
    }

    public List<ManutencaoDTO> listarManutencoes() throws SQLException {
        List<ManutencaoDTO> manutencoes = new ArrayList<>();
        String sql = "SELECT * FROM Manutencao";

        try (Connection conn = ConexaoDAO.conector();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
               ManutencaoDTO man1 = new ManutencaoDTO(
                        rs.getInt("maquina_id"),
                        rs.getString("tipo"),
                        rs.getString("descricao"),
                        rs.getDate("data")

                );
                man1.setId(rs.getInt("id"));
                manutencoes.add(man1);
            }
        }
        return manutencoes;
    }
}

