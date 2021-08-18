package com.springsecurityfull.security;

import java.util.concurrent.TimeUnit;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.springsecurityfull.auth.ApplicationUserService;
import com.springsecurityfull.jwt.JwtConfig;
import com.springsecurityfull.jwt.JwtTokenVerifier;
import com.springsecurityfull.jwt.JwtUsernameAndPasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter{

	private final PasswordEncoder passwordEncoder;
	private final ApplicationUserService applicationUserService;
	private final SecretKey secretKey;
	private final JwtConfig jwtConfig;
	
	@Autowired
	public ApplicationSecurityConfig(PasswordEncoder passwordEncoder,ApplicationUserService applicationUserService,SecretKey secretKey,JwtConfig jwtConfig) {
		this.passwordEncoder = passwordEncoder;
		this.applicationUserService=applicationUserService;
		this.jwtConfig=jwtConfig;
		this.secretKey=secretKey;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http 
				.csrf().disable()
				.sessionManagement()
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(),jwtConfig,secretKey))
				.addFilterAfter(new JwtTokenVerifier(secretKey,jwtConfig),JwtUsernameAndPasswordAuthenticationFilter.class)
				// TODO: I WİLL TEACH THİS İN DETAİL İN THE NEXT SECTİON	
		 	 	.authorizeRequests()
		 	 	.antMatchers("/","index","/css/**","/js/*","/login/**").permitAll()
		 	 	.antMatchers("/api/**").hasRole(ApplicationUserRole.STUDENT.name())
		 	 /*	.antMatchers(HttpMethod.DELETE,"management/api/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())
		 	 	.antMatchers(HttpMethod.POST,"management/api/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())
		 	 	.antMatchers(HttpMethod.PUT,"management/api/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())
		 	 	.antMatchers("management/api/**").hasAnyRole(ApplicationUserRole.ADMIN.name(),ApplicationUserRole.ADMINTRAINEE.name())*/
		 	 	.anyRequest()
		 	 	.authenticated();
		 	 	
		 	 	
		 	 	/*.formLogin()
			 	 	.loginPage("/login")
			 	 	.permitAll()
			 	 	.defaultSuccessUrl("/courses",true)
			 	 	.passwordParameter("password")
			 	 	.usernameParameter("username")
		 	 	.and()
		 	 	.rememberMe().tokenValiditySeconds((int)TimeUnit.DAYS.toSeconds(21)) //defaults to 2 weeks
		 	 	.key("somethingverysecured")
		 	 	.rememberMeParameter("remember-me")
		 	 	.and()
		 	 	.logout()
		 	 	.logoutRequestMatcher(new AntPathRequestMatcher("/logout","GET"))
		 	 	.logoutUrl("/logout")
		 	 	.clearAuthentication(true)
		 	 	.invalidateHttpSession(true)
		 	 	.deleteCookies("JSESSIONID","remember-me")
		 	 	.logoutSuccessUrl("/login");
		*/
	}
	
	
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthenticationProvider());
	}

	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder);
		provider.setUserDetailsService(applicationUserService);
		return provider;
	}

}
