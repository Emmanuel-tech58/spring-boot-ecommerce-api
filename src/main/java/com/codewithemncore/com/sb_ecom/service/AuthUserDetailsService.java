package com.codewithemncore.com.sb_ecom.service;
import com.codewithemncore.com.sb_ecom.model.auth.UserPrincipal;
import com.codewithemncore.com.sb_ecom.repositories.plain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service @RequiredArgsConstructor
public class AuthUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override public UserDetails loadUserByUsername(String email) { return userRepository.findByEmail(email).map(UserPrincipal::new).orElseThrow(() -> new UsernameNotFoundException("User not found")); }
}
