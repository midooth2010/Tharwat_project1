import txt.JsonReader;
import txt.TxtReader;
import txt.XMLReader;

import java.io.IOException;
import java.util.Scanner;

import static txt.XMLReader.exportXmlToCSV;

public class Main {

    public static void main(String[] args) throws IOException {
   // TxtReader textReader = new TxtReader();
   //  textReader.exportfileToCSV();
      // textReader.printStudentData();
   //  exportXmlToCSV();

        Scanner myObj = new Scanner(System.in); // C

        System.out.println("Enter Number student id ");

        String number = myObj.nextLine(); // Read user input
        JsonReader.fromCsvFile(number);

    }
}