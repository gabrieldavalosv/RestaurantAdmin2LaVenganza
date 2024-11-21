/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author josep
 */
public class GestionDeOrdenes extends javax.swing.JFrame {
    
    /**
     * Creates new form GestiónDeOrdenes
     */
    public GestionDeOrdenes() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frameOrden = new javax.swing.JFrame();
        labelTituloOrden = new javax.swing.JLabel();
        labelOrdenCliente = new javax.swing.JLabel();
        labelOrdenTotal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMenu = new javax.swing.JTable();
        labelTituloMenu = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaOrdenProductos = new javax.swing.JTable();
        labelUsuario5 = new javax.swing.JLabel();
        fieldIdProducto = new javax.swing.JTextField();
        buttonAgregarProducto = new javax.swing.JButton();
        buttonEliminarProducto = new javax.swing.JButton();
        buttonTerminarOrden = new javax.swing.JButton();
        framePago = new javax.swing.JFrame();
        labelTituloForm = new javax.swing.JLabel();
        labelUsuario = new javax.swing.JLabel();
        labelTituloFecha = new javax.swing.JLabel();
        buttonAgregarOrden = new javax.swing.JButton();
        buttonVolverPanel = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaOrdenes = new javax.swing.JTable();
        buttonCancelarOrden = new javax.swing.JButton();
        buttonVolverPanel1 = new javax.swing.JButton();
        labelUsuario3 = new javax.swing.JLabel();
        labelTituloFecha1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        labelTituloFecha2 = new javax.swing.JLabel();

        frameOrden.setMinimumSize(new java.awt.Dimension(1090, 520));
        frameOrden.setSize(new java.awt.Dimension(1090, 520));

        labelTituloOrden.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        labelTituloOrden.setText("Gestión de Órden [idOrden] ");

        labelOrdenCliente.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        labelOrdenCliente.setText("Cliente: [cliente]");

        labelOrdenTotal.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        labelOrdenTotal.setText("Total: [precioTotal]");

        tablaMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Categoria", "Precio (S/.)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaMenu);
        if (tablaMenu.getColumnModel().getColumnCount() > 0) {
            tablaMenu.getColumnModel().getColumn(0).setMinWidth(50);
            tablaMenu.getColumnModel().getColumn(0).setPreferredWidth(50);
            tablaMenu.getColumnModel().getColumn(0).setMaxWidth(50);
            tablaMenu.getColumnModel().getColumn(1).setMinWidth(175);
            tablaMenu.getColumnModel().getColumn(1).setPreferredWidth(175);
            tablaMenu.getColumnModel().getColumn(1).setMaxWidth(175);
            tablaMenu.getColumnModel().getColumn(2).setMinWidth(85);
            tablaMenu.getColumnModel().getColumn(2).setPreferredWidth(85);
            tablaMenu.getColumnModel().getColumn(2).setMaxWidth(85);
            tablaMenu.getColumnModel().getColumn(3).setMinWidth(100);
            tablaMenu.getColumnModel().getColumn(3).setPreferredWidth(100);
            tablaMenu.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        labelTituloMenu.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        labelTituloMenu.setText("Menú [fecha]");
        labelTituloMenu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        tablaOrdenProductos.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tablaOrdenProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Categoria", "Precio (S/.)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablaOrdenProductos);
        if (tablaOrdenProductos.getColumnModel().getColumnCount() > 0) {
            tablaOrdenProductos.getColumnModel().getColumn(0).setMinWidth(50);
            tablaOrdenProductos.getColumnModel().getColumn(0).setPreferredWidth(50);
            tablaOrdenProductos.getColumnModel().getColumn(0).setMaxWidth(50);
            tablaOrdenProductos.getColumnModel().getColumn(1).setMinWidth(175);
            tablaOrdenProductos.getColumnModel().getColumn(1).setPreferredWidth(175);
            tablaOrdenProductos.getColumnModel().getColumn(1).setMaxWidth(175);
            tablaOrdenProductos.getColumnModel().getColumn(2).setMinWidth(100);
            tablaOrdenProductos.getColumnModel().getColumn(2).setPreferredWidth(100);
            tablaOrdenProductos.getColumnModel().getColumn(2).setMaxWidth(100);
            tablaOrdenProductos.getColumnModel().getColumn(3).setMinWidth(125);
            tablaOrdenProductos.getColumnModel().getColumn(3).setPreferredWidth(125);
            tablaOrdenProductos.getColumnModel().getColumn(3).setMaxWidth(125);
        }

        labelUsuario5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        labelUsuario5.setText("Id Producto");

        fieldIdProducto.setMaximumSize(new java.awt.Dimension(60, 25));
        fieldIdProducto.setMinimumSize(new java.awt.Dimension(60, 25));
        fieldIdProducto.setPreferredSize(new java.awt.Dimension(60, 25));

        buttonAgregarProducto.setText("Agregar Producto");

        buttonEliminarProducto.setText("Eliminar Producto");

        buttonTerminarOrden.setText("Terminar órden");

        javax.swing.GroupLayout frameOrdenLayout = new javax.swing.GroupLayout(frameOrden.getContentPane());
        frameOrden.getContentPane().setLayout(frameOrdenLayout);
        frameOrdenLayout.setHorizontalGroup(
            frameOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameOrdenLayout.createSequentialGroup()
                .addGroup(frameOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frameOrdenLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(frameOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(frameOrdenLayout.createSequentialGroup()
                                .addGroup(frameOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(frameOrdenLayout.createSequentialGroup()
                                        .addComponent(buttonAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(buttonEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(buttonTerminarOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(frameOrdenLayout.createSequentialGroup()
                                        .addComponent(labelUsuario5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fieldIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frameOrdenLayout.createSequentialGroup()
                                .addGroup(frameOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(frameOrdenLayout.createSequentialGroup()
                                        .addGap(0, 45, Short.MAX_VALUE)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(frameOrdenLayout.createSequentialGroup()
                                        .addComponent(labelOrdenCliente)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labelOrdenTotal)))
                                .addGap(67, 67, 67))))
                    .addGroup(frameOrdenLayout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(labelTituloOrden)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(frameOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frameOrdenLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frameOrdenLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelTituloMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125))))
        );
        frameOrdenLayout.setVerticalGroup(
            frameOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(frameOrdenLayout.createSequentialGroup()
                .addGroup(frameOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frameOrdenLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(labelTituloOrden)
                        .addGap(18, 18, 18)
                        .addGroup(frameOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelOrdenCliente)
                            .addComponent(labelOrdenTotal))
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(frameOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelUsuario5))
                        .addGap(30, 30, 30)
                        .addGroup(frameOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonTerminarOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(frameOrdenLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(labelTituloMenu)
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout framePagoLayout = new javax.swing.GroupLayout(framePago.getContentPane());
        framePago.getContentPane().setLayout(framePagoLayout);
        framePagoLayout.setHorizontalGroup(
            framePagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        framePagoLayout.setVerticalGroup(
            framePagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(552, 547));
        setMinimumSize(new java.awt.Dimension(552, 547));
        setSize(new java.awt.Dimension(552, 547));

        labelTituloForm.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        labelTituloForm.setText("Gestión de órdenes");

        labelUsuario.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        labelUsuario.setText("[labelRol]");
        labelUsuario.setToolTipText("");

        labelTituloFecha.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        labelTituloFecha.setText("[labelFecha-Hora]");

        buttonAgregarOrden.setBackground(new java.awt.Color(34, 141, 110));
        buttonAgregarOrden.setForeground(new java.awt.Color(255, 255, 255));
        buttonAgregarOrden.setText("buttonAgregarOrden");

        buttonVolverPanel.setBackground(new java.awt.Color(34, 141, 110));
        buttonVolverPanel.setForeground(new java.awt.Color(255, 255, 255));
        buttonVolverPanel.setText("buttonVolver");

        tablaOrdenes.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tablaOrdenes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cliente", "Estado", "Precio total (S/.)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaOrdenes);
        if (tablaOrdenes.getColumnModel().getColumnCount() > 0) {
            tablaOrdenes.getColumnModel().getColumn(0).setMinWidth(50);
            tablaOrdenes.getColumnModel().getColumn(0).setPreferredWidth(50);
            tablaOrdenes.getColumnModel().getColumn(0).setMaxWidth(50);
            tablaOrdenes.getColumnModel().getColumn(1).setMinWidth(175);
            tablaOrdenes.getColumnModel().getColumn(1).setPreferredWidth(175);
            tablaOrdenes.getColumnModel().getColumn(1).setMaxWidth(175);
            tablaOrdenes.getColumnModel().getColumn(2).setMinWidth(100);
            tablaOrdenes.getColumnModel().getColumn(2).setPreferredWidth(100);
            tablaOrdenes.getColumnModel().getColumn(2).setMaxWidth(100);
            tablaOrdenes.getColumnModel().getColumn(3).setMinWidth(125);
            tablaOrdenes.getColumnModel().getColumn(3).setPreferredWidth(125);
            tablaOrdenes.getColumnModel().getColumn(3).setMaxWidth(125);
        }

        buttonCancelarOrden.setBackground(new java.awt.Color(34, 141, 110));
        buttonCancelarOrden.setForeground(new java.awt.Color(255, 255, 255));
        buttonCancelarOrden.setText("buttonCancelarOrden");

        buttonVolverPanel1.setBackground(new java.awt.Color(34, 141, 110));
        buttonVolverPanel1.setForeground(new java.awt.Color(255, 255, 255));
        buttonVolverPanel1.setText("buttonModificarOrden");

        labelUsuario3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        labelUsuario3.setText("[labelNombreUsuario]");

        labelTituloFecha1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        labelTituloFecha1.setText("[labelID]");

        jLabel6.setText("Cliente:");

        jTextField1.setBackground(new java.awt.Color(59, 73, 69));
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setText("fieldNombreCliente");
        jTextField1.setToolTipText("");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        labelTituloFecha2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        labelTituloFecha2.setText("[labelOrdenID]");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(buttonVolverPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(labelTituloForm))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(43, 43, 43)
                            .addComponent(buttonAgregarOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12)
                            .addComponent(buttonVolverPanel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(buttonCancelarOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelUsuario)
                    .addComponent(labelUsuario3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTituloFecha)
                    .addComponent(labelTituloFecha1)
                    .addComponent(labelTituloFecha2))
                .addGap(111, 111, 111))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTituloForm)
                    .addComponent(buttonVolverPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelUsuario3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelTituloFecha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelTituloFecha1)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelTituloFecha2))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonVolverPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAgregarOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCancelarOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(GestionDeOrdenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionDeOrdenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionDeOrdenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionDeOrdenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionDeOrdenes().setVisible(true);
            }
        });
    }

    // Getters y Setters de los Widgets
    public JButton getButtonAgregarOrden() {
        return buttonAgregarOrden;
    }

    public JButton getButtonCancelarOrden() {
        return buttonCancelarOrden;
    }

    public JButton getButtonVolverPanel() {
        return buttonVolverPanel;
    }

    public JLabel getLabelTituloFecha() {
        return labelTituloFecha;
    }

    public JLabel getLabelTituloForm() {
        return labelTituloForm;
    }

    public JTable getTablaMenu() {
        return tablaMenu;
    }

    public JTable getTablaOrdenes() {
        return tablaOrdenes;
    }
    
    public JButton getButtonBuscarOrden() {
        return buttonBuscarOrden;
    }

    public JTextField getFieldCliente() {
        return fieldCliente;
    }

    public JTextField getFieldIdOrden() {
        return fieldIdOrden;
    }

    public void setFieldCliente(JTextField fieldCliente) {
        this.fieldCliente = fieldCliente;
    }

    public void setFieldIdOrden(JTextField fieldIdOrden) {
        this.fieldIdOrden = fieldIdOrden;
    }
    
    
    
    // Getters y Setters del frame orden
    public JFrame getFrameOrden() {
        return frameOrden;
    }

    public JLabel getLabelTituloMenu() {
        return labelTituloMenu;
    }

    public JLabel getLabelTituloOrden() {
        return labelTituloOrden;
    }
    
    public JLabel getLabelOrdenCliente() {
        return labelOrdenCliente;
    }

    public JLabel getLabelOrdenTotal() {
        return labelOrdenTotal;
    }
    
    public JTable getTablaOrdenProductos() {
        return tablaOrdenProductos;
    }
    
    public JButton getButtonAgregarProducto() {
        return buttonAgregarProducto;
    }

    public JButton getButtonEliminarProducto() {
        return buttonEliminarProducto;
    }

    public JButton getButtonTerminarOrden() {
        return buttonTerminarOrden;
    }

    public JTextField getFieldIdProducto() {
        return fieldIdProducto;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAgregarOrden;
    private javax.swing.JButton buttonAgregarProducto;
    private javax.swing.JButton buttonCancelarOrden;
    private javax.swing.JButton buttonEliminarProducto;
    private javax.swing.JButton buttonTerminarOrden;
    private javax.swing.JButton buttonVolverPanel;
    private javax.swing.JButton buttonVolverPanel1;
    private javax.swing.JTextField fieldIdProducto;
    private javax.swing.JFrame frameOrden;
    private javax.swing.JFrame framePago;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel labelOrdenCliente;
    private javax.swing.JLabel labelOrdenTotal;
    private javax.swing.JLabel labelTituloFecha;
    private javax.swing.JLabel labelTituloFecha1;
    private javax.swing.JLabel labelTituloFecha2;
    private javax.swing.JLabel labelTituloForm;
    private javax.swing.JLabel labelTituloMenu;
    private javax.swing.JLabel labelTituloOrden;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JLabel labelUsuario3;
    private javax.swing.JLabel labelUsuario5;
    private javax.swing.JTable tablaMenu;
    private javax.swing.JTable tablaOrdenProductos;
    private javax.swing.JTable tablaOrdenes;
    // End of variables declaration//GEN-END:variables

}
