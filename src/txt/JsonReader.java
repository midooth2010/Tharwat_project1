package txt;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JsonReader {
    public static String readFromJsonFile(String number) {
            JSONParser jsonParser = new JSONParser();

    try (FileReader reader = new FileReader("src/resources/StudentCourseDetails.json"))
    {

        Object obj = jsonParser.parse(reader);

        JSONObject json_data = (JSONObject) obj;
        for (Object o : json_data.keySet()) {
            System.out.println(o);
        if(o.equals(number)) {
        System.out.println(json_data.get(o));
        return json_data.get(o).toString();
        }
    }
    } catch (FileNotFoundException e) {
            e.printStackTrace();
}        catch (IOException e)
    {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
}
return null;
    }

        public static void fromCsvFile(String number) throws FileNotFoundException {

            String courses = readFromJsonFile(number);


                Scanner sc = new Scanner(new File("src/resources/students.csv"));
                sc.useDelimiter(",");
                while (sc.hasNext()) {
                    String line = sc.nextLine();
                    String id = line.split(",")[0];
                    String name = line.split(",")[1];
                    String grade = line.split(",")[2];
                    String email = line.split(",")[3];
                    if (id.equals(number)) {
                        System.out.println("====================================================================================");
                        System.out.println("Student Details page");
                        System.out.println("====================================================================================");
                        System.out.println("");
                        System.out.println("Name : " + name + "              " + "Grade : " + grade + "              " + "Email:" + email);
                        System.out.println("------------------------------------------------------------------------------------");
                        break;
                    }

                }
                sc.close();
                System.out.println();
            if(courses==null)
            {
                System.out.println("this student hasn't enrolled in any courses");
            }else {
                Scanner scCourses = new Scanner(new File("src/resources/coursesFinal.csv"));
                scCourses.useDelimiter(",");
                while (scCourses.hasNext()) {
                    String l = scCourses.nextLine();
                    String idc = l.split(",")[0];
                    String namec = l.split(",")[1];
                    String region = l.split(",")[2];
                    String duration = l.split(",")[3];
                    String hours = l.split(",")[4];
                    String hall = l.split(",")[5];

                    if (courses.contains(idc)) {
                        // System.out.println(idc + "-  " + namec +"          "+region+"       "+" "
                        //  +duration+"    "+"   "+hours+"     "+"   "+hall);
                        System.out.printf("%-4s %-20s %-10s %-20s %-10s %-2s-%n", idc, namec, region, duration, hours, hall);
                    }

                }
                scCourses.close();
            }
        }
    }

