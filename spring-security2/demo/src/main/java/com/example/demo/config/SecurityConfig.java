package com.example.demo.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.util.Authority;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig {
  
  @Bean
  public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
      http.authorizeHttpRequests(auth -> auth
                      //cssやjs、 imagesなどの静的リソースをアクセス可能にする
                      .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                      .requestMatchers("/register", "/login").permitAll()
                      .requestMatchers("/admin/**").hasAuthority(Authority.ADMIN.name())
                      .anyRequest().authenticated()
      )
              .formLogin(login -> login
                              //ログイン時のURLを指定
                              .loginPage("/login")
                              //認証後のリダイレクト先を指定
                              .defaultSuccessUrl("/")
                              .permitAll()
              )
              //ログアウトの設定
              .logout(logout -> logout
                              //ログアウト時のURLを指定
                              .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                              .permitAll()
              )
              //RememberMeの認証を許可する
              .rememberMe(me -> me.key("Unique and Secret"));
    return http.build();
  }

}
