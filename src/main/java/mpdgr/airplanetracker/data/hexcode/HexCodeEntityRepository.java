package mpdgr.airplanetracker.data.hexcode;

import lombok.RequiredArgsConstructor;
import mpdgr.airplanetracker.domain.model.HexCode;
import mpdgr.airplanetracker.domain.ports.data.HexCodeRepository;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class HexCodeEntityRepository implements HexCodeRepository {
    private final HexCodeJpaRepository repository;
    private final HexCodeEntityMapper mapper;

    @Override
    public Optional<HexCode> findHexCode(String hexCode) {
        Optional<HexCodeEntity> hexCodeEntity = repository.findById(hexCode);
        return hexCodeEntity.isPresent() ?
                Optional.of(mapper.hexCodeEntityToHexCode(hexCodeEntity.get())) : Optional.empty();
    }

    @Override
    public List<HexCode> getAll() {
        return repository.findAll().stream()
                .map(mapper::hexCodeEntityToHexCode)
                .collect(Collectors.toList());
    }

    @Override
    public void saveHexCode(HexCode hexCode) {
        repository.save(mapper.hexCodeToHexCodeEntity(hexCode));
    }

    @Override
    public boolean isListed(String hexCode) {
        Optional<HexCodeEntity> hexCodeEntity = repository.findById(hexCode);
        return hexCodeEntity.isPresent();
    }
}
