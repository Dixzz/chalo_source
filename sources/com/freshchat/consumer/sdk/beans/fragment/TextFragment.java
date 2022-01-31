package com.freshchat.consumer.sdk.beans.fragment;

import com.freshchat.consumer.sdk.j.as;

public class TextFragment extends MessageFragment {
    public TextFragment() {
        super(FragmentType.TEXT.asInt());
    }

    @Override // com.freshchat.consumer.sdk.beans.fragment.MessageFragment
    public String getContent() {
        String content = super.getContent();
        return as.a(content) ? content.replaceAll("\n", "<br>") : content;
    }

    @Override // com.freshchat.consumer.sdk.beans.fragment.MessageFragment
    public String toString() {
        StringBuilder i0 = hj1.i0("TextFragment{} ");
        i0.append(super.toString());
        return i0.toString();
    }
}
