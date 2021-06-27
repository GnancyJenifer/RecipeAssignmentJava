package com.assignment.recipe.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.assignment.recipe.model.Ingredients;
import com.assignment.recipe.model.Recipe;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RecipeRepositoryTest {

	@Autowired
    private RecipeRepository recipeRepository;

    @Test
    public void testSaveRecipe() {

    	Set<Ingredients> ingredients=new HashSet<Ingredients>();
		Recipe recipe=new Recipe( "Strawberry Milkshake", false, ingredients,2,"test",new Date());		   
		ingredients.add(new Ingredients( "Ingredient1", recipe));
    	recipeRepository.save(recipe);
    	Recipe recipe2 = recipeRepository.findByRecipeName("Strawberry Milkshake");
        assertNotNull(recipe);
        assertEquals(recipe2.getRecipeName(), recipe.getRecipeName());
        assertEquals(recipe2.getServeCount(), recipe.getServeCount());
    }

    @Test
    public void testGetRecipe() {

    	Set<Ingredients> ingredients=new HashSet<Ingredients>();
		Recipe recipe=new Recipe( "Strawberry Milkshake", false, ingredients,2,"test",new Date());		   
		ingredients.add(new Ingredients( "Ingredient1", recipe));
		recipeRepository.save(recipe);
		Recipe recipe2 = recipeRepository.findByRecipeName("Strawberry Milkshake");
        assertNotNull(recipe);
        assertEquals(recipe2.getRecipeName(), recipe.getRecipeName());
        assertEquals(recipe2.getServeCount(), recipe2.getServeCount());
    }

    @Test
    public void testDeleteRecipe() {
    	Set<Ingredients> ingredients=new HashSet<Ingredients>();
		Recipe recipe=new Recipe( "Strawberry Milkshake", false, ingredients,2,"test",new Date());		   
		ingredients.add(new Ingredients( "Ingredient1", recipe));
		recipeRepository.save(recipe);
		recipeRepository.delete(recipe);
    }

    @Test
    public void findAllRecipies() {
    	Set<Ingredients> ingredients=new HashSet<Ingredients>();
		Recipe recipe=new Recipe( "Strawberry Milkshake", false, ingredients,2,"test",new Date());		   
		ingredients.add(new Ingredients( "Ingredient1", recipe));
		recipeRepository.save(recipe);
        assertNotNull(recipeRepository.findAll());
    }

    @Test
    public void deletByEmployeeIdTest() {
    	Set<Ingredients> ingredients=new HashSet<Ingredients>();
		Recipe recipe=new Recipe( "Strawberry Milkshake", false, ingredients,2,"test",new Date());		   
		ingredients.add(new Ingredients( "Ingredient1", recipe));
		Recipe recipe2 = recipeRepository.save(recipe);
		recipeRepository.deleteById(recipe2.getRecipeId());
    }
}
