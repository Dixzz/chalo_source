package server.zophop.models;

public class HaltState {
    private Point _haltPoint;
    private HaltStatus _haltStatus;

    public HaltState(HaltStatus haltStatus, Point point) {
        this._haltPoint = point;
        this._haltStatus = haltStatus;
    }

    public Point getHaltPoint() {
        return this._haltPoint;
    }

    public HaltStatus getHaltStatus() {
        return this._haltStatus;
    }

    public void setHaltPoint(Point point) {
        this._haltPoint = point;
    }

    public void setHaltStatus(HaltStatus haltStatus) {
        this._haltStatus = haltStatus;
    }
}
