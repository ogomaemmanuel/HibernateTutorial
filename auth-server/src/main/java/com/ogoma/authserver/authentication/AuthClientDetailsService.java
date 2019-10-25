package com.ogoma.authserver.authentication;

import com.ogoma.authserver.enitities.Client;
import com.ogoma.authserver.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class AuthClientDetailsService implements ClientDetailsService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {
        Client client = clientRepository.findById(s).orElse(null);
        if (client == null) {
            throw new ClientRegistrationException("resource client not found");
        } else
        {
          ClientDetails clientDetails=  new BaseClientDetails(client.getId(),client.getResourceIds(),client.getScope(),null,client.getRedirectUri());
            //clientDetails.
          return clientDetails;
        }





//            return new ClientDetails() {
//            @Override
//            public String getClientId() {
//                return client.getId();
//            }
//
//            @Override
//            public Set<String> getResourceIds() {
//                if (client.getResourceIds() != null) {
//                    return Stream.of(client.getResourceIds().split(",")).collect(Collectors.toSet());
//                }
//                return null;
//            }
//
//            @Override
//            public boolean isSecretRequired() {
//                return this.getClientSecret() != null;
//            }
//
//            @Override
//            public String getClientSecret() {
//                return client.getClientSecret();
//            }
//
//            @Override
//            public boolean isScoped() {
//                return client.getScope() != null;
//            }
//
//            @Override
//            public Set<String> getScope() {
//                Set scopes = new HashSet<>();
//                if (client.getScope() != null) {
//                     scopes.addAll(Arrays.asList(client.getScope().split(",")));
//                     return scopes;
//                }
//                //we must set a default cope, without default scope, auth2 wont work, I am setting it to none
//                // this one is the scope returned when a client has not specified a scope
//                scopes.add("none");
//                return scopes;
//            }
//
//            @Override
//            public Set<String> getAuthorizedGrantTypes() {
//                Set grantTypes = new HashSet();
//                if (client.getAuthorizedGrantTypes() != null) {
//                    grantTypes.addAll(Arrays.asList(client.getAuthorizedGrantTypes().split(",")));
//                }
//                return grantTypes;
//            }
//
//            @Override
//            public Set<String> getRegisteredRedirectUri() {
//                Set uri = new HashSet<>();
//                uri.add(client.getRedirectUri());
//                return uri;
//            }
//
//            @Override
//            public Collection<GrantedAuthority> getAuthorities() {
//                //This will be added as scopes
//                return new ArrayList<>();
//            }
//
//            @Override
//            public Integer getAccessTokenValiditySeconds() {
//                return client.getAccessTokenValidity();
//            }
//
//            @Override
//            public Integer getRefreshTokenValiditySeconds() {
//                return client.getAccessTokenValidity();
//
//            }
//
//            @Override
//            public boolean isAutoApprove(String s) {
////                if (client.getAutoApprove() != null) {
////                    return Boolean.valueOf(client.getAutoApprove());
////                }
//                return s.equalsIgnoreCase("none");
//            }
//
//            @Override
//            public Map<String, Object> getAdditionalInformation() {
//                HashMap hashMap = new HashMap();
//                hashMap.put(client.getAdditionalInformation(), client.getAdditionalInformation());
//                return hashMap;
//            }
//        };
    }
}
