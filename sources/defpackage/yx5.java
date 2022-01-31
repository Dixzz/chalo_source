package defpackage;

import android.database.Cursor;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

/* renamed from: yx5  reason: default package */
/* compiled from: RemoteData */
public class yx5 implements ox5<sw5<Set<by5>>> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Collection f4097a;
    public final /* synthetic */ wx5 b;

    public yx5(wx5 wx5, Collection collection) {
        this.b = wx5;
        this.f4097a = collection;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.ox5
    public sw5<Set<by5>> apply() {
        Cursor k;
        Set<by5> set;
        cy5 cy5 = this.b.q;
        Collection collection = this.f4097a;
        Objects.requireNonNull(cy5);
        Cursor cursor = null;
        if (collection == null) {
            try {
                k = cy5.k("payloads", null, null, null, null);
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        } else {
            k = cy5.k("payloads", null, "type IN ( " + hd3.D2("?", collection.size(), ", ") + " )", (String[]) collection.toArray(new String[0]), null);
        }
        if (k == null) {
            set = Collections.emptySet();
            if (k != null) {
            }
            return sw5.e(set).h(new jx5(this.b.g.getLooper()));
        }
        set = cy5.m(k);
        k.close();
        return sw5.e(set).h(new jx5(this.b.g.getLooper()));
    }
}
