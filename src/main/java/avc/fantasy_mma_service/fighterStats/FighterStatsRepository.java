package avc.fantasy_mma_service.fighterStats;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FighterStatsRepository extends JpaRepository<FighterStats, Long> {

    // Additional query methods can be defined here if needed
}
