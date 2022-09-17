package mpdgr.airplanetracker.web.apiclients.opensky;

import mpdgr.airplanetracker.domain.config.SearchRange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ClientSearchRange {
    @Value("${search.range.all}")
    private String All;
    @Value("${search.range.poland}")
    private String Poland;
    @Value("${search.range.china}")
    private String China;
    @Value("${search.range.warsaw}")
    private String Warsaw;

    public String getRange(SearchRange range){
        switch (range){
            case ALL: return All;
            case POLAND: return Poland;
            case CHINA: return China;
            case WARSAW: return Warsaw;
            default: return "Range not available";
        }
    }
}