package lv.modbusProject.Controller;


import lv.modbusProject.DAL.Repository;
import lv.modbusProject.Device.Request;
import lv.modbusProject.Domain.Event;
import lv.modbusProject.Domain.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataController {

    @Autowired
    Repository repository;
    @Autowired
    Request request;



    @RequestMapping("/getEvents")
    public List<Event> visitors(String date) {




        return repository.getEventRange(date);

    }

    @RequestMapping("/getWorkers")
    public List<Worker> getWorkers(){



        return repository.getWorkers();
    }

    @RequestMapping("/getDeviceStatus")
    public int getDeviceStatus(){




        return request.read(1);
    }

    @RequestMapping("/setIP")
    public int setIPAddress(){




        return request.read(1);
    }


}
