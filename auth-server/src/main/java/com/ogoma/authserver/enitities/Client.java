package com.ogoma.authserver.enitities;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;

@Entity
@Table(name = "oauth_client_details")
public class Client {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private String id;
    private String clientSecret;
    private String scope;
    private String authorizedGrantTypes;
    private String authorities;
    private Integer accessTokenValidity;
    private String  redirectUri;

    public String getId() {
        return id;
    }

    public Client setId(String id) {
        this.id = id;
        return this;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public Client setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
        return this;
    }

    public String getScope() {
        return scope;
    }

    public Client setScope(String scope) {
        this.scope = scope;
        return this;
    }

    public String getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    public Client setAuthorizedGrantTypes(String authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
        return this;
    }

    public String getAuthorities() {
        return authorities;
    }

    public Client setAuthorities(String authorities) {
        this.authorities = authorities;
        return this;
    }
    public Integer getAccessTokenValidity() {
        return accessTokenValidity;
    }
    public Client setAccessTokenValidity(Integer accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
        return this;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public Client setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
        return this;
    }

}
