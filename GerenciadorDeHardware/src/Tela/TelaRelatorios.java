package Tela;

import DAO.ManutencaoDAO;
import DAO.RelatorioDAO;
import javax.swing.JOptionPane;

public class TelaRelatorios extends javax.swing.JFrame {

    public TelaRelatorios() {
        initComponents();
        preencherTabelaRelatorios();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbRelatorio = new javax.swing.JTable();
        bntExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbRelatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Técnico", "Maquina", "CPU", "RAM", "ROM", "Laboratório", "Status", "Tipo de manutenção", "Descrição"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Long.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbRelatorio.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbRelatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbRelatorioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbRelatorio);

        bntExcluir.setText("Excluir");
        bntExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1266, Short.MAX_VALUE)
                    .addComponent(bntExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bntExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bntExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntExcluirActionPerformed

        int linhaSelecionada = tbRelatorio.getSelectedRow();

        if (linhaSelecionada >= 0) {
            int manutencaoId = (int) tbRelatorio.getValueAt(linhaSelecionada, 0);

            ManutencaoDAO manutencaoDAO = new ManutencaoDAO();
            manutencaoDAO.excluirManutencaoPorId(manutencaoId);
            preencherTabelaRelatorios();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma manutenção para excluir.");
        }
    }//GEN-LAST:event_bntExcluirActionPerformed

    private void tbRelatorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbRelatorioMouseClicked


    }//GEN-LAST:event_tbRelatorioMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRelatorios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntExcluir;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tbRelatorio;
    // End of variables declaration//GEN-END:variables
    private void preencherTabelaRelatorios() {

        RelatorioDAO relatorioDAO = new RelatorioDAO();
        relatorioDAO.preencherRelatorio();
    }
}
