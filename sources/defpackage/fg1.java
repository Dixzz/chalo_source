package defpackage;

import android.view.KeyEvent;
import android.widget.TextView;

/* renamed from: fg1  reason: default package */
/* compiled from: FavoriteDialog */
public class fg1 implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ mf1 f1118a;
    public final /* synthetic */ ig1 b;

    public fg1(ig1 ig1, mf1 mf1) {
        this.b = ig1;
        this.f1118a = mf1;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        this.b.a(textView, this.f1118a);
        return true;
    }
}
