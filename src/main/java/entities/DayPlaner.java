/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Christian
 */
@Entity
@NamedQuery(name = "dayplan.deleteAllRows", query = "DELETE from Role")
@Table(name = "dayplans")
public class DayPlaner implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dayplan_id", length = 20)
    private Long id;
    private int numberOfServings;
    
    @OneToOne
    private Recipe recipe;
    
    @ManyToOne
    private Menuplan MenuPlan;
    
    public DayPlaner()
    {
    }

    public DayPlaner(int nuberOfServings,Recipe recipe)
    {
        this.numberOfServings = nuberOfServings;
        this.recipe = recipe;
    }

    public int getNumberOfServings()
    {
        return numberOfServings;
    }

    public void setNumberOfServings(int numberOfServings)
    {
        this.numberOfServings = numberOfServings;
    }

    public Recipe getRecipe()
    {
        return recipe;
    }

    public void setRecipe(Recipe recipe)
    {
        this.recipe = recipe;
    }

   
    
    
    
    
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DayPlaner))
        {
            return false;
        }
        DayPlaner other = (DayPlaner) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "entities.DayPlaner[ id=" + id + " ]";
    }
    
}
