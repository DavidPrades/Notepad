
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alu20908719v
 */
public class MainFrame extends javax.swing.JFrame {
    
    UndoManager undoManager = new UndoManager();

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        initMyComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnSave = new javax.swing.JButton();
        btnOpen = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnFile = new javax.swing.JMenu();
        mnNew = new javax.swing.JMenuItem();
        mnOpen = new javax.swing.JMenuItem();
        mnSave = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnExit = new javax.swing.JMenuItem();
        mnEdit = new javax.swing.JMenu();
        doUndo = new javax.swing.JMenuItem();
        doRedo = new javax.swing.JMenuItem();
        mnAbout = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 750));
        setPreferredSize(new java.awt.Dimension(400, 400));
        setResizable(false);

        jToolBar1.setRollover(true);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("Bundle"); // NOI18N
        btnSave.setText(bundle.getString("MainFrame.btnSave.text")); // NOI18N
        btnSave.setFocusable(false);
        btnSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSave);

        btnOpen.setText(bundle.getString("MainFrame.btnOpen.text")); // NOI18N
        btnOpen.setFocusable(false);
        btnOpen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOpen.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });
        jToolBar1.add(btnOpen);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        txtArea.setColumns(20);
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        mnFile.setIcon(new ImageIcon(MainFrame.class.getResource("/com/sun/java/swing/plaf/windows/icons/File.gif")));
        mnFile.setText(bundle.getString("MainFrame.mnFile.text")); // NOI18N

        mnNew.setText(bundle.getString("MainFrame.mnNew.text")); // NOI18N
        mnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnNewActionPerformed(evt);
            }
        });
        mnFile.add(mnNew);

        mnOpen.setText(bundle.getString("MainFrame.mnOpen.text")); // NOI18N
        mnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnOpenActionPerformed(evt);
            }
        });
        mnFile.add(mnOpen);

        mnSave.setText(bundle.getString("MainFrame.mnSave.text")); // NOI18N
        mnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSaveActionPerformed(evt);
            }
        });
        mnFile.add(mnSave);
        mnFile.add(jSeparator1);

        mnExit.setText(bundle.getString("MainFrame.mnExit.text")); // NOI18N
        mnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnExitActionPerformed(evt);
            }
        });
        mnFile.add(mnExit);

        jMenuBar1.add(mnFile);

        mnEdit.setText(bundle.getString("MainFrame.mnEdit.text")); // NOI18N

        doUndo.setText(bundle.getString("MainFrame.doUndo.text")); // NOI18N
        doUndo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        doUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doUndoActionPerformed(evt);
            }
        });
        mnEdit.add(doUndo);

        doRedo.setText(bundle.getString("MainFrame.doRedo.text")); // NOI18N
        doRedo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doRedoActionPerformed(evt);
            }
        });
        mnEdit.add(doRedo);

        jMenuBar1.add(mnEdit);

        mnAbout.setText(bundle.getString("MainFrame.mnAbout.text")); // NOI18N
        jMenuBar1.add(mnAbout);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void openAndReadFile() {
        BufferedReader inputStream = null;
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        File filename = f.getAbsoluteFile();
        
        String textfile = "";
        
        try {
            inputStream = new BufferedReader(new FileReader(f));
            String line;
            
            while ((line = inputStream.readLine()) != null) {
                System.out.println(line);
                
                textfile += line + "\n";
            }
            txtArea.setText(textfile);
        } catch (IOException ex) {
            System.out.println("error");
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                    txtArea.setText(textfile);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        
    }
    private void mnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnOpenActionPerformed
        openAndReadFile();
    }//GEN-LAST:event_mnOpenActionPerformed
    private void addUndoRedo() {
        txtArea.getDocument().addUndoableEditListener(undoManager);
        
    }
    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
        openAndReadFile();
    }//GEN-LAST:event_btnOpenActionPerformed

    private void mnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnNewActionPerformed
        int n = JOptionPane.showConfirmDialog(this, "The file isn't salved? do yo wan to save it??", "", JOptionPane.YES_NO_CANCEL_OPTION);
        if (n == JOptionPane.YES_NO_OPTION) {
            saveFile();
        }
        if (n == JOptionPane.NO_OPTION) {
            txtArea.setText("");
        }
        if (n == JOptionPane.CANCEL_OPTION) {
            
        }
        
    }//GEN-LAST:event_mnNewActionPerformed

    private void mnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSaveActionPerformed
        saveFile();
    }//GEN-LAST:event_mnSaveActionPerformed

    private void mnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnExitActionPerformed
        int n = JOptionPane.showConfirmDialog(this, "The file isn't salved? do yo wan to save it??", "", JOptionPane.YES_NO_CANCEL_OPTION);
        if (n == JOptionPane.YES_NO_OPTION) {
            saveFile();
        }
        if (n == JOptionPane.NO_OPTION) {
            System.exit(0);
        }
        if (n == JOptionPane.CANCEL_OPTION) {
            
        }
        

    }//GEN-LAST:event_mnExitActionPerformed
    private void saveFile() {
        JFileChooser saveFile = new JFileChooser();
        if (saveFile.showSaveDialog(saveFile) == JFileChooser.APPROVE_OPTION) {
            File savefile = saveFile.getSelectedFile();
            PrintWriter outputStream = null;
            if (savefile.exists()) {
                int n = JOptionPane.showConfirmDialog(this, "Do you want to delete the current text?", "Remove test?", JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_NO_OPTION) {
                    try {
                        outputStream = new PrintWriter(new FileWriter(savefile));
                        outputStream.print(txtArea.getText());
                    } catch (IOException ex) {
                        System.out.println("Error");
                    } finally {
                        if (outputStream != null) {
                            outputStream.close();
                        }
                    }
                    
                }
            }
            
        }
    }
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        saveFile();

    }//GEN-LAST:event_btnSaveActionPerformed

    private void doUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doUndoActionPerformed
        undoManager.undo();
    }//GEN-LAST:event_doUndoActionPerformed

    private void doRedoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doRedoActionPerformed
        undoManager.redo();
    }//GEN-LAST:event_doRedoActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnSave;
    private javax.swing.JMenuItem doRedo;
    private javax.swing.JMenuItem doUndo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenu mnAbout;
    private javax.swing.JMenu mnEdit;
    private javax.swing.JMenuItem mnExit;
    private javax.swing.JMenu mnFile;
    private javax.swing.JMenuItem mnNew;
    private javax.swing.JMenuItem mnOpen;
    private javax.swing.JMenuItem mnSave;
    private javax.swing.JTextArea txtArea;
    // End of variables declaration//GEN-END:variables

    private void initMyComponents() {
        addUndoRedo();
    }
}
