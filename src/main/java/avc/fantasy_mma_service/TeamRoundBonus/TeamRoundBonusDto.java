package avc.fantasy_mma_service.TeamRoundBonus;

import lombok.Data;

@Data
public class TeamRoundBonusDto {
    private Long id;

    private Long teamRoundId;

    private Long captainId;

    private Long viceCaptainId;

    private Long subBonusId;

    private Long tkoBonusId;

}
