package avc.fantasy_mma_service.fighterStats;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@Repository
@AllArgsConstructor
@RequestMapping("/api/v1/fighter-stats")
public class FighterStatsController {

    public final FighterStatsService fighterStatsService;

    @PostMapping("")
    public FighterStatsDto createFighterStats(@RequestBody FighterStatsDto fighterStatsDto) {
        return fighterStatsService.createFighterStats(fighterStatsDto);
    }

    @PatchMapping("/{id}")
    public FighterStatsDto editFighterStats(@RequestBody FighterStatsDto fighterStatsDto,@PathVariable Long id) {
        return fighterStatsService.editFighterStats(fighterStatsDto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteFighterStats(@PathVariable Long id) {
        fighterStatsService.deleteFighterStats(id);
    }
    @GetMapping("/{id}")
    public FighterStatsDto getFighterStatsById(@PathVariable Long id) {
        return fighterStatsService.getFighterStatsById(id);
    }

}
