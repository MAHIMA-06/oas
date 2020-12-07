package com.cg.oas.dao;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cg.oas.entity.CategoryEntity;
import com.cg.oas.exceptions.NameIsBlankException;
import com.cg.oas.exceptions.DescriptionIsBlankException;
import com.cg.oas.service.CategoryServiceImpl;






public class CategoryDAOImpl implements CategoryDAO
{
	private static Logger logger = LogManager.getLogger(CategoryDAOImpl.class.getName());	
	private static EntityManager entityManager;

	static
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("OnlineAdvertisePU");
		entityManager = entityManagerFactory.createEntityManager();
		 entityManager.getTransaction().begin();
		CategoryEntity cat1= new CategoryEntity("Electronics","All the electrical item"); //Java, Hibernate
		CategoryEntity cat2 = new CategoryEntity("Furniture","All the Wooden items"); //Java, Spring
		CategoryEntity cat3 = new CategoryEntity("RealEstate","All the plots and buildings"); //Hibernate, Spring
		
		
		Set<CategoryEntity> category = new HashSet<CategoryEntity>();
	category.add(cat1);
	category.add(cat2);
	category.add(cat3);
	
	entityManager.persist(cat1);
	entityManager.persist(cat2);
	entityManager.persist(cat3);
	entityManager.getTransaction().commit();
	entityManagerFactory.close();
		
		
		
	}
	public CategoryEntity AddName(String categoryName) throws NameIsBlankException 
	{
		CategoryEntity categoryEntity = entityManager.find(CategoryEntity.class, categoryName);

		logger.info("Database returned CategoryEntity: " + categoryEntity);
		if(categoryEntity==null)
			throw new NameIsBlankException ("CategoryName " + categoryName);
		return categoryEntity;
	}
	public CategoryEntity AddDescription(String categoryDesc) throws DescriptionIsBlankException 
	{
		CategoryEntity categoryEntity = entityManager.find(CategoryEntity.class, categoryDesc);

		logger.info("Database returned CategoryEntity: " + categoryEntity);
		if(categoryEntity==null)
			throw new DescriptionIsBlankException ("CategoryDescription" + categoryDesc);
		return categoryEntity;
	}


}
/*
 
 public static void insertCourses() {
		

		CategoryEntity student_tom = new CategoryEntity("Tom"); //Java, Hibernate
		CategoryEntity student_jerry = new CategoryEntity("Jerry"); //Java, Spring
		CategoryEntity student_ivan = new CategoryEntity("Ivan"); //Hibernate, Spring
		
		Set<CategoryEntity> java_students = new HashSet<CategoryEntity>();
		java_students.add(student_tom);java_students.add(student_jerry);
		Set<CategoryEntity> hibernate_students = new HashSet<CategoryEntity>();
		hibernate_students.add(student_tom);hibernate_students.add(student_ivan);
		Set<CategoryEntity> spring_students = new HashSet<CategoryEntity>();
		spring_students.add(student_jerry);
		spring_students.add(student_ivan);
		
		Course course_java = new Course("Java programming", java_students);		
		Course course_hibernate = new Course("Hibernate", hibernate_students);
		Course course_spring = new Course("Spring", spring_students);

		entityManager.getTransaction().begin();
		entityManager.persist(course_java);
		entityManager.persist(course_hibernate);
		entityManager.persist(course_spring);
		entityManager.getTransaction().commit();
	}
 
 */

