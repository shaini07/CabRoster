package com.blujay.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.vaadin.spring.events.annotation.EnableEventBus;

import com.blujay.app.security.SecurityConfig;
import com.blujay.backend.OrderRepository;
import com.blujay.backend.data.entity.Order;
import com.blujay.backend.service.UserService;
import com.blujay.backend.util.LocalDateJpaConverter;
import com.blujay.ui.AppUI;

@SpringBootApplication(scanBasePackageClasses = { AppUI.class, Application.class, UserService.class,
		SecurityConfig.class })
@EnableJpaRepositories(basePackageClasses = { OrderRepository.class })
@EntityScan(basePackageClasses = { Order.class, LocalDateJpaConverter.class })
@EnableEventBus
public class Application extends SpringBootServletInitializer {

	public static final String APP_URL = "/";
	public static final String LOGIN_URL = "/login.html";
	public static final String LOGOUT_URL = "/login.html?logout";
	public static final String LOGIN_FAILURE_URL = "/login.html?error";
	public static final String LOGIN_PROCESSING_URL = "/login";

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
}
