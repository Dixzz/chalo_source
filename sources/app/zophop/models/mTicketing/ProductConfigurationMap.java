package app.zophop.models.mTicketing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductConfigurationMap {
    private Map<String, List<ProductConfiguration>> _productConfigMap;

    public ProductConfigurationMap() {
        this._productConfigMap = new HashMap();
    }

    public void addConfiguration(String str, ProductConfiguration productConfiguration) {
        List<ProductConfiguration> list;
        if (getProductConfigMap() == null) {
            this._productConfigMap = new HashMap();
        }
        if (!getProductConfigMap().containsKey(str)) {
            list = new ArrayList<>();
        } else {
            list = getProductConfigMap().get(str);
        }
        list.add(productConfiguration);
        getProductConfigMap().put(str, list);
    }

    public Map<String, List<ProductConfiguration>> getProductConfigMap() {
        return this._productConfigMap;
    }

    public List<ProductConfiguration> getProductConfiguration(String str) {
        if (getProductConfigMap() == null || !getProductConfigMap().containsKey(str)) {
            return null;
        }
        return getProductConfigMap().get(str);
    }

    public void setProductConfigMap(Map<String, List<ProductConfiguration>> map) {
        this._productConfigMap = map;
    }

    public ProductConfigurationMap(Map<String, List<ProductConfiguration>> map) {
        if (this._productConfigMap == null) {
            this._productConfigMap = new HashMap();
        }
        this._productConfigMap = map;
    }
}
