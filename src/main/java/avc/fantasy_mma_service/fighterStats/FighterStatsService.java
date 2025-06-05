package avc.fantasy_mma_service.fighterStats;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FighterStatsService {

    private final FighterStatsRepository fighterStatsRepository;
    private final FighterStatsMapper fighterStatsMapper;

    public FighterStatsDto createFighterStats(FighterStatsDto fighterStatsDto) {
        FighterStats fighterStats = fighterStatsMapper.toEntity(fighterStatsDto);
        fighterStatsRepository.save(fighterStats);
        return fighterStatsMapper.toDto(fighterStats);
    }

    public FighterStatsDto editFighterStats(FighterStatsDto fighterStatsDto, Long id) {
        FighterStats fighterStats = fighterStatsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fighter stats not found"));
        fighterStatsMapper.updateFighterStatsFromDto(fighterStatsDto, fighterStats);
        fighterStatsRepository.save(fighterStats);
        return fighterStatsMapper.toDto(fighterStats);
    }

    public void deleteFighterStats(Long id) {
        FighterStats fighterStats = fighterStatsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fighter stats not found"));
        fighterStatsRepository.delete(fighterStats);
    }

    public FighterStatsDto getFighterStatsById(Long id) {
        FighterStats fighterStats = fighterStatsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fighter stats not found"));
        return fighterStatsMapper.toDto(fighterStats);
    }
}
