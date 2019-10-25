package com.ogoma.authserver.config;

import com.ogoma.authserver.authentication.AppUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private AppUserDetailsService appUserDetailsService;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(appUserDetailsService);

                //.and()
               // .inMemoryAuthentication().withUser("user")
               // .password(passwordEncoder.encode("password"))
                //.roles("USER");
    }

    @Override
    public void configure(WebSecurity web) {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //required for implicit flow, a user will be redirected here when they visit to login from resource server
        //Used mainly by web applications, after login the user will be redirected to the main app
        http.authorizeRequests().antMatchers("/login", "/oauth/authorize").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable()
                .formLogin().permitAll();
        ;
    }

    //This is the default bean that handles authentication
    //It must be created since we use it auth2security  config when using password grant
    //In order to use the “password” grant type we need to wire in and use the AuthenticationManager bean
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManager();
    }


}
