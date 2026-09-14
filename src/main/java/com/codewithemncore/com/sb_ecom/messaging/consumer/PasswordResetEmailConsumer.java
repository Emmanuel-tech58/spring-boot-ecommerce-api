package com.codewithemncore.com.sb_ecom.messaging.consumer;

import com.codewithemncore.com.sb_ecom.config.MailFromProperties;
import com.codewithemncore.com.sb_ecom.messaging.payload.EmailPayload;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PasswordResetEmailConsumer {

    private final JavaMailSender mailSender;
    private final MailFromProperties maiProps;

    @RabbitListener(queues = {"${rabbitmq.email.queues.password-reset.name}"})
    public void handlePasswordResetEmail(EmailPayload payload) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom(maiProps.address(), maiProps.name());
            helper.setTo(payload.getTo());
            helper.setSubject(payload.getSubject());
            helper.setText(payload.getBody(), true); // true = treat body as HTML

            mailSender.send(message);
            log.info("Password reset email sent to {}", payload.getTo());

        } catch (MessagingException | java.io.UnsupportedEncodingException e) {
            log.error("Failed to send password reset email to {}: {}", payload.getTo(), e.getMessage());
            throw new RuntimeException(e); // wrap checked exception so retry interceptor catches it
        }
    }
}
