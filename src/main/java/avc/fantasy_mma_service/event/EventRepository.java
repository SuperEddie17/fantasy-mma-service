package avc.fantasy_mma_service.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    // Custom query methods can be defined here if needed
    // For example, to find events by name or date, etc.
    // List<Event> findByName(String name);
    // List<Event> findByDate(String date);
}
