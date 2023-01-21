package pl.bookstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig {

    private static final String USER = "USER";
    private static final String ADMIN = "ADMIN";

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User
                .withUsername("user")
                .password(passwordEncoder().encode("user"))
                .roles(USER)
                .build();

        UserDetails admin = User
                .withUsername("admin")
                .password(passwordEncoder().encode("admin"))
                .roles(ADMIN)
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

         http.csrf()
                .disable();

         http.httpBasic();

         http.authorizeRequests()
                 .antMatchers(HttpMethod.GET,"/api/users/**").hasRole(ADMIN)
                 .antMatchers(HttpMethod.GET, "/api/addresses/**").hasRole(ADMIN)
                 .antMatchers(HttpMethod.POST, "/api/books/**").hasRole(ADMIN)
                 .antMatchers(HttpMethod.POST, "/api/authors/**").hasRole(ADMIN)
                 .antMatchers(HttpMethod.PATCH, "/api/books/**").hasRole(ADMIN)
                 .antMatchers(HttpMethod.DELETE, "/api/books/**").hasRole(ADMIN)
                 .antMatchers("/swagger-ui.html", "/webjars/**",
                         "swagger-resources/**", "/v2/api-docs/**", "/swagger-ui",
                         "/favicon.ico").permitAll()
                 .anyRequest().authenticated();

         return http.build();
    }

}
