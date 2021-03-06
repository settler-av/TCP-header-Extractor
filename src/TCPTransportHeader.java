/**
 * class for TCP header data.
 */
class TCPTransportHeader implements strBinToStrHex {
    String headerFrame;

    String sourcePort;
    String destinationPort;
    String sequenceNumber;
    String acknowledgementNumber;
    String headerLength;
    String reservedBits;
    String URG;
    String ACK;
    String PSH;
    String RST;
    String SYN;
    String FIN;
    String WindowSize;
    String CheckSum;
    String UrgentPointer;

    /**
     * this is parameterized constructor for TCP transport header, it will assign the transport header frame data.
     *
     * @param transportData contains TCP header details.
     */
    TCPTransportHeader(String transportData) {
        this.headerFrame = transportData;
        sourcePort = convertStringToHex(headerFrame.substring(0, 16));
        destinationPort = convertStringToHex(headerFrame.substring(16, 32));
        sequenceNumber = "x" + convertStringToHex(headerFrame.substring(32, 64));
        acknowledgementNumber = "x" + convertStringToHex(headerFrame.substring(64, 96));
        headerLength = "x" + convertStringToHex(headerFrame.substring(96, 100));
        reservedBits = (headerFrame.substring(100, 106));
        URG = convertStringToHex(headerFrame.substring(106, 107));
        ACK = convertStringToHex(headerFrame.substring(107, 108));
        PSH = convertStringToHex(headerFrame.substring(108, 109));
        RST = convertStringToHex(headerFrame.substring(109, 110));
        SYN = convertStringToHex(headerFrame.substring(110, 111));
        FIN = convertStringToHex(headerFrame.substring(111, 112));
        WindowSize = "x" + convertStringToHex(headerFrame.substring(112, 128));
        CheckSum = "x" + convertStringToHex(headerFrame.substring(128, 144));
        UrgentPointer = "x" + convertStringToHex(headerFrame.substring(144, 160));

        System.out.println(this);
    }

    @Override
    public String toString() {
        return ("\n----------------------------" +
                "\nTransport Layer "
                + "\n----------------------------"
                + "\nTCP header\n" +
                "\n----------------------------\n" +
                "sourcePort= " + sourcePort + "\n" +
                "destinationPort= " + destinationPort + "\n" +
                "sequenceNumber= " + sequenceNumber + "\n" +
                "acknowledgementNumber= " + acknowledgementNumber + "\n" +
                "headerLength= " + headerLength + "\n" +
                "reservedBits= " + reservedBits + "\n" +
                "URG= " + URG + "\n" +
                "ACK= " + ACK + "\n" +
                "PSH= " + PSH + "\n" +
                "RST= " + RST + "\n" +
                "SYN= " + SYN + "\n" +
                "FIN= " + FIN + "\n" +
                "WindowSize= " + WindowSize + "\n" +
                "CheckSum= " + CheckSum + "\n" +
                "UrgentPointer= " + UrgentPointer + "\n");
    }
}