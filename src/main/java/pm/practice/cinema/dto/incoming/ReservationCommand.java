package pm.practice.cinema.dto.incoming;

import lombok.Data;

@Data
public class ReservationCommand {
    private String name;
    private Long seats;
    private Long screeningId;
}
