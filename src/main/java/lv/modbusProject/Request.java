package lv.modbusProject;

import lv.modbusProject.DAL.Repository;
import lv.modbusProject.Domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Arrays;

@Component
public class Request {

    @Autowired
    ResponseParser responseParser;

    private InputStream inStream;
    private DataOutputStream outStream;
    private Requests requests = new Requests();
    private byte[] responseData = new byte[17];
    private int counter = 0;

    public void ready(Socket tcpClientSocket) {

        try {
            outStream = new DataOutputStream(tcpClientSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            inStream = tcpClientSocket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void read(int address) {

        //responseData = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        try {
            byte[] requestData = {0x00, 0x01, 0x00, 0x00, 0x00, 0x06, (byte) 0xFE, 0x04, 0x00, 0x00, 0x00, 0x05};


            int transactionID = 0;
            int transactionID2 = 1;
            int protocolID = 0;
            int protocolID2 = 0;
            int messageLength = 0;
            int messageLength2 = 6;
            int unitID = 254;
            int funcCode = 4;
            //int address = 0;
            int address2 = 0;
            int length = 0;
            int length2 = 5;


            //System.out.println("requesting");


            outStream.write(requestData, 0, 12);

            outStream.flush();


            inStream.read(responseData, 0, 17);


        } catch (Exception e) {
            e.printStackTrace();
        }


        if (responseData[10] == 16) {


        responseParser.parse(responseData);
            //responseData = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    }




    }


    public void write(int address, int info) {

        try {
            byte[] requestData = {0x00, 0x01, 0x00, 0x00, 0x00, 0x06, (byte) 0xFE, 0x06, 0x00, (byte)address, 0x00, (byte) info};


            int transactionID = 0;
            int transactionID2 = 1;
            int protocolID = 0;
            int protocolID2 = 0;
            int messageLength = 0;
            int messageLength2 = 6;
            int unitID = 254;
            int funcCode = 4;
            //int address = 0;
            int address2 = 0;
            int length = 0;
            int length2 = 5;


            //System.out.println("requesting");


            outStream.write(requestData, 0, 12);

            outStream.flush();

            //System.out.println("sent");
            inStream.read(responseData, 0, 12);
            //System.out.println(inStream.read(responseData, 0, 17));
            //System.out.println("response***");
          //responseData = null;


        } catch (Exception e) {
            e.printStackTrace();
        }





    }
}