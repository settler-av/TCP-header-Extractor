public class UDPTransportHeader implements strBinToStrHex{
    String sourcePort;
    String destinationPort;
    String length;
    String headerDataChecksum;
    String applicationLayerData;

    UDPTransportHeader(String headerFrame){
        sourcePort = convertStringToHex(headerFrame.substring(0,16));
        destinationPort = convertStringToHex(headerFrame.substring(16,32));
        length = convertStringToHex(headerFrame.substring(32,48));
        headerDataChecksum = convertStringToHex(headerFrame.substring(48,64));
        applicationLayerData = convertStringToHex(headerFrame.substring(64));
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "\nTransport Layer\n"+
                "----------------------------"+
                "~~~~~~UDP header~~~~~\n"+
                "Source port: "+ sourcePort +"\n" +
                "Destination port: "+ destinationPort+"\n" +
                "Length: "+ length+"\n" +
                "Header and data checksum: "+headerDataChecksum +"\n"+
                "Application Layer Data: "+applicationLayerData +"\n";
    }
}
