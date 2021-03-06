/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CE2;

/**
 *
 * @author omer
 */
public class results2 extends javax.swing.JFrame {

    /**
     * Creates new form results2
     */
    public void setOutputsAreSameVis(boolean v){
        OutputsAreSame.setVisible(v);
    }
    public void setAlgo1text(String S){
        Algo1TextArea.setText(S);
    }
    public void setAlgo2text(String S){
        Algo2TextArea.setText(S);
    }
    public void setAlgo3text(String S){
        Algo3TextArea.setText(S);
    }
    public void setAlgoTimeLabels(String a1, String a2, String a3){
        Algo1TimeLabel.setText(a1);
        Algo2TimeLabel.setText(a2);
        Algo3TimeLabel.setText(a3);
    }
    public results2() {
        initComponents();
    }
    public void setOutputsAreSame(String S){
        OutputsAreSame.setText(S);
    }
    public void Algo1SetVisibile(boolean b){
        Algo1.setVisible(b);
    }
    public void Algo2SetVisibile(boolean b){
        Algo2.setVisible(b);
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        Algo1 = new javax.swing.JPanel();
        scrollPane1 = new java.awt.ScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        Algo1TextArea = new javax.swing.JTextArea();
        Algo2 = new javax.swing.JPanel();
        scrollPane2 = new java.awt.ScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        Algo2TextArea = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        scrollPane3 = new java.awt.ScrollPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        Algo3TextArea = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        Algo1Time = new javax.swing.JLabel();
        Algo2Time = new javax.swing.JLabel();
        Algo3Time = new javax.swing.JLabel();
        Algo1TimeLabel = new javax.swing.JLabel();
        Algo2TimeLabel = new javax.swing.JLabel();
        Algo3TimeLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        OutputsAreSame = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(800, 600));

        Algo1TextArea.setColumns(20);
        Algo1TextArea.setRows(5);
        jScrollPane1.setViewportView(Algo1TextArea);

        scrollPane1.add(jScrollPane1);

        javax.swing.GroupLayout Algo1Layout = new javax.swing.GroupLayout(Algo1);
        Algo1.setLayout(Algo1Layout);
        Algo1Layout.setHorizontalGroup(
            Algo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Algo1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                .addContainerGap())
        );
        Algo1Layout.setVerticalGroup(
            Algo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Algo1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Dynamic Programming", Algo1);

        Algo2TextArea.setColumns(20);
        Algo2TextArea.setRows(5);
        jScrollPane3.setViewportView(Algo2TextArea);

        scrollPane2.add(jScrollPane3);

        javax.swing.GroupLayout Algo2Layout = new javax.swing.GroupLayout(Algo2);
        Algo2.setLayout(Algo2Layout);
        Algo2Layout.setHorizontalGroup(
            Algo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Algo2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                .addContainerGap())
        );
        Algo2Layout.setVerticalGroup(
            Algo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Algo2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Brute Force", Algo2);

        Algo3TextArea.setColumns(20);
        Algo3TextArea.setRows(5);
        jScrollPane4.setViewportView(Algo3TextArea);

        scrollPane3.add(jScrollPane4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Recursion", jPanel1);

        jLabel4.setText("<html>\n<b>\nTime Taken:\n</b>\n</html>");

        Algo1Time.setText("Dynamic : ");

        Algo2Time.setText("Brute:");

        Algo3Time.setText("Recursion:");

        Algo1TimeLabel.setText("...");

        Algo2TimeLabel.setText("...");

        Algo3TimeLabel.setText("...");

        OutputsAreSame.setText("Outputs Same?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Algo1Time)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Algo1TimeLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(OutputsAreSame))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(Algo2Time)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Algo2TimeLabel))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(Algo3Time)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(Algo3TimeLabel))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jTabbedPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Algo1Time)
                            .addComponent(Algo1TimeLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Algo2Time)
                            .addComponent(Algo2TimeLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Algo3Time)
                            .addComponent(Algo3TimeLabel))
                        .addGap(18, 18, 18)
                        .addComponent(OutputsAreSame)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Algo1;
    private javax.swing.JTextArea Algo1TextArea;
    private javax.swing.JLabel Algo1Time;
    private javax.swing.JLabel Algo1TimeLabel;
    private javax.swing.JPanel Algo2;
    private javax.swing.JTextArea Algo2TextArea;
    private javax.swing.JLabel Algo2Time;
    private javax.swing.JLabel Algo2TimeLabel;
    private javax.swing.JTextArea Algo3TextArea;
    private javax.swing.JLabel Algo3Time;
    private javax.swing.JLabel Algo3TimeLabel;
    private javax.swing.JLabel OutputsAreSame;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private java.awt.ScrollPane scrollPane1;
    private java.awt.ScrollPane scrollPane2;
    private java.awt.ScrollPane scrollPane3;
    // End of variables declaration//GEN-END:variables
}
