package com.ogoma.authserver.enitities;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;

@Entity
@Table(name = "oauth_client_details")
public class Client {
    @Id
    // @GeneratedValue(strategy = )
    // @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "client_id", length = 36)
    private String id;
    @Column(name = "resource_ids")
    private String resourceIds;
    @Column(name = "client_secret")
    private String clientSecret;
    @Column(name = "scope")
    private String scope;
    @Column(name = "authorized_grant_types")
    private String authorizedGrantTypes;
    @Column(name = "refresh_token_validity")
    private Integer refreshTokenValidity;
    @Column(name = "access_token_validity")
    private Integer accessTokenValidity;
    @Column(name = "web_server_redirect_uri")
    private String redirectUri;
    @Column(name = "additional_information ")
    private String additionalInformation;
    @Column(name = "autoapprove ")
    private String autoApprove;

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

    public Integer getRefreshTokenValidity() {
        return refreshTokenValidity;
    }

    public Client setRefreshTokenValidity(Integer refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
        return this;
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public Client setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
        return this;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public Client setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
        return this;
    }

    public String getAutoApprove() {
        return autoApprove;
    }

    public Client setAutoApprove(String autoApprove) {
        this.autoApprove = autoApprove;
        return this;
    }

    @PrePersist
    public void encryptPassword() {
        if(this.clientSecret!=null) {
            this.clientSecret = new BCryptPasswordEncoder().encode(this.clientSecret);
        }
    }

}
