package lv.modbusProject;

import java.util.TimerTask;

public class MyTimerTask extends TimerTask {

    RequestPlace requestPlace;

    public MyTimerTask(RequestPlace requestPlace) {
this.requestPlace = requestPlace;
    }


    @Override
    public void run() {

    requestPlace.read();


    }
}
