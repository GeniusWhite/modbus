package lv.modbusProject;

import net.sourceforge.jmodbus.ModbusTCPMaster;
import net.wimpi.modbus.io.ModbusTCPTransaction;
import net.wimpi.modbus.msg.ReadInputDiscretesRequest;
import net.wimpi.modbus.msg.ReadInputDiscretesResponse;
import net.wimpi.modbus.net.TCPMasterConnection;

import java.net.InetAddress;

public class Modbus2 {


   /* TCPMasterConnection con = null; //the connection
    ModbusTCPTransaction trans = null; //the transaction
    ReadInputDiscretesRequest req = null; //the request
    ReadInputDiscretesResponse res = null; //the response

    InetAddress addr = null; //the slave's address
    int port = Modbus.DEFAULT_PORT;
    int ref = 0; //the reference; offset where to start reading from
    int count = 0; //the number of DI's to read
    int repeat = 1; //a loop for repeating the transaction


    public void conn(){

        con = new TCPMasterConnection(addr);
        con.setPort(port);
        try {
            con.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        req = new ReadInputDiscretesRequest(ref, count);

        trans = new ModbusTCPTransaction(con);
        trans.setRequest(req);
*/


    //}
    public void startread() {
        int[] results = new int[0];

        ModbusTCPMaster modbusTCPMaster = new ModbusTCPMaster("192.168.40.30", 502);

         modbusTCPMaster.readInputRegisters(254, 0, 5, 1, results);


        System.out.println(results.toString());
    }
}