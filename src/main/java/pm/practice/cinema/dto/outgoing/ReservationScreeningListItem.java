package pm.practice.cinema.dto.outgoing;

import lombok.Data;
import pm.practice.cinema.domain.Reservation;
import pm.practice.cinema.domain.Screening;

@Data
public class ReservationScreeningListItem {
    private String title;
    private Long numberOfScreenings;
    private Long ticketsSold;

}
