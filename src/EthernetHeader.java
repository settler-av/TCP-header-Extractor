import java.math.BigInteger;

import static com.sun.tools.javac.util.StringUtils.toUpperCase;
import static java.lang.System.exit;

public class EthernetHeader implements strBinToStrHex {
    String headerFrame;
    String data;
    String destinationMAC;
    String sourceMAC;
    String type;

    public EthernetHeader(String headerFrame, String data) {
        this.headerFrame = headerFrame;
        this.data = data;
        this.destinationMAC = convertStringToHex(headerFrame.substring(0, 48));
        this.sourceMAC = convertStringToHex(headerFrame.substring(48, 96));
        this.type = convertStringToHex(headerFrame.substring(96, 112));
        System.out.println(this);
        //Code for Network Header
        if (type.compareTo("806") == 0) {
            //ARP header
            ARPHeader frame2 = new ARPHeader(this.data);
        } else if (type.equals("800")) {
            //IPv4 header
            IPv4Header frame2 = new IPv4Header(this.data);
        } else {
            System.out.println("Something went wrong, Unknown type: " + type);
            System.out.println("The program will terminate now...");
            exit(1);
        }
    }

    @Override
    public String toString() {
        System.out.println();
        return "Ethernet Header\n" + "----------------------------" + "\nDestination MAC Address: " + printMAC(destinationMAC)
                + "\nSource MAC Address: " + printMAC(sourceMAC) + "\nType: " + "x" + type;
    }
}

interface strBinToStrHex {
    default String convertStringToHex(String binaryString) {
        BigInteger decimalVal = new BigInteger(binaryString, 2);
        // this is just to debug the code.
        // System.out.println("Print decimal value of "+binaryString +" is
        // "+decimalVal);
        return toUpperCase(decimalVal.toString(16));
    }

    default String printMAC(String hexValue) {
        StringBuilder MACAddress = new StringBuilder(hexValue);
        /**
         * @// TODO: 9/17/2021 add 'x' symbol before the MAC address
         */
//      MACAddress.insert(0,'x');
        for (int i = 2; i <= hexValue.length() + 2; i += 3) {
            // insert character value at offset i
            MACAddress.insert(i, ':');
        }
        return String.valueOf(MACAddress);
    }

    default String printIP(String hex) {
        String ip = "";

        for (int j = 0; j < hex.length(); j += 2) {
            String sub = hex.substring(j, j + 2);
            int num = Integer.parseInt(sub, 16);
            ip += num + ".";
        }

        ip = ip.substring(0, ip.length() - 1);
        return ip;
    }

}