package com.ogoma.authserver.services;

import com.ogoma.authserver.enitities.Client;
import com.ogoma.authserver.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
public class AuthClientDetailsService implements ClientDetailsService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {
        Client client = clientRepository.findById(s).orElse(null);
        if (client == null) {
            throw new ClientRegistrationException("resource client not found");
        } else return new ClientDetails() {
            @Override
            public String getClientId() {
                return client.getId();
            }

            @Override
            public Set<String> getResourceIds() {
                return null;
            }

            @Override
            public boolean isSecretRequired() {
                return true;
            }

            @Override
            public String getClientSecret() {
                return client.getClientSecret();
            }

            @Override
            public boolean isScoped() {
                return client.getScope() == null;
            }

            @Override
            public Set<String> getScope() {
                Set scopes = new HashSet<>();
                scopes.add(client.getScope());
                return scopes;
            }

            @Override
            public Set<String> getAuthorizedGrantTypes() {
                return null;
            }

            @Override
            public Set<String> getRegisteredRedirectUri() {
                Set uri = new HashSet<>();
                uri.add(client.getRedirectUri());
                return uri;
            }

            @Override
            public Collection<GrantedAuthority> getAuthorities() {
                return null;
            }

            @Override
            public Integer getAccessTokenValiditySeconds() {
                return null;
            }

            @Override
            public Integer getRefreshTokenValiditySeconds() {
                return null;
            }

            @Override
            public boolean isAutoApprove(String s) {
                return false;
            }

            @Override
            public Map<String, Object> getAdditionalInformation() {
                return null;
            }
        };
    }
}
