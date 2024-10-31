package DAO;

import DTO.MaquinaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MaquinaDAO {

    public void cadastrarMaquina(MaquinaDTO maquina) throws SQLException {
        String sql = "INSERT INTO Maquina (laboratorio_id, cpu, ram, armazenamento, status) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoDAO.conector();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, maquina.getLaboratorioId());
            stmt.setString(2, maquina.getCpu());
            stmt.setInt(3, maquina.getRam());
            stmt.setInt(4, maquina.getArmazenamento());
            stmt.setString(5, maquina.getStatus());
            stmt.executeUpdate();
        }
    }

    public List<MaquinaDTO> listarMaquinas() throws SQLException {
        List<MaquinaDTO> maquinas = new ArrayList<>();
        String sql = "SELECT * FROM Maquina";

        try (Connection conn = ConexaoDAO.conector();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                MaquinaDTO maquina = new MaquinaDTO(
                    rs.getInt("laboratorio_id"),
                    rs.getString("cpu"),
                    rs.getInt("ram"),
                    rs.getInt("armazenamento"),
                    rs.getString("status")
                );
                maquina.setId(rs.getInt("id"));
                maquinas.add(maquina);
            }
        }
        return maquinas;
    }
}

