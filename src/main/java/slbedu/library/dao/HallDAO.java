package slbedu.library.dao;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
public class HallDAO {

    @PersistenceContext
    private EntityManager em;
}
