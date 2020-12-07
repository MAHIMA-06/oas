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


	@Entity                                                                          // Declare the class as entity or table
	@Table(name="category")                                                          // Declare table name       
	public class CategoryEntity
	{
		
		@Id
		@GeneratedValue
		@Column(name="category_id")
		private int id;

		@Column(name="category_name")
		private String name;
		
		@Column(name="category_desc")
		private String desc;
		
		/*
		 * Creating many to many relation with user
		*/
		

		@ManyToMany(cascade = CascadeType.ALL)
		@JoinTable(name = "category_user", 
					joinColumns = { @JoinColumn(name = "category_id") }, 
					inverseJoinColumns = { @JoinColumn(name = "user_id") })
		
		private Set<UserEntity> users = new HashSet<UserEntity>();                  // Initialization required to avoid NullPointerException

		public CategoryEntity(int id, String name, String desc, Set<UserEntity> users) 
		{
			super();
			this.id = id;
			this.name = name;
			this.desc = desc;
			this.users = users;
		}
		public CategoryEntity( String name, String desc) 
		{
			super();
			this.name = name;
			this.desc = desc;
		}

		public CategoryEntity(String name, String desc, Set<UserEntity> users) 
		{
			super();
			this.name = name;
			this.desc = desc;
			this.users = users;
		}

		public CategoryEntity() 
		{
			super();
		}
		
		/*
		 * creating getters and setters
		 */	

		public int getId() 
		{
			return id;
		}

		public void setId(int id)
		{
			this.id = id;
		}

		public String getName() 
		{
			return name;
		}

		public void setName(String name) 
		{
			this.name = name;
		}

		public String getDesc() 
		{
			return desc;
		}

		public void setDesc(String desc)
		{
			this.desc = desc;
		}

		public Set<UserEntity> getUsers()
		{
			return users;
		}

		public void setUsers(Set<UserEntity> users)
		{
			this.users = users;
		}
		
		/*
		 * creating to string method
		 */

		@Override
		public String toString() 
		{
			return "CategoryEntity [id=" + id + ", name=" + name + ", desc=" + desc + ", users=" + users + "]";
		}
		

		
	}
