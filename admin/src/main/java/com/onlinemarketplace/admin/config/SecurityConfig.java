package com.onlinemarketplace.admin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig
    extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("mkyong@gmail.com").password("123456").roles("USER");
        auth.inMemoryAuthentication().withUser("admin@gmail.com").password("123456").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("dba@gmail.com").password("123456").roles("DBA");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests().antMatchers("/resources/**").permitAll();
    	
        http.authorizeRequests().antMatchers("/**").access("hasRole('ROLE_ADMIN')").antMatchers("/dba/**")
            .access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')").and().formLogin()
            .loginPage("/login").loginProcessingUrl("/loginProcess").failureUrl("/login?error")
            .defaultSuccessUrl("/*").usernameParameter("user").passwordParameter("password").permitAll()
            .and().logout().logoutSuccessUrl("/login?logout")
		.and()
		    .csrf();

    }
}