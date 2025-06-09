package avc.fantasy_mma_service.TeamRoundBonus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRoundBonusRepository extends JpaRepository<TeamRoundBonus, Long> {
}
