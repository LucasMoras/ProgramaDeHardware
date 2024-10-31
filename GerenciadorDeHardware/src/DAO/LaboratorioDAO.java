package DAO;

import DTO.LaboratorioDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LaboratorioDAO {

    public void cadastrarLaboratorio(LaboratorioDTO laboratorio) throws SQLException {
        String sql = "INSERT INTO Laboratorio (nome, localizacao) VALUES (?, ?)";

        try (Connection conn = ConexaoDAO.conector();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, laboratorio.getNome());
            stmt.setString(2, laboratorio.getLocalizacao());
            stmt.executeUpdate();
        }
    }

    public List<LaboratorioDTO> listarLaboratorios() throws SQLException {
        List<LaboratorioDTO> laboratorios = new ArrayList<>();
        String sql = "SELECT * FROM Laboratorio";

        try (Connection conn = ConexaoDAO.conector();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                LaboratorioDTO laboratorio = new LaboratorioDTO(
                        rs.getString("nome"),
                        rs.getString("localizacao")
                );
                laboratorio.setId(rs.getInt("id"));
                laboratorios.add(laboratorio);
            }
        }
        return laboratorios;
    }
}

