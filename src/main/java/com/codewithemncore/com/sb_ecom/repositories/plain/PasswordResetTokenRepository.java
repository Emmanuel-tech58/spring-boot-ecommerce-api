package com.codewithemncore.com.sb_ecom.repositories.plain;

import com.codewithemncore.com.sb_ecom.model.auth.PasswordResetToken;
import com.codewithemncore.com.sb_ecom.model.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, UUID> {

    Optional<PasswordResetToken> findByTokenHash(String tokenHash);

    /** Invalidates all unused, unexpired tokens for a user before issuing a new one. */
    @Modifying
    @Query("UPDATE PasswordResetToken t SET t.usedAt = CURRENT_TIMESTAMP WHERE t.user = :user AND t.usedAt IS NULL")
    void invalidateAllForUser(User user);
}
