/**
 * @implNote class for IPv4 header
 */
class IPv4Header implements strBinToStrHex {
    String headerFrame;
    String version;
    String headerLength;
    String DSCP;
    String ECN;
    String totalLength;
    String identification;
    String flags;
    String fragmentOffset;
    String timeToLive;
    String protocol;
    String headerChecksum;
    String sourceIP;
    String destinationIP;
    String option;
    String dataOfTransportLayer;

    /**
     * parameterized constructor. We will be using this constructor to allocate data to different fields of IPv4 Header. Rest of the data will be going to send to Transport header.
     *
     * @param headerFrame stores the data of header frame. length of header frame is usually 160 bits
     */
    public IPv4Header(String headerFrame) {
        this.headerFrame = headerFrame;
        version = convertStringToHex(headerFrame.substring(0, 4));
        headerLength = convertStringToHex(headerFrame.substring(4, 8));
        DSCP = convertStringToHex(headerFrame.substring(8, 14));
        ECN = convertStringToHex(headerFrame.substring(14, 16));
        totalLength = convertStringToHex(headerFrame.substring(16, 32));
        identification = convertStringToHex(headerFrame.substring(32, 48));
        flags = convertStringToHex(headerFrame.substring(48, 51));
        fragmentOffset = convertStringToHex(headerFrame.substring(51, 64));
        timeToLive = convertStringToHex(headerFrame.substring(64, 72));
        protocol = convertStringToHex(headerFrame.substring(72, 80));
        headerChecksum = convertStringToHex(headerFrame.substring(80, 96));
        sourceIP = convertStringToHex(headerFrame.substring(96, 128));
        destinationIP = convertStringToHex(headerFrame.substring(128, 160));
        if (headerLength.equals("5")) {
            option = "Empty";
        } else {
            option = convertStringToHex(headerFrame.substring(160, (32 * Integer.parseInt(headerLength))));
        }
        System.out.println(this);
        //this we will be using in transport layer.
        dataOfTransportLayer = headerFrame.substring((32 * Integer.parseInt(headerLength)));
        if (protocol.equals(Integer.toString(6))) {
            TCPTransportHeader frame3 = new TCPTransportHeader(dataOfTransportLayer);
        } else if (protocol.equals(Integer.toString(11))) {
            UDPTransportHeader frame3 = new UDPTransportHeader(dataOfTransportLayer);
        } else {
            System.out.println("Unknown protocol detected, Protocol: " + protocol);
        }
    }

    @Override
    public String toString() {
        return "\n----------------------------" +
                "\nNetwork Header" + "\n" +
                "----------------------------" + "\n" +
                "IPv4 Header" + "\n" +
                "Version:" + " x" + version + "\n" +
                "IHL:" + " x" + headerLength + "\n" +
                "DSCP:" + " x" + DSCP + "\n" +
                "ECN:" + " x" + ECN + "\n" +
                "Total Length:" + " x" + totalLength + "\n" +
                "Identification:" + " x" + identification + "\n" +
                "Flags:" + " x" + flags + "\n" +
                "Fragment Offset:" + " x" + fragmentOffset + "\n" +
                "Time to Live:" + " x" + timeToLive + "\n" +
                "Protocol:" + " x" + protocol + "\n" +
                "Header Checksum:" + " x" + headerChecksum + "\n" +
                "Source IP Address:" + printIP(sourceIP) + "\n" +
                "Destination IP Address:" + printIP(destinationIP);
    }
}