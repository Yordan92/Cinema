package slbedu.library.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the RESERVATION_ENTITY database table.
 * 
 */
@Entity
@Table(name="RESERVATION_ENTITY")
@NamedQuery(name="ReservationEntity.findAll", query="SELECT r FROM ReservationEntity r")
public class ReservationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to Reservation
	@ManyToOne
	private Reservation reservation;

	//bi-directional many-to-one association to Seat
	@ManyToOne
	private Seat seat;

	public ReservationEntity() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Reservation getReservation() {
		return this.reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public Seat getSeat() {
		return this.seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

}