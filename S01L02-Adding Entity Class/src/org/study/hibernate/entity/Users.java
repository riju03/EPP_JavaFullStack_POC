package org.study.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * How hibernate know that this class is based on database name users for this we will mark this class as entity class
 * and will also provide name of the table, based on entity information hibernate will develop the object to relational model.
 */

@Entity
@Table(name = "users")
public class Users {

	/*
	 * As the naming convention in java and table differ for that we will mark these
	 * properties as column and also provide column name
	 * 
	 * @Id means primary key
	 */

	@Id
	@Column(name = "user_id")
	int userId;

	@Column(name = "username")
	String username;
	@Column(name = "password")
	String password;
	@Column(name = "first_name")
	String firstName;
	@Column(name = "last_name")
	String lastName;

	public Users(String username, String password, String firstName, String lastName) {
		
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
