package Tela;

import DAO.ManutencaoDAO;
import DTO.ManutencaoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class TelaManutencao extends javax.swing.JFrame {

    public TelaManutencao() {
        initComponents();
        chamarDados();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        cbTipo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cbNomeMaquina = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        bntSalvar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cbNomeTec = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Descrição");

        txtDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescricaoActionPerformed(evt);
            }
        });

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Preventiva", "Corretiva" }));
        cbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoActionPerformed(evt);
            }
        });

        jLabel2.setText("Tipo");

        jLabel3.setText("Nome da maquina");

        bntSalvar.setText("Salvar");
        bntSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSalvarActionPerformed(evt);
            }
        });

        jLabel4.setText("Técnico");

        cbNomeTec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNomeTecActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                    .addComponent(cbNomeMaquina, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbTipo, 0, 435, Short.MAX_VALUE)
                    .addComponent(cbNomeTec, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(187, Short.MAX_VALUE)
                .addComponent(bntSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(185, 185, 185))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbNomeTec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbNomeMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescricao)
                .addGap(32, 32, 32)
                .addComponent(bntSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescricaoActionPerformed

    }//GEN-LAST:event_txtDescricaoActionPerformed

    private void cbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoActionPerformed

    }//GEN-LAST:event_cbTipoActionPerformed

    private void bntSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSalvarActionPerformed

        String NomeTec = cbNomeTec.getSelectedItem().toString();
        String Descricao = txtDescricao.getText();
        String Tipo = cbTipo.getSelectedItem().toString();
        String NomeMaq = cbNomeMaquina.getSelectedItem().toString();

        ManutencaoDTO man1 = new ManutencaoDTO();
        man1.setTecnicoNome(NomeTec);
        man1.setDescricao(Descricao);
        man1.setTipo(Tipo);
        man1.setMaquinaNome(NomeMaq);

        ManutencaoDAO man2 = new ManutencaoDAO();
        man2.cadastrarManutencao(man1);
        
    }//GEN-LAST:event_bntSalvarActionPerformed

    private void cbNomeTecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNomeTecActionPerformed

    }//GEN-LAST:event_cbNomeTecActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaManutencao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntSalvar;
    public static javax.swing.JComboBox cbNomeMaquina;
    public static javax.swing.JComboBox cbNomeTec;
    public static javax.swing.JComboBox cbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public static javax.swing.JTextField txtDescricao;
    // End of variables declaration//GEN-END:variables

    public static void chamarDados() {

        ManutencaoDAO manDAO = new ManutencaoDAO();
        ResultSet rsM = manDAO.listarMaquinas();
        ResultSet rsU = manDAO.listarUsuarios();
        try {
            while (rsM.next()) {
                cbNomeMaquina.addItem(rsM.getString("nome"));
            }

            while (rsU.next()) {
                cbNomeTec.addItem(rsU.getString("nome"));
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher ComboBoxes: " + erro.getMessage());
        }
    }
}
