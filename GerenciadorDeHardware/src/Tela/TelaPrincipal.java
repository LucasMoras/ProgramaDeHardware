package Tela;

public class TelaPrincipal extends javax.swing.JFrame {

    public TelaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bntMaquina = new javax.swing.JButton();
        bntManutencao = new javax.swing.JButton();
        bntLabin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        bntRelatorio = new javax.swing.JButton();
        bntCadastroCli = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bntMaquina.setText("Cadastro Maquinas");
        bntMaquina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntMaquinaActionPerformed(evt);
            }
        });

        bntManutencao.setText("Cadastro Manutenções");
        bntManutencao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntManutencaoActionPerformed(evt);
            }
        });

        bntLabin.setText("Cadastro Laboratorios");
        bntLabin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntLabinActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Tela principal");

        bntRelatorio.setText("Tabela de relatórios");
        bntRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntRelatorioActionPerformed(evt);
            }
        });

        bntCadastroCli.setText("Cadastro de Usuários");
        bntCadastroCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCadastroCliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(160, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(146, 146, 146))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bntRelatorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bntManutencao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(bntMaquina, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bntLabin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bntCadastroCli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(bntCadastroCli, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bntLabin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bntRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bntManutencao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bntMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bntLabinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLabinActionPerformed
    TelaLaboratorio lab1 = new TelaLaboratorio();
    lab1.setVisible(true);
    }//GEN-LAST:event_bntLabinActionPerformed

    private void bntManutencaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntManutencaoActionPerformed
    TelaManutencao man1 = new TelaManutencao();
    man1.setVisible(true);
    }//GEN-LAST:event_bntManutencaoActionPerformed

    private void bntMaquinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntMaquinaActionPerformed
    TelaMaquina maq1 = new TelaMaquina();
    maq1.setVisible(true);
    }//GEN-LAST:event_bntMaquinaActionPerformed

    private void bntRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntRelatorioActionPerformed
    TelaRelatorios rel1 = new TelaRelatorios();
    rel1.setVisible(true);
    }//GEN-LAST:event_bntRelatorioActionPerformed

    private void bntCadastroCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCadastroCliActionPerformed
     TelaUsuario tlUsu1 = new TelaUsuario();
     tlUsu1.setVisible(true);
    }//GEN-LAST:event_bntCadastroCliActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton bntCadastroCli;
    private javax.swing.JButton bntLabin;
    private javax.swing.JButton bntManutencao;
    private javax.swing.JButton bntMaquina;
    private javax.swing.JButton bntRelatorio;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
