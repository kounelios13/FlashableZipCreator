/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashablezipcreator;

import flashablezipcreator.Core.ProjectNode;
import flashablezipcreator.UserInterface.JTreeDemo;
import flashablezipcreator.DiskOperations.Read;
import flashablezipcreator.DiskOperations.ReadZip;
import flashablezipcreator.Operations.JarOperations;
import flashablezipcreator.Protocols.Device;
import flashablezipcreator.Protocols.Jar;
import flashablezipcreator.Protocols.Logs;
import flashablezipcreator.Protocols.Xml;
import flashablezipcreator.UserInterface.AddDevice;
import flashablezipcreator.UserInterface.AddName;
import flashablezipcreator.UserInterface.Preferences;
import static flashablezipcreator.UserInterface.Preferences.preferencesConfig;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

/**
 *
 * @author Nikhil
 */
public class FlashableZipCreator {

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws java.io.FileNotFoundException
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws org.xml.sax.SAXException
     */
    public static void main(String args[]) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException, ParserConfigurationException, SAXException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            if (JarOperations.getSystemOS().equals("Windows")) {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Windows".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } else {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("GTK+".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }

                }
            }

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(null, "intoMultiCatch");
            java.util.logging.Logger.getLogger(JTreeDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        try {
            Logs.logFile = "Logs_" + Logs.getTime() + ".log";
            Logs.write("Created Logs File..");
            if (Jar.isExecutingThrough()) {
                JarOperations.setJarFileList();
                Device.loadDeviceList();
                Logs.write("Device List Loaded");
                String configString = "";
                if ((new File(Xml.device_config_path).exists())) {
                    Read r = new Read();
                    configString = r.getFileString(Xml.device_config_path);
                    Device.selected = Xml.getDeviceName(configString);
                    Logs.write("Selected Device from Config: " + Device.selected);
                } else if ((new File("update-binary").exists())) {
                    Device.binary = (new Read()).getFileBytes("update-binary");
                    Logs.write("update-binary Found");
                } else {
                    AddDevice ad = new AddDevice();
                }
            } else {
                Xml.file_details_path = "dist/" + Xml.file_details_path;
            }
            File f = new File(Xml.file_details_path);
            Read r = new Read();
            if (f.exists()) {
                Xml.fileDetailsData = r.getFileString(Xml.file_details_path);
                Xml.initializeProjectDetails(Xml.fileDetailsData);
            }
            f = new File("Preferences.config");
            if (f.exists()) {
                Logs.write("Preferences.config Found");
                Preferences.preferencesFilePresent = true;
                Preferences.preferencesConfig = r.getFileString("Preferences.config");
                Preferences.themes = Xml.getThemes(preferencesConfig);
                Preferences.aromaVersion = Xml.getAromaVersion(preferencesConfig);
                Preferences.IsFromLollipop = Xml.getAndroidVersionDetail(preferencesConfig);
                Preferences.IsQuickSetup = Xml.getQuickProjectSetup(preferencesConfig);
                Preferences.zipCreatorName = Xml.getZipCreatorName(preferencesConfig);
                Preferences.zipVersion = Xml.getZipVersion(preferencesConfig);
                Logs.write("Preferences Loaded");
            }
            if (Preferences.themes.isEmpty()) {
                Preferences.themes.add("Nikhil");
            }
            //if(!Device.selected.equals("")){
            new MyTree().setVisible(true);
            if (Preferences.IsQuickSetup) {
                new AddName("Project", ProjectNode.PROJECT_AROMA, MyTree.rootNode);
            }
            //}
        } catch (IOException ex) {
            Logger.getLogger(FlashableZipCreator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(FlashableZipCreator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(FlashableZipCreator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(FlashableZipCreator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void extractZip() throws IOException {
        String dirPath = "C:\\Users\\Nikhil\\Documents\\NetBeansProjects\\FlashableZipCreator\\Fonts";
        File folder = new File(dirPath);
        for (File file : folder.listFiles()) {
            ReadZip rz = new ReadZip(file.getAbsolutePath());
            String fileName = file.getName().replace("Font_", "");
            if (fileName.indexOf(".") > 0) {
                fileName = fileName.substring(0, fileName.lastIndexOf("."));
            }
            for (Enumeration<? extends ZipEntry> e = rz.zf.entries(); e.hasMoreElements();) {
                ZipEntry ze = e.nextElement();
                String name = ze.getName();
                if (name.startsWith("META-INF")) {
                    continue;
                }
                File f = new File(name);

                String parent = f.getParent();
                String fName = f.getName();
                String writeToPath = "My Fonts" + File.separator + parent + File.separator + fileName + File.separator + fName;
                InputStream in = rz.zf.getInputStream(ze);
                rz.writeFileFromZip(in, writeToPath);
                System.out.println(writeToPath);
            }
            System.out.println();
        }
    }
}
