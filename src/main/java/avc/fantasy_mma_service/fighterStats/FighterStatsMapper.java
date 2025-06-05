package avc.fantasy_mma_service.fighterStats;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface FighterStatsMapper {

    FighterStatsDto toDto(FighterStats fighterStats);

    @Mapping(target = "id", ignore = true)
    FighterStats toEntity(FighterStatsDto fighterStatsDto);

    @Mapping(target = "id", ignore = true)
    void updateFighterStatsFromDto(FighterStatsDto fighterStatsDto,@MappingTarget FighterStats fighterStats);
}
