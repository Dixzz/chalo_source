package app.zophop.models.mTicketing;

import java.util.List;
import java.util.Map;

public class ProductConfigPassengerInfo {
    private Map<Integer, Double> _discountedFareMap;
    private List<String> _docsList;
    private Map<Integer, Double> _fareMap;
    private boolean _isActive;
    private int _maxCount;
    private int _verification;

    public Map<Integer, Double> getDiscountedFareMap() {
        return this._discountedFareMap;
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

    public int getVerification() {
        return this._verification;
    }

    public boolean isActive() {
        return this._isActive;
    }

    public void setDiscountedFareMap(Map<Integer, Double> map) {
        this._discountedFareMap = map;
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

    public void setVerification(int i) {
        this._verification = i;
    }
}
