package abdullah.todomanagement.model;

import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tutorial")
@Audited(withModifiedFlag = true)
public class Tutorial extends AbstractPersistable<Long> {
	String title;
	String description;
	Boolean published;

	public Tutorial() {
	}

	public Tutorial(String title, String description, Boolean published) {
		this.title = title;
		this.description = description;
		this.published = published;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getPublished() {
		return published;
	}

	public void setPublished(Boolean published) {
		this.published = published;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Tutorial)) return false;
		if (!super.equals(o)) return false;

		Tutorial tutorial = (Tutorial) o;

		if (getTitle() != null ? !getTitle().equals(tutorial.getTitle()) : tutorial.getTitle() != null) return false;
		if (getDescription() != null ? !getDescription().equals(tutorial.getDescription()) : tutorial.getDescription() != null)
			return false;
		return getPublished() != null ? getPublished().equals(tutorial.getPublished()) : tutorial.getPublished() == null;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
		result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
		result = 31 * result + (getPublished() != null ? getPublished().hashCode() : 0);
		return result;
	}
}