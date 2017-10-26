package org.superbiz.struts;

import com.opensymphony.module.sitemesh.filter.PageFilter;
import org.apache.struts2.dispatcher.ActionContextCleanUp;
import org.apache.struts2.dispatcher.FilterDispatcher;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean struts2() {
        Filter f = new FilterDispatcher();
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(f);
        filterRegistration.addInitParameter("actionPackages", "com.lq");

        return filterRegistration;
    }

    @Bean
    public FilterRegistrationBean strutsCleanup() {
        Filter f = new ActionContextCleanUp();
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(f);

        return filterRegistration;
    }

    @Bean
    public FilterRegistrationBean sitemesh() {
        Filter f = new PageFilter();
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(f);

        return filterRegistration;
    }
}
