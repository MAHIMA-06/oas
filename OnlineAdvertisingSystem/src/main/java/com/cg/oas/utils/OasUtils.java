package com.cg.oas.utils;

import java.util.Set;

import com.cg.oas.dto.Category;
import com.cg.oas.dto.User;
import com.cg.oas.entity.CategoryEntity;
import com.cg.oas.entity.UserEntity;
	
public class OasUtils 
{

	
		public static CategoryEntity convertCategoryIntoCategoryEntity(Category category) 
		{
			return new CategoryEntity( category.getName(), category.getDesc());
		}
		public static Category convertCategoryEntityIntoCategory(CategoryEntity categoryEntity)
		{
			return new Category(categoryEntity.getId(), categoryEntity.getName(), categoryEntity.getDesc());
		}
}

	

