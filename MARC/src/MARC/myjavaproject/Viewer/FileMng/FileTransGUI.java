package MARC.myjavaproject.Viewer.FileMng;

import MARC.Administrator.ServerMainWindoeForInitiating;
import MARC.myjavaproject.LogInfo.ForAdministrator.AppLogInfoForAdministrator;
import MARC.myjavaproject.ViewerHelper.Recorder;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

//import RDP_Util.main;
import MARC.myjavaproject.main;
import MARC.myjavaproject.utilities.FileUtility;
import java.awt.Toolkit;
//import RDP_Util.utilities.FileUtility;
//import RDP_Util.viewer.Recorder;


public class FileTransGUI extends javax.swing.JFrame {
    private Recorder recorder;
        
    private boolean canceled = false;
    private boolean done = false;
    
    private File[] files;
    private long index = 0;    
    private long count = 0;
    private long size = 0;
    private long startedAt = 0;
    private long duration = 0;
    private long speed = 0;    
    private float leftEstim = 0.0f;
    private float totalEstim = 0.0f;   
    
    /** Creates new form FileTransGui */
    public FileTransGUI(Recorder recorder) {
        this.recorder = recorder;
        initComponents();
        setVisible(true);
        startedAt = System.currentTimeMillis();

        setIconImage(Toolkit.getDefaultToolkit().getImage("resourse/Project-icon16.png"));

    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jLabelCurrentFile = new javax.swing.JLabel();
        jLabelFileCount = new javax.swing.JLabel();
        jLabelTotalSize = new javax.swing.JLabel();
        jLabelSpeed = new javax.swing.JLabel();
        jLabelDuration = new javax.swing.JLabel();
        jButtonClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("File Transmission");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 0, 51), 2, true));

        jProgressBar1.setForeground(new java.awt.Color(178, 100, 106));
        jProgressBar1.setMaximumSize(new java.awt.Dimension(150, 20));
        jProgressBar1.setMinimumSize(new java.awt.Dimension(150, 20));
        jProgressBar1.setPreferredSize(new java.awt.Dimension(150, 20));
        jProgressBar1.setStringPainted(true);

        jLabel1.setText("Current file:");

        jLabelFileCount.setText("0 file(s)");

        jLabelTotalSize.setText("0 KB");

        jLabelSpeed.setText("0 KB/S");

        jLabelDuration.setText("0 Seconds");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDuration)
                            .addComponent(jLabelSpeed)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelCurrentFile, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelTotalSize)
                                    .addComponent(jLabelFileCount))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCurrentFile, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDuration)
                    .addComponent(jLabelFileCount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSpeed)
                    .addComponent(jLabelTotalSize))
                .addGap(17, 17, 17))
        );

        jButtonClose.setText("Cancel");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(301, Short.MAX_VALUE)
                .addComponent(jButtonClose)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-384)/2, (screenSize.height-209)/2, 384, 209);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        if (done) dispose();
        else if (JOptionPane.showConfirmDialog(this, 
               "Stop file transmission ?", "Confirm Dialog", 
               JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE)
               == JOptionPane.OK_OPTION) {       
                canceled = true;      
                dispose();
            }


//          this line shows log info on consone and adminLogInfoTextArea
            if(ServerMainWindoeForInitiating.isLogEnable == Boolean.TRUE)
            {
                AppLogInfoForAdministrator.logger.info("Transmition of " + filName + " has been cancled.");
            }


}//GEN-LAST:event_jButtonCloseActionPerformed

private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (evt.getID() == WindowEvent.WINDOW_CLOSING)
            jButtonCloseActionPerformed(null);        
        else
            super.processWindowEvent(evt);
}//GEN-LAST:event_formWindowClosing
          
    private SwingWorker sendingWorker = new SwingWorker() {
        @Override
        protected Object doInBackground() throws Exception {



            recorder.fileManager.SendFiles(FileTransGUI.this, files);




            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        protected void done() {
            Done();
        }      
    };
        
    private SwingWorker receivingWorker = new SwingWorker() {
        @Override
        protected Object doInBackground() throws Exception {



            recorder.fileManager.ReceiveFiles(FileTransGUI.this, files);


            
            throw new UnsupportedOperationException("Not supported yet.");
        }
            
        @Override
        protected void done() {
            Done();
        }             
   };
       
   public boolean isCanceled () {
        return canceled;
   }   
   
   public void Done() {
        done = true;
        jButtonClose.setText("Close");
        setTitle("File Transmission [Done !! ]");       
   }
   
   public void ReceiveFiles (ArrayList arrayList) {
        setTitle("File Transmission [Receiving ...]");       
        recorder.fileManager.setServerDownloadingFolder(
                arrayList.get(0).toString());
        recorder.fileManager.setDownloadingFolder(
                FileUtility.getCurrentDirectory());
        files = (File[]) arrayList.get(1);
        count = files.length;        
        
        receivingWorker.execute();          
   }   
   
   public void SendFiles (File[] _files) {       
       setTitle("File Transmission [Sending ...]");               
       recorder.fileManager.setUploadingFolder(
               _files[0].getParent() + File.separatorChar);        
       files = FileUtility.getAllFiles(_files); 
       count = files.length; 
       
       sendingWorker.execute();       
   }

   public String filName;
   public void setCurrentFile(String filename) {

        filName = filename;
        jLabelCurrentFile.setText(filename);    
   }   

   public void updateData(long size) {
       this.size = size;
       index ++;
       duration = System.currentTimeMillis() - startedAt;
       speed = size / (duration + 1);
       leftEstim = (float) duration / (float) index;
       totalEstim = leftEstim * (float) count;
       
        jLabelFileCount.setText(String.valueOf(index) + "/" 
               + String.valueOf(count) + " file(s)");         
       jLabelTotalSize.setText(String.valueOf(size / 1000) + " KB");       
       jLabelDuration.setText(String.valueOf(duration / 1000) + " Seconds");
       jLabelSpeed.setText(String.valueOf(speed) + " KB/S");
       jProgressBar1.setMaximum((int) totalEstim);
       jProgressBar1.setValue((int) (leftEstim * index));
   }   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCurrentFile;
    private javax.swing.JLabel jLabelDuration;
    private javax.swing.JLabel jLabelFileCount;
    private javax.swing.JLabel jLabelSpeed;
    private javax.swing.JLabel jLabelTotalSize;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
    
}
