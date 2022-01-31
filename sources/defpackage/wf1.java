package defpackage;

import android.os.Handler;
import android.os.Message;

/* renamed from: wf1  reason: default package */
/* compiled from: PickerActivity */
public class wf1 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ vf1 f3770a;

    public wf1(vf1 vf1) {
        this.f3770a = vf1;
    }

    public void handleMessage(Message message) {
        if (message.what == 1) {
            this.f3770a.o0(message.getData().getString("bundle:queryString"));
        }
    }
}
