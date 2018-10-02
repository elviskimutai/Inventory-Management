/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import geniusapp.*;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eng.Joseph Gitahi
 */
public class sUppliers extends javax.swing.JDialog {

    /**
     * Creates new form sUppliers
     */
   public String RegSource,UserID;
   static SqlConnection _SqlConnection =new SqlConnection();
     Connection con=_SqlConnection.connect();  
      DefaultTableModel model = new DefaultTableModel(new String[]{ "SuppCode", "Suppliernames","PostalAdress","PhysicalAdress","Mobile","Email","Telephone","Fax","IsActive"}, 0);
       Constants _Constants=new Constants();
       public String SuppCode;
    public sUppliers() {
        initComponents();
        LoadSupliers();
        setModal(true);
        setLocationRelativeTo(null);
         SuppliersTable.setModel(model);
        GenerateSUPCODE();
        txtSUPCODE.setEditable(false); 
        
    }
       public void GenerateSUPCODE(){
    try {
           Statement pst=con.createStatement();
            ResultSet rs= pst.executeQuery("{call GenerateSuppCode}");
          
          
             while(rs.next()){
                  String id = rs.getString("SuppCode");
          txtSUPCODE.setText(id);
                 
            }
         
        rs.close();
     pst.close();
            
         
      
        } catch (Exception e) {
            Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Initializing Suppliers");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
        }
}
public void LoadSupliers(){
        try {
            model.setRowCount(0);
           Statement pst=con.createStatement();
            ResultSet rs= pst.executeQuery("{call SelectAllSuppliers}");
            while(rs.next()){
                String SuppCode=rs.getNString("SuppCode");
                String Suppliernames=rs.getNString("Suppliernames");
                String PostalAdress=rs.getNString("PostalAdress");
                String PhysicalAdress=rs.getNString("PhysicalAdress");
                String Mobile=rs.getNString("Mobile");
                
                String Email=rs.getNString("Email");
                
                String Telephone=rs.getNString("Telephone");
                
                String Fax=rs.getNString("Fax");
                 Boolean IsActive = rs.getBoolean("IsActive") ;
                
                model.addRow(new Object[]{SuppCode, Suppliernames,PostalAdress,PhysicalAdress,Mobile,Email,Telephone,Fax,IsActive});
                              
            }
          
            rs.close();
            pst.close();
            
           // UsersTable.setModel(DbUtils.resultSetToTableModel(rs));
      
        } catch (Exception e) {
              Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Load fields Suppliers");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
             
        }
    }
public void getRowValue(){
    try {
        int column = 0;
        int row = SuppliersTable.getSelectedRow();
        String S = SuppliersTable.getModel().getValueAt(row, column).toString();
        SuppCode=S;
        txtSUPCODE.setText(S);
        fillFiields(S);
    } catch (Exception e) {
        Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Selecting Supplier");
            sec.setRegSource(RegSource);
            sec.setUserID(UserID);
            sec.SaveErrors();
    }
}
public void DisableFields(){
            txtSuppName.setEditable(false); 
            txtPostal.setEditable(false); 
            txtPhysical.setEditable(false); 
            txtMobile.setEditable(false); 
            txtEmail.setEditable(false); 
            txtTelephone.setEditable(false); 
            txtFax.setEditable(false); 
            jCheckIsActive.setEnabled(false); 
}
public void EnableFields(){
            txtSuppName.setEditable(true); 
            txtPostal.setEditable(true); 
            txtPhysical.setEditable(true); 
            txtMobile.setEditable(true); 
            txtEmail.setEditable(true); 
            txtTelephone.setEditable(true); 
            txtFax.setEditable(true); 
            jCheckIsActive.enable(true);
}
public void fillFiields(String SuppCode){
    try {
//             Statement pst=con.createStatement();
//                ResultSet rs= pst.executeQuery("{call SelectUser}");
                 PreparedStatement pstmt = con.prepareStatement("{call SelectSuppliers(?,?,?)}");
                pstmt.setString(1, SuppCode);
                pstmt.setString(2, UserID);
                pstmt.setString(3, RegSource);
                ResultSet rs=pstmt.executeQuery();
                while(rs.next()){
                    // JOptionPane.showMessageDialog(null,rs.getNString("UserName"));
            txtSuppName.setText(rs.getNString("FullNames"));
            txtPostal.setText(rs.getNString("PostalAdress"));
            txtPhysical.setText(rs.getNString("PhysicalAdress"));
            txtMobile.setText(rs.getNString("Mobile"));
            txtEmail.setText(rs.getNString("Email"));
            txtTelephone.setText(rs.getNString("Telephone"));
            txtFax.setText(rs.getNString("Fax"));
            jCheckIsActive.setSelected(rs.getBoolean("isActive"));
                            
            }
               DisableFields();
               pstmt.close();
               
               
    } catch (Exception e) {
             Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Filling Fields Suppliers");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
    }
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
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButtonEdit = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtFax = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTelephone = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMobile = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPostal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSuppName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPhysical = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jCheckIsActive = new javax.swing.JCheckBox();
        txtSUPCODE = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        SuppliersTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DEFINE NEW SUPPLIER");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Search_35px.png"))); // NOI18N

        jButtonEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Compose_35px.png"))); // NOI18N
        jButtonEdit.setText("Edit");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        jButtonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Trash_Can_35px.png"))); // NOI18N
        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Data_Recovery_35px.png"))); // NOI18N
        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 676, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonEdit)
                        .addComponent(jButtonDelete)
                        .addComponent(jButtonSave)))
                .addGap(708, 708, 708))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Define New Item Here"));

        jLabel10.setText("Fax");

        jLabel6.setText("Telephone");

        jLabel4.setText("Mobile");

        jLabel1.setText("PostalAdress ");

        jLabel2.setText("Suppier Names");

        txtSuppName.setMinimumSize(new java.awt.Dimension(7, 22));

        jLabel3.setText("PhysicalAdress ");

        jLabel5.setText("Email");

        jCheckIsActive.setText("Is Active");
        jCheckIsActive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckIsActiveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhysical, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtSuppName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtEmail)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFax, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(txtPostal, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                            .addComponent(txtMobile)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelephone)
                            .addComponent(jCheckIsActive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSUPCODE))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSuppName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPostal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhysical, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckIsActive)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFax, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSUPCODE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        SuppliersTable.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        SuppliersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        SuppliersTable.setGridColor(new java.awt.Color(0, 0, 0));
        SuppliersTable.setOpaque(false);
        SuppliersTable.setRowHeight(24);
        SuppliersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SuppliersTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(SuppliersTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckIsActiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckIsActiveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckIsActiveActionPerformed

    private void SuppliersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SuppliersTableMouseClicked
        getRowValue();
        
    }//GEN-LAST:event_SuppliersTableMouseClicked

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        // TODO add your handling code here:
        EnableFields();
        
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        // TODO add your handling code here:
         try {
            String FullNames,PostalAdress,PhysicalAdress,Mobile,Email,Telephone,Fax;           
            Boolean IsActive;
            String SuppCode=txtSUPCODE.getText();
            FullNames=txtSuppName.getText();
            PostalAdress=txtPostal.getText();
            PhysicalAdress=txtPhysical.getText();
            Mobile=txtMobile.getText();
            Email=txtEmail.getText();
            Telephone=txtTelephone.getText();
            Fax=txtFax.getText();
            
            
            IsActive=jCheckIsActive.isSelected();
            //model.addRow(new Object[]{SuppCode, FullNames,PostalAdress,PhysicalAdress,Mobile,Email,Telephone,Fax,IsActive});
                
            Supplier _Supplier=new Supplier( SuppCode,FullNames,  PostalAdress,  PhysicalAdress,  Mobile,  _Constants.getRegSource(),  _Constants.getUserId(),  Email,  Telephone,  Fax,  IsActive);
            if(_Supplier.SaveSupplier()){
                JOptionPane.showMessageDialog(null,"Supllier Saved Successfully");
                LoadSupliers();
                GenerateSUPCODE();
            }
            else{
            JOptionPane.showMessageDialog(null,"Supllier Could Not Be Saved ");
        }
        } catch (Exception e) {
            Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Saving Suppliers");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
        }
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
        try {
            
            Supplier _Supplier=new Supplier();
             _Supplier.setSuppCode(SuppCode);
            if(_Supplier.DeleteSupplier()){
                JOptionPane.showMessageDialog(null,"Supplier Deleted Successfully");
                 LoadSupliers();
            }
        } catch (Exception e) {
             Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Deleting Items");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(sUppliers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sUppliers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sUppliers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sUppliers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sUppliers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable SuppliersTable;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JCheckBox jCheckIsActive;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFax;
    private javax.swing.JTextField txtMobile;
    private javax.swing.JTextField txtPhysical;
    private javax.swing.JTextField txtPostal;
    private javax.swing.JTextField txtSUPCODE;
    private javax.swing.JTextField txtSuppName;
    private javax.swing.JTextField txtTelephone;
    // End of variables declaration//GEN-END:variables
}
