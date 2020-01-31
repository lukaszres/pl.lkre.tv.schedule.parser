package pl.lkre.tv.schedule.constants;

import java.util.List;

public enum StationNames {
    TVP_1("TVP 1", "TVP-1")
    ;

    private static final String URL_PATH = "/program-tv/stacje/";
    String displayName;
    String resourceName;

    StationNames(String displayName, String resourceName) {
        this.displayName = displayName;
        this.resourceName = resourceName;
    }

    public String urlPatch(StationNames station) {
        return URL_PATH + resourceName;
    }


}
