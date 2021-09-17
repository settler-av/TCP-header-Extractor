import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
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
        File inputFile = new File(filePath);
        Scanner readInput = new Scanner(inputFile, StandardCharsets.UTF_8);
        /**
         * @// TODO: 9/17/2021 Add try and catch for wrong file path. 
         * @// TODO: 9/17/2021 Add how many rows you want to print option.
         */
        System.out.print("How many lines? -> ");
        int numberOfLinesToRead = userInput.nextInt();
        for (int i = 0; i < numberOfLinesToRead; i++) {
            String fileData = readInput.nextLine();
//            //To check if file is being read or not
//            System.out.println(fileData);
            System.out.println("------------------------------------------\n" + "Output for the row - " + (i + 1) + "\n"
                    + "------------------------------------------");
            // Code for Ethernet Header

            ethernetHeader frame1 = new ethernetHeader(fileData.substring(0, 112), fileData.substring(112));
            System.out.println(frame1.toString());
        }
        userInput.close();
        readInput.close();
    }
}





