package abdullah.todomanagement.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .withUser("admin").password("admin")
                .roles("USER", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().authorizeRequests()
                .antMatchers("/login", "/h2-console/**").permitAll()
				.antMatchers("/api/tutorials","/api/tutorials/**").permitAll()
                .antMatchers("/", "/*todo*/**","/*users*/**").access("hasRole('USER')").and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
                .permitAll()
                .and()
                .httpBasic();

        // TODO: FOR ANGULAR DISABLED CSRF
        http.csrf().disable();
        /*if(activeProfile.equalsIgnoreCase("dev")){
            http.csrf().disable();
        } else {
            *//**
             *  HERE !  Defaults XSRF-TOKEN as cookie name and X-XSRF-TOKEN as header name
             *//*
            http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());


            *//**
             * Prevention from Click jacking. More: https://en.wikipedia.org/wiki/Clickjacking
             *//*
            http.headers().frameOptions().disable();
        }*/
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("https://sample-angular-project.herokuapp.com","http://localhost:4200"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
