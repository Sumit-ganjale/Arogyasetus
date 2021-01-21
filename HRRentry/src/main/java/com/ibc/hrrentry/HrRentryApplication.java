package com.ibc.hrrentry;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HrRentryApplication extends SpringBootServletInitializer {

	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(HrRentryApplication.class);
	    }
	 @Bean
		public ModelMapper modelMapper() {
		    return new ModelMapper();
		}
	    public static void main(String[] args) throws Exception {
	        SpringApplication.run(HrRentryApplication.class, args);
	    }
	    //@Bean
		//public KieContainer kieContainer() {
		//	return KieServices.Factory.get().getKieClasspathContainer();
		//}
}
