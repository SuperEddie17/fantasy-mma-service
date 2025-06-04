package avc.fantasy_mma_service.event;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    public EventDto createEvent(EventDto eventDto) {
        Event event = eventMapper.toEntity(eventDto);
        eventRepository.save(event);
        return eventMapper.toDto(event);
    }
    public EventDto editEvent(Long id, EventDto eventDto) {
        Event existingEvent = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + id));

        eventMapper.updateEntityFromDto(eventDto, existingEvent);
        eventRepository.save(existingEvent);
        return eventMapper.toDto(existingEvent);
    }

    public EventDto getEventById(Long id) {
        return eventRepository.findById(id)
                .map(eventMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + id));
    }

    public void deleteEvent(Long id) {
        if (!eventRepository.existsById(id)) {
            throw new RuntimeException("Event not found with id: " + id);
        }
        eventRepository.deleteById(id);
    }
}
