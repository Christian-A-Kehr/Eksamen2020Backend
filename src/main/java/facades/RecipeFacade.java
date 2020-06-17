/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Role;
import entities.User;
import errorhandling.AlreadyExistsException;
import errorhandling.AuthenticationException;
import errorhandling.NotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Christian
 */
public class RecipeFacade
{
     private static EntityManagerFactory emf;
    private static RecipeFacade instance;

    private RecipeFacade()
    {
    }

    /**
     *
     * @param _emf
     * @return the instance of this facade.
     */
    public static RecipeFacade getUserFacade(EntityManagerFactory _emf)
    {
        if (instance == null)
        {
            emf = _emf;
            instance = new RecipeFacade();
        }
        return instance;
    }

    
    public User createNormalUser(String username, String password, String role ) throws AlreadyExistsException
    {
        EntityManager em = emf.createEntityManager();
        User userRegister = new User(username, password);

        try
        {
          Role userRole = em.find(Role.class, role);
//            Role userRole = new Role("user");
            userRegister.addRole(userRole);
            User user = em.find(User.class, username);
            if (user != null)
            {
                throw new AlreadyExistsException("User name already exists");
            }
            em.getTransaction().begin();
            em.persist(userRegister);
            em.getTransaction().commit();
        } finally
        {
            em.close();
        }
        return userRegister;
    }

   
    public long getUserCount()
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            long renameMeCount = (long) em.createQuery("SELECT COUNT(r) FROM User r").getSingleResult();
            return renameMeCount;
        } finally
        {
            em.close();
        }

    }

    public User getUserByName(String userName) throws NotFoundException
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            User u = em.find(User.class, userName);
            if (u == null)
            {
                throw new NotFoundException("No object matching provided id exists in database.");
            }
            return u;
        } catch (IllegalArgumentException ex)
        {
            throw new NotFoundException("No object matching provided id exists in database. IllegalArgumentException.");
        } finally
        {
            em.close();
        }
    }
}
