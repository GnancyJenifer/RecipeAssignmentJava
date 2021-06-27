package com.assignment.recipe.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "recipe")
public class Recipe implements Serializable{
	
	private static final long serialVersionUID = -769205141094396806L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long recipeId;

	private String recipeName;
	private boolean isVegetarian;
	
	@OneToMany(	orphanRemoval = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "recipe_id")
    private Set<Ingredients> ingredients;
	
	private int serveCount;
	
	@Type(type="text")
	private String cookingInstructions;
	
	@JsonFormat(pattern="dd-MM-yyyy HH:mm")
	private Date createdDate;

	public String getCookingInstructions() {
		return cookingInstructions;
	}

	public void setCookingInstructions(String cookingInstructions) {
		this.cookingInstructions = cookingInstructions;
	}

	public Recipe() {
		
	}	
	

	public Recipe(String recipeName, boolean isVegetarian, Set<Ingredients> ingredients, int serveCount,
			String cookingInstructions, Date createdDate) {
		super();
		this.recipeName = recipeName;
		this.isVegetarian = isVegetarian;
		this.ingredients = ingredients;
		this.serveCount = serveCount;
		this.cookingInstructions = cookingInstructions;
		this.createdDate = createdDate;
	}

	public Long getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(Long recipeId) {
		this.recipeId = recipeId;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public boolean isVegetarian() {
		return isVegetarian;
	}

	public void setVegetarian(boolean isVegetarian) {
		this.isVegetarian = isVegetarian;
	}

	public int getServeCount() {
		return serveCount;
	}

	public Set<Ingredients> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Set<Ingredients> ingredients) {
		this.ingredients = ingredients;
	}

	public void setServeCount(int serveCount) {
		this.serveCount = serveCount;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
