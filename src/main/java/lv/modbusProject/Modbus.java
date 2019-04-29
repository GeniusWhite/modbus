package lv.modbusProject;

import de.re.easymodbus.modbusclient.ModbusClient;


import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.System.out;


public class Modbus {

    private String cardNumber = "80005AE3C1";
    private Socket tcpClientSocket = new Socket();
    protected String ipAddress = "192.168.40.30";
    protected int port = 502;
    private int connectTimeout = 500;
    private InputStream inStream;
    private DataOutputStream outStream;
    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();



    public void start() {


        try {
            this.connect("192.168.40.30", 502);
        } catch (Exception e) {
            e.printStackTrace();
        }


        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {

                read();
            }
        };



        timer.schedule(timerTask, 0, 50);


    }

    private void check(String inHex3){






    }
    public void read() {


        try {
            byte[] requestData = {0x00, 0x01, 0x00, 0x00, 0x00, 0x06, (byte) 0xFE, 0x04, 0x00, 0x00, 0x00, 0x05};

            byte[] data = new byte[17];
            int transactionID = 0;
            int transactionID2 = 1;
            int protocolID = 0;
            int protocolID2 = 0;
            int messageLength = 0;
            int messageLength2 = 6;
            int unitID = 254;
            int funcCode = 4;
            int address = 0;
            int address2 = 0;
            int length = 0;
            int length2 = 5;


            //outStream = new DataOutputStream(tcpClientSocket.getOutputStream());

            System.out.println("requesting");


            outStream.write(requestData, 0, 12);


            outStream.flush();
            //outStream.close();

            System.out.println("sent");
            System.out.println("input " + inStream.available());

            //while (inStream.available() > 0) {

            System.out.println(inStream.read(data, 0, 17));
            System.out.println("response***");
            int i;

            String[] inHex2 = new String[17];
            for (i = 0; i < data.length; i++) {
                //System.out.println("array " + data[i]);

                int j = data[i] & 0xFF;

                System.out.println(Integer.toHexString(j));


                inHex2[i] = Integer.toHexString(j);



            }

            String inHex3 = bytesToHex(data);

            this.check(inHex3);

            System.out.println(inHex3);


            System.out.println("Card number = " + inHex2[15] + inHex2[14] + inHex2[13] + inHex2[12] + inHex2[11]);
            System.out.println("response***");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void connect(String ipAddress, int port) throws IOException {
        this.ipAddress = ipAddress;
        this.port = port;
        tcpClientSocket.setSoTimeout(connectTimeout);
        tcpClientSocket = new Socket(ipAddress, port);
        outStream = new DataOutputStream(tcpClientSocket.getOutputStream());
        inStream = tcpClientSocket.getInputStream();
    }




    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);

    }
}




