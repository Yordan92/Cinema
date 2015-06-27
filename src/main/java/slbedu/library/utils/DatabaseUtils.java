package slbedu.library.utils;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import slbedu.library.dao.MovieDAO;
import slbedu.library.dao.ReservationDAO;
import slbedu.library.dao.UserDAO;
import slbedu.library.model.Movie;
import slbedu.library.model.Reservation;
import slbedu.library.model.User;

@Stateless
public class DatabaseUtils {
    
    private static User[] USERS = {
            new User("admin", "admin", true),
            new User("vasko", "123", true),
            new User("dancho", "123", false)};
    
    private static Movie[] MOVIES = {
    	new Movie("fast and furious", new Date(), null),
    	new Movie("qko film4e", new Date(), null),
    	new Movie("maliii", new Date(), null)
    };
    
    private static Reservation[] RESERVATIONS = {
    	new Reservation(USERS[0], MOVIES[0]),
    	new Reservation(USERS[0], MOVIES[1]),
    	new Reservation(USERS[2], MOVIES[2])
    };


    @PersistenceContext
    private EntityManager em;
    
    @EJB
    private UserDAO userDAO;
    
    @EJB
    private ReservationDAO reservationDAO;
    
    @EJB
    private MovieDAO movieDAO;
    
    public void addTestDataToDB() {
        deleteData();
        addTestUsers();
    }

    private void deleteData() {
        em.createQuery("DELETE FROM User").executeUpdate();
   }

    private void addTestUsers() {
//        for (User user : USERS) {
//            userDAO.addUser(user);
//        }
//        for (Movie m: MOVIES) {
//        	movieDAO.addMovie(m);
//        }
//        for (Reservation r: RESERVATIONS) {
//        	reservationDAO.addReservation(r);
//        }
    }
}
