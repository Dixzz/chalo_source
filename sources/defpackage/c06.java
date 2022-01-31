package defpackage;

import android.content.Context;
import java.io.File;
import java.util.Collection;

/* renamed from: c06  reason: default package */
/* compiled from: Kit */
public abstract class c06<Result> implements Comparable<c06> {
    public Context context;
    public final u06 dependsOnAnnotation = ((u06) getClass().getAnnotation(u06.class));
    public xz5 fabric;
    public o06 idManager;
    public zz5<Result> initializationCallback;
    public b06<Result> initializationTask = new b06<>(this);

    public boolean containsAnnotatedDependency(c06 c06) {
        if (hasAnnotatedDependency()) {
            for (Class<?> cls : this.dependsOnAnnotation.value()) {
                if (cls.isAssignableFrom(c06.getClass())) {
                    return true;
                }
            }
        }
        return false;
    }

    public abstract Result doInBackground();

    public Context getContext() {
        return this.context;
    }

    public Collection<a16> getDependencies() {
        return this.initializationTask.getDependencies();
    }

    public xz5 getFabric() {
        return this.fabric;
    }

    public o06 getIdManager() {
        return this.idManager;
    }

    public abstract String getIdentifier();

    public String getPath() {
        StringBuilder i0 = hj1.i0(".Fabric");
        i0.append(File.separator);
        i0.append(getIdentifier());
        return i0.toString();
    }

    public abstract String getVersion();

    public boolean hasAnnotatedDependency() {
        return this.dependsOnAnnotation != null;
    }

    public final void initialize() {
        throw null;
    }

    public void injectParameters(Context context2, xz5 xz5, zz5<Result> zz5, o06 o06) {
        this.context = new yz5(context2, getIdentifier(), getPath());
        this.initializationCallback = zz5;
    }

    public void onCancelled(Result result) {
    }

    public void onPostExecute(Result result) {
    }

    public boolean onPreExecute() {
        return true;
    }

    public int compareTo(c06 c06) {
        if (containsAnnotatedDependency(c06)) {
            return 1;
        }
        if (c06.containsAnnotatedDependency(this)) {
            return -1;
        }
        if (hasAnnotatedDependency() && !c06.hasAnnotatedDependency()) {
            return 1;
        }
        if (hasAnnotatedDependency() || !c06.hasAnnotatedDependency()) {
            return 0;
        }
        return -1;
    }
}
