package slbedu.library.dao;


import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import slbedu.library.model.Hall;
import slbedu.library.model.Seat;


@Singleton
public class HallDAO {

    @PersistenceContext
    private EntityManager em;
    
    
    public List<Seat> findSeatsInHall(int id){
	 	String txtQuery = "SELECT id FROM SEAT u WHERE u.id = :id";
        TypedQuery<Seat> query = em.createQuery(txtQuery, Seat.class);
        query.setParameter("id", id);
        return querySeat(query);
}

 private List<Seat> querySeat(TypedQuery<Seat> query) {
        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
}

public Hall findHallById(int id) {
        String txtQuery = "SELECT name FROM HALL u WHERE u.id = :id";
        TypedQuery<Hall> query = em.createQuery(txtQuery, Hall.class);
        query.setParameter("id", id);
        return queryHall(query);
    }
 
    private Hall queryHall(TypedQuery<Hall> query) {
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
