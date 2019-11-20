package com.thp.spring.projetfinal.security;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.thp.spring.projetfinal.model.UtilisateurDetailsService;
import com.thp.spring.projetfinal.repository.UtilisateurRepository;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private UtilisateurDetailsService utilisateurDetailsService;
	private UtilisateurRepository utilisateurRepository;

	public SecurityConfig(UtilisateurDetailsService utilisateurDetailsService,
			UtilisateurRepository utilisateurRepository) {
		super();
		this.utilisateurDetailsService = utilisateurDetailsService;
		this.utilisateurRepository = utilisateurRepository;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// @formatter:off
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(utilisateurDetailsService).passwordEncoder(passwordEncoder());
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication().passwordEncoder(encoder).withUser("spring").password(encoder.encode("secret"))
				.roles("COLLABORATEUR");
	}

	// @formatter:off
	@Override
	protected void configure(HttpSecurity http) throws Exception {


		http.cors().and().csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

				.and()
				
				.addFilter(new JWTAuthentificationFilter(authenticationManager()))
				.addFilter(new JwtAuthorizationFilter(authenticationManager(), this.utilisateurRepository))
				.authorizeRequests()

				.antMatchers("/", "/index.html", "/app/**", "/assets/**", "/environments/**").permitAll()
				.antMatchers(HttpMethod.POST, "/mail").permitAll().antMatchers(HttpMethod.POST, "/user").permitAll()
				.antMatchers(HttpMethod.POST, "/mail").permitAll().antMatchers(HttpMethod.POST, "/utilisateur")
				.permitAll()

				.antMatchers(HttpMethod.POST, "/taskModele").permitAll()

				.antMatchers(HttpMethod.DELETE, "/utilisateur/**").permitAll()

				.antMatchers(HttpMethod.GET, "/utilisateurs").permitAll()
				.antMatchers(HttpMethod.PUT, "/mission").permitAll()
				.antMatchers(HttpMethod.GET, "/taches/{idUser}").permitAll()
				.antMatchers(HttpMethod.GET, "/parPseudo/{pseudo}").permitAll()
				.antMatchers(HttpMethod.GET, "/tachesCollaborateur/{idUser}").permitAll()
				.antMatchers(HttpMethod.PUT, "/taches/update").permitAll()
				.antMatchers(HttpMethod.GET,"/mailManager/{idManager}").permitAll()


				.anyRequest().authenticated().and().exceptionHandling()
				.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)).and()

				.formLogin().permitAll().and().logout().logoutUrl("/logout")
				
				.permitAll();


	}

	@Bean
	public FilterRegistrationBean simpleCorsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.setAllowedOrigins(Arrays.asList("http://localhost:4200", "http://localhost:4300"));
		config.setAllowedMethods(Collections.singletonList("*"));
		config.setAllowedHeaders(Collections.singletonList("*"));
		config.addExposedHeader(
				"Authorization, x-xsrf-token, Access-Control-Allow-Headers, Origin, Accept, X-Requested-With, "
						+ "Content-Type, Access-Control-Request-Method, Custom-Filter-Header");

		source.registerCorsConfiguration("/**", config);
		@SuppressWarnings("unchecked")
		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}

}