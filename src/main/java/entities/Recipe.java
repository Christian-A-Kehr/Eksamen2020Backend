/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Christian
 */
@Entity
public class Recipe implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int preperation_time;
    private List<String> dierections; 
    private String category;
//    @OneToMany
    private List<Ingredient> ingredients;
//    
//    @OneToOne
//    private DayPlaner dayPlaner;  
//    
    public Recipe()
    {
    }
    
    public Recipe(Long id, String name, int preperation_time, List<String> dierections, String category, List<Ingredient> ingredients)
    {
        this.id = id;
        this.name = name;
        this.preperation_time = preperation_time;
        this.dierections = dierections;
        this.category = category;
        this.ingredients = ingredients;
    }

         
    public Long getId()
    {
        return id;
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

  

    

}
