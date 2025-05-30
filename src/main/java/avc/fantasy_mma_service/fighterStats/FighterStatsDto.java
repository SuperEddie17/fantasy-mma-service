package avc.fantasy_mma_service.fighterStats;

import lombok.Data;

@Data
public class FighterStatsDto {

    private long id;

    private long fighterId;

    private long eventId;

    private int strikes;

    private int significantStrikes;

    private int takedowns;

    private int attendedSubmissions;

    private boolean subWin;

    private boolean tkoWin;

    private boolean decWin;

    private boolean underdog;

    private int points;
}
