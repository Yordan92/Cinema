package slbedu.library.dao;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
public class ReservationEntityDAO {

    @PersistenceContext
    private EntityManager em;
}
