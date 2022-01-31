package com.freshchat.consumer.sdk.beans.fragment;

import com.freshchat.consumer.sdk.j.ab;

public class CarouselCardDefaultFragment extends TemplateFragment {
    @ab.c
    private boolean selected = false;

    public CarouselCardDefaultFragment() {
        super(TemplateType.CAROUSEL_CARD_DEFAULT.asString());
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(boolean z) {
        this.selected = z;
    }

    @Override // com.freshchat.consumer.sdk.beans.fragment.TemplateFragment, com.freshchat.consumer.sdk.beans.fragment.MessageFragment
    public String toString() {
        StringBuilder i0 = hj1.i0("CarouselCardDefaultFragment{messageFragment='");
        hj1.U0(i0, super.toString(), '\'', ", selected=");
        i0.append(this.selected);
        i0.append('}');
        return i0.toString();
    }
}
