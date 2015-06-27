package slbedu.library.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the RESERVATION database table.
 * 
 */
@Entity
@Table(name="RESERVATION")
@NamedQuery(name="Reservation.findAll", query="SELECT r FROM Reservation r")
public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	//bi-directional many-to-one association to Movie
	@ManyToOne
	private Movie movie;

	//bi-directional many-to-one association to ReservationEntity
	@OneToMany(mappedBy="reservation")
	private List<ReservationEntity> reservationEntities;

	public Reservation() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return this.movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public List<ReservationEntity> getReservationEntities() {
		return this.reservationEntities;
	}

	public void setReservationEntities(List<ReservationEntity> reservationEntities) {
		this.reservationEntities = reservationEntities;
	}

	public ReservationEntity addReservationEntity(ReservationEntity reservationEntity) {
		getReservationEntities().add(reservationEntity);
		reservationEntity.setReservation(this);

		return reservationEntity;
	}

	public ReservationEntity removeReservationEntity(ReservationEntity reservationEntity) {
		getReservationEntities().remove(reservationEntity);
		reservationEntity.setReservation(null);

		return reservationEntity;
	}

}