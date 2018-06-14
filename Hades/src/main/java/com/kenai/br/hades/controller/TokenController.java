package com.kenai.br.hades.controller;

import com.kenai.br.hades.configuration.properties.HadesProperties;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/security/token")
@Api(value = "Token", description = "Token Controller", tags = "token")
public class TokenController {

    @Autowired
    private HadesProperties hadesProperties;

    @ApiOperation(value = "Revoke the current token")
    @RequestMapping(value = "/revoke")
    public void revoke(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("refreshToken", null);
        cookie.setHttpOnly(Boolean.TRUE);
        cookie.setSecure(hadesProperties.getSecurity().isEnalbleHttps());
        cookie.setPath(request.getContextPath() + "/oauth/token");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        response.setStatus(HttpStatus.NO_CONTENT.value());
    }
}
