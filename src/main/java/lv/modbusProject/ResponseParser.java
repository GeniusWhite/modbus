package lv.modbusProject;

import lv.modbusProject.DAL.Repository;
import lv.modbusProject.Domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class ResponseParser {

    @Autowired
    Request request;

    @Autowired
    Repository repository;
    @Autowired
    Access access;


    private Byte address = 0;
    private int counter = 0;


    //@Async("threadPoolTaskExecutor")
    public void parse(byte[] responseData) {

        String key = "";

            if (address == responseData[6])
            {
                counter++;
            }

            if(counter > 7)
            {
                counter = 0;
            }

            if(counter ==0 || counter >7){

                System.out.println(responseData[9]);
                System.out.println(responseData[10]);
                System.out.println(responseData[11]);
                System.out.println(responseData[12]);
                System.out.println(responseData[13]);
                System.out.println(responseData[14]);
                System.out.println(responseData[15]);
                System.out.println(responseData[16]);
                if (access.checkAccess(key)) {



                    address = responseData[6];


                    request.write(1, 100);
                    request.write(3, 10);


                    Event event = new Event();

                    event.setEventInfo("karte");
                    repository.addEvent(event);
                    event = null;


                } else {
                    request.write(2, 100);
                    request.write(3, 100);

                    Event event = new Event();

                    event.setEventInfo("nav pieejas");
                    repository.addEvent(event);
                    event = null;
                }
            }

    }
}