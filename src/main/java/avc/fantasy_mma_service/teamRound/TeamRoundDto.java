package avc.fantasy_mma_service.teamRound;

import lombok.Data;
import java.util.Set;

@Data
public class TeamRoundDto {
    private long id;

    private long userId;

    private long eventId;

    private Set<Long> fighterIds;
}
