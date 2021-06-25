package com.assignment.recipe.service;

import java.util.List;

import com.assignment.recipe.model.Recipe;

public interface IRecipeService {

	List<Recipe> findAll();
	Recipe findByRecipeId(Long id);
	Recipe save(Recipe recipe);
	Recipe update(Recipe recipe);
	void delete(Long id);
}