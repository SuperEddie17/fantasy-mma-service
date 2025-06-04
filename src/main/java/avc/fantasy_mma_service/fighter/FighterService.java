package avc.fantasy_mma_service.fighter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FighterService {

    private final FighterRepository fighterRepository;
    private final FighterMapper fighterMapper;

    public FighterDto createFighter(FighterDto fighterDto){
        Fighter fighter = fighterMapper.toEntity(fighterDto);
        fighterRepository.save(fighter);
        return fighterMapper.toDto(fighter);
    }

    public FighterDto editFighter(FighterDto fighterDto, Long id){
        Fighter fighter = fighterRepository.findById(id).orElseThrow(() -> new RuntimeException("Fighter not found"));
        fighterMapper.updateFighterFromDto(fighterDto, fighter);
        fighterRepository.save(fighter);
        return fighterMapper.toDto(fighter);
    }

    public void deleteFighter(Long id){
        Fighter fighter = fighterRepository.findById(id).orElseThrow(() -> new RuntimeException("Fighter not found"));
        fighterRepository.delete(fighter);
    }

    public FighterDto getFighterById(Long id) {
        Fighter fighter = fighterRepository.findById(id).orElseThrow(() -> new RuntimeException("Fighter not found"));
        return fighterMapper.toDto(fighter);
    }
}
