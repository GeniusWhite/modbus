package lv.modbusProject;

import lv.modbusProject.Device.ModbusConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ModbusProjectApplication {



	public static void main(String[] args) {
		//SpringApplication.run(ModbusProjectApplication.class, args);

		ApplicationContext applicationContext = SpringApplication.run(ModbusProjectApplication.class, args);

		ModbusConfig modbusConfig = applicationContext.getBean(ModbusConfig.class);
		modbusConfig.start();


	}
	/*@Bean("threadPoolTaskExecutor")
	public TaskExecutor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(2);
		executor.setWaitForTasksToCompleteOnShutdown(true);
		executor.setThreadNamePrefix("Async-");
		return executor;
	}*/

}
