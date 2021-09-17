import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    /**
     * @param args CLI args
     * @author 20CE155 Adnan Vahora
     * @since v1.0 16/9/2021
     */
    public static void main(String[] args) throws IOException {
        System.out.println("This program is prepared by  20CE155 ADNAN VAHORA\n" + "Total line of code = <<value>>\n"
                + "Total lines for comment= <<value>>\n");

        System.out.println("Enter path of input file along with file name: ");

//        G:\Other computers\My Laptop\college document\0 SEM 3\CE 257 DCN\assignment - 1\Header-Extractor\Sample.txt
        Scanner userInput = new Scanner(System.in);


        String filePath = userInput.nextLine();
//        String filePath = new String("D:\\college document\\0 SEM 3\\CE 257 DCN\\assignment - 1\\Sample.txt");
        File inputFile = new File(filePath);
        try (Scanner readInput = new Scanner(inputFile, StandardCharsets.UTF_8)) {
            System.out.print("How many input rows wants to print: ");
            int numberOfLinesToRead = userInput.nextInt();
            for (int i = 0; i < numberOfLinesToRead; i++) {
                String fileData = readInput.nextLine();
    //            To check if file is being read or not
    //            System.out.println(fileData);
                System.out.println("\n\n------------------------------------------\n" +
                        "------------------------------------------\n" +
                        "Output for the row - " + (i + 1) + "\n"
                        + "------------------------------------------");

    //            I have used constructor to call print methods, and it will implicitly call another layer
                EthernetHeader frame1 = new EthernetHeader(fileData.substring(0, 112), fileData.substring(112));

            }
            userInput.close();
            readInput.close();
        }
        catch (IOException e){
            System.out.println("File not detected : Program will terminate now...");
            System.out.println(e.getMessage());
        }
    }
}





