package avc.fantasy_mma_service.teamRound;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TeamRoundMapper {

    TeamRoundDto toDto(TeamRound teamRound);

    @Mapping(target = "id", ignore = true)
    TeamRound toEntity(TeamRoundDto teamRoundDto);

    void updateTeamRoundFromDto(TeamRoundDto teamRoundDto, @MappingTarget TeamRound teamRound);
}
