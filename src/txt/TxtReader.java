package txt;
import java.io.*;

public class TxtReader {
    public String [] readingTxtFile () throws IOException{
        File txtFile = new File("src/resources/student-data.txt");

        BufferedReader read = new BufferedReader(new FileReader(txtFile));
        String student ;
        String [] studentList = null;

        while ((student = read.readLine()) != null){
            student = student.replace("#",",");
            student = student.replace("$","\n");
            studentList = student.split("\n");
            System.out.println(student);
        }
        return studentList;


    }

    public String[] exportfileToCSV () throws IOException{
        String []studentList = readingTxtFile();
        File file = new File("src/resources/students.csv");
        FileWriter fileWconverter = new FileWriter(file);

        for (String student : studentList){
            StringBuilder line = new StringBuilder();
            line.append(student);
            line.append("\n");
            fileWconverter.write(line.toString());
        }
        fileWconverter.close();


        return studentList;
    }
    public void printStudentData () throws IOException {
        String[] studentList = exportfileToCSV();


        System.out.println("------------------------");
        System.out.println("Current Student List");
        System.out.println("------------------------");
        //System.out.println(" ID   Name          Grade        Email              Address            region        Country");


    for (String student : studentList){
        String [] studentData = student.split(",");
        System.out.printf("%-4s %-20s %-10s %-30s %-40s %-10s %-20s-%n",studentData[0],
                studentData[1], studentData[2], studentData[3], studentData[4],
                studentData[5], studentData[6]);
    }
    }
}

