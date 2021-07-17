package abdullah.todomanagement.model.audit;
/**
 * see more for Link: https://docs.jboss.org/envers/docs/#revisionlog
 */

import abdullah.todomanagement.audit.AuditRevisionListener;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

import javax.persistence.*;

@Entity
@Table(name = "revision_info")
@RevisionEntity(AuditRevisionListener.class)
@AttributeOverrides({
    @AttributeOverride(name = "timestamp", column = @Column(name = "rev_timestamp")),
    @AttributeOverride(name = "id", column = @Column(name = "revision_id"))
})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AuditRevisionEntity extends DefaultRevisionEntity {

    @Column(name = "user")
    private String user;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
