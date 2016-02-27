package cs320stu47.Homework2;

import java.util.Date;

public class Homework2User {
	
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private Date created;
	private static int numberOfUsers;
	
	public Homework2User() {
		this.created = new Date();
		numberOfUsers++;
		this.id = 100 + (numberOfUsers);
	}
	
	public Homework2User(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.created = new Date();
		numberOfUsers++;
		this.id = 100 + numberOfUsers;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDate() {
		return created;
	}

	public void setDate(Date created) {
		this.created = created;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public static int getNumberOfUsers() {
		return Homework2User.numberOfUsers;
	}
	

}
