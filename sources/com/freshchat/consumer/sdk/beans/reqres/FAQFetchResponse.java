package com.freshchat.consumer.sdk.beans.reqres;

import android.os.Parcel;
import android.os.Parcelable;
import com.freshchat.consumer.sdk.beans.FAQ;
import com.freshchat.consumer.sdk.service.e.ag;

public class FAQFetchResponse extends ag {
    public static final Parcelable.Creator<FAQFetchResponse> CREATOR = new Parcelable.Creator<FAQFetchResponse>() {
        /* class com.freshchat.consumer.sdk.beans.reqres.FAQFetchResponse.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public FAQFetchResponse createFromParcel(Parcel parcel) {
            return new FAQFetchResponse(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public FAQFetchResponse[] newArray(int i) {
            return new FAQFetchResponse[i];
        }
    };
    private FAQ faq;

    public FAQFetchResponse() {
    }

    public FAQFetchResponse(Parcel parcel) {
        super(parcel);
        this.faq = (FAQ) parcel.readParcelable(FAQ.class.getClassLoader());
    }

    @Override // com.freshchat.consumer.sdk.service.e.ag
    public int describeContents() {
        return 0;
    }

    public FAQ getFaq() {
        return this.faq;
    }

    public void setFaq(FAQ faq2) {
        this.faq = faq2;
    }

    @Override // com.freshchat.consumer.sdk.service.e.ag
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.faq, i);
    }
}
