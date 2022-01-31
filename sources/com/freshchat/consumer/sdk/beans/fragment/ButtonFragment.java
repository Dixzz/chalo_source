package com.freshchat.consumer.sdk.beans.fragment;

public class ButtonFragment extends MessageFragment {
    private String androidUri;
    private String iosUri;
    private String label;

    public ButtonFragment() {
        super(FragmentType.BUTTON.asInt());
    }

    public String getAndroidUri() {
        return this.androidUri;
    }

    public String getIosUri() {
        return this.iosUri;
    }

    public String getLabel() {
        return this.label;
    }

    public void setAndroidUri(String str) {
        this.androidUri = str;
    }

    public void setIosUri(String str) {
        this.iosUri = str;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    @Override // com.freshchat.consumer.sdk.beans.fragment.MessageFragment
    public String toString() {
        StringBuilder i0 = hj1.i0("ButtonFragment{label='");
        hj1.U0(i0, this.label, '\'', ", androidUri='");
        hj1.U0(i0, this.androidUri, '\'', ", iosUri='");
        hj1.U0(i0, this.iosUri, '\'', "} ");
        i0.append(super.toString());
        return i0.toString();
    }
}
