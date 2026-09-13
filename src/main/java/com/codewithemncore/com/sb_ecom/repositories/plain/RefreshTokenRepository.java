package com.codewithemncore.com.sb_ecom.repositories.plain;
import com.codewithemncore.com.sb_ecom.model.auth.RefreshToken;
import com.codewithemncore.com.sb_ecom.model.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, UUID> { Optional<RefreshToken> findByTokenHash(String tokenHash); List<RefreshToken> findAllByUserAndRevokedAtIsNull(User user); }
