package cc.wordview.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

        @Autowired
        private JwtRequestFilter jwtRequestFilter;

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
                auth.userDetailsService(JwtShared.jwtUserDetailsService)
                                .passwordEncoder(passwordEncoder());
        }

        @Bean
        public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }

        /*~~(Migrate manually based on https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter)~~>*//*~~(Migrate manually based on https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter)~~>*/@Bean
        @Override
        public AuthenticationManager authenticationManagerBean() throws Exception {
                return super.authenticationManagerBean();
        }

        @Override
        protected void configure(HttpSecurity httpSecurity) throws Exception {
            httpSecurity.csrf(csrf -> csrf.disable())
                    // Não cheque essas requisições
                    .authorizeRequests(requests -> requests
                            .antMatchers("/authenticate", "/v2/api-docs",
                                    "/configuration/ui", "/swagger-resources/**",
                                    "/configuration/**", "/swagger-ui.html",
                                    "/webjars/**")
                            .permitAll().
                            // Qualquer outra requisição deve ser checada
                            anyRequest().authenticated()).exceptionHandling(handling -> handling
                    .authenticationEntryPoint(jwtAuthenticationEntryPoint))
                    .sessionManagement(management -> management
                            .sessionCreationPolicy(SessionCreationPolicy.STATELESS));
                httpSecurity.addFilterBefore(jwtRequestFilter,
                                UsernamePasswordAuthenticationFilter.class);
        }

}