package pl.sda.demo.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;


@EnableWebSecurity
public class Configuration extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/advisor/**").access("hasRole('ROLE_ADVISOR')")
                .antMatchers("/client/**").access("hasRole('ROLE_ADVISOR') or hasRole('ROLE_CLIENT')")
                .antMatchers("/credit/**").access("hasRole('ROLE_ADVISOR') or hasRole('ROLE_CLIENT')")
                .antMatchers("/client_Income/**").access("hasRole('ROLE_ADVISOR') or hasRole('ROLE_CLIENT')")
                .antMatchers("/client_liabilities/**").access("hasRole('ROLE_ADVISOR') or hasRole('ROLE_CLIENT')")
//                .antMatchers("/index").access("hasRole('ROLE_ADVISOR') or hasRole('ROLE_CLIENT')")
                .antMatchers("/login*").permitAll()
                .antMatchers("/regist*").permitAll()
                .antMatchers("/users").permitAll()
                .anyRequest().authenticated();

        http.formLogin()
////                .loginPage("/login")// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!111
////                .loginProcessingUrl("/appLogin")
//                .failureForwardUrl("/failure") /// ???
//                .usernameParameter("login")
//                .passwordParameter("pass")
                .defaultSuccessUrl("/index", true);///???

        http.csrf().disable()
                .headers().frameOptions().disable();

        http.logout()
                .logoutSuccessUrl("/login")
                .logoutUrl("/logout");

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

//  .usersByUsernameQuery("SELECT u.login, u.password,1 FROM user AS u WHERE u.login=?")
//                .authoritiesByUsernameQuery("SELECT u.login, r.typ_roli, 1 " +
//                        "FROM user u " +
//                        "INNER JOIN user_role ur ON ur.user_id = u.user_id " +
//                        "INNER JOIN role r ON r.role_id = ur.role_id " +
//                        "WHERE u.login=?")
