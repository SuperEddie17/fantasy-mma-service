package avc.fantasy_mma_service.teamRound;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRoundRepository extends JpaRepository<TeamRound,Long> {
}
