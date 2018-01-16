package com.assignment.security.securitydb.config;

import com.assignment.security.securitydb.repository.UsersRepository;
import com.assignment.security.securitydb.service.CustomUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 
 * @author Maruthi
 * 
 * Following class is used to enforce Spring security on the URLs containing
 * "secured" word.
 * 
 * Basic Authentication is provided for making the testing easy.
 * Uncomment the lines for authentication and authorization from DB
 *
 */


@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses = UsersRepository.class)
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    /*@Autowired
    private CustomUserDetailsService userDetailsService;*/
    
    @Autowired
	private AuthenticationEntryPoint authEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /*http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/secured/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin().permitAll();*/
    	
    
    	http.csrf().disable();
    	http.authorizeRequests()
        .antMatchers("/secured/**").authenticated()
        .anyRequest().permitAll()
        .and()
        .httpBasic()
        .authenticationEntryPoint(authEntryPoint);
    }

   
    
    @Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("mmsr").password("mmsr").roles("USER");
	}
    
    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService)
        .passwordEncoder(getPasswordEncoder());
    }
    
    private PasswordEncoder getPasswordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return true;
            }
        };
    }*/
}
