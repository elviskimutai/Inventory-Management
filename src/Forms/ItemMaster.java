/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import geniusapp.Constants;
import geniusapp.Item;
import geniusapp.Security;
import geniusapp.SqlConnection;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eng.Joseph Gitahi
 */
public class ItemMaster extends javax.swing.JDialog   {

    /**
     * Creates new form ItemMaster
     */
     static SqlConnection _SqlConnection =new SqlConnection();
     Connection con=_SqlConnection.connect();
     Constants _Constants=new Constants();
    public ItemMaster() {
        initComponents();
        
        
        setModal(true);
        setLocationRelativeTo(null);
        LoadItemss();
    }
public void LoadItemss(){
        try {
           Statement pst=con.createStatement();
            ResultSet rs= pst.executeQuery("{call SelectAllItems}");
            DefaultTableModel model = new DefaultTableModel(new String[]{ "ItemCode", "ItemName","ItemDescription","CostPrice","SellingPrice","VATInclusive","VATValue","UOM"}, 0);
            while(rs.next()){
                String U=rs.getNString("ItemCode");
                String N=rs.getNString("ItemName");
                String E=rs.getNString("ItemDescription");
                
                String Em=rs.getString("CostPrice") ;//.getNString("CostPrice");
                String T=rs.getString("CostPrice") ;//getNString("SellingPrice");
                
                Boolean Nm= rs.getBoolean("VATInclusive");// getNString("VATInclusive");
                float Ek=rs.getFloat("VATValue");// getNString("VATValue");
                String Emm=rs.getNString("UOM");
              
                model.addRow(new Object[]{U, N,E,Em,T,Nm,Ek,Emm});
                              
            }
           TblItems.setModel(model);
            pst.close();
           // UsersTable.setModel(DbUtils.resultSetToTableModel(rs));
      
        } catch (Exception e) {
              Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Loading Items to jtable");
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
        BTNUpdate = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtVATValue = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtSellingPrice = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Itemdesc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ItemCode = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ItemCode1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtItemName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtItemCostprice = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblItems = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DEFINE NEW ITEM HERE");
        setBackground(new java.awt.Color(204, 204, 255));
        setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Search_35px.png"))); // NOI18N

        BTNUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Update_35px.png"))); // NOI18N
        BTNUpdate.setText("Update");
        BTNUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNUpdateActionPerformed(evt);
            }
        });

        jButtonEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Compose_35px.png"))); // NOI18N
        jButtonEdit.setText("Edit");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Trash_Can_35px.png"))); // NOI18N
        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTNUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(BTNUpdate)
                        .addComponent(jButtonEdit)
                        .addComponent(jButton1)
                        .addComponent(jButtonSave)))
                .addGap(708, 708, 708))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Define New Item Here"));

        jLabel10.setText("VAT Value");

        jLabel6.setText("Selling Price");

        jLabel4.setText("Item Description");

        jLabel1.setText("BarCode");

        jLabel2.setText("Item Code");

        jLabel3.setText("Item Name");

        jLabel5.setText("Cost Price");

        jCheckBox1.setText("VAT Inclusive");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Each", "Box", "Whole" }));

        jLabel11.setText("Unit of Measure");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(ItemCode1)
                        .addComponent(txtItemCostprice)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 279, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtVATValue, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(ItemCode, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(99, 99, 99))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Itemdesc, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSellingPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap()))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ItemCode1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ItemCode, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Itemdesc, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtItemCostprice, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSellingPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVATValue, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 33, Short.MAX_VALUE))))
        );

        TblItems.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        TblItems.setModel(new javax.swing.table.DefaultTableModel(
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
        TblItems.setGridColor(new java.awt.Color(255, 255, 255));
        TblItems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblItemsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TblItems);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void TblItemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblItemsMouseClicked
        // TODO add your handling code he
        getRowValue();
    }//GEN-LAST:event_TblItemsMouseClicked
