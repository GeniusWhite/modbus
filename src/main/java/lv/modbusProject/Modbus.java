package lv.modbusProject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.*;

@Component
public class Modbus {



    private String cardNumber = "80005AE3C1";
    @Autowired
    Connection connection;
    @Autowired
    Request request;


    private Socket tcpClientSocket;
    private List<Integer> listOfAddresses = new ArrayList<>();
    private byte[] responseData = new byte[17];

    private  byte[] requestData = {0x00, 0x01, 0x00, 0x00, 0x00, 0x06, (byte) 0xFE, 0x06, 0x00, 0x02, 0x00, (byte) 0xC8};

    public void start() {

        try {
          tcpClientSocket =   connection.connect("192.168.40.30", 502);
        } catch (IOException e) {
            e.printStackTrace();
        }

        request.ready(tcpClientSocket);
        request.write(2,200);
        listOfAddresses.add(1);


        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);



        Runnable task = () -> request.read(1);

        executor.scheduleAtFixedRate(task, 0,  10, TimeUnit.MILLISECONDS);





    }

}




