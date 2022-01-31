package app.zophop.models;

public class OrderStatus {
    private int count;
    private String orderId;

    public OrderStatus(String str, int i) {
        this.orderId = str;
        this.count = i;
    }

    public int getCount() {
        return this.count;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }
}
