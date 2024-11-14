package DAO;

import Tela.TelaRelatorios;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class RelatorioDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void preencherRelatorio() {
        conexao = ConexaoDAO.conector();

        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("Id manutenção");
        modelo.addColumn("Nome do Técnico");
        modelo.addColumn("Nome da Máquina");
        modelo.addColumn("Processador");
        modelo.addColumn("RAM");
        modelo.addColumn("Armazenamento");
        modelo.addColumn("Nome do Laboratório");
        modelo.addColumn("Status da Máquina");
        modelo.addColumn("Tipo de Manutenção");
        modelo.addColumn("Descrição da Manutenção");

         String sql = "SELECT m.id AS id_manutencao, "
            + "u.nome AS nome_tecnico, "
            + "ma.nome AS nome_maquina, "
            + "ma.processador AS processador, "
            + "ma.ram AS ram, "
            + "ma.armazenamento AS armazenamento, "
            + "l.nome AS nome_laboratorio, "
            + "ma.statuss AS status_maquina, "
            + "m.tipo AS tipo_manutencao, "
            + "m.descricao AS descricao_manutencao "
            + "FROM Manutencao m "
            + "INNER JOIN Maquina ma ON m.maquinaNome = ma.nome "
            + "INNER JOIN Usuario u ON m.tecnicoNome = u.nome "
            + "INNER JOIN Laboratorio l ON ma.laboratorioNome = l.nome";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                int idManutencao = rs.getInt("id_manutencao");
                String nomeTecnico = rs.getString("nome_tecnico");
                String nomeMaquina = rs.getString("nome_maquina");
                String processador = rs.getString("processador");
                String ram = rs.getString("ram");
                String armazenamento = rs.getString("armazenamento");
                String nomeLaboratorio = rs.getString("nome_laboratorio");
                String statusMaquina = rs.getString("status_maquina");
                String tipoManutencao = rs.getString("tipo_manutencao");
                String descricaoManutencao = rs.getString("descricao_manutencao");

                modelo.addRow(new Object[]{idManutencao, nomeTecnico, nomeMaquina, processador, ram, armazenamento, nomeLaboratorio, statusMaquina, tipoManutencao, descricaoManutencao});
            }

            TelaRelatorios.tbRelatorio.setModel(modelo);

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher relatório: " + erro.getMessage());

        }
    }
}
