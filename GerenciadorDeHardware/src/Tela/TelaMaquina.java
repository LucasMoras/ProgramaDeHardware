package Tela;

import java.sql.*;
import DAO.MaquinaDAO;
import DTO.MaquinaDTO;
import javax.swing.JOptionPane;

public class TelaMaquina extends javax.swing.JFrame {

    public TelaMaquina() {
        initComponents();
        chamarDados();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bntSalvar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        cbLabin = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        txtCPU = new javax.swing.JTextField();
        txtRAM = new javax.swing.JTextField();
        txtROM = new javax.swing.JTextField();
        bntEditar = new javax.swing.JButton();
        bntExcluir = new javax.swing.JButton();
        bntPesquisar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cbStatus = new javax.swing.JComboBox<>();
        txtId = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        bntSalvar.setText("Salvar");
        bntSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSalvarActionPerformed(evt);
            }
        });

        jLabel1.setText("CPU");

        jLabel2.setText("RAM");

        jLabel3.setText("ROM");

        jLabel4.setText("Nome da maquina");

        cbLabin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));
        cbLabin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLabinActionPerformed(evt);
            }
        });

        jLabel8.setText("Laboratório");

        txtCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPUActionPerformed(evt);
            }
        });

        txtRAM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRAMActionPerformed(evt);
            }
        });

        txtROM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtROMActionPerformed(evt);
            }
        });

        bntEditar.setText("Editar");
        bntEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntEditarActionPerformed(evt);
            }
        });

        bntExcluir.setText("Excluir");
        bntExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntExcluirActionPerformed(evt);
            }
        });

        bntPesquisar.setText("Pesquisar");
        bntPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntPesquisarActionPerformed(evt);
            }
        });

        jLabel5.setText("Status");

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Funcionando", "Fora de uso", "Em manutenção" }));
        cbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbStatusActionPerformed(evt);
            }
        });

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        jLabel6.setText("Id");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(bntSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bntEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bntExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bntPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtROM, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRAM, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCPU, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(77, 77, 77)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(75, 75, 75)
                                        .addComponent(jLabel3)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addGap(59, 59, 59))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(65, 65, 65))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(cbLabin, 0, 160, Short.MAX_VALUE)
                                                .addComponent(cbStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtId))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(169, 169, 169)
                                .addComponent(jLabel4)))
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(txtNome)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbLabin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtROM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntSalvar)
                    .addComponent(bntEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bntExcluir)
                    .addComponent(bntPesquisar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bntSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSalvarActionPerformed

        String Nome = txtNome.getText();
        String CPU = txtCPU.getText();
        String RAM = txtRAM.getText();
        String ROM = txtROM.getText();
        String Status = cbStatus.getSelectedItem().toString();
        String Labin = cbLabin.getSelectedItem().toString();

        MaquinaDTO maq1 = new MaquinaDTO();
        maq1.setNome(Nome);
        maq1.setCpu(CPU);
        maq1.setRam(RAM);
        maq1.setArmazenamento(ROM);
        maq1.setStatus(Status);
        maq1.setLaboratorioNome(Labin);
        
        MaquinaDAO maq2 = new MaquinaDAO();
        maq2.cadastrarMaquina(maq1);

    }//GEN-LAST:event_bntSalvarActionPerformed

    private void txtCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPUActionPerformed

    }//GEN-LAST:event_txtCPUActionPerformed

    private void txtRAMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRAMActionPerformed

    }//GEN-LAST:event_txtRAMActionPerformed

    private void txtROMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtROMActionPerformed

    }//GEN-LAST:event_txtROMActionPerformed

    private void cbLabinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLabinActionPerformed
    
    }//GEN-LAST:event_cbLabinActionPerformed

    private void bntEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntEditarActionPerformed
                
        String nome = txtNome.getText();
        String cpu = txtCPU.getText();
        String ram = txtRAM.getText();
        String rom = txtROM.getText();
        String labin = cbLabin.getSelectedItem().toString();
        String status = cbStatus.getSelectedItem().toString();
        int id = Integer.parseInt(txtId.getText());
        MaquinaDTO MaqDTO = new MaquinaDTO();

        MaqDTO.setNome(nome);
        MaqDTO.setCpu(cpu);
        MaqDTO.setRam(ram);
        MaqDTO.setArmazenamento(rom);
        MaqDTO.setLaboratorioNome(labin);
        MaqDTO.setStatus(status);
        MaqDTO.setId(id); 
        
        MaquinaDAO MaqDAO = new MaquinaDAO();
        MaqDAO.editar(MaqDTO);
        
    }//GEN-LAST:event_bntEditarActionPerformed

    private void bntExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntExcluirActionPerformed

        String nome = txtNome.getText();
        MaquinaDTO maqDTO = new MaquinaDTO();
        maqDTO.setNome(nome);

        MaquinaDAO maqDAO = new MaquinaDAO();
        maqDAO.deletar(maqDTO);

    }//GEN-LAST:event_bntExcluirActionPerformed

    private void bntPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntPesquisarActionPerformed

        MaquinaDTO maq1 = new MaquinaDTO();
        String nome = txtNome.getText();
        maq1.setNome(nome);

        MaquinaDAO maq = new MaquinaDAO();
        maq.pesquisar(maq1);

    }//GEN-LAST:event_bntPesquisarActionPerformed

    private void cbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbStatusActionPerformed

    }//GEN-LAST:event_cbStatusActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMaquina().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntEditar;
    private javax.swing.JButton bntExcluir;
    private javax.swing.JButton bntPesquisar;
    private javax.swing.JButton bntSalvar;
    public static javax.swing.JComboBox cbLabin;
    public static javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    public static javax.swing.JTextField txtCPU;
    public static javax.swing.JTextField txtId;
    public static javax.swing.JTextField txtNome;
    public static javax.swing.JTextField txtRAM;
    public static javax.swing.JTextField txtROM;
    // End of variables declaration//GEN-END:variables

    public static void chamarDados() {
        
            MaquinaDAO maqDAO = new MaquinaDAO();
            ResultSet rs = maqDAO.listarLabins();
            try {
            while (rs.next()) {
                cbLabin.addItem(rs.getString(1));
            }
        } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null, "hum2"+ erro.getMessage());
        }
    }
}