package pm.practice.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pm.practice.cinema.domain.Reservation;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
