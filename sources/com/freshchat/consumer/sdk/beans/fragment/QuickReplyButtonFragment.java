package com.freshchat.consumer.sdk.beans.fragment;

public class QuickReplyButtonFragment extends MessageFragment {
    private String customReplyText;
    private String label;
    private String payload;

    public QuickReplyButtonFragment() {
        super(FragmentType.QUICK_REPLY_BUTTON.asInt());
    }

    public String getCustomReplyText() {
        return this.customReplyText;
    }

    public String getLabel() {
        return this.label;
    }

    public String getPayload() {
        return this.payload;
    }

    public void setCustomReplyText(String str) {
        this.customReplyText = str;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setPayload(String str) {
        this.payload = str;
    }

    @Override // com.freshchat.consumer.sdk.beans.fragment.MessageFragment
    public String toString() {
        StringBuilder i0 = hj1.i0("QuickReplyButtonFragment{messageFragment='");
        hj1.U0(i0, super.toString(), '\'', ", label='");
        hj1.U0(i0, this.label, '\'', ", customReplyText='");
        hj1.U0(i0, this.customReplyText, '\'', ", payload='");
        i0.append(this.payload);
        i0.append('\'');
        i0.append('}');
        return i0.toString();
    }
}
