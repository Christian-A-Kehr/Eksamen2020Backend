/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dtos.RecipeDTO;
import dtos.RecipeOverviewDTO;
import dtos.UserDTO;
import dtos.simpleRecipeDTO;
import errorhandling.AlreadyExistsException;
import facades.UserFacade;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import org.eclipse.persistence.exceptions.DatabaseException;
import utils.EMF_Creator;
import utils.RequestSender;
/**
 *
 * @author Christian
 */
@Path("recipe")
public class RecipeResource
{
    //attributs 
    private String AllRecipesURL = "https://cphdat.dk/recipes";
    private String RecipesID = "https://cphdat.dk/recipe/";
    
      private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
                "pu",
                "jdbc:mysql://localhost:3307/Eksamen2020_test",
                "dev",
                "ax2",
                EMF_Creator.Strategy.CREATE);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final UserFacade FACADE = UserFacade.getUserFacade(EMF);
    private static final RequestSender requestSender = RequestSender.getRequestSender();

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String dummyMessage() {
        return "{\"msg\":\"Dummy message\"}";
    }
    
//    @Path("/count")
//    @GET
//    @Produces({MediaType.APPLICATION_JSON})
//    public String getRecipeMeCount() {
//        long count = FACADE.getRecipeCount();
//        return "{\"count\":"+count+"}";  //Done manually so no need for a DTO
//    }

    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllRecipes() {
        
        // alternativ Solution loop getRecipeById => add to list of recipes, then return list for frontEnd
       
        Gson gson = new Gson();
        try
        {
            HashMap headers = new HashMap();
            headers.put("Accept", "application/json");
            String recipeData = requestSender.sendRequest(AllRecipesURL, "GET", headers, 5000);

            if (recipeData == null)
            {
                return "{\"msg\": \"No data from " + AllRecipesURL + "\"}";
            }

            List<RecipeOverviewDTO> recipeList = gson.fromJson(recipeData, new TypeToken<simpleRecipeDTO>()
            {
            }.getType());

//            FACADE.persistAllExternalCountries(recipeList);
            return GSON.toJson(recipeList);
        }
        catch (IllegalArgumentException | DatabaseException ex)
        {
            System.out.println(Arrays.toString(ex.getStackTrace()));
            return "{\"msg\": \"" + ex.getMessage() + "\"}";
        }
        catch (IOException ex)
        {
            System.out.println(Arrays.toString(ex.getStackTrace()));
            return "{\"msg\": \"The provided URL is invalid.\"}\n\n" + ex.getMessage() + "";
        }
        
    }
    
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getRecipeById(@PathParam("id") String id) {
        
        Gson gson = new Gson();
        try
        {
            HashMap headers = new HashMap();
            headers.put("Accept", "application/json");
            String recipeData = requestSender.sendRequest(RecipesID + id, "GET", headers, 5000);

            if (recipeData == null)
            {
                return "{\"msg\": \"No data from " + AllRecipesURL + "\"}";
            }

//            List<RecipeDTO> recipeList = gson.fromJson(recipeData, new TypeToken<RecipeDTO>()
            RecipeDTO recipeList = gson.fromJson(recipeData, new TypeToken<RecipeDTO>()
            {
            }.getType());

//            FACADE.persistAllExternalCountries(recipeList);
            return GSON.toJson(recipeList);
        }
        catch (IllegalArgumentException | DatabaseException ex)
        {
            System.out.println(Arrays.toString(ex.getStackTrace()));
            return "{\"msg\": \"" + ex.getMessage() + "\"}";
        }
        catch (IOException ex)
        {
            System.out.println(Arrays.toString(ex.getStackTrace()));
            return "{\"msg\": \"The provided URL is invalid.\"}\n\n" + ex.getMessage() + "";
        }
        
    }
    
}
