package app.zophop.models.mTicketing;

import java.util.List;
import java.util.Map;

public class BookingConfigPassengerInfo {
    private Map<Integer, Double> _discountedFareMap;
    private int _displayOrder;
    private Map<String, String> _displayProps;
    private List<String> _docsList;
    private Map<Integer, Double> _fareMap;
    private boolean _isActive;
    private int _maxCount;

    public Map<Integer, Double> getDiscountedFareMap() {
        return this._discountedFareMap;
    }

    public int getDisplayOrder() {
        return this._displayOrder;
    }

    public Map<String, String> getDisplayProps() {
        return this._displayProps;
    }

    public List<String> getDocsList() {
        return this._docsList;
    }

    public Map<Integer, Double> getFareMap() {
        return this._fareMap;
    }

    public int getMaxCount() {
        return this._maxCount;
    }

    public boolean isActive() {
        return this._isActive;
    }

    public void setDiscountedFareMap(Map<Integer, Double> map) {
        this._discountedFareMap = map;
    }

    public void setDisplayOrder(int i) {
        this._displayOrder = i;
    }

    public void setDisplayProps(Map<String, String> map) {
        this._displayProps = map;
    }

    public void setDocsList(List<String> list) {
        this._docsList = list;
    }

    public void setFareMap(Map<Integer, Double> map) {
        this._fareMap = map;
    }

    public void setIsActive(boolean z) {
        this._isActive = z;
    }

    public void setMaxCount(int i) {
        this._maxCount = i;
    }
}
