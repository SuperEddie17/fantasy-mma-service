package avc.fantasy_mma_service.teamRound;


import avc.fantasy_mma_service.fighter.Fighter;
import avc.fantasy_mma_service.fighter.FighterRepository;
import avc.fantasy_mma_service.user.User;
import avc.fantasy_mma_service.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TeamRoundService {

    private final TeamRoundRepository teamRoundRepository;
    private final TeamRoundMapper teamRoundMapper;
    private final FighterRepository fighterRepository;
    private final UserRepository userRepository;

    public TeamRoundDto createTeamRound(TeamRoundDto teamRoundDto){
        User user = userRepository.findById(teamRoundDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Uživatel s ID " + teamRoundDto.getUserId() + " neexistuje"));
        double MAX_TEAM_PRICE = user.getBudget();
        TeamRound teamRound = teamRoundMapper.toEntity(teamRoundDto);
        Set<Long> fighterIds = teamRound.getFighterIds();
        List<Fighter> fighters = fighterRepository.findAllById(fighterIds);
        Set<Long> foundIds = fighters.stream()
                .map(Fighter::getId)
                .collect(Collectors.toSet());

        // Ověření, že každé požadované ID skutečně existuje
        Set<Long> missingIds = new HashSet<>(fighterIds);
        missingIds.removeAll(foundIds);

        if (!missingIds.isEmpty()) {
            throw new IllegalArgumentException("Některá fighter ID neexistují: " + missingIds);
        }

        double totalPrice = fighters.stream()
                .mapToDouble(Fighter::getPrice)
                .sum();

        if (totalPrice > MAX_TEAM_PRICE) {
            throw new IllegalArgumentException("Celková cena týmu překračuje limit " + MAX_TEAM_PRICE);
        }
        user.setBudget(user.getBudget() - totalPrice);
        userRepository.save(user);

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
