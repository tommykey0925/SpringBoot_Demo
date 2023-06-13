package com.example.demo.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.repository.SiteUserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
  private final SiteUserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username)
    throws UsernameNotFoundException{
    //ユーザー名を検索する。
    var user = userRepository.findByUsername(username)
      .orElseThrow(() -> new UsernameNotFoundException(username + "not found"));

    //ユーザー情報を返す。
    return new User(user.getUsername(), user.getPassword(),
      AuthorityUtils.createAuthorityList(user.getAuthority().name()));
  }
}
