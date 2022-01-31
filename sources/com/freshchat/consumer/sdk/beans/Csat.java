package com.freshchat.consumer.sdk.beans;

import com.google.gson.annotations.SerializedName;

public class Csat {
    private long csatId;
    @SerializedName("initiated")
    private long initiatedTime;
    private boolean isMandatory;
    private boolean mobileUserCommentsAllowed;
    private String question;
    private transient CSatStatus status = CSatStatus.NOT_RATED;

    public enum CSatStatus {
        NOT_RATED(0),
        RATED_NOT_UPLOADED(1),
        UPLOADED(2);
        
        private final int intValue;

        private CSatStatus(int i) {
            this.intValue = i;
        }

        public static CSatStatus fromInt(int i) {
            CSatStatus[] values = values();
            for (int i2 = 0; i2 < 3; i2++) {
                CSatStatus cSatStatus = values[i2];
                if (cSatStatus.asInt() == i) {
                    return cSatStatus;
                }
            }
            return NOT_RATED;
        }

        public int asInt() {
            return this.intValue;
        }
    }

    public long getCsatId() {
        return this.csatId;
    }

    public long getInitiatedTime() {
        return this.initiatedTime;
    }

    public String getQuestion() {
        return this.question;
    }

    public CSatStatus getStatus() {
        return this.status;
    }

    public boolean isMandatory() {
        return this.isMandatory;
    }

    public boolean isMobileUserCommentsAllowed() {
        return this.mobileUserCommentsAllowed;
    }

    public void setCsatId(long j) {
        this.csatId = j;
    }

    public void setInitiatedTime(long j) {
        this.initiatedTime = j;
    }

    public void setMandatory(boolean z) {
        this.isMandatory = z;
    }

    public void setMobileUserCommentsAllowed(boolean z) {
        this.mobileUserCommentsAllowed = z;
    }

    public void setQuestion(String str) {
        this.question = str;
    }

    public void setStatus(CSatStatus cSatStatus) {
        this.status = cSatStatus;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Csat{");
        sb.append("csatId=");
        sb.append(this.csatId);
        sb.append(", question='");
        hj1.U0(sb, this.question, '\'', ", mobileUserCommentsAllowed=");
        sb.append(this.mobileUserCommentsAllowed);
        sb.append(", isMandatory=");
        sb.append(this.isMandatory);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(", initiatedTime=");
        sb.append(this.initiatedTime);
        sb.append('}');
        return sb.toString();
    }
}
