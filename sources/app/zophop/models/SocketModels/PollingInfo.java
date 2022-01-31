package app.zophop.models.SocketModels;

public class PollingInfo {
    private int pollingFrequency;
    private boolean pollingStatus;
    private double randomizationFactor;
    private int resyncFrequency;
    private RetryPolicy retryPolicy;

    public PollingInfo(boolean z) {
        this.pollingStatus = z;
    }

    public int getPollingFrequency() {
        return this.pollingFrequency;
    }

    public double getRandomizationFactor() {
        return this.randomizationFactor;
    }

    public int getResyncFrequency() {
        return this.resyncFrequency;
    }

    public RetryPolicy getRetryPolicy() {
        return this.retryPolicy;
    }

    public boolean isPollingStatus() {
        return this.pollingStatus;
    }

    public void setPollingFrequency(int i) {
        this.pollingFrequency = i;
    }

    public void setRandomizationFactor(double d) {
        this.randomizationFactor = d;
    }

    public void setResyncFrequency(int i) {
        this.resyncFrequency = i;
    }

    public void setRetryPolicy(RetryPolicy retryPolicy2) {
        this.retryPolicy = retryPolicy2;
    }
}
