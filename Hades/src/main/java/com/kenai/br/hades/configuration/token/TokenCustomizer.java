package com.kenai.br.hades.configuration.token;

import com.kenai.br.hades.model.Person;
import com.kenai.br.hades.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class TokenCustomizer extends JwtAccessTokenConverter {

    @Autowired
    private PersonService personService;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Map<String, Object> additionalInfo = new HashMap<>();

        Optional<Person> person = this.personService.findByUsername(authentication.getName());
        additionalInfo.put("authorities", authentication.getUserAuthentication()
                                                        .getAuthorities());
        additionalInfo.put("username", authentication.getName());
        if (person.isPresent()) {
            additionalInfo.put("person_name",person.get().getName());
            additionalInfo.put("person_status",person.get().getStatus().getDescription());
        }
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return super.enhance(accessToken, authentication);
    }
}
