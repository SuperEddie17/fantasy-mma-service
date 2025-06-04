package avc.fantasy_mma_service.fighter;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/fighters")
public class FighterController {

    private final FighterService fighterService;

    // Endpoint to create a fighter
    @PostMapping("")
    public FighterDto createFighter(@RequestBody FighterDto fighterDto) {
        return fighterService.createFighter(fighterDto);
    }

    // Endpoint to edit a fighter
    @PatchMapping("/{id}")
    public FighterDto editFighter(@RequestBody FighterDto fighterDto,@PathVariable Long id) {
        return fighterService.editFighter(fighterDto, id);
    }

    // Endpoint to delete a fighter
    @DeleteMapping("/{id}")
    public void deleteFighter(@PathVariable Long id) {
        fighterService.deleteFighter(id);
    }

    @GetMapping("/{id}")
    public FighterDto getFighterById(@PathVariable Long id) {
        return fighterService.getFighterById(id);
    }
}
