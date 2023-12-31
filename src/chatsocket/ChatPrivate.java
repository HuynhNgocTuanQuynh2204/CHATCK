/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// lưu trữ thông tin về một tài khoản trong ứng dụng chat sử dụng socket
package chatsocket;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class ChatPrivate extends javax.swing.JFrame {

    private static String src;
    private static String desuser;
    private static ClientHandle client;
    private static ClientTransferFile transferfile = null;
    private static String mess;
    private static boolean stt = false;
    

    
    
    /**
     * Creates new form ChatPrivate
     */
    public ChatPrivate(String src,String des, ClientHandle client,String mess) {
        initComponents();
        this.src = src;
        this.desuser=des;
        this.client = client;
        this.mess = mess;
        txtUsername.setText(des);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(ChatPrivate.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                client.WriteExitPrivateClient(des);
            }
        });
        System.out.println("Thread init frame"+Thread.currentThread().getName());
        this.addWindowFocusListener(new WindowFocusListener(){
            @Override
            public void windowGainedFocus(WindowEvent e) {
                System.out.println(txtUsername.getText());
                desuser = txtUsername.getText();
            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                System.out.println("nothing");
            }
            
        });
    }

    public static ClientTransferFile getTransferfile() {
        return transferfile;
    }

    public static void setTransferfile(ClientTransferFile transferfile) {
        ChatPrivate.transferfile = transferfile;
    }
    
    public static void  getInfo(String username, String mess){
        ChatPrivate.desuser = username;
        ChatPrivate.mess = mess;
        ChatPrivate.stt = true;
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
        txtUsername = new javax.swing.JLabel();
        txtChatPrivate = new javax.swing.JTextField();
        btnSendPrivate = new javax.swing.JButton();
        btnFilePrivate = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPaneChatPrivate = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        txtUsername.setFont(new java.awt.Font("Lucida Sans Typewriter", 3, 18)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(204, 0, 51));
        txtUsername.setText("Username");

        txtChatPrivate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtChatPrivateKeyPressed(evt);
            }
        });

        btnSendPrivate.setText("Send");
        btnSendPrivate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendPrivateActionPerformed(evt);
            }
        });

        btnFilePrivate.setText("File");
        btnFilePrivate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilePrivateActionPerformed(evt);
            }
        });

        jTextPaneChatPrivate.setBackground(new java.awt.Color(204, 204, 255));
        jTextPaneChatPrivate.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(51, 204, 0)));
        jTextPaneChatPrivate.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jTextPaneChatPrivate.setDisabledTextColor(new java.awt.Color(0, 0, 204));
        jTextPaneChatPrivate.setEnabled(false);
        jTextPaneChatPrivate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextPaneChatPrivateMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTextPaneChatPrivate);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtChatPrivate, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSendPrivate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFilePrivate))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtUsername)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSendPrivate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFilePrivate, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtChatPrivate, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendPrivateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendPrivateActionPerformed
        // TODO add your handling code here:
        String mess = txtChatPrivate.getText();
        client.WriteChatPrivate(desuser, mess);
        txtChatPrivate.setText("");
        System.out.println(txtUsername.getText());
    }//GEN-LAST:event_btnSendPrivateActionPerformed

    private void txtChatPrivateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtChatPrivateKeyPressed
        // TODO add your handling code here:
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            String mess = txtChatPrivate.getText();
            client.WriteChatPrivate(desuser, mess);
            txtChatPrivate.setText("");
            System.out.println(txtUsername.getText());
        }
        
    }//GEN-LAST:event_txtChatPrivateKeyPressed
    
    private void btnFilePrivateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilePrivateActionPerformed
        // TODO add your handling code here:
        
        JFileChooser ch = new JFileChooser();
        int c = ch.showOpenDialog(this);
        if (c == JFileChooser.APPROVE_OPTION) {
            File f = ch.getSelectedFile();
            client.setPathfile(f.getPath());
            client.WriteAlertSendFile(desuser);
        }
    }//GEN-LAST:event_btnFilePrivateActionPerformed

    private void jTextPaneChatPrivateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextPaneChatPrivateMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() == 2 ){
            int x = evt.getX();
            int y = evt.getY();
            System.out.println("X: "+x+" Y:"+y);
            int startOffset = jTextPaneChatPrivate.viewToModel(new Point(x, y));//where on jtextarea click was made
            System.out.println(startOffset);
            String text = jTextPaneChatPrivate.getText();
            //System.out.println(text);
            int filebeginindex = 0;
            int fileendindex = 0;
            String[] words = text.split("\n");//spliting the text to words. link will be a single word

            for(String word:words)
            {
                if(word.contains("File..."))//looking for the word representing the link
                {
                    filebeginindex = text.indexOf(word)+7;
                    fileendindex = filebeginindex+word.length();
                    System.out.println("filebeginindex: "+filebeginindex+ " startOffset:"+startOffset+" fileendindex: "+fileendindex);
                    if(startOffset>=filebeginindex && startOffset<=fileendindex)//after the link word was found, making sure the double click was made on this link
                    {
                        try
                        {
                            jTextPaneChatPrivate.select(filebeginindex, fileendindex);
                            File fileadd = null;
                            //get name file from tmpfile
                            String []datafromword = word.split(" ");
                            for(int i=0; i<datafromword.length; i++){
                                if(datafromword[i].contains("File...")){
                                    String filename = datafromword[i].substring(7,datafromword[i].length());
                                    fileadd = new File("tmpfile/"+filename);
                                }
                            }

                            FileInputStream fileInputStream = null;
                            try {
                                fileInputStream = new FileInputStream(fileadd);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(ChatPrivate.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            byte[] data=new byte[(int) fileadd.length()];

                            BufferedInputStream bufferedInputStream=new BufferedInputStream(fileInputStream);
                            try {
                                bufferedInputStream.read(data,0,data.length);
                            } catch (IOException ex) {
                                Logger.getLogger(ChatPrivate.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            JFileChooser ch = new JFileChooser();
                            int c = ch.showSaveDialog(jPanel1);
                            if (c == JFileChooser.APPROVE_OPTION) {
                                try {
                                    FileOutputStream out = new FileOutputStream(ch.getSelectedFile());
                                    out.write(data);
                                    out.close();
                                } catch (IOException ex) {
                                    System.out.println("err mouse click: "+ex.getMessage());
                                    JOptionPane.showMessageDialog(jPanel1, ex, "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }

                    }

                }
            }
        }
        
    }//GEN-LAST:event_jTextPaneChatPrivateMouseClicked
    public void appendmess(String mess){
        //txtareaChatPrivate.append(mess+"\n");
        String newms = mess+"\n";
        StyledDocument doc = jTextPaneChatPrivate.getStyledDocument();
        try {
            doc.insertString(doc.getLength(), newms, null );
        } catch (BadLocationException ex) {
            Logger.getLogger(ChatPrivate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String ReadfileToString(File file) throws FileNotFoundException, IOException{
        //write format to file
        File fileformat = new File("formatsendfile.txt");
        String output = src+"::SendFile:"+desuser+":";
        byte[] writetofile = output.getBytes("UTF-8");
        OutputStream os = new FileOutputStream(fileformat); 
        // Starts writing the bytes in it 
        os.write(writetofile); 
        System.out.println("Successfully" + " byte inserted"); 
        // Close the file 
        os.close();
        //get byte from fileformat
        BufferedReader reader1 = new BufferedReader(new FileReader(fileformat));
        StringBuilder stringBuilder1 = new StringBuilder();
        char[] buffer1 = new char[10];
        while (reader1.read(buffer1) != -1) {
                stringBuilder1.append(new String(buffer1));
                //stringBuilder1.append(buffer1, 0, (int) testfile.length());
                buffer1 = new char[10];
        }
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder stringBuilder = new StringBuilder();
        char[] buffer = new char[10];
        while (reader.read(buffer) != -1) {
                stringBuilder.append(new String(buffer));
                //stringBuilder.append(buffer1, 0, (int) testfile2.length());
                buffer = new char[10];
        }
        reader.close();
        String str1 = stringBuilder1.toString().substring(0,(int) fileformat.length());
        str1+=":"+file.getName()+":";
        String str2 = stringBuilder.toString().substring(0,(int) file.length());
        String content = str1+str2;
        return content;
    }
    public void ReadTransferFile()
    {
        System.out.println("7_ReadTransferFile");
        ObjectInputStream ois = null;
        
        try {
            ois = new ObjectInputStream(transferfile.getS().getInputStream());
            System.out.println("--Server file: pass new obj");

            Data_file datafile;
            try {
                datafile = (Data_file) ois.readObject();
                System.out.println("-Server file:read file successfully");
                String sourceName = datafile.getdes_name();
                String desName = datafile.getsource_name();
                //txtareaChatPrivate.append("File..."+datafile.toString()+"\n");
                //appendStringForTextPane("File..."+datafile.toString()+"\n");
                addjlabelfiletoTextpane(datafile.toString());
                appendStringForTextPane("\n");
                System.out.println("--file name:"+datafile.toString());
                
                File fileoutput = new File("tmpfile/"+datafile.toString());
                String path = "tmpfile/"+datafile.toString();
                System.out.println("path: "+path);
                try (FileOutputStream stream = new FileOutputStream(path)) {
                    stream.write(datafile.getFile());
                }catch(Exception ex){
                    System.out.println("err write file");
                }
                
                //transferfile.closeTransferFileFromClient();
                //client.closeTransferFileMess();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ChatPrivate.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(ChatPrivate.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(ois !=null){
                    ois.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ChatPrivate.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
                
        
    }
    public void appendStringForTextPane(String str){
        StyledDocument doc = jTextPaneChatPrivate.getStyledDocument();
        try {
            doc.insertString(doc.getLength(), str, null );
        } catch (BadLocationException ex) {
            Logger.getLogger(ChatPrivate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void addjlabelfiletoTextpane(String namefile){
        StyledDocument doc = jTextPaneChatPrivate.getStyledDocument();
        SimpleAttributeSet keyWord = new SimpleAttributeSet();
        StyleConstants.setForeground(keyWord, Color.RED);
        StyleConstants.setBackground(keyWord, Color.YELLOW);
        StyleConstants.setBold(keyWord, true);
        
        String str ="File...";
        try {
            doc.insertString(doc.getLength(), "File...", null );
            doc.insertString(doc.getLength(), namefile, keyWord );
            
        } catch (BadLocationException ex) {
            Logger.getLogger(ChatPrivate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
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
            java.util.logging.Logger.getLogger(ChatPrivate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatPrivate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatPrivate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatPrivate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatPrivate(src,desuser,client,mess).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFilePrivate;
    private javax.swing.JButton btnSendPrivate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPaneChatPrivate;
    private javax.swing.JTextField txtChatPrivate;
    private javax.swing.JLabel txtUsername;
    // End of variables declaration//GEN-END:variables
}
