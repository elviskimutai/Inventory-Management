
package Forms;

import geniusapp.Constants;
import geniusapp.Inventory;
import geniusapp.Security;
import geniusapp.SqlConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class InventoryAdjustment extends javax.swing.JDialog {

   static SqlConnection _SqlConnection =new SqlConnection();
     Connection con=_SqlConnection.connect();
     Constants _Constants=new Constants();
     DefaultTableModel model = new DefaultTableModel(new String[]{ "DocNo", "TransDate","ItemCode","Quantity","UnitCost","ExtendedCost"}, 0);
      
    public InventoryAdjustment() {
        initComponents();
          setModal(true);
        setLocationRelativeTo(null);
        GenerateDOCNO();
        LoadInventoryAdjustment();
        INTable.setModel(model);
        jTextFieldDoCNo.setEnabled(false);
        fillitems();
        txtNewQUantity.setEnabled(false);
        TXTCurentQTY.setEnabled(false);                
        txtCurrentValue.setEnabled(false);
        txtNewValue.setEnabled(false);
        TXTCurentQTY.setText("0.0");
        txtCurrentValue.setText("0.0");
        txtNewValue.setText("0.0");
        txtNewQUantity.setText("0.0");
        jTextFieldDoCNo.setEnabled(false);
    }
    public void LoadInventoryAdjustment(){
        try {
            model.setRowCount(0);
           Statement pst=con.createStatement();
            ResultSet rs= pst.executeQuery("{call SpSelectAllInventoryAdjustment}");
            while(rs.next()){
                String DocNo=rs.getNString("DocNo");
                Date TransDate=rs.getDate("TransDate");
                String ItemCode=rs.getNString("ItemCode");
                Float Quantity=rs.getFloat("Quantity");
                Double  UnitCost=rs.getDouble("UnitCost");
                
                Double  ExtendedCost=rs.getDouble("ExtendedCost");
                
                
                
                model.addRow(new Object[]{DocNo, TransDate,ItemCode,Quantity,UnitCost,ExtendedCost});
                              
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
 public void fillitems(){
    try {
           Statement pst=con.createStatement();
            ResultSet rs= pst.executeQuery("{call SelectAllItems}");
          
           jComItems.addItem("ItemCode   /  ItemName");
             while(rs.next()){
            String id = rs.getString("ItemCode");
            String nme = rs.getString("ItemName");
            String cmb = (id+ "  /  "+nme);
             
                jComItems.addItem(cmb);    
                 
            }
         
        rs.close();
     pst.close();
            
         
      
        } catch (Exception e) {
            e.printStackTrace();
             System.out.println( e.getMessage() );
             
        }
}
  public void ComputeNewValues(){
    try {
            String   Item1=jComItems.getSelectedItem().toString();
              String[] parts = Item1.split("/");
              String Item = parts[0];
              Float qty=Float.parseFloat(String.valueOf(txtQTY.getText()));
              PreparedStatement pst=con.prepareStatement("{call computestocknewvalue(?,?)}");
              pst.setString(1, Item);
              pst.setFloat(2, qty);
              ResultSet rs=pst.executeQuery();
                while(rs.next()){
                    // JOptionPane.showMessageDialog(null,rs.getNString("UserName"));
                txtNewQUantity.setText(Float.toString(rs.getFloat("NewStockQuantity")));
                txtNewQUantity.setEnabled(false);
                txtNewValue.setText(Double.toString(rs.getDouble("NewValue")));
                txtNewValue.setEnabled(false);
             
                 
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
 public void GenerateDOCNO(){
    try {
           Statement pst=con.createStatement();
            ResultSet rs= pst.executeQuery("{call GenerateInventoryAdjustmentDOCNO}");
           
          
             while(rs.next()){
                  String id = rs.getString("DOCCode");
          jTextFieldDoCNo.setText(id);
                 
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        INTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        txtCurrentValue = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldDOCType = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldDoCNo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TXTCurentQTY = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jComItems = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        txtNewQUantity = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtQTY = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNewValue = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Reason = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButtonSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("INVENTORY ADJUSTMENTS");

        INTable.setBackground(new java.awt.Color(204, 204, 255));
        INTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        INTable.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        INTable.setModel(new javax.swing.table.DefaultTableModel(
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
        INTable.setGridColor(new java.awt.Color(204, 255, 255));
        INTable.setRowHeight(25);
        jScrollPane1.setViewportView(INTable);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "INVENTORY ADJUSTMENTS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(51, 51, 255))); // NOI18N
        jPanel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtCurrentValue.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtCurrentValue.setDisabledTextColor(new java.awt.Color(255, 51, 51));

        jLabel1.setText("current Value");

        jLabel2.setText("DOC Type");

        jTextFieldDOCType.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldDOCType.setText("IA");
        jTextFieldDOCType.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldDOCType.setEnabled(false);

        jLabel3.setText("DOC NO");

        jTextFieldDoCNo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextFieldDoCNo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldDoCNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDoCNoActionPerformed(evt);
            }
        });

        jLabel4.setText("Current Quantity");

        TXTCurentQTY.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        TXTCurentQTY.setDisabledTextColor(new java.awt.Color(153, 153, 255));

        jLabel12.setText("Select Item");

        jComItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComItemsActionPerformed(evt);
            }
        });

        jLabel5.setText("New Quantity");

        txtNewQUantity.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtNewQUantity.setDisabledTextColor(new java.awt.Color(153, 153, 255));

        jLabel6.setText("Adjustment Quantity");

        txtQTY.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtQTY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQTYActionPerformed(evt);
            }
        });

        jLabel7.setText("New Value");

        txtNewValue.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtNewValue.setDisabledTextColor(new java.awt.Color(255, 51, 51));

        jLabel8.setText("Reason for Adjustment");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TXTCurentQTY, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComItems, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNewQUantity, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtQTY, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Reason))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 268, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDOCType, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDoCNo, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtNewValue, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCurrentValue, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(207, 207, 207))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComItems, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDOCType, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TXTCurentQTY, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDoCNo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQTY, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCurrentValue, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNewQUantity, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNewValue, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Reason, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Search_35px.png"))); // NOI18N

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addComponent(jButtonSave)))
                .addGap(708, 708, 708))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldDoCNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDoCNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDoCNoActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        try {

            String Item1=jComItems.getSelectedItem().toString();
            String[] parts2 = Item1.split("/");
            String Item = parts2[0];

            String DocNo=jTextFieldDoCNo.getText();
            String DocType=jTextFieldDOCType.getText();

            String Remarks=Reason.getText();

            float Quantity=Float.parseFloat(String.valueOf(txtQTY.getText()));

            Inventory _Inventory=new Inventory( );
            _Inventory.setItemCode(Item);
            _Inventory.setDocNo(DocNo);
            _Inventory.setDocType(DocType);
            _Inventory.setRemarks(Remarks);
            _Inventory.setQuantity(Quantity);
            if(_Inventory.SaveInventoryAdjustments()){
                JOptionPane.showMessageDialog(null,"Inventory Adjustments Saved Successfully");

            }else{
                JOptionPane.showMessageDialog(null,"Inventory Adjustments Could Not Be Saved");
            }

        } catch (Exception e) {
            e.printStackTrace();
            Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Initializing Suppliers");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
        }
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void txtQTYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQTYActionPerformed
        ComputeNewValues();
    }//GEN-LAST:event_txtQTYActionPerformed

    private void jComItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComItemsActionPerformed
          try {
            String   Item1=jComItems.getSelectedItem().toString();
              String[] parts = Item1.split("/");
              String Item = parts[0];
           
              PreparedStatement pst=con.prepareStatement("{call computeItemvalue(?)}");
              pst.setString(1, Item);
             
              ResultSet rs=pst.executeQuery();
                while(rs.next()){
                    // JOptionPane.showMessageDialog(null,rs.getNString("UserName"));
                TXTCurentQTY.setText(Float.toString(rs.getFloat("StockQuantity")));
                TXTCurentQTY.setEnabled(false);
                txtCurrentValue.setText(Double.toString(rs.getDouble("Value")));
                txtCurrentValue.setEnabled(false);
                txtNewValue.setText("0.0");
                     txtNewQUantity.setText("0.0");
                 
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
    }//GEN-LAST:event_jComItemsActionPerformed

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
            java.util.logging.Logger.getLogger(InventoryAdjustment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InventoryAdjustment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InventoryAdjustment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventoryAdjustment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InventoryAdjustment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable INTable;
    private javax.swing.JTextField Reason;
    private javax.swing.JTextField TXTCurentQTY;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JComboBox jComItems;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldDOCType;
    private javax.swing.JTextField jTextFieldDoCNo;
    private javax.swing.JTextField txtCurrentValue;
    private javax.swing.JTextField txtNewQUantity;
    private javax.swing.JTextField txtNewValue;
    private javax.swing.JTextField txtQTY;
    // End of variables declaration//GEN-END:variables
}
