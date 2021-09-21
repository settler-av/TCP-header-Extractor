import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static com.sun.tools.javac.util.StringUtils.toUpperCase;

public class Main {
    /**
     * @param args CLI args
     * @author 20CE155 Adnan Vahora
     * @since v1.0 16/9/2021
     * @throws IOException it throws IOException if the path of given file is not valid.
     * @implNote the catch block will print the error msg and terminate the program.
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
        }
        catch (IOException e){
            System.out.println("File not detected : Program will terminate now...");
            System.out.println(e.getMessage());
        }
    }
}

/**
 * Interface for conveting binary string into Hexadecimal and Print MAC and IP address like shown in output
 */
interface strBinToStrHex {
    default String convertStringToHex(String binaryString) {
        BigInteger decimalVal = new BigInteger(binaryString, 2);
        // this is just to debug the code.
        // System.out.println("Print decimal value of "+binaryString +" is
        // "+decimalVal);
        return toUpperCase(decimalVal.toString(16));
    }

    /**
     * this function will print hex value to MAC address in colon separated format
     *
     * @param hexValue takes Hexadecimal Value
     * @return MAC address format.
     */
    default String printMAC(String hexValue) {
        StringBuilder finals = new StringBuilder();
        for (int i = 0; hexValue.length() > i; i = i + 2) {
            if ((i + 2) < hexValue.length())
                finals.append(hexValue.substring(i, i + 2)).append(":");
            if ((i + 2) == hexValue.length()) {
                finals.append(hexValue.substring(i, i + 2));
            }
        }
        return String.valueOf(finals);
    }

    /**
     * It will print IP address in dot (.) separated format.
     *
     * @param hex string to be converted into IP address format.
     * @return IP address with dot separated format.
     */
    default String printIP(String hex) {
        StringBuilder ip = new StringBuilder();

        for (int j = 0; j < hex.length(); j += 2) {
            String sub = hex.substring(j, j + 2);
            int num = Integer.parseInt(sub, 16);
            ip.append(num).append(".");
        }
        ip = new StringBuilder(ip.substring(0, ip.length() - 1));
        return ip.toString();
    }
}







