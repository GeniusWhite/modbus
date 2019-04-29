package lv.modbusProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ModbusProjectApplication {



	public static void main(String[] args) {
		SpringApplication.run(ModbusProjectApplication.class, args);


		Modbus modbus = new Modbus();

		modbus.start();


	}

}
