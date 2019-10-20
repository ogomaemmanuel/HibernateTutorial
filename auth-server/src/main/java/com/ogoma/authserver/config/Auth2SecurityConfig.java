package com.ogoma.authserver.config;

import com.ogoma.authserver.services.AuthClientDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
@EnableAuthorizationServer
@Configuration
public class Auth2SecurityConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    AuthClientDetailsService authClientDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(authClientDetailsService);

//        clients.inMemory()
//                .withClient("SampleClientId")
//                .secret(passwordEncoder.encode("secret"))
//                .authorizedGrantTypes("authorization_code")
//                .scopes("user_info")
//                .autoApprove(true)
//                .redirectUris("http://localhost:8082/ui/login","http://localhost:8083/ui2/login");
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        //used for obtaining token for Password Flow
        //Used mainly by mobile , desktop or spa   clients
        security.tokenKeyAccess("permitAll()")
                //only authenticated users can check token validity given the tokens
                .checkTokenAccess("isAuthenticated()");
    }

}
