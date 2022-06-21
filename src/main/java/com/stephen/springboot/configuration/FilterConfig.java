package com.stephen.springboot.configuration;

import com.stephen.springboot.filter.FooFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean fooFilterBean() {
        Map<String, String> initParams = new HashMap<>();

        List<String> urlPatterns = new ArrayList<>();
        urlPatterns.add("/foo");
        urlPatterns.add("/fooAll");

        return filterConfigs(new FooFilter(), urlPatterns, initParams);
    }

    private FilterRegistrationBean filterConfigs(Filter filter, List<String> urlPatterns, Map<String, String> initParams) {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(filter);

        registrationBean.setUrlPatterns(urlPatterns);
        registrationBean.setInitParameters(initParams);

        return registrationBean;
    }
}
