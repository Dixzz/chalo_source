package app.zophop.pubsub.eventbus.events;

import app.zophop.models.mTicketing.DocumentProofMap;
import app.zophop.models.mTicketing.ProductConfigurationMap;
import app.zophop.models.mTicketing.ProductDisplayProps;
import java.util.List;

public class ProductConfigurationFetchedEvent {
    private final String _configRequestId;
    private DocumentProofMap _documentProofMap;
    private String _errorMessage;
    private ProductConfigurationMap _productConfigMap;
    private final List<ProductDisplayProps> _productDisplayPropsList;
    private ad1 _responseType;

    public ProductConfigurationFetchedEvent(ad1 ad1, String str, ProductConfigurationMap productConfigurationMap, List<ProductDisplayProps> list, String str2) {
        this._responseType = ad1;
        this._errorMessage = str;
        this._productConfigMap = productConfigurationMap;
        this._configRequestId = str2;
        this._productDisplayPropsList = list;
    }

    public String getConfigRequestId() {
        return this._configRequestId;
    }

    public String getErrorMessage() {
        return this._errorMessage;
    }

    public ProductConfigurationMap getProductConfigMap() {
        return this._productConfigMap;
    }

    public List<ProductDisplayProps> getProductDisplayPropsList() {
        return this._productDisplayPropsList;
    }

    public ad1 getResponseType() {
        return this._responseType;
    }

    public void setBookingConfigMap(ProductConfigurationMap productConfigurationMap) {
        this._productConfigMap = productConfigurationMap;
    }

    public void setErrorMessage(String str) {
        this._errorMessage = str;
    }

    public void setResponseType(ad1 ad1) {
        this._responseType = ad1;
    }
}
