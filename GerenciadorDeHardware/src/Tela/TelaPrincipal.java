package Tela;

public class TelaPrincipal extends javax.swing.JFrame {

    public TelaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Desktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        labinA = new javax.swing.JMenuItem();
        labinB = new javax.swing.JMenuItem();
        labinC = new javax.swing.JMenuItem();
        labinD = new javax.swing.JMenuItem();
        ManutencaoMenu = new javax.swing.JMenu();
        MenuPeca = new javax.swing.JMenu();
        menuEqui = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 748, Short.MAX_VALUE)
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
        );

        jMenu5.setText("Laboratorios");

        labinA.setText("Labin A");
        labinA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labinAActionPerformed(evt);
            }
        });
        jMenu5.add(labinA);

        labinB.setText("Labin B");
        labinB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labinBActionPerformed(evt);
            }
        });
        jMenu5.add(labinB);

        labinC.setText("Labin C");
        labinC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labinCActionPerformed(evt);
            }
        });
        jMenu5.add(labinC);

        labinD.setText("Labin D");
        labinD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labinDActionPerformed(evt);
            }
        });
        jMenu5.add(labinD);

        jMenuBar1.add(jMenu5);

        ManutencaoMenu.setText("Manutenção");
        ManutencaoMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ManutencaoMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(ManutencaoMenu);

        MenuPeca.setText("Peças");
        MenuPeca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuPecaMouseClicked(evt);
            }
        });
        jMenuBar1.add(MenuPeca);

        menuEqui.setText("Equipamentos");
        menuEqui.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuEquiMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuEqui);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Desktop)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Desktop)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void labinBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_labinBActionPerformed
        
        TelaLabinB lbB = new TelaLabinB();
        lbB.setVisible(true);
        Desktop.add(lbB);
         
    }//GEN-LAST:event_labinBActionPerformed

    private void labinAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_labinAActionPerformed
        
        TelaLabinA lbA = new TelaLabinA();
        lbA.setVisible(true);
        Desktop.add(lbA);
        
    }//GEN-LAST:event_labinAActionPerformed

    private void labinCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_labinCActionPerformed
 
        TelaLabinC lbC = new TelaLabinC();
        lbC.setVisible(true);
        Desktop.add(lbC);
         
    }//GEN-LAST:event_labinCActionPerformed

    private void labinDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_labinDActionPerformed
       
        TelaLabinD lbD = new TelaLabinD();             
        lbD.setVisible(true);
        Desktop.add(lbD);
         
    }//GEN-LAST:event_labinDActionPerformed

    private void ManutencaoMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ManutencaoMenuMouseClicked
        
        Manutenção mn1 = new Manutenção();
        mn1.setVisible(true);
        Desktop.add(mn1);
         
    }//GEN-LAST:event_ManutencaoMenuMouseClicked

    private void MenuPecaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuPecaMouseClicked
        
        Peças pc1 = new Peças();
        pc1.setVisible(true);
        Desktop.add(pc1);
         
    }//GEN-LAST:event_MenuPecaMouseClicked

    private void menuEquiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuEquiMouseClicked
        
        TelaEquipamentos eq1 = new TelaEquipamentos();
        eq1.setVisible(true);
        Desktop.add(eq1);
        
    }//GEN-LAST:event_menuEquiMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JMenu ManutencaoMenu;
    private javax.swing.JMenu MenuPeca;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem labinA;
    private javax.swing.JMenuItem labinB;
    private javax.swing.JMenuItem labinC;
    private javax.swing.JMenuItem labinD;
    private javax.swing.JMenu menuEqui;
    // End of variables declaration//GEN-END:variables
}
