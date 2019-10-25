package com.ogoma.resourceserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
//used when the application expects access tokens to validate with the server
//@EnableResourceServer
public class Auth2Config   {



//    @Bean("resourceServerRequestMatcher")
//    public RequestMatcher apiResources() {
//        return new AntPathRequestMatcher("/api/resources/**");
//    }
//    @Override
//    public void configure(final HttpSecurity http) throws Exception {
//        http
//                .requestMatcher(apiResources()).authorizeRequests()
//                .anyRequest().authenticated();
//    }


    @Primary
    @Bean
    //Used by Auth2 to check validity of token since we are not using jdbcstore , jdbc store is ideal when resource server
    // and auth server share the same db, here they do not
    public RemoteTokenServices tokenService() {
        RemoteTokenServices tokenService = new RemoteTokenServices();
        tokenService.setCheckTokenEndpointUrl(
                "http://localhost:8094/sso-server/oauth/check_token");
        tokenService.setClientId("SampleClientId");
        tokenService.setClientSecret("secret");
        return tokenService;
    }
}
