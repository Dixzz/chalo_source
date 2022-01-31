package app.zophop.models;

import java.util.List;

public class AutoCabResponse {
    private final List<AutoCabAggregatorInfo> _autoCabs;

    public AutoCabResponse(List<AutoCabAggregatorInfo> list) {
        this._autoCabs = list;
    }

    public List<AutoCabAggregatorInfo> getAutoCabs() {
        return this._autoCabs;
    }
}
