package avc.fantasy_mma_service.teamRound;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeamRoundService {

    private final TeamRoundRepository teamRoundRepository;
    private final TeamRoundMapper teamRoundMapper;

    public TeamRoundDto createTeamRound(TeamRoundDto teamRoundDto){
        TeamRound teamRound = teamRoundMapper.toEntity(teamRoundDto);
        teamRoundRepository.save(teamRound);
        return teamRoundMapper.toDto(teamRound);
    }

    public TeamRoundDto updateTeamRound(long id, TeamRoundDto teamRoundDto) {
        TeamRound existingTeamRound = teamRoundRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Team Round not found"));
        teamRoundMapper.updateTeamRoundFromDto(teamRoundDto, existingTeamRound);
        teamRoundRepository.save(existingTeamRound);
        return teamRoundMapper.toDto(existingTeamRound);
    }

    public TeamRoundDto getTeamRound(long id) {
        TeamRound teamRound = teamRoundRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Team Round not found"));
        return teamRoundMapper.toDto(teamRound);
    }

    public void deleteTeamRound(long id) {
        if (!teamRoundRepository.existsById(id)) {
            throw new RuntimeException("Team Round not found");
        }
        teamRoundRepository.deleteById(id);
    }
}
