public class TransportHeader {
    String HeaderFrame;

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

    TransportHeader(String transportData, String protocol){
        this.HeaderFrame = transportData;

    }
    void TCPProtocol(){

    }
}
