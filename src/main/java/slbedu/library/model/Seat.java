package slbedu.library.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SEAT database table.
 * 
 */
@Entity
@Table(name="SEAT")
@NamedQuery(name="Seat.findAll", query="SELECT s FROM Seat s")
public class Seat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int col;

	private int row;

	//bi-directional many-to-one association to ReservationEntity
	@OneToMany(mappedBy="seat")
	private List<ReservationEntity> reservationEntities;

	//bi-directional many-to-one association to Hall
	@ManyToOne
	private Hall hall;

	public Seat() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCol() {
		return this.col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getRow() {
		return this.row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public List<ReservationEntity> getReservationEntities() {
		return this.reservationEntities;
	}

	public void setReservationEntities(List<ReservationEntity> reservationEntities) {
		this.reservationEntities = reservationEntities;
	}

	public ReservationEntity addReservationEntity(ReservationEntity reservationEntity) {
		getReservationEntities().add(reservationEntity);
		reservationEntity.setSeat(this);

		return reservationEntity;
	}

	public ReservationEntity removeReservationEntity(ReservationEntity reservationEntity) {
		getReservationEntities().remove(reservationEntity);
		reservationEntity.setSeat(null);

		return reservationEntity;
	}

	public Hall getHall() {
		return this.hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}

}