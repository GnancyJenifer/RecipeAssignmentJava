package com.assignment.recipe.controller;

import static java.util.Collections.singletonList;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.assignment.recipe.model.Ingredients;
import com.assignment.recipe.model.Recipe;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(RecipeController.class)
@SpringBootTest
public class RecipeControllerTest {
	@Autowired
	   private MockMvc mvc;

	   @MockBean
	   private RecipeController recipeController;
	   
	   @Test
	   public void getAllRecipies() throws Exception {
	       Recipe recipe = new Recipe();
	       List<Recipe> allRecipes = singletonList(recipe);

	       given(recipeController.getAllRecipies()).willReturn(allRecipes);

	       mvc.perform(get( "/recipies")
	               .contentType(APPLICATION_JSON))
	       		   .andDo(print())
	               .andExpect(status().isOk())
	               .andExpect(jsonPath("$", hasSize(1)))
	               .andExpect(jsonPath("$[0].recipeId").value(recipe.getRecipeId()));
	   }
	   
	   @Test
	   public void getRecipieById() throws Exception {
		   Recipe recipe = new Recipe();
		   recipe.setRecipeName("Strawberry Milkshake");

	       given(recipeController.getRecipeById(recipe.getRecipeId())).willReturn(recipe);

	       mvc.perform(get("/recipie/" + recipe.getRecipeId())
	               .contentType(APPLICATION_JSON))
	               .andExpect(status().isOk())
	               .andExpect(jsonPath("recipeName").value(recipe.getRecipeName()));
	   }
	   
	   @Test
	   public void addRecipie() throws Exception 
	   { 	Set<Ingredients> ingredients=new HashSet<Ingredients>();
		   Recipe recipe=new Recipe(null, "Strawberry Milkshake", false, ingredients,2,"test",new Date());		   
		   ingredients.add(new Ingredients(null, "Ingredient1", recipe));
	     mvc.perform( post("/recipie/add")
	         .content(asJsonString(recipe))
	         .contentType(MediaType.APPLICATION_JSON)
	         .accept(MediaType.APPLICATION_JSON))
	         .andExpect(status().isCreated())
	         .andExpect(MockMvcResultMatchers.jsonPath("$.recipeId").exists());
	   }
	   
	   @Test
	   public void updateRecipie() throws Exception 
	   { 	Set<Ingredients> ingredients=new HashSet<Ingredients>();
		   Recipe recipe=new Recipe(3l, "Strawberry Milkshake", false, ingredients,2,"test",new Date());		   
		   ingredients.add(new Ingredients(null, "Ingredient1", recipe));
	     mvc.perform( put("/recipie/update/{id}",3)
	         .content(asJsonString(recipe))
	         .contentType(MediaType.APPLICATION_JSON)
	         .accept(MediaType.APPLICATION_JSON))
	         .andExpect(status().isOk())
	         .andExpect(MockMvcResultMatchers.jsonPath("$.recipeName").value("Strawberry Milkshake"))
	         .andExpect(MockMvcResultMatchers.jsonPath("$.isVegetarian").value(false))
	         .andExpect(MockMvcResultMatchers.jsonPath("$.serveCount").value(2));
	   }
	   
	   @Test
	   public void deleteRecipie() throws Exception 
	   {
	     mvc.perform( delete("/recipie/{id}", 1) )
	           .andExpect(status().isAccepted());
	   }
	    
	   public static String asJsonString(final Object obj) {
	       try {
	           return new ObjectMapper().writeValueAsString(obj);
	       } catch (Exception e) {
	           throw new RuntimeException(e);
	       }
	   }
}
