package defpackage;

import android.content.SharedPreferences;
import android.os.Build;
import androidx.fragment.app.FragmentManager;
import com.rabbitmq.client.AMQP;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* renamed from: jh5  reason: default package */
/* compiled from: RequestPermissionHandler.kt */
public final class jh5 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1926a;
    public Set<String> b = new HashSet();
    public final ve c;
    public final a d;

    /* renamed from: jh5$a */
    /* compiled from: RequestPermissionHandler.kt */
    public interface a {
    }

    /* renamed from: jh5$b */
    /* compiled from: RequestPermissionHandler.kt */
    public enum b {
        GRANTED,
        UN_GRANTED,
        TEMPORARY_DENIED,
        PERMANENT_DENIED
    }

    public jh5(ve veVar, a aVar) {
        Set<String> set;
        n86.e(veVar, "activity");
        this.c = veVar;
        this.d = aVar;
        if (Build.VERSION.SDK_INT >= 26) {
            set = y56.t("android.permission.ANSWER_PHONE_CALLS", "android.permission.READ_CALL_LOG", "android.permission.READ_PHONE_STATE");
        } else {
            set = y56.t("android.permission.READ_CALL_LOG", "android.permission.READ_PHONE_STATE", "android.permission.CALL_PHONE");
        }
        this.b = set;
    }

    public final void a(Set<String> set) {
        FragmentManager supportFragmentManager = this.c.getSupportFragmentManager();
        n86.d(supportFragmentManager, "fragmentManager");
        ih5 ih5 = (ih5) supportFragmentManager.I("FragTag");
        if (ih5 == null) {
            ih5 = new ih5();
            ke keVar = new ke(supportFragmentManager);
            keVar.f(0, ih5, "FragTag", 1);
            keVar.c(null);
            keVar.d();
        }
        n86.e(this, "requestPermissionHandler");
        ih5.f = this;
        Object[] array = this.b.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        ih5.g = (String[]) array;
        if (ih5.isAdded()) {
            Object[] array2 = set.toArray(new String[0]);
            Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
            ih5.requestPermissions((String[]) array2, AMQP.REPLY_SUCCESS);
        }
    }

    public final Set<String> b(Set<String> set, b bVar) {
        HashSet hashSet = new HashSet();
        for (String str : set) {
            int ordinal = bVar.ordinal();
            boolean z = false;
            if (ordinal == 0) {
                if (q5.a(this.c, str) == 0) {
                    z = true;
                }
                if (z) {
                    hashSet.add(str);
                }
            } else if (ordinal == 1) {
                if (q5.a(this.c, str) == 0) {
                    z = true;
                }
                if (!z) {
                    hashSet.add(str);
                }
            } else if (ordinal != 2) {
                if (ordinal == 3) {
                    SharedPreferences sharedPreferences = this.c.getSharedPreferences("SHARED_PREFS_RUNTIME_PERMISSION", 0);
                    n86.d(sharedPreferences, "context.getSharedPrefere…N\", Context.MODE_PRIVATE)");
                    if (sharedPreferences.getBoolean(str, false)) {
                        hashSet.add(str);
                    }
                }
            } else if (t4.d(this.c, str)) {
                hashSet.add(str);
            }
        }
        return hashSet;
    }

    public final void c(String str, boolean z) {
        SharedPreferences sharedPreferences = this.c.getSharedPreferences("SHARED_PREFS_RUNTIME_PERMISSION", 0);
        n86.d(sharedPreferences, "context.getSharedPrefere…N\", Context.MODE_PRIVATE)");
        sharedPreferences.edit().putBoolean(str, z).apply();
    }

    public final void d() {
        a aVar = this.d;
        if (aVar != null) {
            b(this.b, b.GRANTED);
            b(this.b, b.UN_GRANTED);
            zg5 zg5 = (zg5) aVar;
            ah5 ah5 = zg5.f;
            ((dh5) ah5.h).a(ah5.d, zg5.f4170a, zg5.b, zg5.c, ah5.j, zg5.d);
        }
    }
}
