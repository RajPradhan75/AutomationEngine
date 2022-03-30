package com.nexops.auto.remediate.webautomation;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.nexops.auto.remediate.controller.AutomationController;

@SpringBootApplication
@ComponentScan(basePackageClasses = AutomationController.class)
public class WebAutomationApplication extends SpringBootServletInitializer  {
	public static void main(String[] args) throws Exception {
		 SpringApplication.run(WebAutomationApplication.class, args);
		
		 TestUnit test = new TestUnit();
			test.getDriverParam(args[0]);
	}
	

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebAutomationApplication.class);
    }
	

	/*@Override
	public void run(String... args) throws Exception {

		String str = "{\"Driver\":\"SalesForceDriver\",\"Machine_Id\":238,\"Browser\":\"chrome\",\"UnitTest\":false,\"Exec_ID\":1,\"Project_Id\":108,\"ProjectType\":\"WEB\"}";

		
	}
*/
	

	
}
