package abdullah.todomanagement.model;

import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "todos")
//@EntityListeners(AuditingEntityListener.class)
@Audited(withModifiedFlag = true)
public class Todo extends AbstractPersistable<Long> {

	private String userName;

	@Size(min = 10, message = "Enter at least 10 Characters...")
	private String description;

	private Date targetDate;
	
	public Todo() {
		super();
	}

	public Todo(String user, String desc, Date targetDate, boolean isDone) {
		super();
		this.userName = user;
		this.description = desc;
		this.targetDate = targetDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
}