package tms.business.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class AppController implements WebMvcConfigurer {


  public void addCorsMappings(CorsRegistry registry) {
	  registry.addMapping("/**")
	  		  .allowedOrigins("http://localhost:4200")
	  		  .allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
			  .allowedHeaders("*")
			  .allowCredentials(true);
  }
}

