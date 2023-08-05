package pm.practice.cinema.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pm.practice.cinema.domain.Reservation;
import pm.practice.cinema.domain.Screening;
import pm.practice.cinema.dto.incoming.ReservationCommand;
import pm.practice.cinema.dto.incoming.ScreeningCommand;
import pm.practice.cinema.dto.outgoing.ReservationListItem;
import pm.practice.cinema.dto.outgoing.ScreeningDetails;
import pm.practice.cinema.repositories.ReservationRepository;
import pm.practice.cinema.repositories.ScreeningRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ReservationService {

    private ReservationRepository reservationRepository;
    private ScreeningRepository screeningRepository;
    private ScreeningService movieScreeningService;

    public ReservationService(ReservationRepository reservationRepository, ScreeningRepository screeningRepository, ScreeningService movieScreeningService) {
        this.reservationRepository = reservationRepository;
        this.screeningRepository = screeningRepository;
        this.movieScreeningService = movieScreeningService;
    }

    public void addReservation(ReservationCommand command) {
        Screening screening = screeningRepository.findById(command.getScreeningId()).orElse(null);
        Reservation reservation = new Reservation(command, screening);

        reservation.setScreening(screeningRepository.findById(command.getScreeningId()).orElse(null));

        reservationRepository.save(reservation);

        
    }

    public List<ScreeningDetails> getDetails() {
        List<ScreeningDetails> details = screeningRepository.findByOrderByScreeningAsc().stream().map(ScreeningDetails::new).collect(Collectors.toList());
    return details;
    }
    public List<ReservationListItem> getBookings(){
        return reservationRepository.findAll().stream().map(ReservationListItem::new).collect(Collectors.toList());
    }
}
