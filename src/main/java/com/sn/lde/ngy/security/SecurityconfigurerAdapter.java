package com.sn.lde.ngy.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@EnableWebSecurity
public class SecurityconfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Bean
    public ResourceServerTokenServices tokenServices() {
        RemoteTokenServices tokenServices = new RemoteTokenServices();
        tokenServices.setClientId("orderprocessingservice");
        tokenServices.setClientSecret("orderprocessingservicesecret");
        tokenServices.setCheckTokenEndpointUrl("http://localhost:8085/oauth/check_token");
        return tokenServices;
    }
}
