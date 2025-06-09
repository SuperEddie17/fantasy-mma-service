package avc.fantasy_mma_service.TeamRoundBonus;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TeamRoundBonus {
    @Id
    private Long id;

    private Long teamRoundId;

    private Long captainId;

    private Long viceCaptainId;

    private Long subBonusId;

    private Long tkoBonusId;

}
