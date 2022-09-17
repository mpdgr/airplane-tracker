package mpdgr.airplanetracker.data.hexcode;

import mpdgr.airplanetracker.domain.model.HexCode;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface HexCodeEntityMapper {
    HexCodeEntityMapper INSTANCE = Mappers.getMapper(HexCodeEntityMapper.class);
    HexCodeEntity hexCodeToHexCodeEntity(HexCode hexCode);
    HexCode hexCodeEntityToHexCode(HexCodeEntity hexCodeEntity);
}
