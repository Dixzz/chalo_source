package app.zophop.models.SocketModels;

public class RetryPolicy {
    private float backoffMultiplier;
    private int maxRetries;
    private int timeout;

    public RetryPolicy(int i, int i2, float f) {
        this.timeout = i;
        this.maxRetries = i2;
        this.backoffMultiplier = f;
    }

    public float getBackoffMultiplier() {
        return this.backoffMultiplier;
    }

    public int getMaxRetries() {
        return this.maxRetries;
    }

    public int getTimeout() {
        return this.timeout;
    }
}
