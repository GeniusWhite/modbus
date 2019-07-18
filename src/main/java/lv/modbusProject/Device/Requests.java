package lv.modbusProject.Device;

import org.springframework.stereotype.Component;


public class Requests {



    public byte[] open(){

        byte[] requestData = {0x00, 0x01, 0x00, 0x00, 0x00, 0x06, (byte) 0xFE, 0x06, 0x00, 0x02, 0x00, (byte) 0xC8};


        return null;
    }

    public byte[] noEntry(){

        byte[] requestData = {0x00, 0x01, 0x00, 0x00, 0x00, 0x06, (byte) 0xFE, 0x06, 0x00, 0x02, 0x00, (byte) 0xC8};

        return requestData;

    }

    public void noName(){




    }

}
