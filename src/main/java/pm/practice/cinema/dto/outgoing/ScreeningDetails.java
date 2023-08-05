package pm.practice.cinema.dto.outgoing;

import jakarta.persistence.Column;
import lombok.Data;
import pm.practice.cinema.domain.Screening;

import java.time.LocalDate;

@Data
public class ScreeningDetails {
    private Long id;
    private String title;
    private LocalDate screening;

    public ScreeningDetails(Screening screening) {
        this.id = screening.getId();
        this.title = screening.getTitle();
        this.screening = screening.getScreening();
    }
}
