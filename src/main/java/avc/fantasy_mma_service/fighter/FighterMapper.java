package avc.fantasy_mma_service.fighter;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface FighterMapper {

    @Mapping(target = "id", ignore = true)
    Fighter toEntity(FighterDto fighterDto);

    FighterDto toDto(Fighter fighter);

    void updateFighterFromDto(FighterDto fighterDto, @MappingTarget Fighter fighter);
}
