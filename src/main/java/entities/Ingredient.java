/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Christian
 */
@Entity
public class Ingredient implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ingredient_name", length = 25)
    private String name;
    
    private long amunt; 

    public Ingredient()
    {
    }

    public Ingredient(String name, long amunt)
    {
        this.name = name;
        this.amunt = amunt;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public long getAmunt()
    {
        return amunt;
    }

    public void setAmunt(long amunt)
    {
        this.amunt = amunt;
    }

    @Override
    public String toString()
    {
        return "Ingredient{" + "name=" + name + ", amunt=" + amunt + '}';
    }
    
}