package pm.practice.cinema.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pm.practice.cinema.domain.Reservation;
import pm.practice.cinema.domain.Screening;
import pm.practice.cinema.dto.incoming.ScreeningCommand;
import pm.practice.cinema.dto.outgoing.ReservationScreeningListItem;
import pm.practice.cinema.dto.outgoing.ScreeningListItem;
import pm.practice.cinema.repositories.ScreeningRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class ScreeningService {
    private ScreeningRepository screeningRepository;

    public ScreeningService(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
    }

    public void addScreening(ScreeningCommand command) {
        screeningRepository.save(new Screening(command));
    }

    public List<ScreeningListItem> listAllScreenings() {
        return screeningRepository.findByOrderByScreeningAsc().stream().map(ScreeningListItem::new).collect(Collectors.toList());
    }

    public List<ReservationScreeningListItem> listAllScreeningsAndReservation() {
        List<Screening> screenings = screeningRepository.findAll();
        Set<String> titles = new HashSet<>();
        for (Screening screening : screenings) {
                titles.add(screening.getTitle());
        }
        List<ReservationScreeningListItem> targetList = new ArrayList<>();
        for (String title : titles) {
            ReservationScreeningListItem item = new ReservationScreeningListItem();
            item.setTitle(title);
            item.setNumberOfScreenings((long) screeningRepository.findByTitle(title).size());
            int reservations = 0;
            for (Screening screening : screeningRepository.findByTitle(title)) {
                for (Reservation reservation : screening.getReservations()) {
                    reservations += reservation.getNumberOfSeats();
                }
            }
            item.setTicketsSold((long) reservations);
            targetList.add(item);
        }

        return targetList;
    }


}
