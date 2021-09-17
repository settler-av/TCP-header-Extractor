import javax.print.attribute.standard.Destination;

public class ARPHeader implements strBinToStrHex {
    String HeaderData;
    String HardwareType;
    String ProtocolType;
    String HeaderLength;
    String ProtocolLength;
    String OperationCode;
    String SourceMAC;
    String SourceIP;
    String TargetMAC;
    String TargetIP;

    ARPHeader(String HeaderData) {
        this.HeaderData = HeaderData;
        HardwareType = convertStringToHex(this.HeaderData.substring(0, 16));
        ProtocolType = convertStringToHex(HeaderData.substring(16, 32));
        HeaderLength = convertStringToHex(HeaderData.substring(32, 40));
        ProtocolLength = convertStringToHex(HeaderData.substring(40, 48));
        OperationCode = convertStringToHex(HeaderData.substring(48, 64));
        SourceMAC = convertStringToHex(HeaderData.substring(64, 112));
        SourceIP = convertStringToHex(HeaderData.substring(112, 144));
        TargetMAC = convertStringToHex(HeaderData.substring(144, 192));
        TargetIP = convertStringToHex(HeaderData.substring(192, 224));
        System.out.println(this);
    }

    @Override
    public String toString() {
        return ("Network Header\n"+
                "----------------------------"
                +"\nARP header \n"+HeaderData+"\n"+
                "Hardware type: " + HardwareType + "\n" +
                "Protocol type: " + ProtocolType + "\n" +
                "Header Length: " + HeaderLength + "\n" +
                "Protocol Length: " + ProtocolLength + "\n" +
                "Operation code: " + OperationCode + "\n" +
                "Source MAC: " + printMAC(SourceMAC) + "\n" +
                "Source IP: " + printIP(SourceIP) + "\n" +
                "Target MAC: " + printMAC(TargetMAC) + "\n" +
                "Target IP: " + printIP(TargetIP) + "\n+");
    }
}
