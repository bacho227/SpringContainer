package ge.config;

import ge.security.CustomAuthenticationFilter;
import ge.security.CustomAuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bacho on 1/30/15.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public CustomAuthenticationFilter customUsernamePasswordAuthenticationFilter()
            throws Exception {
        CustomAuthenticationFilter customUsernamePasswordAuthenticationFilter = new CustomAuthenticationFilter();
        customUsernamePasswordAuthenticationFilter.setAuthenticationManager(authenticationManagerBean());
//        customUsernamePasswordAuthenticationFilter.setAuthenticationSuccessHandler(customSuccessHandler());
        return customUsernamePasswordAuthenticationFilter;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        List<AuthenticationProvider> authenticationProviderList = new ArrayList<AuthenticationProvider>();
        authenticationProviderList.add(customAuthenticationProvider());
        AuthenticationManager authenticationManager = new ProviderManager(authenticationProviderList);
        return authenticationManager;
    }
//    @Bean
//    public CustomSuccessHandler customSuccessHandler() {
//        CustomSuccessHandler customSuccessHandler = new CustomSuccessHandler();
//        return customSuccessHandler;
//    }

    @Bean
    public CustomAuthenticationProvider customAuthenticationProvider() {
        CustomAuthenticationProvider customAuthenticationProvider = new CustomAuthenticationProvider();
        return customAuthenticationProvider;
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.debug(true);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login").anonymous()
//                .antMatchers("/rest/**").permitAll()
//                .antMatchers("/js/**").permitAll()
//                .antMatchers("/css/**").permitAll()
                .anyRequest().hasRole("USER")
                .and().formLogin().loginPage("/login").failureUrl("/login?auth=fail")
                .loginProcessingUrl("/loginProcess").passwordParameter("password").usernameParameter("username").defaultSuccessUrl("/")
                .permitAll().and().httpBasic().and().logout()
                .logoutSuccessUrl("/login").and().csrf().disable()
                .addFilter(customUsernamePasswordAuthenticationFilter());
    }
}
