package androidx.lifecycle;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import defpackage.ch;
import defpackage.zg;
import java.util.Objects;

public class ProcessLifecycleOwnerInitializer extends ContentProvider {
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        Context context = getContext();
        if (!ch.f564a.getAndSet(true)) {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new ch.a());
        }
        Context context2 = getContext();
        th thVar = th.n;
        Objects.requireNonNull(thVar);
        thVar.j = new Handler();
        thVar.k.e(zg.a.ON_CREATE);
        ((Application) context2.getApplicationContext()).registerActivityLifecycleCallbacks(new uh(thVar));
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
