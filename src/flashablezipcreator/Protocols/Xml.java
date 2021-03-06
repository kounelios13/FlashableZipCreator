/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashablezipcreator.Protocols;

import flashablezipcreator.Core.GroupNode;
import flashablezipcreator.Core.ProjectItemNode;
import flashablezipcreator.Core.ProjectNode;
import flashablezipcreator.MyTree;
import flashablezipcreator.Operations.XmlOperations;
import static flashablezipcreator.Protocols.Export.to;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

/**
 *
 * @author Nikhil
 */
public class Xml {

    static XmlOperations xo;
    public static String device_config_path = "device.config";
    static String custom_path = "afzc/custom_data.xml";
    static String delete_path = "afzc/delete_data.xml";
    static String data_path = "afzc/file_data.xml";
    public static String file_details_path = "file_details.xml";
    static String originalData = "";
    static String generatedData = "";
    static String fileData = "";
    static String deleteData = "";
    public static String fileDetailsData = "";

    public static String generateFileDataXml() throws ParserConfigurationException, TransformerException {
        xo = new XmlOperations();
        xo.createXML();
        for (ProjectItemNode project : to.getProjectsSorted(MyTree.rootNode)) {
            if (((ProjectNode) project).projectType != ProjectNode.PROJECT_THEMES) {
                xo.addProjectNode((ProjectNode) project);
            }
        }
        return xo.getCleanXML();
    }

    public static void parseXml(int type) throws ParserConfigurationException, SAXException, IOException {
        ProjectItemNode rootNode = MyTree.rootNode;
        switch (type) {
            case GroupNode.GROUP_CUSTOM:
                xo.parseGeneratedXML(rootNode, generatedData, originalData);//generatedData and OriginalData are modified in Import.java.
                break;
            case GroupNode.GROUP_DELETE_FILES:
                xo.parseXML(deleteData);
                break;
            default:
                xo.parseDataXML(fileData);//this is for setting description of files.
        }

    }

    //following functions are used in generating generatedData in Import.java
    public static void initialize() throws ParserConfigurationException {
        xo = new XmlOperations();
        xo.createXML();
    }

    public static void terminate() throws TransformerException {
        generatedData = xo.getXML();
    }

    //following will initialize project variables if external xml file is present.
    public static void initializeProjectDetails(String data) throws ParserConfigurationException, SAXException, IOException {
        xo = new XmlOperations();
        xo.initializeProjectData(data);
    }

    public static String getDeviceConfigString() throws ParserConfigurationException, TransformerException {
        xo = new XmlOperations();
        xo.createDeviceConfig(Device.selected);
        return xo.getXML();
    }

    public static String getDeviceName(String configData) throws ParserConfigurationException, SAXException, IOException {
        xo = new XmlOperations();
        return xo.getStringConfigValue(configData, "Name");
    }

    public static String getPreferenceConfigString(String aromaVersion, boolean androidVersionAboveLP,
            boolean quickProjectSetup, ArrayList<String> themes, String zipCreatorName, String ZipVersion)
            throws ParserConfigurationException, TransformerException {
        xo = new XmlOperations();
        xo.createConfigurationConfig(aromaVersion, androidVersionAboveLP, quickProjectSetup, themes, zipCreatorName, ZipVersion);
        return xo.getXML();
    }

    public static String getAromaVersion(String configData) throws ParserConfigurationException, SAXException, IOException {
        xo = new XmlOperations();
        return xo.getStringConfigValue(configData,"AromaVersion");
    }

    public static boolean getAndroidVersionDetail(String configData) throws ParserConfigurationException, SAXException, IOException {
        xo = new XmlOperations();
        return xo.getBoolConfigValue(configData, "AboveLollipop");
    }

    public static boolean getQuickProjectSetup(String configData) throws ParserConfigurationException, SAXException, IOException {
        xo = new XmlOperations();
        return xo.getBoolConfigValue(configData, "QuickProjectSetup");
    }

    public static ArrayList<String> getThemes(String configData) throws ParserConfigurationException, SAXException, IOException {
        xo = new XmlOperations();
        return xo.getThemes(configData);
    }

    public static String getZipCreatorName(String configData) throws ParserConfigurationException, SAXException, IOException {
        xo = new XmlOperations();
        return xo.getStringConfigValue(configData, "zipCreatorName");
    }

    public static String getZipVersion(String configData) throws ParserConfigurationException, SAXException, IOException {
        xo = new XmlOperations();
        return xo.getStringConfigValue(configData, "zipVersion");
    }
}
