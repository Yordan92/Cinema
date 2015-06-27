package slbedu.library.dao;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import slbedu.library.model.Movie;
import slbedu.library.model.Reservation;
import slbedu.library.model.User;

@Singleton
public class ReservationDAO {

    @PersistenceContext
    private EntityManager em;
    
    public void addReservation(Reservation reservation) {
    	em.persist(reservation);
    	em.flush();
    }
    
    public List<Reservation> getAllUserReservations(User user) {
    	String txtQuery = "SELECT r FROM Reservation r WHERE r.user=:user";
        TypedQuery<Reservation> query = em.createQuery(txtQuery, Reservation.class);
        query.setParameter("user", user);
        return query.getResultList();
    }
    
    public List<Reservation> getAllReservationsForMovie(Movie movie) {
    	String txtQuery = "SELECT r FROM Reservation r WHERE r.movie=:movie";
        TypedQuery<Reservation> query = em.createQuery(txtQuery, Reservation.class);
        query.setParameter("movie", movie);
        return query.getResultList();
    }
}
