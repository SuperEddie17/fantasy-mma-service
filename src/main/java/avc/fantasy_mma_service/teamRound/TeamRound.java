package avc.fantasy_mma_service.teamRound;


import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class TeamRound {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private long id;

    private long userId;

    private long eventId;

    @ElementCollection
    private List<Long> fighterIds;


}
