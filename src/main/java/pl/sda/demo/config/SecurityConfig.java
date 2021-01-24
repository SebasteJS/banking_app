package pl.sda.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.sda.demo.repository.UserRepository;
import pl.sda.demo.service.UserService;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    UserService userService;

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/advisor_panel").access("hasRole('ROLE_ADVISOR')")// tu pomyslec
                .antMatchers("/broker").access("hasRole('ROLE_ADVISOR')")
                .antMatchers("/client").access("hasRole('ROLE_ADVISOR') or hasRole('ROLE_CLIENT')")
                .antMatchers("/credit").access("hasRole('ROLE_ADVISOR') or hasRole('ROLE_CLIENT')")
                .antMatchers("/customer").access("hasRole('ROLE_ADVISOR') or hasRole('ROLE_CLIENT')")
                .antMatchers("/clientIncome").access("hasRole('ROLE_ADVISOR') or hasRole('ROLE_CLIENT')")
                .antMatchers("/clientLiabilities/").access("hasRole('ROLE_ADVISOR') or hasRole('ROLE_CLIENT')")
                .antMatchers("/clientLiabilities/**").access("hasRole('ROLE_ADVISOR') or hasRole('ROLE_CLIENT')")
                .antMatchers("/login*").permitAll()
                .antMatchers("/regist*").permitAll()
                .antMatchers("/users").permitAll()
                .antMatchers("/customers_admin").access("hasRole('ROLE_ADMIN')")
                .anyRequest().authenticated();
        http.formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .usernameParameter("login")
                .passwordParameter("password")
                .defaultSuccessUrl("/advisor-panel", true);  //  + userRepository.findById(userService.getCurrentID()
        http.csrf().disable()
                .headers().frameOptions().disable();
        http.logout()
                .logoutSuccessUrl("/login")
                .logoutUrl("/logout");
    }

    @Override
    public void configure(WebSecurity web) {
        web
                .ignoring()
                .antMatchers("/resources/**", "/css/**", "/js/**", "/img/**", "/icon/**");
    }

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .usersByUsernameQuery("SELECT u.login, u.password,1 FROM user AS u WHERE u.login=?")
                .authoritiesByUsernameQuery("SELECT u.login, r.typ_roli, 1 " +
                        "FROM user u " +
                        "INNER JOIN user_role ur ON ur.user_id = u.user_id " +
                        "INNER JOIN role r ON r.role_id = ur.role_id " +
                        "WHERE u.login=?")
                .dataSource(dataSource);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}