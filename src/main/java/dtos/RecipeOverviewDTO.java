/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.util.List;

/**
 *
 * @author Christian
 */
public class RecipeOverviewDTO
{
    private List<simpleRecipeDTO> listOfSimpleRecipeDTO;

    public RecipeOverviewDTO(List<simpleRecipeDTO> listOfSimpleRecipeDTO)
    {
        this.listOfSimpleRecipeDTO = listOfSimpleRecipeDTO;
    }
    
}