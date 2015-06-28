package slbedu.library.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import slbedu.library.dao.HallDAO;
import slbedu.library.dao.ReservationDAO;
import slbedu.library.model.Movie;
import slbedu.library.model.Reservation;
import slbedu.library.model.ReservationEntity;
import slbedu.library.model.Seat;

@Singleton
public class ReservationService {
	
	@EJB
	private HallDAO hallDAO;
	
	@EJB
	private ReservationDAO resrvationDAO;
	
	private List<Reservation> reservations = new ArrayList<>();
	
	public List<SeatTrans> getSeats(Movie movie) {
		List<Seat> seats = hallDAO.findSeatsInHall(movie.getHall());
		List<SeatTrans> result = new ArrayList<>();
		for(Seat s: seats) {
			SeatTrans trans = new SeatTrans(s);
			trans.movieId = movie.getId();
			result.add(trans);
		}
		List<Reservation> reservations = resrvationDAO.getAllReservationsForMovie(movie);
		for(Reservation reservation: reservations) {
			if(reservation.getMovie().equals(movie)) {
				for(ReservationEntity r: reservation.getReservationEntities()) {
					matchTaken(result, r.getSeat().getId());
				}
			}
		}
		
		return result;
	}
	
	private void matchTaken(List<SeatTrans> seats, int seatId) {
		for(SeatTrans s: seats) {
			if(s.id == seatId) {
				s.isTaken = true;
			}
		}
	}
}

class Tmp {
	Reservation res;
	Date date;
}
