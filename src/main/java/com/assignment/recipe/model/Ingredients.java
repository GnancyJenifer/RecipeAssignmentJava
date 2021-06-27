package com.assignment.recipe.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "ingredients")
public class Ingredients implements Serializable{	
	private static final long serialVersionUID = 3955168854841799812L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
    private Long id;
	
	private String ingredientName;
	
	@ManyToOne	
    @JoinColumn(name = "recipe_id")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Recipe recipe;
	
	public Ingredients() {
    }

	
	public Ingredients(String ingredientName, Recipe recipe) {
		super();
		this.ingredientName = ingredientName;
		this.recipe = recipe;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
}
