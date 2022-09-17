package mpdgr.airplanetracker.domain.ports.data;

import mpdgr.airplanetracker.domain.model.HexCode;
import java.util.List;
import java.util.Optional;

public interface HexCodeRepository {
    Optional<HexCode> findHexCode(String hexCode);
    List<HexCode> getAll();
    void saveHexCode(HexCode hexCode);
    boolean isListed(String hexCode);
}
