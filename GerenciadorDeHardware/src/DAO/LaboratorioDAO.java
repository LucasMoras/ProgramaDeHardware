package DAO;

import DTO.LaboratorioDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LaboratorioDAO {

    public void cadastrarLaboratorio(LaboratorioDTO laboratorio) throws SQLException {
        String sql = "INSERT INTO Laboratorio (nome) VALUES (?)";

        try (Connection conn = ConexaoDAO.conector();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, laboratorio.getNome());
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
                LaboratorioDTO lab1 = new LaboratorioDTO(
                        rs.getString("nome")
                );
                lab1.setId(rs.getInt("id"));
                laboratorios.add(lab1);
            }
        }
        return laboratorios;
    }
}

