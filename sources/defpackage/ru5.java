package defpackage;

import android.content.ContentValues;
import java.util.Objects;
import java.util.Set;

/* renamed from: ru5  reason: default package */
/* compiled from: Inbox */
public class ru5 implements Runnable {
    public final /* synthetic */ Set f;
    public final /* synthetic */ qu5 g;

    public ru5(qu5 qu5, Set set) {
        this.g = qu5;
        this.f = set;
    }

    public void run() {
        bv5 bv5 = this.g.f;
        Set<String> set = this.f;
        Objects.requireNonNull(bv5);
        ContentValues contentValues = new ContentValues();
        contentValues.put("deleted", Boolean.TRUE);
        bv5.h(set, contentValues);
    }
}
