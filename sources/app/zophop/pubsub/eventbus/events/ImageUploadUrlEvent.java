package app.zophop.pubsub.eventbus.events;

public class ImageUploadUrlEvent {
    public final String configRequestId;
    public String errorReason;
    public final String imageUrl;
    public final String localImageUri;
    public final int picNo;
    public final String proofId;
    public long responseTime;
    public ad1 responseType;

    public ImageUploadUrlEvent(String str, String str2, int i) {
        this.imageUrl = str;
        this.configRequestId = str2;
        this.picNo = i;
        this.proofId = "";
        this.localImageUri = "";
    }

    public String getConfigRequestId() {
        return this.configRequestId;
    }

    public String getFailureReason() {
        return this.errorReason;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getLocalImageUri() {
        return this.localImageUri;
    }

    public int getPicNo() {
        return this.picNo;
    }

    public String getProofId() {
        return this.proofId;
    }

    public long getResponseTime() {
        return this.responseTime;
    }

    public ad1 getResponseType() {
        return this.responseType;
    }

    public void setFailureReason(String str) {
        this.errorReason = str;
    }

    public void setResponseTime(long j) {
        this.responseTime = j;
    }

    public void setResponseType(ad1 ad1) {
        this.responseType = ad1;
    }

    public ImageUploadUrlEvent(String str, String str2, String str3, String str4) {
        this.localImageUri = str2;
        this.imageUrl = str;
        this.configRequestId = str3;
        this.picNo = 0;
        this.proofId = str4;
    }
}
