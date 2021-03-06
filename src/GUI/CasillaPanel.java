/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import civitas.*;

/**
 *
 * @author josemanu
 */
public class CasillaPanel extends javax.swing.JPanel {

    /**
     * Creates new form CasillaActual
     */
    
    Casilla casilla;
    
    public CasillaPanel() {
        initComponents();
    }
    
    void setCasilla(Casilla casilla) {
        
        this.casilla = casilla;
        
        if (this.casilla instanceof CasillaCalle) {
        
        textoTipo.setText("Calle");
        textoNombre.setText(this.casilla.getNombrePub());
        textoCompra.setText(Float.toString(((CasillaCalle) this.casilla).getPrecioCompra()));
        if (((CasillaCalle) this.casilla).getPropietario() != null)
            textoPropietario.setText(((CasillaCalle) this.casilla).getPropietario().getNombre());
        else
            textoPropietario.setText("NO tiene");
        
        }
        
        if (this.casilla instanceof CasillaSorpresa) {
        
        textoTipo.setText("Sorpresa");
        textoNombre.setText(this.casilla.getNombrePub());
        textoCompra.setText("X");
        textoPropietario.setText("X");
        
        }
        
        repaint();
        revalidate();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipo = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        precioCompra = new javax.swing.JLabel();
        propietario = new javax.swing.JLabel();
        textoTipo = new javax.swing.JTextField();
        textoNombre = new javax.swing.JTextField();
        textoCompra = new javax.swing.JTextField();
        textoPropietario = new javax.swing.JTextField();

        tipo.setText("Tipo");

        nombre.setText("Nombre");

        precioCompra.setText("PrecioCompra");

        propietario.setText("Propietario");

        textoTipo.setEditable(false);
        textoTipo.setText("casilla");
        textoTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoTipoActionPerformed(evt);
            }
        });

        textoNombre.setEditable(false);
        textoNombre.setText("nombre");
        textoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoNombreActionPerformed(evt);
            }
        });

        textoCompra.setEditable(false);
        textoCompra.setText("precio");

        textoPropietario.setEditable(false);
        textoPropietario.setText("propietario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(propietario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textoPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(precioCompra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                        .addComponent(textoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(nombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(tipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(115, 115, 115))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipo)
                    .addComponent(textoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre)
                    .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(precioCompra)
                    .addComponent(textoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(propietario)
                    .addComponent(textoPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(131, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textoTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoTipoActionPerformed

    private void textoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoNombreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel nombre;
    private javax.swing.JLabel precioCompra;
    private javax.swing.JLabel propietario;
    private javax.swing.JTextField textoCompra;
    private javax.swing.JTextField textoNombre;
    private javax.swing.JTextField textoPropietario;
    private javax.swing.JTextField textoTipo;
    private javax.swing.JLabel tipo;
    // End of variables declaration//GEN-END:variables
}
