package app.zophop.models.mTicketing;

import app.zophop.models.ProductGroup;
import defpackage.ut;
import java.util.List;
import java.util.Map;

public class ProductConfiguration {
    private ProductBranding _branding;
    private CardRechargeFareInfo _cardRechargeFareInfo;
    private String _inactiveReason;
    private boolean _isActive;
    private boolean _isVisible;
    private int _maxAppVer;
    private int _minAppVer;
    private long _productActiveDuration;
    private String _productAdditionalInfo;
    private String _productAgency;
    private List<ProductCategory> _productCategoryList;
    private String _productCity;
    private String _productDesc;
    private List<ProductDuration> _productDurations;
    private Map<String, List<ProductFareMapping>> _productFareMapping;
    private String _productIcon;
    private String _productId;
    private String _productLabel;
    private String _productName;
    private int _productPriority;
    private String _productSubType;
    private Map<String, ProductSubCategory> _productSubcategoryMap;
    private List<String> _productTerms;
    private String _productType;
    private long _productValidity;
    private String _rechargeDelayCopy;
    private boolean _shouldHideSubCategorySelection;
    private SubCategorySelectionDetails _subCategorySelectionDetails;

    public ProductBranding getBranding() {
        return this._branding;
    }

    public CardRechargeFareInfo getCardRechargeFareInfo() {
        return this._cardRechargeFareInfo;
    }

    public String getInactiveReason() {
        return this._inactiveReason;
    }

    public boolean getIsActive() {
        return this._isActive;
    }

    public boolean getIsVisible() {
        return this._isVisible;
    }

    public int getMaxAppVer() {
        return this._maxAppVer;
    }

    public int getMinAppVer() {
        return this._minAppVer;
    }

    public long getProductActiveDuration() {
        return this._productActiveDuration;
    }

    public String getProductAdditionalInfo() {
        return this._productAdditionalInfo;
    }

    public String getProductAgency() {
        return this._productAgency;
    }

    public List<ProductCategory> getProductCategoryList() {
        return this._productCategoryList;
    }

    public String getProductCity() {
        return this._productCity;
    }

    public String getProductDesc() {
        return this._productDesc;
    }

    public List<ProductDuration> getProductDurations() {
        return this._productDurations;
    }

    public Map<String, List<ProductFareMapping>> getProductFareMapping() {
        return this._productFareMapping;
    }

    public ProductGroup getProductGroup() {
        if ("singleJourneyTicket".equalsIgnoreCase(getProductType())) {
            return ProductGroup.TICKET;
        }
        if ("cardRecharge".equalsIgnoreCase(getProductType())) {
            return ProductGroup.CARDRECHARGE;
        }
        return ProductGroup.LONGTERM;
    }

    public String getProductId() {
        return this._productId;
    }

    public String getProductLabel() {
        return this._productLabel;
    }

    public String getProductLogo() {
        return this._productIcon;
    }

    public String getProductName() {
        return this._productName;
    }

    public int getProductPriority() {
        return this._productPriority;
    }

    public String getProductSubType() {
        return this._productSubType;
    }

    public Map<String, ProductSubCategory> getProductSubcategoryMap() {
        return this._productSubcategoryMap;
    }

    public List<String> getProductTerms() {
        return this._productTerms;
    }

    public String getProductType() {
        return this._productType;
    }

    public long getProductValidity() {
        return this._productValidity;
    }

    public String getRechargeDelayCopy() {
        return this._rechargeDelayCopy;
    }

    public SubCategorySelectionDetails getSubCategorySelectionDetails() {
        return this._subCategorySelectionDetails;
    }

    public boolean isProductConfigSupportedOnCurrentAppVersion() {
        ut.a aVar = ut.f3552a;
        if (764 < this._minAppVer) {
            return false;
        }
        int i = this._maxAppVer;
        if (i != -1 && 764 > i) {
            return false;
        }
        return true;
    }

    public void setBranding(ProductBranding productBranding) {
        this._branding = productBranding;
    }

    public void setCardRechargeFareInfo(CardRechargeFareInfo cardRechargeFareInfo) {
        this._cardRechargeFareInfo = cardRechargeFareInfo;
    }

    public void setIsActive(boolean z) {
        this._isActive = z;
    }

    public void setIsVisible(boolean z) {
        this._isVisible = z;
    }

    public void setMaxAppVer(int i) {
        this._maxAppVer = i;
    }

    public void setMinAppVer(int i) {
        this._minAppVer = i;
    }

    public void setProductActiveDuration(long j) {
        this._productActiveDuration = j;
    }

    public void setProductAdditionalInfo(String str) {
        this._productAdditionalInfo = str;
    }

    public void setProductAgency(String str) {
        this._productAgency = str;
    }

    public void setProductCategoryList(List<ProductCategory> list) {
        this._productCategoryList = list;
    }

    public void setProductCity(String str) {
        this._productCity = str;
    }

    public void setProductDesc(String str) {
        this._productDesc = str;
    }

    public void setProductDurationList(List<ProductDuration> list) {
        this._productDurations = list;
    }

    public void setProductFareMapping(Map<String, List<ProductFareMapping>> map) {
        this._productFareMapping = map;
    }

    public void setProductIcon(String str) {
        this._productIcon = str;
    }

    public void setProductId(String str) {
        this._productId = str;
    }

    public void setProductLabel(String str) {
        this._productLabel = str;
    }

    public void setProductName(String str) {
        this._productName = str;
    }

    public void setProductPriority(int i) {
        this._productPriority = i;
    }

    public void setProductSubType(String str) {
        this._productSubType = str;
    }

    public void setProductSubcategoryMap(Map<String, ProductSubCategory> map) {
        this._productSubcategoryMap = map;
    }

    public void setProductTerms(List<String> list) {
        this._productTerms = list;
    }

    public void setProductType(String str) {
        this._productType = str;
    }

    public void setProductValidity(long j) {
        this._productValidity = j;
    }

    public void setRechargeDelayCopy(String str) {
        this._rechargeDelayCopy = str;
    }

    public void setShouldHideSubCategorySelection(boolean z) {
        this._shouldHideSubCategorySelection = z;
    }

    public void setSubCategorySelectionDetails(SubCategorySelectionDetails subCategorySelectionDetails) {
        this._subCategorySelectionDetails = subCategorySelectionDetails;
    }

    public void setinactiveReason(String str) {
        this._inactiveReason = str;
    }

    public boolean shouldHideSubCategorySelection() {
        return this._shouldHideSubCategorySelection;
    }
}
