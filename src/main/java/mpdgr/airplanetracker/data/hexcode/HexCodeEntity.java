package mpdgr.airplanetracker.data.hexcode;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity(name = "Hexcode")
@Table(name = "Hexcodes")
@Getter
@Setter
public class HexCodeEntity {
    @Id
    private String hexIcao;
    private boolean isB747;
    private String aircraftType;
}
