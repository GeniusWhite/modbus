package lv.modbusProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ModbusProjectApplication {



	public static void main(String[] args) {
		//SpringApplication.run(ModbusProjectApplication.class, args);

		ApplicationContext applicationContext = SpringApplication.run(ModbusProjectApplication.class, args);

		Modbus modbus = applicationContext.getBean(Modbus.class);

		modbus.start();


	}

}
