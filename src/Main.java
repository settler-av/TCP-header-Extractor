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
        System.out.println("This program is prepared by  20CE155 ADNAN VAHORA\n" +
                "Total line of code = <<value>>\n" +
                "Total lines for comment= <<value>>\n");

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

        String fileData = readInput.nextLine();
        System.out.println(fileData);
        System.out.println("------------------------------------------\n" +
                "Output for the row-1\n" +
                "------------------------------------------\n");
        //Code for Ethernet Header

        ethernetHeader frame1 = new ethernetHeader(fileData.substring(0,112),fileData.substring(112));
        System.out.println(frame1.toString());
    }
}

class HeaderExtractor{
    String inputFrameData;
    public HeaderExtractor(String inputFrameData) {
        this.inputFrameData = inputFrameData;
    }

}
class ethernetHeader implements strBinToStrHex{
    String headerFrame;
    String data;
    String destinationMAC;
    String sourceMAC;
    String type;

    public ethernetHeader(String headerFrame, String data) {
        this.headerFrame = headerFrame;
        this.data = data;
        this.destinationMAC = convertStringToHex(headerFrame.substring(0,48));
        this.sourceMAC= convertStringToHex(headerFrame.substring(48,96));
        this.type = convertStringToHex(headerFrame.substring(96,112));
    }

    @Override
    public String toString() {
        System.out.println();
        return "Ethernet Header\n" +
                "\n" +
                "\nDestination MAC Address: " + printMAC(destinationMAC)+
                "\nSource MAC Address: " + printMAC(sourceMAC)+
                "\nType: " +type;
    }
}

interface strBinToStrHex{
    default String convertStringToHex(String binaryString) {
        BigInteger decimalVal = new BigInteger(binaryString,2);
//        this is just to debug the code.
//        System.out.println("Print decimal value of "+binaryString +" is "+decimalVal);
        return decimalVal.toString(16);
    }
    default String printMAC(String hexValue){
        StringBuilder MACAddress = new StringBuilder(hexValue);
        for (int i = 2; i < hexValue.length(); i+= 3) {
            // insert character value at offset i
            MACAddress.insert(i, ':');
        }
        return String.valueOf(MACAddress);
    }
}
