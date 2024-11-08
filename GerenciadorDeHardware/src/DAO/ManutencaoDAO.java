package DAO;

import DTO.ManutencaoDTO;
import java.sql.*;

public class ManutencaoDAO {

    public void cadastrarManutencao(ManutencaoDTO manutencao) throws SQLException {
        String sql = "INSERT INTO Manutencao (maquinaNome, tecnicoNome, tipo, descricao) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoDAO.conector();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, manutencao.getMaquinaNome());
            stmt.setString(2, manutencao.getTecnicoNome());
            stmt.setString(3, manutencao.getTipo());
            stmt.setString(4, manutencao.getDescricao());
            stmt.executeUpdate();
        }
    }
}

