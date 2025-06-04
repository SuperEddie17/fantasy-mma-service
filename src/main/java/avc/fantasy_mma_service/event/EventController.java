package avc.fantasy_mma_service.event;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/events")
public class EventController {

    private final EventService eventService;

    @PostMapping("")
    public EventDto createEvent(@RequestBody EventDto eventDto) {
        return eventService.createEvent(eventDto);
    }
    @PatchMapping("/{id}")
    public EventDto editEvent(@RequestBody EventDto eventDto, @PathVariable Long id) {
        return eventService.editEvent(id, eventDto);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
    }

    @GetMapping("/{id}")
    public EventDto getEventById(@PathVariable Long id) {
        return eventService.getEventById(id);
    }


}
