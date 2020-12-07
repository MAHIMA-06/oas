package com.cg.oas.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cg.oas.dao.CategoryDAO;
import com.cg.oas.dao.CategoryDAOImpl;
import com.cg.oas.dto.Category;
import com.cg.oas.entity.CategoryEntity;
import com.cg.oas.exceptions.NameIsBlankException;
import com.cg.oas.exceptions.DescriptionIsBlankException;
import com.cg.oas.service.CategoryServiceImpl;
import com.cg.oas.presentation.OasController;
import com.cg.oas.utils.OasUtils;

public class CategoryServiceImpl implements CategoryService
{   
	private static Logger logger = LogManager.getLogger(CategoryServiceImpl.class.getName());
	CategoryDAO categoryDao = new CategoryDAOImpl();
	
	public Category AddName(String categoryName) throws NameIsBlankException 
	{
		CategoryEntity categoryEntity = categoryDao.AddName(categoryName);
		logger.info("CategoryEntity: " + categoryEntity);
		return OasUtils.convertCategoryEntityIntoCategory(categoryEntity);
	}
	public Category AddDescription(String categoryDesc) throws DescriptionIsBlankException 
	{
		CategoryEntity categoryEntity = categoryDao.AddDescription(categoryDesc);
		logger.info("CategoryEntity: " + categoryEntity);
		return OasUtils.convertCategoryEntityIntoCategory(categoryEntity);
	}



	
	
	
}
