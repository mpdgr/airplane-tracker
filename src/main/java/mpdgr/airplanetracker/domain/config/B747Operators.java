package mpdgr.airplanetracker.domain.config;

/* All airlines version */

public enum B747Operators {
    ATLAS_AIR 		          ("GTI", "GIANT"),
    UPS_AIRLINES		      ("UPS", "UPS"),
    CARGOLUX		          ("CLX", "CARGOLUX"),
    LUFTHANSA		          ("DLH", "LUFTHANSA"),
    KALITTA_AIR		          ("CKS", "CONNIE"),
    CATHAY_PACIFIC		      ("CPA", "CATHAY"),
    KOREAN_AIR		          ("KAL", "KOREAN AIR"),
    CHINA_AIRLINES		      ("CAL", "DYNASTY"),
    AIRBRIDGECARGO		      ("ABW", "AIRBRIDGECARGO"),
    AIR_ATLANTA_ICELANDIC	  ("ABD", "ATLANTA"),
    AIR_ATLANTA_EUROPE	      ("AAE", "EUROVIKING"),
    ASIANA_AIRLINES		      ("AAR", "ASIANA"),
    SILK_WAY_WEST_AIRLINES	  ("AZG", "SILK WEST"),
    AIR_CHINA		          ("CCA", "AIR CHINA"),
    AIR_CHINA_CARGO	          ("CAO", "AIRCHINA FREIGHT"),
    POLAR_AIR_CARGO		      ("PAC", "POLAR"),
    ROSSIYA_AIRLINES	      ("SDM", "ROSSIYA"),
    AEROTRANSCARGO		      ("ATG", "MOLDCARGO"),
    NIPPON_CARGO_AIRLINES	  ("NCA", "NIPPON CARGO"),
    SINGAPORE_AIRLINES	      ("SIA", "SINGAPORE"),
    LONGTAIL_AVIATION   	  ("LGT", "LONGTAIL"),
    QATAR_AIRWAYS             ("QTR", "QATARI"),
    AIR_ACT                   ("RUN", "CARGO TURK"),
    FARS_QESHM_AIR            ("QFZ", "FARS AIR"),
    NATIONAL_AIRLINES	      ("NCR", "NATIONAL CARGO"),
    AIR_INDIA                 ("AIC", "AIRINDIA"),
    WESTERN_GLOBAL            ("WGN", "WESTERN GLOBAL"),
    ALS_AIRLINES_BELGIUM      ("TAY", "QUALITY"),
    US_TRANSPORTATION_COMMAND ("CMB", "CAMBER");

    private final String icao;
    private final String callSign;

    B747Operators(String icao, String callSign) {
        this.icao = icao;
        this.callSign = callSign;
    }

    public String getIcao() {
        return icao;
    }

    public String getCallSign() {
        return callSign;
    }
}