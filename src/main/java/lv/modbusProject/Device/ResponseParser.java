package lv.modbusProject.Device;

import lv.modbusProject.DAL.Repository;
import lv.modbusProject.Domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalTime;


@Component
public class ResponseParser {

    @Autowired
    Request request;

    @Autowired
    Repository repository;
    @Autowired
    Access access;


    private Byte address = -2;


    private LocalTime StartLocalTime;


    //@Async("threadPoolTaskExecutor")
    public void parse(byte[] responseData) {


        Duration duration = Duration.ZERO;

        String key = "";

            if (address == responseData[6]) {



                if(StartLocalTime == null){


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
                        StartLocalTime = LocalTime.now();

                    } else {
                        request.write(2, 100);
                        request.write(3, 100);

                        Event event = new Event();

                        event.setEventInfo("nav pieejas");
                        repository.addEvent(event);
                        event = null;

                        StartLocalTime = LocalTime.now();
                    }


                }


                LocalTime StopLocalTime = LocalTime.now();

                duration = Duration.between(StartLocalTime, StopLocalTime);



            }

            if(duration.getSeconds() > 3)
            {

                StartLocalTime = null;
            }





    }
}