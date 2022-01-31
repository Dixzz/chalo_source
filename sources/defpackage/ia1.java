package defpackage;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import app.zophop.R;
import app.zophop.service.LocationTrackingService;

/* renamed from: ia1  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ia1 implements View.OnClickListener {
    public final /* synthetic */ pa1 f;

    public /* synthetic */ ia1(pa1 pa1) {
        this.f = pa1;
    }

    public final void onClick(View view) {
        pa1 pa1 = this.f;
        n86.e(pa1, "this$0");
        if (LocationTrackingService.q) {
            pa1.b.f.b.setImageResource(R.drawable.audio_mute);
            Context context = pa1.f2788a;
            Toast.makeText(context, context.getString(R.string.audio_off), 0).show();
            LocationTrackingService.q = false;
        } else {
            pa1.b.f.b.setImageResource(R.drawable.audio_on);
            Context context2 = pa1.f2788a;
            Toast.makeText(context2, context2.getString(R.string.audio_on), 0).show();
            LocationTrackingService.q = true;
        }
        ed1 ed1 = new ed1("audio mode changed", 86400000);
        ed1.a("audioMode", String.valueOf(LocationTrackingService.q));
        jz5.b().g(ed1);
    }
}
