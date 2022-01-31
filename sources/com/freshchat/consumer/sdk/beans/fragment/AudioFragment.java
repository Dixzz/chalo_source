package com.freshchat.consumer.sdk.beans.fragment;

public class AudioFragment extends MessageFragment {
    private int duration;

    public AudioFragment() {
        super(FragmentType.AUDIO.asInt());
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    @Override // com.freshchat.consumer.sdk.beans.fragment.MessageFragment
    public String toString() {
        StringBuilder i0 = hj1.i0("AudioFragment{duration=");
        i0.append(this.duration);
        i0.append("} ");
        i0.append(super.toString());
        return i0.toString();
    }
}
