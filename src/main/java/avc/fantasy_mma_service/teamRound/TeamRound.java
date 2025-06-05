package avc.fantasy_mma_service.teamRound;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class TeamRound {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private long id;

    private long userId;

    private long eventId;

    @ElementCollection
    private Set<Long> fighterIds;


}
