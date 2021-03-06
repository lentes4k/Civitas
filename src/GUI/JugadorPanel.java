/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import civitas.*;
import java.util.ArrayList;


/**
 *
 * @author josemanu
 */
public class JugadorPanel extends javax.swing.JPanel {

    /**
     * Creates new form JugadorPanel
     */
    private Jugador jugador;
    
    public JugadorPanel() {
        initComponents();
    }
    
    void setJugador(Jugador jugador) {
        
        this.jugador = jugador;
        campoNombre.setText(jugador.getNombre());
        campoSaldo.setText(Float.toString(jugador.getSaldo()));
        if (jugador instanceof JugadorEspeculador)
            campoTipo.setText("Especulador");
        else
            campoTipo.setText("Normal");
        
        rellenaPropiedades(this.jugador.getPropiedadesPub());
        
        repaint();
        revalidate();
        
    }
    
    private void rellenaPropiedades (ArrayList<CasillaCalle> lista) {
        
        //Se elimina la información antigua
        propiedadesPanel.removeAll();
        
        //Se recorre la lista de propiedades para ir creando sus vistas individuales y añadirlas al panel
        for (CasillaCalle t: lista) {
            
            PropiedadPanel vistaPropiedad = new PropiedadPanel();
            vistaPropiedad.setPropiedad(t);
            
            propiedadesPanel.add(vistaPropiedad);
            vistaPropiedad.setVisible(true);
            
        }
        
        //Se fuerza la actualización visual del panel propiedades y del panel del jugador
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

        jPanel1 = new javax.swing.JPanel();
        tituloNombre = new javax.swing.JLabel();
        tituloSaldo = new javax.swing.JLabel();
        tituloTipo = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        campoSaldo = new javax.swing.JTextField();
        campoTipo = new javax.swing.JTextField();
        propiedadesPanel = new javax.swing.JPanel();

        tituloNombre.setText("Nombre");

        tituloSaldo.setText("Saldo");

        tituloTipo.setText("Tipo");

        campoNombre.setEditable(false);
        campoNombre.setText("jTextField1");

        campoSaldo.setEditable(false);
        campoSaldo.setText("jTextField2");

        campoTipo.setEditable(false);
        campoTipo.setText("jTextField3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tituloNombre)
                    .addComponent(tituloSaldo)
                    .addComponent(tituloTipo))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(propiedadesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tituloNombre)
                            .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tituloSaldo)
                            .addComponent(campoSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tituloTipo)
                            .addComponent(campoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(propiedadesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoSaldo;
    private javax.swing.JTextField campoTipo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel propiedadesPanel;
    private javax.swing.JLabel tituloNombre;
    private javax.swing.JLabel tituloSaldo;
    private javax.swing.JLabel tituloTipo;
    // End of variables declaration//GEN-END:variables


}
