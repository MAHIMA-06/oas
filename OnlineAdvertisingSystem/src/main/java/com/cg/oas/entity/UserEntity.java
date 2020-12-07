package com.cg.oas.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity               // Declare the class as entity or table

@Table(name="user")    // Declare table name  

public class UserEntity
{

	@Id
	@GeneratedValue
	@Column(name="user_id")
	private int id;

	@Column(name="user_name")
	private String name;
	
	@Column(name="address")
	private String address;
	
	@Column(name="contact_no")
	private int contactno;
	
	@Column(name="email")
	private String email;
	
	/*
	 * Creating many to many relation with user
	*/
	

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "category_user", 
				joinColumns = { @JoinColumn(name = "user_id") }, 
				inverseJoinColumns = { @JoinColumn(name = "category_id") })
	
	
	private Set<CategoryEntity> users = new HashSet<CategoryEntity>();                  // Initialization required to avoid NullPointerException

	public UserEntity(int id, String name, String address, int contactno, String email, Set<CategoryEntity> users) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.contactno = contactno;
		this.email = email;
		this.users = users;
	}

	public UserEntity(String name, String address, int contactno, String email, Set<CategoryEntity> users) {
		super();
		this.name = name;
		this.address = address;
		this.contactno = contactno;
		this.email = email;
		this.users = users;
	}

	public UserEntity() {
		super();
	}
	
	/*
	 * creating getters and setters
	 */	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getContactno() {
		return contactno;
	}

	public void setContactno(int contactno) {
		this.contactno = contactno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<CategoryEntity> getUsers() {
		return users;
	}

	public void setUsers(Set<CategoryEntity> users) {
		this.users = users;
	}
	/*
	 * creating toString method
	 */	 

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", name=" + name + ", address=" + address + ", contactno=" + contactno
				+ ", email=" + email + ", users=" + users + "]";
	}

}
