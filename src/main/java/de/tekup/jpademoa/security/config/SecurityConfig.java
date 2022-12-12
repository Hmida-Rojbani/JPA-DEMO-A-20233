package de.tekup.jpademoa.security.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {
    private UserDetailsService bdUserDetailsService;
     @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/","/signin","/signup","/css/**","/js/**","/fonts/**","/images/**","/scss/**","/voitures-photos/**")
                .permitAll()
                .antMatchers("/clients/ui/**","/voitures/ui/**").hasRole("ADMIN")
                .antMatchers("/voitures/ui/").hasRole("USER")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                    .loginPage("/signin")
                    .defaultSuccessUrl("/")
                .and().logout().logoutSuccessUrl("/")
                .and().userDetailsService(bdUserDetailsService)
                .build();

    }
    @Bean
    public PasswordEncoder getPasswordEncoder(){
         return new BCryptPasswordEncoder();
    }
}
