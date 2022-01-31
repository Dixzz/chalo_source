package app.zophop.models.mTicketing;

public class ProductDisplayProps {
    private int displayOrder;
    private String getProductCategoryName;
    private String productCategoryId;

    public int getDisplayOrder() {
        return this.displayOrder;
    }

    public String getProductCategoryId() {
        return this.productCategoryId;
    }

    public String getProductCategoryName() {
        return this.getProductCategoryName;
    }

    public void setDisplayOrder(int i) {
        this.displayOrder = i;
    }

    public void setProductCategoryId(String str) {
        this.productCategoryId = str;
    }

    public void setProductCategoryName(String str) {
        this.getProductCategoryName = str;
    }
}
