package pm.practice.cinema.domain;

import jakarta.persistence.*;
import pm.practice.cinema.dto.incoming.ScreeningCommand;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "screening")
public class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String title;
    @Column
    private Long totalSeat;
    @Column
    private String pictureUrl;
    @Column
    private LocalDate screening;
    @OneToMany(mappedBy = "screening")
    private List<Reservation> reservations;

    public Screening(Long id, String title, Long totalSeat, String pictureUrl, LocalDate screening) {
        this.id = id;
        this.title = title;
        this.totalSeat = totalSeat;
        this.pictureUrl = pictureUrl;
        this.screening = screening;
    }

    public Screening() {
    }
    public Screening(ScreeningCommand command) {
        this.title = command.getTitle();
        this.screening= command.getScreeningDate();
        this.totalSeat = command.getTotalSeat();
        this.pictureUrl = command.getPictureUrl();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTotalSeat() {
        return totalSeat;
    }

    public void setTotalSeat(Long totalSeat) {
        this.totalSeat = totalSeat;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public LocalDate getScreening() {
        return screening;
    }

    public void setScreening(LocalDate screening) {
        this.screening = screening;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
