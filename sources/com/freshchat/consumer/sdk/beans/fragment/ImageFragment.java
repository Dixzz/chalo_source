package com.freshchat.consumer.sdk.beans.fragment;

public class ImageFragment extends MessageFragment {
    private int height;
    private Thumbnail thumbnail;
    private int width;

    public ImageFragment() {
        super(FragmentType.IMAGE.asInt());
    }

    public int getHeight() {
        return this.height;
    }

    public Thumbnail getThumbnail() {
        return this.thumbnail;
    }

    public int getWidth() {
        return this.width;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setThumbnail(Thumbnail thumbnail2) {
        this.thumbnail = thumbnail2;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    @Override // com.freshchat.consumer.sdk.beans.fragment.MessageFragment
    public String toString() {
        StringBuilder i0 = hj1.i0("ImageFragment{height=");
        i0.append(this.height);
        i0.append(", width=");
        i0.append(this.width);
        i0.append(", thumbnail=");
        i0.append(this.thumbnail);
        i0.append("} ");
        i0.append(super.toString());
        return i0.toString();
    }
}
