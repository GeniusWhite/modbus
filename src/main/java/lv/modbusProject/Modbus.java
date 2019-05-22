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



    public void start() {

        try {
          tcpClientSocket =   connection.connect("192.168.40.30", 502);
        } catch (IOException e) {
            e.printStackTrace();
        }

        request.ready(tcpClientSocket);

        listOfAddresses.add(1);

       // Timer timer = new Timer();
        //MyTimerTask myTimerTask = new MyTimerTask(request, listOfAddresses);


        //timer.schedule(myTimerTask, 0, 50);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = () -> request.read(1);

        executor.scheduleAtFixedRate(task, 0,  50, TimeUnit.MILLISECONDS);



        //request.write(1, 10);

    }

}




