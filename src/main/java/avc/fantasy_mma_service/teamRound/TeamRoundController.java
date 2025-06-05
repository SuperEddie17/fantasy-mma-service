package avc.fantasy_mma_service.teamRound;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/team-rounds")
public class TeamRoundController {

    private final TeamRoundService teamRoundService;

    @PostMapping("")
   public TeamRoundDto createTeamRound(@RequestBody TeamRoundDto teamRoundDto) {
        return teamRoundService.createTeamRound(teamRoundDto);
    }
    @PatchMapping("/{id}")
    public TeamRoundDto updateTeamRound(@PathVariable long id, @RequestBody TeamRoundDto teamRoundDto) {
        return teamRoundService.updateTeamRound(id, teamRoundDto);
    }

    @GetMapping("/{id}")
    public TeamRoundDto getTeamRound(@PathVariable long id) {
        return teamRoundService.getTeamRound(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTeamRound(@PathVariable long id) {
        teamRoundService.deleteTeamRound(id);
    }
}
