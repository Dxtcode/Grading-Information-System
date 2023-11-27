
package finalproject;
import static java.lang.Double.sum;
import java.sql.*;
import java.text.MessageFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;  
import javax.swing.table.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class GradingSystem extends javax.swing.JFrame {

    private JFrame frame;

Connection con;
Statement st;
PreparedStatement pst;
ResultSet rs;
    public GradingSystem() {
        initComponents();
  
      
    }

    
    public Connection openConnection(){
     if(con==null){
         String url="jdbc:mysql://localhost:3306/";
         String dbName="gradingdb";
         String driver ="com.mysql.jdbc.Driver";
         String userName="root";
         String password="";
         
         try{
         Class.forName(driver);
         this.con=(Connection)DriverManager.getConnection(url+dbName,userName,password);
         System.out.println("Connection Successful");
         }catch(ClassNotFoundException | SQLException sqle) {
             System.out.println("Connection Failed"+sqle+"");
             
         }
     } 
      
      
      return con;
      
  }
    
    
    public void getInfo(String qry){
    try{
        
      pst=openConnection().prepareStatement(qry);
      rs=pst.executeQuery();
      DefaultTableModel tm = (DefaultTableModel)jTable1.getModel();
      tm.setColumnIdentifiers(new Object[]{"ID","Name","Gender","Prelim","Midterm","PreFinal","Final","Average"});
      tm.setRowCount(0);
      
      while(rs.next()){
          Object obj[]={rs.getInt("sid"),rs.getString("sname"),rs.getString("sgender"),rs.getFloat("sprelim"),rs.getFloat("smidterm"),rs.getFloat("sprefinal"),rs.getFloat("sfinal"),rs.getFloat("saverage")};
          tm.addRow(obj);
      }
        
    } catch(SQLException e) {
        System.out.print(e);
    }
         
      
  }
    
   
    
        public void insertRecord(){
        try{
            
         pst=con.prepareStatement("INSERT INTO gradinginfo(sid,sname,sgender,sprelim,smidterm,sprefinal,sfinal,saverage)VALUES(?,?,?,?,?,?,?,?)");   
          pst.setInt(1,0);
         pst.setString(2,sname.getText().toString());
         pst.setString(3,(String)sgender.getSelectedItem());
         pst.setString(4,sprelim.getText().toString());
        pst.setString(5,smidterm.getText().toString());
         pst.setString(6,sprefinal.getText().toString());
          pst.setString(7,sfinal.getText().toString());
           pst.setString(8,saverage.getText().toString());
           
      
           if (sname.getText().isEmpty()||sprelim.getText().isEmpty()||smidterm.getText().isEmpty()||sprefinal.getText().isEmpty()||sfinal.getText().isEmpty()||saverage.getText().isEmpty()){   
             JOptionPane.showMessageDialog(this,"You need to fill up all fields!");
         }else if(sgender.getSelectedItem().equals("Select a Gender")){
             JOptionPane.showMessageDialog(this,"Please Select a Gender!");
         }else{
         int i=pst.executeUpdate();  
         
        JOptionPane.showMessageDialog(this,"Record added successfully!");
  updateRecord();
         } 
  
        }catch(SQLException e){
            System.out.print(e);
        }
    }  
  

   public void updateRecord(){
       int q,i;
        try{
      
         pst=con.prepareStatement("SELECT * FROM gradinginfo");      

      rs=pst.executeQuery();
      ResultSetMetaData model = rs.getMetaData();
      
      q = model.getColumnCount();
      DefaultTableModel tm = (DefaultTableModel)jTable1.getModel();
      tm.setRowCount(0);
         
  while(rs.next()){
          Vector columnData = new Vector ();      
          for (i = 1; i <= q;i++){
              columnData.add(rs.getInt("sid"));
              columnData.add(rs.getString("sname"));
              columnData.add(rs.getString("sgender"));
              columnData.add(rs.getString("sprelim"));
              columnData.add(rs.getString("smidterm"));
              columnData.add(rs.getString("sprefinal"));
              columnData.add(rs.getString("sfinal"));
              columnData.add(rs.getString("saverage"));
              
              
          } 
              
          tm.addRow(columnData);
      }
  
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }  
        
        
    
    
    
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        sname = new javax.swing.JTextField();
        sprelim = new javax.swing.JTextField();
        sprefinal = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        saverage = new javax.swing.JTextField();
        sid = new javax.swing.JTextField();
        smidterm = new javax.swing.JTextField();
        sgender = new javax.swing.JComboBox<>();
        sfinal = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btndelete = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        calculate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 204, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 204, 0));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 40)); // NOI18N
        jLabel1.setText("Grading Information System");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 680, 50));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/finalproject/st1.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 100, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 70));

        jPanel2.setBackground(new java.awt.Color(0, 204, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 173), 4));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Name:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 100, 30));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Gender:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 100, 30));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Prelim:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 100, 30));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Midterm:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 100, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("PreFinal:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 100, 30));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Final:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 100, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Average:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 100, 30));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Student ID:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 100, 30));

        sname.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        sname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                snameActionPerformed(evt);
            }
        });
        jPanel3.add(sname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 280, 30));

        sprelim.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        sprelim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sprelimActionPerformed(evt);
            }
        });
        jPanel3.add(sprelim, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 280, 30));

        sprefinal.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        sprefinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sprefinalActionPerformed(evt);
            }
        });
        jPanel3.add(sprefinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 280, 30));

        jTextField4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 280, 30));

        saverage.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        saverage.setEnabled(false);
        saverage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saverageActionPerformed(evt);
            }
        });
        jPanel3.add(saverage, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 280, 30));

        sid.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        sid.setText("Auto Generated ID Number");
        sid.setEnabled(false);
        sid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sidActionPerformed(evt);
            }
        });
        jPanel3.add(sid, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 280, 30));

        smidterm.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        smidterm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smidtermActionPerformed(evt);
            }
        });
        jPanel3.add(smidterm, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 280, 30));

        sgender.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        sgender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a Gender...", "Male", "Female" }));
        sgender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sgenderActionPerformed(evt);
            }
        });
        jPanel3.add(sgender, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 280, 30));

        sfinal.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        sfinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sfinalActionPerformed(evt);
            }
        });
        jPanel3.add(sfinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 280, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 510, 420));

        jPanel4.setBackground(new java.awt.Color(255, 255, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 173), 4));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 810, 400));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 830, 420));

        jPanel5.setBackground(new java.awt.Color(255, 255, 153));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 173), 4));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btndelete.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        jPanel5.add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 10, 90, 40));

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 10, 90, 40));

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton4.setText("Refresh");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, -1, 40));

        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton5.setText("Insert");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, 90, 40));

        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton6.setText("Print");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 90, 40));

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 10, 90, 40));

        calculate.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        calculate.setText("Calculate Average");
        calculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateActionPerformed(evt);
            }
        });
        jPanel5.add(calculate, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 180, 40));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 1350, 60));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1370, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
