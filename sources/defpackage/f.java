package defpackage;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;

/* renamed from: f  reason: default package */
/* compiled from: kotlin-style lambda group */
public final class f extends o86 implements h76<Paint> {
    public static final f g = new f(0);
    public static final f h = new f(1);
    public final /* synthetic */ int f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(int i) {
        super(0);
        this.f = i;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.h76
    public final Paint invoke() {
        int i = this.f;
        if (i == 0) {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.SRC_IN));
            return paint;
        } else if (i == 1) {
            Paint paint2 = new Paint();
            paint2.setColor(-16777216);
            paint2.setStyle(Paint.Style.FILL);
            return paint2;
        } else {
            throw null;
        }
    }
}
