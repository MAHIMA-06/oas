package com.cg.oas.service;

import com.cg.oas.dto.Category;
import com.cg.oas.exceptions.NameIsBlankException;
import com.cg.oas.exceptions.DescriptionIsBlankException;



	public interface CategoryService 
	{
		Category AddName(String categoryName) throws NameIsBlankException;
		Category AddDescription(String categoryDesc) throws  DescriptionIsBlankException; 
	}
	