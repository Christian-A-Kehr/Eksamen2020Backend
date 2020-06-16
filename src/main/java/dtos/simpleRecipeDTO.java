/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

/**
 *
 * @author Christian
 */
public class simpleRecipeDTO
{

    private String category, name;
    private long preparation_time;

    public simpleRecipeDTO(String category, String name, long preparation_time)
    {
        this.category = category;
        this.name = name;
        this.preparation_time = preparation_time;
    }
}
