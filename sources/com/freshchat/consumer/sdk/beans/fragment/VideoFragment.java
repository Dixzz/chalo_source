package com.freshchat.consumer.sdk.beans.fragment;

public class VideoFragment extends MessageFragment {
    private Thumbnail thumbnail;

    public VideoFragment() {
        super(FragmentType.VIDEO.asInt());
    }

    public Thumbnail getThumbnail() {
        return this.thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail2) {
        this.thumbnail = thumbnail2;
    }

    @Override // com.freshchat.consumer.sdk.beans.fragment.MessageFragment
    public String toString() {
        StringBuilder i0 = hj1.i0("VideoFragment{thumbnail=");
        i0.append(this.thumbnail);
        i0.append("} ");
        i0.append(super.toString());
        return i0.toString();
    }
}
