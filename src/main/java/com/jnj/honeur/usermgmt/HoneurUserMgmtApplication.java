package com.jnj.honeur.usermgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {	"com.jnj.honeur.usermgmt.repository" })
public class HoneurUserMgmtApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(HoneurUserMgmtApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(HoneurUserMgmtApplication.class, args);
	}
}
