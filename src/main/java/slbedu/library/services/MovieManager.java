package slbedu.library.services;


import slbedu.library.dao.HallDAO;
import slbedu.library.dao.MovieDAO;
import slbedu.library.dao.UserDAO;
import slbedu.library.model.Hall;
import slbedu.library.model.Movie;
import slbedu.library.model.Seat;
import slbedu.library.model.User;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("movie")
public class MovieManager {
    
    private static final Response RESPONSE_OK = Response.ok().build();

    @EJB
    private UserDAO userDAO;

    @EJB
    private MovieDAO movieDAO;
    
    @EJB
    private HallDAO hallDAO;
    
    @Inject
    private UserContext context;
    
//    @Path("authenticated")
//    @GET
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response isAuthenticated() {
//      if (context.getCurrentUser() == null) {
//          return Response.status(HttpURLConnection.HTTP_NOT_FOUND).build();
//      }
//      return RESPONSE_OK;
//    }
//    
//    @Path("issupervisor")
//    @GET
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response isSupervisor() {
//      if (context.getCurrentUser() == null) {
//          return Response.status(HttpURLConnection.HTTP_NOT_FOUND).build();
//      }
//      if (context.getCurrentUser().isSupervisor()) {
//    	  return RESPONSE_OK;
//      };
//      return Response.status(HttpURLConnection.HTTP_NOT_FOUND).build();
//    }
    
    @GET
    @Produces("application/json")
    public Collection<Movie> getAllMovies(){
    	List<Movie> result = movieDAO.getAll();
    	
    	return result;
    }
    
    @Path("seats/{id}")
    @GET
    @Produces("application/json")
    public Collection<SeatTrans> getSeats(@PathParam("id") String id) {
    	int movieId = Integer.parseInt(id);
    	Hall hall = movieDAO.getById(movieId).getHall();
    	List<Seat> result = hallDAO.findSeatsInHall(hall);
    	List<SeatTrans> transObjects = new ArrayList<>();
    	Random random = new Random();
    	for(Seat s: result) {
    		SeatTrans trans = new SeatTrans(s);
    		
    		trans.isTaken = random.nextBoolean();
    		trans.movieId = movieId;
    		transObjects.add(trans);
    	}
    	return transObjects;
    }

//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void registerUser(User newUser) {
//        userDAO.addUser(newUser);
//        context.setCurrentUser(newUser);
//    }
//    
//    @Path("login")
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response loginUser(User user) {
//        boolean isUserValid = userDAO.validateUserCredentials(user.getUserName(), user.getPassword());
//        if (!isUserValid) {
//            return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).build();
//        }
//        context.setCurrentUser(user);
//        return RESPONSE_OK;
//    }
//    
//    @Path("authenticated")
//    @GET
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response isAuthenticated() {
//        if (context.getCurrentUser() == null) {
//            return Response.status(HttpURLConnection.HTTP_NOT_FOUND).build();
//        }
//        return RESPONSE_OK;
//    }
//
//    @Path("current")
//    @GET
//    @Consumes(MediaType.TEXT_PLAIN)
//    public String getUser() {
//        if (context.getCurrentUser() == null) {
//            return null;
//        }
//        return context.getCurrentUser().getUserName();
//    }
//
//	@Path("logout")
//	@GET
//	@Consumes(MediaType.TEXT_PLAIN)
//	public void logoutUser() {
//		context.setCurrentUser(null);
//	}
}
