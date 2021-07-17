package abdullah.todomanagement.config;

import abdullah.todomanagement.audit.AuditAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "customAuditProvider")
@EnableTransactionManagement
public class JpaConfig {

    @Bean
    public AuditorAware<String> customAuditProvider() {
        return new AuditAwareImpl();
    }
}
