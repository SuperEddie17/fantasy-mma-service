package avc.fantasy_mma_service.fighterStats;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class FighterStats {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
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

