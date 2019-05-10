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
    Requests requests = new Requests();
    ConnectionPlace connectionPlace = new ConnectionPlace();
    RequestPlace requestPlace = new RequestPlace();

    private Socket tcpClientSocket;





    public void start() {

        try {
          tcpClientSocket =   connectionPlace.connect("192.168.40.30", 502);
        } catch (IOException e) {
            e.printStackTrace();
        }

        requestPlace.ready(tcpClientSocket);



        Timer timer = new Timer();
        MyTimerTask myTimerTask = new MyTimerTask(requestPlace);

        requestPlace.read();

        timer.schedule(myTimerTask, 0, 50);


    }

}




