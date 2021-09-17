public class UDPTransportHeader implements strBinToStrHex {
    String sourcePort;
    String destinationPort;
    String length;
    String headerDataChecksum;
    String applicationLayerData;

    UDPTransportHeader(String headerFrame) {
        sourcePort = convertStringToHex(headerFrame.substring(0, 16));
        destinationPort = convertStringToHex(headerFrame.substring(16, 32));
        length = convertStringToHex(headerFrame.substring(32, 48));
        headerDataChecksum = convertStringToHex(headerFrame.substring(48, 64));
        applicationLayerData = convertStringToHex(headerFrame.substring(64));
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "\nTransport Layer\n" +
                "\nUDP header\n" +
                "----------------------------\n" +
                "Source port: " + sourcePort + "\n" +
                "Destination port: " + destinationPort + "\n" +
                "Length: " + "x" + length + "\n" +
                "Header and data checksum: " + "x" + headerDataChecksum + "\n" +
                "Application Layer Data: " + "x" + applicationLayerData + "\n";
    }
}
