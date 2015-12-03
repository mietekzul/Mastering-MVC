package masterSpringMvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by dlok on 03/12/2015.
 */
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/profile")
            .and()
            .logout().logoutSuccessUrl("/login")
            .and()
            .authorizeRequests()
            .antMatchers("/webjars/**", "/login").permitAll()
            .anyRequest().authenticated();
    }
}