frame= new JFrame("Exit"); 
if(JOptionPane.showConfirmDialog(frame,"Confirm if you want to exit","Grading System",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
    System.exit(0);
}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
         int index=jTable1.getSelectedRow();
       TableModel model= jTable1.getModel();   
       try{
         //  int id = Integer.parseInt(model.getValueAt(index, 0).toString() );
        int deleteItem = JOptionPane.showConfirmDialog(null,"Confirm if you want to delete item","Warning",JOptionPane.YES_NO_OPTION);
        
        if (deleteItem == JOptionPane.YES_OPTION){
 
         pst=con.prepareStatement("DELETE FROM `gradinginfo` WHERE `sid` = ?");  
      
        JOptionPane.showMessageDialog(this,"Deleted successfully!");
        updateRecord();

         sid.requestFocus();
         sid.setText("");
         sname.setText("");
         sgender.setSelectedIndex(0);
         sprelim.setText("");
         smidterm.setText("");
         sprefinal.setText("");
         sfinal.setText("");
         saverage.setText("");
         
        }
         
     
        }catch(SQLException e){
            System.out.print(e);
        }
    

    }//GEN-LAST:event_btndeleteActionPerformed

    private void snameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_snameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_snameActionPerformed

    private void sprelimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sprelimActionPerformed
     
    }//GEN-LAST:event_sprelimActionPerformed

    private void sprefinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sprefinalActionPerformed
      
    }//GEN-LAST:event_sprefinalActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void sidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sidActionPerformed

    private void smidtermActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smidtermActionPerformed
     
    }//GEN-LAST:event_smidtermActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        getInfo("SELECT * FROM gradinginfo");
          
    }//GEN-LAST:event_jButton4ActionPerformed

    private void sfinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sfinalActionPerformed
      
    }//GEN-LAST:event_sfinalActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
      MessageFormat header = new  MessageFormat("Printing in progress");
        MessageFormat footer = new  MessageFormat("Page {0, number, integer}");
        
       try
       {
           jTable1.print(JTable.PrintMode.NORMAL,header,footer);
       }
        catch(java.awt.print.PrinterException e)
        {
            System.out.format("No Printer found",e.getMessage());
        }
      
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int index=jTable1.getSelectedRow();
       TableModel model= jTable1.getModel();
       sid.setText(model.getValueAt(index,0).toString());
       sname.setText(model.getValueAt(index,1).toString());
        sgender.setSelectedItem(model.getValueAt(index,2).toString());
        sprelim.setText(model.getValueAt(index,3).toString());
         smidterm.setText(model.getValueAt(index,4).toString());
        sprefinal.setText(model.getValueAt(index,5).toString());
        sfinal.setText(model.getValueAt(index,6).toString());
        saverage.setText(model.getValueAt(index,7).toString());
       
       
       
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
insertRecord();          
         
       
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
  
       int index=jTable1.getSelectedRow();
       TableModel model= jTable1.getModel();   
       try{
    
         pst=con.prepareStatement("UPDATE gradinginfo SET `sname` = ?,`sgender` = ?,`sprelim` = ?,`smidterm` = ?,`sprefinal` = ?,`sfinal` = ?,`saverage` = ? WHERE sid= ?");   
        pst.setInt(1,0);
         pst.setString(2,sname.getText().toString());
         pst.setString(3,(String)sgender.getSelectedItem());
         pst.setString(4,sprelim.getText().toString());
        pst.setString(5,smidterm.getText().toString());
         pst.setString(6,sprefinal.getText().toString());
          pst.setString(7,sfinal.getText().toString());
           pst.setString(8,saverage.getText().toString());
         
           
         pst.executeUpdate();
        JOptionPane.showMessageDialog(this,"Record updated successfully!");
        updateRecord();

        
  
        }catch(SQLException e){
            System.out.print(e);
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void calculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateActionPerformed
double prelim,midterm,prefinal,finalg,average;      
        prelim= Double.parseDouble(sprelim.getText());
       midterm= Double.parseDouble(smidterm.getText());
       prefinal= Double.parseDouble(sprefinal.getText());
        finalg= Double.parseDouble(sfinal.getText());
        if (sprelim.getText().isEmpty()||smidterm.getText().isEmpty()||sprefinal.getText().isEmpty()||sfinal.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"You need to fill up all grades!");
        }else {
            String answer;
            average = (prelim+midterm+prefinal+finalg)/4;
            answer = String.format("%.1f",average);
            saverage.setText(answer);
            
            JOptionPane.showMessageDialog(this,"Grades calculated successfully!");
        }
    }//GEN-LAST:event_calculateActionPerformed

    private void saverageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saverageActionPerformed

    }//GEN-LAST:event_saverageActionPerformed

    private void sgenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sgenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sgenderActionPerformed

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
            java.util.logging.Logger.getLogger(GradingSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GradingSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GradingSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GradingSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GradingSystem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndelete;
    private javax.swing.JButton calculate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField saverage;
    private javax.swing.JTextField sfinal;
    private javax.swing.JComboBox<String> sgender;
    private javax.swing.JTextField sid;
    private javax.swing.JTextField smidterm;
    private javax.swing.JTextField sname;
    private javax.swing.JTextField sprefinal;
    private javax.swing.JTextField sprelim;
    // End of variables declaration//GEN-END:variables

    private void getInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Object sgender() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}