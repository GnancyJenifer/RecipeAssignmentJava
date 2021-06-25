package com.assignment.recipe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.recipe.model.Recipe;
import com.assignment.recipe.service.IRecipeService;

@RestController()
public class RecipeController {
	@Autowired
    private IRecipeService recipeService;
    
    @GetMapping("/recipies")
    public List<Recipe> getAllRecipies() {
	      return recipeService.findAll();
	}
    
    @GetMapping("/recipie/{id}")
    public Recipe getRecipeById(@PathVariable Long id) {
	      return recipeService.findByRecipeId(id);
	}
    
    @PostMapping("/recipie/add")
    public Recipe addRecipie(@RequestBody Recipe recipe) {
	      return recipeService.save(recipe);
	}
    
    @PutMapping("/recipie/update/{id}")
    public Recipe updateRecipie(@RequestBody Recipe recipe,@PathVariable Long id) {
    	  System.out.println(id);
    	  recipe.setRecipeId(id);
	      return recipeService.save(recipe);
	}
    
    @DeleteMapping("/recipie/{id}")
    public List<Recipe> deleteRecipie(@PathVariable Long id) {
	      recipeService.delete(id);
	      return getAllRecipies();
	}
}
