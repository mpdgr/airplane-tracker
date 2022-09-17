package mpdgr.airplanetracker.domain.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class HexCode {
    private String hexIcao;
    private boolean isB747;
    private String aircraftType;

    public HexCode(String hexIcao, boolean isB774) {
        this.hexIcao = hexIcao;
        this.isB747 = isB774;
    }
}
