package lv.modbusProject.Device;

import lv.modbusProject.DAL.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Access {

    @Autowired
    Repository repository;


    public boolean checkAccess(String key){

        boolean accessGranted = false;

        repository.checkKey(key);
        //responseData[11] == -63;

        return accessGranted;
    }




}




