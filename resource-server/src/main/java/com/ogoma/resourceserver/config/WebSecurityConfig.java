package com.ogoma.resourceserver.config;


import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

@Configuration
@EnableOAuth2Sso
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    public void configure(WebSecurity webSecurity)  {
        //        Register application requests to be ignored by Spring Security
        webSecurity.ignoring().antMatchers("/resources/**","/dist/**","/resources/static/**", "/css/**", "/scss/**", "/images/**", "/photos/**", "/js/**", "/fonts/**", "/plugins/**", "/theme/**")
                .antMatchers("/fonts.googleapis.com/**", "/.i.pravatar.cc", "/maxcdn.bootstrapcdn.com/**", "/health");

        // necessary for the thymeleaf-extra-security4 to function properly and allow to use method sec:authorize="hasPermission(...)" in html view
        DefaultWebSecurityExpressionHandler handler = new DefaultWebSecurityExpressionHandler();
        //handler.setPermissionEvaluator(customPermissionEvaluator);
        webSecurity.expressionHandler(handler);
        /*Enable spring security debugging: allowed only in development enviroment only*/
//        websecurity.debug(true);
    }


        @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //.antMatchers("/", "/login**")
                //.permitAll()
                .anyRequest().authenticated();
                //.and().csrf().disable().httpBasic().disable();
                //Disable basic authentication that is being used by spring by default

    }

}
