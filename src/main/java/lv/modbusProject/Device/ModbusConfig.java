package lv.modbusProject.Device;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.*;

@Component
public class ModbusConfig {


    @Autowired
    ModbusTCPConnection modbusTCPConnection;
    @Autowired
    Request request;


    private Socket tcpClientSocket;
    private List<Integer> listOfAddresses = new ArrayList<>();

    public void start() {

        try {
          tcpClientSocket =   modbusTCPConnection.connect("192.168.40.30", 502);
        } catch (IOException e) {
            e.printStackTrace();
        }

        request.ready(tcpClientSocket);

        listOfAddresses.add(1);

        for(int i: listOfAddresses){

            request.write(i,200);
        }


        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);



        Runnable task = () -> {

                for (int i : listOfAddresses) {
                    request.read(i);
                }


            };

        executor.scheduleAtFixedRate(task, 0,  10, TimeUnit.MILLISECONDS);





    }

}




