package lv.modbusProject.Device;

import org.springframework.stereotype.Component;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

@Component
public class ModbusTCPConnection {


    private Socket tcpClientSocket = new Socket();
    protected String ipAddress = "192.168.40.30";
    protected int port = 502;
    private int connectTimeout = 500;



    public Socket connect(String ipAddress, int port) throws IOException {
        this.ipAddress = ipAddress;
        this.port = port;
        tcpClientSocket.setSoTimeout(connectTimeout);
        tcpClientSocket = new Socket(ipAddress, port);


return tcpClientSocket;
    }



}
