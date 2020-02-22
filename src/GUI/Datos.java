package GUI;


import javax.swing.JOptionPane;

//llamado de las clases
import Clases.Logica;
import BD.*;


//bases de datos
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableModel;
import static jdk.nashorn.internal.runtime.Debug.id;

public class Datos extends javax.swing.JFrame {
    
    Logica log=new Logica();
    private final Proceso CP;
    int num=0;
    
    
   
    public Datos() {
        
        initComponents();
        CP=new Proceso();
        listar();
        this.setLocationRelativeTo(null);
        
    }
    
    private void listar(){
        
        Tabla_select.setModel(CP.getDatos()); 
        
    }
    
    
    
    private void limpiar(){
        BRid.setText(null);
         BRnombre.setText(null);
        BRprecio_original.setText(null);
        BRiva.setText(null);
        BRneto.setText(null);
    }
    
   private void guardar(){
       if(BRnombre.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Es obligatorio colocar el nombre");
            return;
        }
        
        if(BRprecio_original.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Es obligatorio colocar el precio");
            return;
        }
        
          if(BRiva.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Es obligatorio realizar los calculos");
            return;
        }
       
        
        String id=BRid.getText();
        String nombre=BRnombre.getText();
        double bruto=Double.parseDouble(BRprecio_original.getText());
        double iva=Double.parseDouble(BRiva.getText());
        double neto=Double.parseDouble(BRneto.getText());
       
       
        
        if(num ==0){
         
        
        int respuesta=CP.insertDatos(nombre, bruto, iva, neto);
         
        if(respuesta>0){
            listar();
            limpiar();
        }
        
      } else {
            
        int respuesta=CP.updateDatos(id,nombre, bruto, iva, neto);
         
        if(respuesta>0){
            listar();
            limpiar();
        }
          
      }
   }
    
    
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jSpinner1 = new javax.swing.JSpinner();
        jColorChooser1 = new javax.swing.JColorChooser();
        jOptionPane1 = new javax.swing.JOptionPane();
        jLabel3 = new javax.swing.JLabel();
        BRprecio_original = new javax.swing.JTextField();
        BRnombre = new javax.swing.JTextField();
        JLnombre = new javax.swing.JLabel();
        BTguardar = new javax.swing.JButton();
        JLbruto = new javax.swing.JLabel();
        labIVA = new javax.swing.JLabel();
        labNeto = new javax.swing.JLabel();
        BTCalcular = new javax.swing.JToggleButton();
        BTSAlir = new javax.swing.JToggleButton();
        BRiva = new javax.swing.JTextField();
        BRneto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_select = new javax.swing.JTable();
        BReliminar = new javax.swing.JToggleButton();
        BRid = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BRprecio_original.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRprecio_originalActionPerformed(evt);
            }
        });
        BRprecio_original.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BRprecio_originalKeyTyped(evt);
            }
        });

        BRnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRnombreActionPerformed(evt);
            }
        });
        BRnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BRnombreKeyTyped(evt);
            }
        });

        JLnombre.setText("Nombre del producto:");

        BTguardar.setText("Guardar");
        BTguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTguardarActionPerformed(evt);
            }
        });
        BTguardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BTguardarKeyTyped(evt);
            }
        });

        JLbruto.setText("Precio bruto del producto:");

        labIVA.setText("IVA:");

        labNeto.setText("Precio neto:");

        BTCalcular.setText("Calcular");
        BTCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTCalcularActionPerformed(evt);
            }
        });

        BTSAlir.setText("Salir");
        BTSAlir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTSAlirActionPerformed(evt);
            }
        });

        BRiva.setEditable(false);
        BRiva.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                BRivaVetoableChange(evt);
            }
        });

        BRneto.setEditable(false);
        BRneto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRnetoActionPerformed(evt);
            }
        });

        Tabla_select.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Tabla_select.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_selectMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla_select);

        BReliminar.setText("Eliminar");
        BReliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BReliminarActionPerformed(evt);
            }
        });

        BRid.setEditable(false);

        jLabel1.setText("id");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JLbruto))
                        .addGap(0, 89, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BRnombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BRid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(JLnombre)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(13, 13, 13)
                                                .addComponent(jLabel1)))
                                        .addGap(169, 169, 169)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(BRiva, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(BRneto, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labNeto, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(labIVA))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(354, 354, 354)
                                .addComponent(BTguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BReliminar)
                                .addGap(40, 40, 40)
                                .addComponent(BTSAlir))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BRprecio_original, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105)
                                .addComponent(BTCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labIVA)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BRiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BRid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labNeto)
                    .addComponent(JLnombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BRneto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BRnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(JLbruto)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BRprecio_original, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTCalcular))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTguardar)
                    .addComponent(BReliminar)
                    .addComponent(BTSAlir))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BRnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BRnombreActionPerformed

    private void BRprecio_originalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRprecio_originalActionPerformed
        
    }//GEN-LAST:event_BRprecio_originalActionPerformed

    private void BTguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTguardarActionPerformed
        guardar();
             
    }//GEN-LAST:event_BTguardarActionPerformed

    private void BTCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTCalcularActionPerformed
        
        double bruto=Double.parseDouble(BRprecio_original.getText());
        double a=log.Iva(bruto);
        BRiva.setText(""+a);
        double neto=log.neto(a, bruto);
        BRneto.setText(""+neto);
        
    }//GEN-LAST:event_BTCalcularActionPerformed

    private void BTSAlirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTSAlirActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null,"tu puedes terminar esto, eres un gran programador");
        System.exit(0);
    }//GEN-LAST:event_BTSAlirActionPerformed

    
    private void BRnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BRnombreKeyTyped

        char c=evt.getKeyChar();
        if((c<'a'||c>'z') && (c<'A'||c>'Z') && (c<' '||c>' '))evt.consume();
    }//GEN-LAST:event_BRnombreKeyTyped

    
    private void BTguardarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BTguardarKeyTyped
        //ERROR EN IMPLEMENTACION
    }//GEN-LAST:event_BTguardarKeyTyped

    
    
    private void BRprecio_originalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BRprecio_originalKeyTyped
        
        char c=evt.getKeyChar();
        if(c<'0'||c>'9')evt.consume();
        
        
    }//GEN-LAST:event_BRprecio_originalKeyTyped

    private void BRnetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRnetoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BRnetoActionPerformed

    private void BRivaVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_BRivaVetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_BRivaVetoableChange

    
    
    private void Tabla_selectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_selectMouseClicked
        
        int row=Tabla_select.getSelectedRow();
        
        BRid.setText(Tabla_select.getValueAt(row, 0).toString());
        BRnombre.setText(Tabla_select.getValueAt(row, 1).toString());
        BRprecio_original.setText(Tabla_select.getValueAt(row, 2).toString());
        BRiva.setText(Tabla_select.getValueAt(row, 3).toString());
        BRneto.setText(Tabla_select.getValueAt(row, 4).toString());
        
        num=1;
    }//GEN-LAST:event_Tabla_selectMouseClicked

    private void BReliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BReliminarActionPerformed
        int fila=Tabla_select.getSelectedColumnCount();
        
        if(fila<1){
            
            JOptionPane.showMessageDialog(null,"Seleccione un registro de la tabla");
            
        }else{
            
            if(CP.deleteData(Tabla_select.getValueAt(Tabla_select.getSelectedRow(),0).toString())>0){
                limpiar();
                listar();
           }
        }
    }//GEN-LAST:event_BReliminarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Datos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Datos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Datos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Datos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Datos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BReliminar;
    private javax.swing.JTextField BRid;
    private javax.swing.JTextField BRiva;
    private javax.swing.JTextField BRneto;
    private javax.swing.JTextField BRnombre;
    private javax.swing.JTextField BRprecio_original;
    private javax.swing.JToggleButton BTCalcular;
    private javax.swing.JToggleButton BTSAlir;
    private javax.swing.JButton BTguardar;
    private javax.swing.JLabel JLbruto;
    private javax.swing.JLabel JLnombre;
    private javax.swing.JTable Tabla_select;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel labIVA;
    private javax.swing.JLabel labNeto;
    // End of variables declaration//GEN-END:variables
}
