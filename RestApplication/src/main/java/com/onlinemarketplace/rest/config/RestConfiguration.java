package com.onlinemarketplace.rest.config;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.onlinemarketplace.datamanagement.service.AuthenticationService;
import com.onlinemarketplace.datamanagement.serviceimpl.AuthenticationServiceImpl;
import com.onlinemarketplace.rest.filter.AuthenticationFilter;

@EnableWebMvc
@ComponentScan(basePackages = {
    "com.onlinemarketplace.rest.controller", "com.onlinemarketplace.rest.responce" })
@Configuration
@PropertySource(value = {
    "classpath:commen.properties" })
public class RestConfiguration
    extends WebMvcConfigurerAdapter {

    private static final Logger LOG = Logger.getLogger(MainConfig.class);

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        LOG.info(">> addResourceHandlers");
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/META-INF/resources/webjars/")
            .setCachePeriod(31556926);
        registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
        registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
        registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
    }

    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean(name = "messageSource")
    public ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public AuthenticationService authenticationService() {
        return new AuthenticationServiceImpl();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthenticationFilter(authenticationService()));
    }

}
