package lv.modbusProject;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {

    Request request;
    List <Integer> listOfAddresses = new ArrayList();

    public MyTimerTask(Request request, List<Integer> listOfAddresses) {
            this.request = request;
            this.listOfAddresses = listOfAddresses;
    }


    @Override
    public void run() {

       for(int address: listOfAddresses) {

           request.read(address);
       }

    }
}
