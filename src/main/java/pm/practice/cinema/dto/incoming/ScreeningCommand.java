package pm.practice.cinema.dto.incoming;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ScreeningCommand {

    private String title;
    private Long totalSeat;
    private String pictureUrl;
    private LocalDate screeningDate;

}
