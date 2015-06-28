package slbedu.library.dao;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import slbedu.library.model.Movie;
import slbedu.library.model.Seat;

@Singleton
public class SeatDAO {

    @PersistenceContext
    private EntityManager em;
    
	public void addHall(Seat seat) {
		em.persist(seat);
		em.flush();
	}
	
	public Seat getById(int id) {
		return em.find(Seat.class, id);
	}
}
