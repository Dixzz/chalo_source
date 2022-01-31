package com.freshchat.consumer.sdk.beans.fragment;

public class CallbackButtonFragment extends MessageFragment {
    private String label;
    private String payload;

    public CallbackButtonFragment() {
        super(FragmentType.CALLBACK_BUTTON.asInt());
    }

    public String getLabel() {
        return this.label;
    }

    public String getPayload() {
        return this.payload;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setPayload(String str) {
        this.payload = str;
    }

    @Override // com.freshchat.consumer.sdk.beans.fragment.MessageFragment
    public String toString() {
        StringBuilder i0 = hj1.i0("CallbackButtonFragment{content='");
        i0.append(getContent());
        i0.append('\'');
        i0.append(", contentType='");
        i0.append(getContentType());
        i0.append('\'');
        i0.append(", fragmentType=");
        i0.append(getFragmentType());
        i0.append(", label='");
        hj1.U0(i0, this.label, '\'', ", payload='");
        i0.append(this.payload);
        i0.append('\'');
        i0.append('}');
        return i0.toString();
    }
}
