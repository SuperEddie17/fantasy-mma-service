package avc.fantasy_mma_service.event;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EventMapper {

    @Mapping(target = "id", ignore = true)
    EventDto toDto(Event event);

    Event toEntity(EventDto eventDto);

    void updateEntityFromDto(EventDto eventDto,@MappingTarget Event event);
}
