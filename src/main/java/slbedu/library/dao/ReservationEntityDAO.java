package slbedu.library.dao;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import slbedu.library.model.Hall;
import slbedu.library.model.ReservationEntity;

@Singleton
public class ReservationEntityDAO {

    @PersistenceContext
    private EntityManager em;

	public void addEntity(ReservationEntity rEntity) {
		em.persist(rEntity);
		em.flush();
	}
}
