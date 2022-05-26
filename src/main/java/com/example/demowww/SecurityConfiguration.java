package com.example.demowww;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests().antMatchers("/").permitAll().and()
                .authorizeRequests()
                .antMatchers("/h2-console/**","/register","/login").permitAll()
                .antMatchers("/adminsignup","/edit_user").hasRole("ADMIN")
                .antMatchers("/new_info","/edit_info","/UserPanel").hasRole("USER")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin() .loginPage("/login").permitAll()
                .loginProcessingUrl("/login")
                .successHandler(myAuthenticationSuccessHandler())
                .usernameParameter("login")
                .passwordParameter("password")
                .permitAll()
                .and()
                .logout().logoutSuccessUrl("/").permitAll();
        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
    }

    @Bean("authenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
        return new MySimpleUrlAuthenticationSuccessHandler();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception{
        auth.
                inMemoryAuthentication()
                .withUser("user")
                .password("{noop}password")
                .authorities("USER").and()
                .withUser("admin")
                .password("{noop}password")
                .authorities("USER","ADMIN");
    }
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }


}
