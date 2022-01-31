package zophop.models;

public class StageStop {
    private int _stageIndex;
    private String _stopId;

    public StageStop(String str) {
        this._stopId = str;
        this._stageIndex = -1;
    }

    public int getStageIndex() {
        return this._stageIndex;
    }

    public String getStopId() {
        return this._stopId;
    }

    public StageStop(String str, int i) {
        this._stopId = str;
        this._stageIndex = i;
    }
}
