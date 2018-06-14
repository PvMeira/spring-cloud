package com.kenai.br.hades.configuration.token;

import com.kenai.br.hades.configuration.properties.HadesProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class RefreshTokenPostProcessor implements ResponseBodyAdvice<OAuth2AccessToken> {

    @Autowired
    private HadesProperties hadesProperties;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return returnType.getMethod().getName().equals("postAccessToken");
    }

    @Override
    public OAuth2AccessToken beforeBodyWrite(  OAuth2AccessToken body
                                             , MethodParameter returnType
                                             , MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        HttpServletRequest req = ((ServletServerHttpRequest) request).getServletRequest();
        HttpServletResponse resp = ((ServletServerHttpResponse) response).getServletResponse();
        DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) body;
        String refresh_token = body.getRefreshToken().getValue();
        addRefreshTokenOnCookie(refresh_token,req,resp);
        removeRefreshTokenOfBody(token);
        return body;
    }

    private void removeRefreshTokenOfBody(DefaultOAuth2AccessToken token) {

        token.setRefreshToken(null);
    }

    private void addRefreshTokenOnCookie(String refreshToken, HttpServletRequest req, HttpServletResponse resp) {

        Cookie refreshTokenCookie = new Cookie("refreshToken", refreshToken);
        refreshTokenCookie.setHttpOnly(Boolean.TRUE);
        refreshTokenCookie.setSecure(hadesProperties.getSecurity().isEnalbleHttps());
        refreshTokenCookie.setPath(req.getContextPath() + "/oauth/token");
        refreshTokenCookie.setMaxAge(2592000);
        resp.addCookie(refreshTokenCookie);
    }
}
