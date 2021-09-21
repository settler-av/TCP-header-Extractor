import java.math.BigInteger;

import static com.sun.tools.javac.util.StringUtils.toUpperCase;
import static java.lang.System.exit;

/**
 * @implNote this is Ethernet header class it will take first 122 bits as data and rest bits will be sent to IPv4 or ARP header as data.
 */
class EthernetHeader implements strBinToStrHex {
    String headerFrame;
    String data;
    String destinationMAC;
    String sourceMAC;
    String type;

    /**
     * Parameterized constructor for Ethernet header.
     *
     * @param headerFrame data for header frame will be converted into different header fields of Ethernet header.
     * @param data        it will be transferred to Network header called implicitly in this constructor.
     */
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
        return "----------------------------" +
                "\nEthernet Header\n"
                + "----------------------------" +
                "\nDestination MAC Address: " + printMAC(destinationMAC)
                + "\nSource MAC Address: " + printMAC(sourceMAC)
                + "\nType: " + "x" + type;
    }
}