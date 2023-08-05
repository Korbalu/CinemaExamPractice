package pm.practice.cinema.dto.outgoing;

import lombok.Data;
import pm.practice.cinema.domain.Reservation;
import pm.practice.cinema.domain.Screening;

import java.time.LocalDate;

@Data
public class ScreeningListItem {
    private String title;
    private Long totalSeat;
    private Long freeSeat;
    private String pictureUrl;
    private LocalDate screeningDate;

    public ScreeningListItem(Screening screening) {
        this.title = screening.getTitle();
        this.totalSeat = screening.getTotalSeat();
        this.pictureUrl = screening.getPictureUrl();
        this.screeningDate = screening.getScreening();
        this.freeSeat = this.totalSeat - screening.getReservations().stream().map(Reservation::getNumberOfSeats).mapToLong(l -> l).sum();
    }
}
