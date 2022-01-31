package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import defpackage.q5;
import j$.lang.Iterable;
import j$.util.function.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;

/* renamed from: p5  reason: default package */
/* compiled from: TaskStackBuilder */
public final class p5 implements Iterable<Intent>, Iterable {
    public final ArrayList<Intent> f = new ArrayList<>();
    public final Context g;

    /* renamed from: p5$a */
    /* compiled from: TaskStackBuilder */
    public interface a {
        Intent getSupportParentActivityIntent();
    }

    public p5(Context context) {
        this.g = context;
    }

    public p5 b(Intent intent) {
        ComponentName component = intent.getComponent();
        if (component == null) {
            component = intent.resolveActivity(this.g.getPackageManager());
        }
        if (component != null) {
            d(component);
        }
        this.f.add(intent);
        return this;
    }

    public p5 d(ComponentName componentName) {
        int size = this.f.size();
        try {
            Intent S = h.S(this.g, componentName);
            while (S != null) {
                this.f.add(size, S);
                S = h.S(this.g, S.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void e() {
        if (!this.f.isEmpty()) {
            ArrayList<Intent> arrayList = this.f;
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            Context context = this.g;
            Object obj = q5.f2896a;
            q5.a.a(context, intentArr, null);
            return;
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }

    @Override // j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    @Override // j$.lang.Iterable, java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f.iterator();
    }

    /* Return type fixed from 'j$.util.Spliterator' to match base method */
    @Override // j$.lang.Iterable, java.lang.Iterable
    public /* synthetic */ Spliterator<Intent> spliterator() {
        return Iterable.CC.$default$spliterator(this);
    }
}
