
package GUI;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.DefaultListModel;

public class GestionarDialog extends javax.swing.JDialog {

    private int gestionElegida;
    private int propiedadElegida;
    
    /**
     * Creates new form GestionarDialog
     * @param parent
     * @param modal
     */
    public GestionarDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        DefaultListModel gestiones = new DefaultListModel<>();
        
        ArrayList opciones = new ArrayList<> (Arrays.asList("Construir casa","Construir hotel","Terminar"));
        
        opciones.forEach(s -> {
            gestiones.addElement(s);
        });
        listaGestiones.setModel(gestiones);
        
        gestionElegida = -1;
        
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        g = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaGestiones = new javax.swing.JList<>();
        realizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        g.setText("GESTIONES");

        listaGestiones.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaGestiones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaGestionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaGestiones);

        realizar.setText("Realizar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(realizar)
                    .addComponent(g))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(133, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(g)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(realizar)
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listaGestionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaGestionesMouseClicked
        // TODO add your handling code here:
        gestionElegida = listaGestiones.getSelectedIndex();
        dispose();
    }//GEN-LAST:event_listaGestionesMouseClicked

    
    int getGestionElegida(){
        return gestionElegida;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel g;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaGestiones;
    private javax.swing.JButton realizar;
    // End of variables declaration//GEN-END:variables
}
