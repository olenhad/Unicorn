/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CE2;

/**
 *
 * @author omer
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Vector;
public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     * 
     */
    public String Algo1Chosen="0";
    public String Algo2Chosen="0";
    public String Algo3Chosen="0";
    public Main main;
    public results2 result; 
    public ArrayList<String> InputList = new ArrayList();
    private double budget;
    public double getBudget(){
        return budget;
    }
    private void configOutput(){
        
        String out1= "";
        String[] out1A= null;
        if("1".equals(Algo1Chosen)){
         out1A= main.formatout(main.Algo1Res);
         for(int i=0;i<out1A.length;i++){
             out1=out1+out1A[i];
         }
        }
        
        String out2= "";
        String[] out2A=null;
        if("1".equals(Algo2Chosen)){
            out2A = main.formatout(main.Algo2Res);
        for(int i=0;i< out2A.length;i++){
            out2=out2+out2A[i];
        }
        }
        
        String out3 ="";
        String[] out3A= null;
        if("1".equals(Algo3Chosen)){
            out3A= main.formatout(main.Algo3Res);
        for(int i=0;i< out3A.length;i++){
            out3=out3+out3A[i];
        }
        }/*
        String out1 ="";
        String out2="";
        String out3="";
        if("1".equals(Algo1Chosen)){
        
         for(int i=0;i<main.Algo1Res.length;i++){
             out1=out1+main.Algo1Res[i];
         }
        }
        if("1".equals(Algo2Chosen)){
        
         for(int i=0;i<main.Algo2Res.length;i++){
             out2=out2+main.Algo2Res[i];
         }
        }
        if("1".equals(Algo3Chosen)){
        
         for(int i=0;i<main.Algo3Res.length;i++){
             out3=out3+main.Algo3Res[i];
         }
        }*/
        result.setAlgo1text(out1);
        result.setAlgo2text(out2);
        result.setAlgo3text(out3);
        result.setAlgoTimeLabels(main.Algo1Time, main.Algo2Time, main.Algo3Time);
        if(Algo1Chosen=="1"&& Algo2Chosen=="1"&& Algo3Chosen=="1"){
            
        
        if(main.allEq(main.Algo1Res, main.Algo2Res, main.Algo3Res)[0]==1){
            result.setOutputsAreSame("All Outputs are the same");
        } 
        else{
            switch(main.allEq(main.Algo1Res, main.Algo2Res, main.Algo3Res)[1]){
                case 1: {result.setOutputsAreSame("Recursion returns a different answer.") ;break;}
                case 2: {result.setOutputsAreSame("Dynamic Programming returns a different answer."); break;}
                case 3: {result.setOutputsAreSame("Brute Force returns a different answer."); break;}
                case 4: {result.setOutputsAreSame("All Algos return different answers."); break;}
                default: result.setOutputsAreSame("Something's up. It must be YOUR machine. It worked on mine."); break;
            }
        }
        }
        else if(Algo1Chosen=="1"&& Algo2Chosen=="1"&& Algo3Chosen=="0"){
            if(main.twoEq(main.Algo1Res, main.Algo2Res)){
                result.setOutputsAreSame("Both outputs are equal");
            }else{
                result.setOutputsAreSame("Both outputs are not equal");
            }
        }
        else if(Algo1Chosen=="0"&& Algo2Chosen=="1"&& Algo3Chosen=="1"){
            if(main.twoEq(main.Algo2Res, main.Algo3Res)){
                result.setOutputsAreSame("Both outputs are equal");
            }else{
                result.setOutputsAreSame("Both outputs are not equal");
            }
        }
        else if(Algo1Chosen=="1"&& Algo2Chosen=="0"&& Algo3Chosen=="1"){
            if(main.twoEq(main.Algo1Res, main.Algo3Res)){
                result.setOutputsAreSame("Both outputs are equal");
            }else{
                result.setOutputsAreSame("Both outputs are not equal");
            }
        }
    }
    private String[] getInput(){
        String s;
        
        s = TextBox.getText();
        return s.split("\n");
        
    }
    
    public GUI() {
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

        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextBox = new javax.swing.JTextArea();
        BudgetField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Algo1Box = new javax.swing.JCheckBox();
        Algo2Box = new javax.swing.JCheckBox();
        Algo3Box = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        OpenFile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Enter Item details in the following format:");

        jLabel2.setText("[item name] [price] [satisfaction] [type]");

        TextBox.setColumns(20);
        TextBox.setRows(5);
        jScrollPane1.setViewportView(TextBox);

        jLabel3.setText("Budget");

        Algo1Box.setText("DP");
        Algo1Box.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Algo1BoxMouseClicked(evt);
            }
        });
        Algo1Box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Algo1BoxActionPerformed(evt);
            }
        });

        Algo2Box.setText("Brute");
        Algo2Box.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Algo2BoxMouseClicked(evt);
            }
        });
        Algo2Box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Algo2BoxActionPerformed(evt);
            }
        });

        Algo3Box.setText("Recursion");
        Algo3Box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Algo3BoxActionPerformed(evt);
            }
        });

        jButton1.setText("Go!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        OpenFile.setText("Open from File");
        OpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Algo1Box)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Algo2Box))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BudgetField, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(34, 34, 34)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Algo3Box)
                                .addComponent(OpenFile)))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BudgetField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Algo1Box)
                    .addComponent(Algo2Box)
                    .addComponent(Algo3Box))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(OpenFile)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        result = new results2();
        
        result.setVisible(true);
        main = new Main();
        String chosen = Algo1Chosen+Algo2Chosen+Algo3Chosen;
        
        budget= Double.parseDouble(BudgetField.getText());
        
        main.run(getInput(),budget,chosen );
        configOutput();
      
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Algo1BoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Algo1BoxActionPerformed
        // TODO add your handling code here:
        if(Algo1Box.isSelected()){
            Algo1Chosen="1";
        }
        else{
            Algo1Chosen="0";
        }
       
        
    }//GEN-LAST:event_Algo1BoxActionPerformed

    private void Algo2BoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Algo2BoxActionPerformed
        // TODO add your handling code here:
        if(Algo2Box.isSelected()){
            Algo2Chosen="1";
        }
        else{
            Algo2Chosen="0";
        }
        
    }//GEN-LAST:event_Algo2BoxActionPerformed

    private void Algo3BoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Algo3BoxActionPerformed
        // TODO add your handling code here:
        if(Algo3Box.isSelected()){
            Algo3Chosen="1";
        }
        else{
            Algo3Chosen="0";
        }
        
    }//GEN-LAST:event_Algo3BoxActionPerformed

    private void Algo1BoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Algo1BoxMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_Algo1BoxMouseClicked

    private void Algo2BoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Algo2BoxMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_Algo2BoxMouseClicked
  
    private void OpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenFileActionPerformed
        // TODO add your handling code here:
        
        int returnVal = jFileChooser1.showOpenDialog(this);
        String input;
        
        if (returnVal == jFileChooser1.APPROVE_OPTION) {
            File f = jFileChooser1.getSelectedFile();
            try{
                BufferedReader br=new BufferedReader(new FileReader(f));
                while((input=br.readLine())!=null){
                    //input=input;
               InputList.add(input+"\n");  
                TextBox.append(input+"\n");
                
                                              
               
            }
            }catch(IOException ex){
                System.out.println("IO Error");
            }
            
            
            
            
        }
        
    }//GEN-LAST:event_OpenFileActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Algo1Box;
    private javax.swing.JCheckBox Algo2Box;
    private javax.swing.JCheckBox Algo3Box;
    private javax.swing.JTextField BudgetField;
    private javax.swing.JButton OpenFile;
    private javax.swing.JTextArea TextBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
