package hello.security.main.secConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain SecurityFilter(HttpSecurity http) {
		http.csrf(Customizer -> Customizer.disable());
		http.authorizeHttpRequests(auth -> auth.requestMatchers("/login", "/","/blog/**").permitAll().anyRequest().authenticated());
		http.formLogin(form -> form
			    .loginPage("/login")
			    .usernameParameter("email")   // 👈 yeh add karo
			    .passwordParameter("password")
			    .loginProcessingUrl("/login")
			    .defaultSuccessUrl("/admin/dashboard", true)
			    .failureUrl("/login?error=true")
			    .permitAll()
			);

		return http.build();
	}
	
	@Bean
	PasswordEncoder epasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration configurations)throws Exception {
		  return configurations.getAuthenticationManager();
	    }
}