public void getRowValue(){
    try {
        int column = 0;
        int row = TblItems.getSelectedRow();
        String ItemCode = TblItems.getModel().getValueAt(row, column).toString();
       // JOptionPane.showMessageDialog(null,value);
        fillFiields(ItemCode);
    } catch (Exception e) {
         Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Getting Items from jtable");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
    }
}
public void DisableFields(){
       ItemCode1.enable(false);
            txtItemName.enable(false);
            Itemdesc.enable(false);
            jComboBox2.enable(false);
          
            txtVATValue.enable(false);
            jCheckBox1.enable(false);
           txtSellingPrice.enable(false);
            txtItemCostprice.enable(false);
            
            
}
public void EnableFields(){
        ItemCode1.enable(true);
            txtItemName.enable(true);
            Itemdesc.enable(true);
            jComboBox2.enable(true);
          
            txtVATValue.enable(true);
            jCheckBox1.enable(true);
           txtSellingPrice.enable(true);
            txtItemCostprice.enable(true);
            
            
}
public void fillFiields(String ItemCode){
    try {

        try (PreparedStatement pstmt = con.prepareStatement("{call SelectItems(?)}")) {
            pstmt.setString(1, ItemCode);
            
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                ItemCode1.setText(rs.getNString("ItemCode"));
                txtItemName.setText(rs.getNString("ItemName"));
                Itemdesc.setText(rs.getNString("ItemDescription"));
                jComboBox2.setSelectedItem(rs.getNString("UOM"));
                
                txtVATValue.setText(String.valueOf(rs.getFloat("VATValue")));
                jCheckBox1.setSelected(rs.getBoolean("VATInclusive"));
              //  String s=String.valueOf(rs.getFloat("VATValue"));
                txtSellingPrice.setText(String.valueOf(rs.getFloat("SellingPrice")));
                txtItemCostprice.setText(String.valueOf(rs.getFloat("CostPrice")));
                
                
                
            }
            pstmt.close();
            DisableFields();
        }
               // con.close();
    } catch (Exception e) {
             Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Filling Fields Item Master");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
    }
}
 
    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        // TODO add your handling code here:
          try {
            String ItemCode,ItemName,ItemDescription,UOM;
            Double SellingPrice,CostPrice;
            Float VATValue;
            Boolean VATInclusive;

            ItemCode=ItemCode1.getText();
            ItemName=txtItemName.getText();
            ItemDescription=Itemdesc.getText();
            UOM=jComboBox2.getSelectedItem().toString();
           
            VATValue=Float.parseFloat(txtVATValue.getText());
            VATInclusive=jCheckBox1.isSelected();
            SellingPrice=Double.parseDouble(txtSellingPrice.getText());
            CostPrice=Double.parseDouble(txtItemCostprice.getText());
            Item _Item=new Item( ItemCode,  ItemName,  ItemDescription,  UOM,  _Constants.getRegSource(),  _Constants.getUserId(),  SellingPrice, CostPrice,  VATValue,  VATInclusive);
            if(_Item.SaveItem()){
                JOptionPane.showMessageDialog(null,"Item Saved Successfully");
                 LoadItemss();
            }
        } catch (Exception e) {
             Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Saving Items");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
        }
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        EnableFields();
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void BTNUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNUpdateActionPerformed
        // TODO add your handling code here:
         try {
            String ItemCode,ItemName,ItemDescription,UOM;
            Double SellingPrice,CostPrice;
            Float VATValue;
            Boolean VATInclusive;

            ItemCode=ItemCode1.getText();
            ItemName=txtItemName.getText();
            ItemDescription=Itemdesc.getText();
            UOM=jComboBox2.getSelectedItem().toString();
           
            VATValue=Float.parseFloat(txtVATValue.getText());
            VATInclusive=jCheckBox1.isSelected();
            SellingPrice=Double.parseDouble(txtSellingPrice.getText());
            CostPrice=Double.parseDouble(txtItemCostprice.getText());
            Item _Item=new Item( ItemCode,  ItemName,  ItemDescription,  UOM,  _Constants.getRegSource(),  _Constants.getUserId(),  SellingPrice, CostPrice,  VATValue,  VATInclusive);
            if(_Item.SaveItem()){
                JOptionPane.showMessageDialog(null,"Item Saved Successfully");
                 LoadItemss();
            }
        } catch (Exception e) {
             Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Saving Items");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
        }
    }//GEN-LAST:event_BTNUpdateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         try {
            String ItemCode,ItemName;
          

            ItemCode=ItemCode1.getText();
            ItemName=txtItemName.getText();
            
            Item _Item=new Item();
             _Item.setItemCode(ItemCode);
             _Item.setItemName(ItemName);
            if(_Item.DeleteItem()){
                JOptionPane.showMessageDialog(null,"Item Deleted Successfully");
                 LoadItemss();
            }
        } catch (Exception e) {
             Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Deleting Items");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ItemMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ItemMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ItemMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ItemMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ItemMaster().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNUpdate;
    private javax.swing.JTextField ItemCode;
    private javax.swing.JTextField ItemCode1;
    private javax.swing.JTextField Itemdesc;
    public javax.swing.JTable TblItems;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JTextField txtItemCostprice;
    private javax.swing.JTextField txtItemName;
    private javax.swing.JTextField txtSellingPrice;
    private javax.swing.JTextField txtVATValue;
    // End of variables declaration//GEN-END:variables
}
