package com.hitema.spring.boot.planning.security;


import com.hitema.spring.boot.planning.services.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        FormLoginConfigurer login = http.authorizeRequests().antMatchers("/admin").hasRole("admin").anyRequest().authenticated()
//                .and().formLogin().defaultSuccessUrl("/admin");
//
//        FormLoginConfigurer login2 = http.authorizeRequests().antMatchers("/sessions").hasRole("responsable").anyRequest().authenticated()
//                .and().formLogin().defaultSuccessUrl("/sessions");
//
//        FormLoginConfigurer login3 = http.authorizeRequests().antMatchers("/membre").hasRole("membre").anyRequest().authenticated()
//                .and().formLogin().defaultSuccessUrl("/membre");


//        http.authorizeRequests()
//                .antMatchers("/admin").hasRole("admin")
//                .antMatchers("/responsable").hasRole("responsable")
//                .antMatchers("/membre").hasRole("membre")
//                .anyRequest().authenticated().and()
//                .formLogin().and().logout().logoutSuccessUrl("index.html");
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll().successHandler(new AuthenticationSuccessHandler() {

                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                                        Authentication authentication) throws IOException, ServletException {
                        // run custom logics upon successful login

                        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
                        String username = userDetails.getUsername();
                        String role = userDetails.getUserRole();
                        String path1 = request.getContextPath()+"/admin";
                        String path2 = request.getContextPath()+"/session_responsable";
                        String path3 = request.getContextPath()+"/membre";

                        if (role.equals("admin")) {
                            response.sendRedirect(path1);
                        } else if (role.equals("responsable")) {
                            response.sendRedirect(path2);

                        } else if (role.equals("membre")) {
                            response.sendRedirect(path3);

                        }
                        else {
                            response.sendRedirect(request.getContextPath());
                        }
//
                    }


                });
    }
}
