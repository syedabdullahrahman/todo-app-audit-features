package abdullah.todomanagement.model;

import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "users")
@Audited(withModifiedFlag = true)
public class User extends AbstractPersistable<Long> {

	// form:input - textbox
	String name;

	// form:input - textbox
	String email;

	// form:textarea - textarea
	String address;

	// form:input - password
	String password;

	// form:input - password
	String confirmPassword;

	// form:checkbox - single checkbox
	boolean newsletter;

	@ElementCollection
	// form:checkboxes - multiple checkboxes
	List<String> framework;

	// form:radiobutton - radio button
	String sex;

	// form:radiobuttons - radio button
	Integer number;

	// form:select - form:option - dropdown - single select
	String country;

	@ElementCollection
	// form:select - multiple=true - dropdown - multiple select
	List<String> skill;

	public boolean isNew() {
		return (this.getId() == null);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public boolean isNewsletter() {
		return newsletter;
	}

	public void setNewsletter(boolean newsletter) {
		this.newsletter = newsletter;
	}

	public List<String> getFramework() {
		return framework;
	}

	public void setFramework(List<String> framework) {
		this.framework = framework;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<String> getSkill() {
		return skill;
	}

	public void setSkill(List<String> skill) {
		this.skill = skill;
	}

	@Override
	public String toString() {
		return "User [id=" + getId() + ", name=" + name + ", email=" + email + ", address=" + address
				+ ", password=" + password + ", confirmPassword=" + confirmPassword
				+ ", newsletter=" + newsletter + ", framework=" + framework + ", sex=" + sex
				+ ", number=" + number + ", country=" + country + ", skill=" + skill + "]" + isNew();
	}

}
