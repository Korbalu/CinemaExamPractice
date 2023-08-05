package pm.practice.cinema.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pm.practice.cinema.domain.Screening;
import pm.practice.cinema.dto.incoming.ScreeningCommand;
import pm.practice.cinema.dto.outgoing.ScreeningListItem;
import pm.practice.cinema.repositories.ScreeningRepository;

import java.util.List;
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


}
