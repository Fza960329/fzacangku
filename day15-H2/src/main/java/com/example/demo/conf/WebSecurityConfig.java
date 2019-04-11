package com.example.demo.conf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      // auth.inMemoryAuthentication()
    	auth.jdbcAuthentication().dataSource(dataSource);
        /* .withDefaultSchema()
                .withUser("1").password("1").roles("USERS")
                .and().withUser("2").password("2").roles("ADMIN")
                .and().withUser("3").password("3").authorities("READ");*/
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/h2-console/**").permitAll();

        http.formLogin()
              //.loginPage("/login")
              .permitAll();

        // 禁用 H2 控制台的 CSRF 防护
        http.csrf().ignoringAntMatchers("/h2-console/**");
        // 允许来自同一来源的H2 控制台的请求
        http.headers().frameOptions().sameOrigin();
    }

   /* @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }*/
    
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/favicon.ico", "/css/**", "/js/**", "image/**");
    }
}