/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Ingredient;
import java.util.List;

/**
 *
 * @author Christian
 */
public class RecipeDTO
{
    private long id; 
    private String name;
    private int preperation_time;
    private List<String> dierections; 
    private String category;
    private List<Ingredient> ingredients;

    public RecipeDTO(long id, String name, int preperation_time, List<String> dierections, String category, List<Ingredient> ingredients)
    {
        this.id = id;
        this.name = name;
        this.preperation_time = preperation_time;
        this.dierections = dierections;
        this.category = category;
        this.ingredients = ingredients;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getPreperation_time()
    {
        return preperation_time;
    }

    public void setPreperation_time(int preperation_time)
    {
        this.preperation_time = preperation_time;
    }

    public List<String> getDierections()
    {
        return dierections;
    }

    public void setDierections(List<String> dierections)
    {
        this.dierections = dierections;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public List<Ingredient> getIngredients()
    {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients)
    {
        this.ingredients = ingredients;
    }

    @Override
    public String toString()
    {
        return "RecipeDTO{" + "id=" + id + ", name=" + name + ", preperation_time=" + preperation_time + ", dierections=" + dierections + ", category=" + category + ", ingredients=" + ingredients + '}';
    }

}
