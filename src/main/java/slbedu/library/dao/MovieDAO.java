package slbedu.library.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import slbedu.library.model.Movie;


@Singleton
public class MovieDAO {

    @PersistenceContext
    private EntityManager em;
    
    public void addMovie(Movie movie) {
    	em.persist(movie);
    	em.flush();
    }
    
    public List<Movie> getMoviesAfter(Date startingTime) {
    	String txtQuery = "SELECT m FROM Movie m WHERE m.startingTime>=:startingTime";
        TypedQuery<Movie> query = em.createQuery(txtQuery, Movie.class);
        query.setParameter("startingTime", startingTime);
        return query.getResultList();
    }

}
