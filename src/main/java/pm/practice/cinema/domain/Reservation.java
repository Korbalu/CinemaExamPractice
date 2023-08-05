package pm.practice.cinema.domain;

import jakarta.persistence.*;
import lombok.Data;
import pm.practice.cinema.dto.incoming.ReservationCommand;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private Long numberOfSeats;
    @ManyToOne
    @JoinColumn(name = "screening_id")
    private Screening screening;

    public Reservation() {
    }

//    public Reservation(ReservationCommand reservationCommand) {
//        this.name = reservationCommand.getName();
//        this.numberOfSeats = reservationCommand.getSeats();
//    }

    public Reservation(ReservationCommand reservationCommand, Screening screening) {
        this.name = reservationCommand.getName();
        this.numberOfSeats = reservationCommand.getSeats();
        this.screening = screening;
    }

    public Long getNumberOfSeats() {
        return numberOfSeats;
    }
}
