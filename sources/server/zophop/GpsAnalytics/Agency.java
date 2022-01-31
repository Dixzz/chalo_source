package server.zophop.GpsAnalytics;

import org.json.JSONObject;

public enum Agency {
    apsrtc("apsrtc", "vijayawada"),
    jctslJaipur("jctsl", "jaipur"),
    hoho("hoho", "goa"),
    bcll("bcll", "bhopal"),
    astc("astc", "guwahati"),
    amctsl("amctsl", "agra"),
    amctslMathura("amctsl", "mathura"),
    kmrl("kmrl", "kochi"),
    ibus("aictsl", "indore"),
    ctype("c-type", "indore"),
    aictsl("ibus", "indore"),
    uctsl("uctsl", "ujjain"),
    jctsl("jctsl", "jabalpur"),
    bsrtc("bsrtc", "patna"),
    lctsl("lctsl", "lucknow"),
    mctsl("mctsl", "meerut"),
    kctsl("kctsl", "kanpur"),
    dkboa("dkboa", "mangaluru"),
    actsl("actsl", "prayagraj");
    
    private String _agency;
    private String _name;

    private Agency(String str, String str2) {
        this._agency = str;
        this._name = str2;
    }

    public String getAgency() {
        return this._agency;
    }

    public String getCity() {
        return this._name;
    }

    public String toString() {
        return new JSONObject().put("city", this._name).put("agency", this._agency).toString();
    }
}
