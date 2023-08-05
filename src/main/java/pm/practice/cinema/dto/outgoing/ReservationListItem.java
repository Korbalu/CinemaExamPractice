package pm.practice.cinema.dto.outgoing;

import lombok.Data;
import pm.practice.cinema.domain.Reservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class ReservationListItem {
    private String name;
    private String title;
    private Long numberOfSeats;
    private LocalDate screeningDate; //format: yyyy-MM-dd hh:mm

    public ReservationListItem(Reservation reservation) {
        this.name = reservation.getName();
        this.title = reservation.getScreening().getTitle();
        this.numberOfSeats = reservation.getNumberOfSeats();
        this.screeningDate = reservation.getScreening().getScreening();
    }
}
