package com.assignment.recipe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.recipe.model.Recipe;
import com.assignment.recipe.repository.RecipeRepository;

@Service
public class RecipeService  implements IRecipeService {

    @Autowired
    private RecipeRepository repository;

    @Override
    public List<Recipe> findAll() {

        return (List<Recipe>) repository.findAll();
    }
    @Override
    public Recipe findByRecipeId(Long id) {
    	
    	return (Recipe) repository.findByRecipeId(id);
    	
    }
	@Override
	public Recipe save(Recipe recipe) {
		return repository.save(recipe);
	}
	@Override
	public Recipe update(Recipe recipe) {
		return repository.save(recipe);
	}
	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
