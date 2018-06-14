package com.kenai.br.hades.configuration.oauth2;

import com.kenai.br.hades.configuration.token.TokenCustomizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Value("${auth.client.secret}")
    private String clientKey;
    @Value("${auth.client.id}")
    private String clientId;
    @Value("#{'${auth.client.scope}'.split(',')}")
    private String[] scope;
    @Value("#{'${auth.client.authorized-grant-types}'.split(',')}")
    private String[] grantTypes;
    @Value("${auth.token.expiration.time}")
    private Integer expirationTime;
    @Value("${auth.token.validity.time}")
    private Integer validityTime;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    @Qualifier("tokenConverterDefault")
    private TokenCustomizer customTokenConverter;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
               .withClient(clientId)
               .secret(clientKey)
               .scopes(scope)
               .authorizedGrantTypes(grantTypes)
               .accessTokenValiditySeconds(validityTime)
               .refreshTokenValiditySeconds(expirationTime);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.tokenStore(tokenStore())
                 .accessTokenConverter(customTokenConverter)
                 .reuseRefreshTokens(Boolean.FALSE)
                 .authenticationManager(authenticationManager);
    }

    @Bean(name ="tokenConverterDefault")
    public TokenCustomizer accessTokenConverter() {
        TokenCustomizer jwtAccessTokenConverter = new TokenCustomizer();
        jwtAccessTokenConverter.setSigningKey("hades@2018");
        return jwtAccessTokenConverter;
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

}
