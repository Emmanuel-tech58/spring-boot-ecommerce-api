package com.codewithemncore.com.sb_ecom.controller;
import com.codewithemncore.com.sb_ecom.dto.auth.*;
import com.codewithemncore.com.sb_ecom.model.auth.UserPrincipal;
import com.codewithemncore.com.sb_ecom.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/api/auth") @RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/register") public ResponseEntity<UserResponse> register(@Valid @RequestBody RegisterRequest request) { return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(request)); }
    @PostMapping("/login") public TokenResponse login(@Valid @RequestBody LoginRequest request) { return authService.login(request); }
    @PostMapping("/refresh") public TokenResponse refresh(@Valid @RequestBody RefreshTokenRequest request) { return authService.refresh(request); }
    @PostMapping("/logout") public ResponseEntity<Void> logout(@Valid @RequestBody RefreshTokenRequest request) { authService.logout(request); return ResponseEntity.noContent().build(); }
    @GetMapping("/me") public UserResponse me(@AuthenticationPrincipal UserPrincipal principal) { return authService.current(principal); }
}
