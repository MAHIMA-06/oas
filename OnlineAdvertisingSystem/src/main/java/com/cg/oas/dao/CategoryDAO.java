package com.cg.oas.dao;

import com.cg.oas.entity.CategoryEntity;
import com.cg.oas.exceptions.NameIsBlankException;
import com.cg.oas.exceptions.DescriptionIsBlankException;

public interface CategoryDAO
{
	public CategoryEntity AddName(String categoryName) throws NameIsBlankException;
	public CategoryEntity AddDescription(String categoryDesc) throws DescriptionIsBlankException;
}
