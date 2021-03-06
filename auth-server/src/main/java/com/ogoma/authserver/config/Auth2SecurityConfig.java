package com.ogoma.authserver.config;

import com.ogoma.authserver.authentication.AppUserDetailsService;
import com.ogoma.authserver.authentication.AuthClientDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.JdbcApprovalStore;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

@EnableAuthorizationServer
@Configuration
public class Auth2SecurityConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    AuthClientDetailsService authClientDetailsService;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private AppUserDetailsService appUserDetailsService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    @Qualifier("authenticationManagerBean")
    //In order to use the “password” grant type we need to wire in and use the AuthenticationManager bean
    private AuthenticationManager authenticationManager;
    @Override

    //https://alexbilbie.com/guide-to-oauth-2-grants/
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                .jdbc(dataSource);
//                .inMemory()
//                .withClient("SampleClientId")
//                .secret(passwordEncoder.encode("secret"))
//                .authorizedGrantTypes("authorization_code","password","client_credentials","refresh_token")
//                .scopes("user_info")
//                .autoApprove(true)
//                .redirectUris("http://localhost:8082/login");

    }
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        //used so trusted resources can obtain the public key for JWT verification
        security.tokenKeyAccess("permitAll()")
                //only authenticated users can check token validity given the tokens
                .checkTokenAccess("isAuthenticated()");
    }
    @Override
    public void configure(
            AuthorizationServerEndpointsConfigurer endpoints)
            throws Exception {
                  endpoints
                .tokenStore(tokenStore())
                .approvalStore(approvalStore())
                .userDetailsService(appUserDetailsService)
                .authenticationManager(authenticationManager);
    }
    @Bean
    public TokenStore tokenStore() {

       return new JdbcTokenStore(dataSource);
        //return new JdbcTokenStore(dataSource);
    }

    @Bean
    public ApprovalStore approvalStore(){
        return new JdbcApprovalStore(dataSource);
    }

}
