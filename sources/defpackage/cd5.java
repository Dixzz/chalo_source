package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/* renamed from: cd5  reason: default package */
/* compiled from: SharedPreferencesLoader */
public class cd5 {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f552a = Executors.newSingleThreadExecutor();

    /* renamed from: cd5$a */
    /* compiled from: SharedPreferencesLoader */
    public static class a implements Callable<SharedPreferences> {
        public final Context f;
        public final String g;
        public final b h;

        public a(Context context, String str, b bVar) {
            this.f = context;
            this.g = str;
            this.h = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public SharedPreferences call() throws Exception {
            SharedPreferences sharedPreferences = this.f.getSharedPreferences(this.g, 0);
            b bVar = this.h;
            if (bVar != null) {
                mc5 mc5 = (mc5) bVar;
                Integer num = xc5.p;
                String string = sharedPreferences.getString("people_distinct_id", null);
                if (string != null) {
                    nc5.b(mc5.f2354a, string);
                }
            }
            return sharedPreferences;
        }
    }

    /* renamed from: cd5$b */
    /* compiled from: SharedPreferencesLoader */
    public interface b {
    }

    public Future<SharedPreferences> a(Context context, String str, b bVar) {
        FutureTask futureTask = new FutureTask(new a(context, str, bVar));
        this.f552a.execute(futureTask);
        return futureTask;
    }
}
