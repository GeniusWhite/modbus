package lv.modbusProject;

import org.springframework.stereotype.Component;

@Component
public class ResponseParser {


    public boolean parse(byte[] responseData) {

        boolean ok = false;

        for (byte b : responseData) {

            System.out.println(Integer.toHexString(b));


        }

        if (responseData[10] == 16) {

            ok = true;

        }

        return ok;
    }
}