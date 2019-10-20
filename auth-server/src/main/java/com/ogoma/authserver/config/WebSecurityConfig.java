package com.ogoma.authserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    @Override
    public void configure(WebSecurity web) {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //required for implicit flow, a user will be redirected here when they visit to login from resource server
        //Used mainly by web applications, after login the user will be redirected to the main app
        http.authorizeRequests().antMatchers("/login","/user/register").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll();;
    }
    //This is the default bean that handles authentication
    //It must be created since we use it auth2security  config
    @Override
    @Bean
    public  AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManager();
    }
}
