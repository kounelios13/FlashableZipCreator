/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashablezipcreator.UserInterface;

import java.awt.Toolkit;

/**
 *
 * @author Nikhil
 */
public class About extends javax.swing.JFrame{
    
    /**
     * Creates new form AboutUI
     */
    public About() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        panelHeader = new javax.swing.JPanel();
        lblMyImage = new javax.swing.JLabel();
        lblAboutMe = new javax.swing.JLabel();
        jspInstructions = new javax.swing.JScrollPane();
        jepInstructions = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        panelHeader.setBackground(new java.awt.Color(255, 255, 255));

        lblMyImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/flashablezipcreator/1549450_687091887991785_1258867375_n.jpg"))); // NOI18N

        lblAboutMe.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lblAboutMe.setText("<HTML> <CENTER><B>About Me</B></CENTER>  <br> I am <a href=\"https://forum.xda-developers.com/member.php?u=4867515\">Nikhil Menghani</a>, creator of this tool, xda senior member, programming enthusiast, a software developer, chess player, cricket lover. I try to ease my life by creating utilities.<br>  What you are using is one of my utilities, it will get you a flashable zip which you can directly flash in your phone, saving your time in writing flawless aroma script, updater script and of course putting all the files at right place.<br>  Happy flashing! </HTML>");

        jepInstructions.setEditable(false);
        jepInstructions.setContentType("text/html"); // NOI18N
        jepInstructions.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jepInstructions.setText("<html> <CENTER><B><h2>Instructions</h2></B></CENTER> <B><h3>Steps to Create a Flashable Zip</h3></B>  <br>0. Select your device if listed in Devices List, If not listed, place update-binary of your device in the directory of jar file. <br><br>1. Add a Project, give it a name.(A project can have multiple groups) <br>A popup appears on start up, you can change the settings in File->Preferences. <br><br>2. Add a Group. (A group will contain specific type of files in it) <br>For eg. you create a group (say xyz) with install location (system/app), then xyz group will include all the apk files that needs to be pushed to system/app <br><br>3. Add a Subgroup if required (When you need furthur grouping. It is required for bootanimations and fonts) <br>For eg. 2 Boot Animations will have their own bootanimation.zip. You cannot add file with same name twice. Hence you need subgroup to further distinguish the file. <br><br>4. Add a Folder. (From android 5.x+, we have apk files placed in folder which contains optional lib files as well with it. To build the same directory structure, you need to add folders) <br><br>5. Add Files to Groups/Subgroups/Folders. <br><br>6. Click on Export Zip to choose the destination and Click OK to generate zip.  <br><br><B><h3>How to add objects</h3></B>  <br>1. To add a Project <br><br>-> Right Click on AFZC Projects <br>-> Give a unique name to project <br>-> Click on Add.  <br><br>2. To add a Group <br><br>-> Right Click on the Project that you want your group to be added in <br>-> Hover on Add group and proceed ahead with selecting location to which you want to push your files to <br>-> Give a unique name <br>-> Click on Add  <br><br>3. To add a SubGroup <br><br>-> Right Click on Group <br>-> Click on Add SubGroup <br>-> Give a unique name <br>-> Click on Add. <U><br><br>Note: You will get an option to add subgroup only for Boot Animation and Fonts group as only they require it.</U>  <br><br>4. To add a Folder <br><br>-> Right Click on Group <br>-> Click on Add Folder <br>-> Give a unique name <br>-> Click on Add. <br><br>-> Right Click on Folder <br>-> Click on Add Folder to further add folder <br>-> Give an appropriate name <br>-> Click on Add.  <U><br><br>Tip: You can also drag and drop folders from your drive to the group. All the sub folders (if any) and files will be added automatically.</U>  <br><br>5. To add a File <br><br>-> Right Click on Group/Folder/SubGroup <br>-> Click on Add Files <br>-> Import the files.  <U><br><br>Tip: You can also drag and drop files from your drive to the Group/SubGroup/Folder. All the files will be imported.</U>  <br><br>6. To add a Theme <br><br>-> Right on Themes Project <br>-> Add Theme <br>-> Give appropriate name <br>-> Add required files to it  <br><br><B><h3>How to rename objects</h3></B>   <br>-> To rename a Project/Group/SubGroup/Folder/File, triple click on the object and change the name.  <br><br><B><h3>Finding it tedious to create again and again?</h3></B>  <br>Don't worry, once you create a zip, you can import the created zip to make further changes to existing zip file. <br><br>To do so, use Import Zip button to add an already created zip OR drag the zip and add it to the tool. <br><br> <B><h3>Explore yourself to identify more hidden features.</h3></B><br> </html>");
        jepInstructions.setAutoscrolls(false);
        jepInstructions.setCaretPosition(0);
        jepInstructions.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jspInstructions.setViewportView(jepInstructions);
        jepInstructions.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addComponent(lblMyImage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAboutMe, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jspInstructions, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        panelHeaderLayout.setVerticalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMyImage)
                    .addComponent(lblAboutMe, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jspInstructions, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>      
    
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
            java.util.logging.Logger.getLogger(AboutUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AboutUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AboutUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AboutUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new About().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JEditorPane jepInstructions;
    private javax.swing.JScrollPane jspInstructions;
    private javax.swing.JLabel lblAboutMe;
    private javax.swing.JLabel lblMyImage;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel panelHeader;
}
