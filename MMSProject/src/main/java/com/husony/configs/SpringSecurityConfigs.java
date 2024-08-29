/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author ACER
 */
@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.husony.controllers",
    "com.husony.repository",
    "com.husony.service",
    "com.husony.components"
})
@Order(2)
public class SpringSecurityConfigs extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public Cloudinary cloudinary() {
        Cloudinary cloudinary
                = new Cloudinary(ObjectUtils.asMap(
                        "cloud_name", "dluxogrmn",
                        "api_key", "958699327246893",
                        "api_secret", "sL64XQ_2Djr4kg8Gi2vZyR-f5MA",
                        "secure", true));
        return cloudinary;
    }
    
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http)
            throws Exception {
        http.formLogin().usernameParameter("username").passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/").failureUrl("/login?error");

        http.logout().logoutSuccessUrl("/login");

        http.exceptionHandling().accessDeniedPage("/login?accessDenied");

        http.authorizeRequests().antMatchers("/api/**").permitAll()
                .antMatchers("/").hasAnyRole("ADMIN", "EMPLOYEE")
                .antMatchers("/job/**").hasAnyRole("ADMIN", "EMPLOYEE")
                .antMatchers("/category/**").hasAnyRole("ADMIN", "EMPLOYEE")
                .antMatchers("/location/**").hasAnyRole("ADMIN", "EMPLOYEE")
                .antMatchers("/maintenancetype/**").hasAnyRole("ADMIN", "EMPLOYEE")
                .antMatchers("/repairtype/**").hasAnyRole("ADMIN", "EMPLOYEE")
                .antMatchers("/report").hasAnyRole("ADMIN", "EMPLOYEE")
                .antMatchers("/**").hasRole("ADMIN");
                
                

        http.csrf().disable();
    }
}
