package slbedu.library.utils;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import slbedu.library.dao.UserDAO;
import slbedu.library.model.User;

@Stateless
public class DatabaseUtils {
    
    private static User[] USERS = {
            new User("admin", "admin", true),
            new User("vasko", "123", true),
            new User("dancho", "123", false)};


    @PersistenceContext
    private EntityManager em;
    
    @EJB
    private UserDAO userDAO;
    
    public void addTestDataToDB() {
        deleteData();
        addTestUsers();
    }

    private void deleteData() {
        em.createQuery("DELETE FROM User").executeUpdate();
   }

    private void addTestUsers() {
        for (User user : USERS) {
            userDAO.addUser(user);
        }
    }
}
