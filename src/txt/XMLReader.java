package txt;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLReader {
    public static String  FileReader = "src/resources/coursesData.xml";

    public static List<String> ReadFromXML(){

        List <String> coursesList = new ArrayList<>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();


        try {
           // documentBuilder.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING,true);
            DocumentBuilder dp = dbf.newDocumentBuilder();
            Document document = dp.parse(new File(FileReader));

            document.getDocumentElement().normalize();
            System.out.println("Courses List :" );//+ document.getDocumentElement().getNodeName());
            System.out.println("--------------------");
            System.out.println("id,CourseName,Instructor,CourseDuration,CourseTime,Location");
            NodeList list = document.getElementsByTagName("row");

            for (int i=0;i< list.getLength();i++) {
                Node node = list.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String id = element.getElementsByTagName("id").item(0).getTextContent();
                    String courseName = element.getElementsByTagName("CourseName").item(0).getTextContent();
                    String instructor = element.getElementsByTagName("Instructor").item(0).getTextContent();
                    String courseDuration = element.getElementsByTagName("CourseDuration").item(0).getTextContent();
                    String location = element.getElementsByTagName("Location").item(0).getTextContent();
                    String courseTime = element.getElementsByTagName("CourseTime").item(0).getTextContent();
                    coursesList.add(id + "," + courseName + "," + instructor + "," + courseDuration + "," + courseTime
                            + "," + location);
                    System.out.println(id + "," + courseName + "," + instructor + "," + courseDuration + "," + courseTime
                            + "," + location);
                }
            }




            }
        catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
                }
            return coursesList;

            }
    public static void exportXmlToCSV() throws IOException {
        List <String> coursesList = ReadFromXML();
        File file = new File("src/resources/coursesFinal.csv");
        FileWriter fileWriter = new FileWriter(file);
        for (String courses : coursesList) {

            System.out.println(coursesList);
            StringBuilder line = new StringBuilder();
            line.append(courses);
            line.append("\n");
            fileWriter.write(line.toString());
        }
        fileWriter.close();





        }
    }



