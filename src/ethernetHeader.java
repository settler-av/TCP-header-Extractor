import java.math.BigInteger;

public class ethernetHeader implements strBinToStrHex {
    String headerFrame;
    String data;
    String destinationMAC;
    String sourceMAC;
    String type;

    public ethernetHeader(String headerFrame, String data) {
        this.headerFrame = headerFrame;
        this.data = data;
        this.destinationMAC = convertStringToHex(headerFrame.substring(0, 48));
        this.sourceMAC = convertStringToHex(headerFrame.substring(48, 96));
        this.type = convertStringToHex(headerFrame.substring(96, 112));
    }

    @Override
    public String toString() {
        System.out.println();
        return "Ethernet Header\n" + "\n" + "\nDestination MAC Address: " + printMAC(destinationMAC)
                + "\nSource MAC Address: " + printMAC(sourceMAC) + "\nType: " + type;
    }
}

interface strBinToStrHex {
    default String convertStringToHex(String binaryString) {
        BigInteger decimalVal = new BigInteger(binaryString, 2);
        // this is just to debug the code.
        // System.out.println("Print decimal value of "+binaryString +" is
        // "+decimalVal);
        return decimalVal.toString(16);
    }

    default String printMAC(String hexValue) {
        StringBuilder MACAddress = new StringBuilder(hexValue);
        MACAddress.insert(0,'x');
        for (int i = 2; i <= hexValue.length() + 2; i += 3) {
            // insert character value at offset i
            MACAddress.insert(i, ':');
        }
        return String.valueOf(MACAddress);
    }
}