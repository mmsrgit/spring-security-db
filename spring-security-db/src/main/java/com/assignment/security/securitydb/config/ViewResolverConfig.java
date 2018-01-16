package com.assignment.security.securitydb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 
 * @author Maruthi
 * Following class is used for displaying the results in both JSON and XML
 *
 * When the URL is appended by ".xml", results are displayed in XML. 
 * Otherwise defaulted to JSON
 */

@Configuration
@EnableWebMvc
public class ViewResolverConfig extends WebMvcConfigurerAdapter {
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
	configurer.favorPathExtension(true).
	    favorParameter(false).
	    parameterName("mediaType").
	    ignoreAcceptHeader(true).
	    useJaf(false).
	    defaultContentType(MediaType.APPLICATION_JSON).
	    mediaType("xml", MediaType.APPLICATION_XML).
	    mediaType("json", MediaType.APPLICATION_JSON);
	  }
	

}
