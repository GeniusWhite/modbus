package lv.modbusProject.Controller;


import lv.modbusProject.DAL.Repository;
import lv.modbusProject.Domain.Event;
import lv.modbusProject.Domain.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@RestController
public class DataController {

    @Autowired
    Repository repository;




    @RequestMapping("/getEvents")
    public List<Event> visitors(String date) {





        return repository.getEvent(date);

    }



}
