package defpackage;

import java.io.File;
import java.util.Objects;

/* JADX WARN: Incorrect class signature, class is equals to this class: Lwq1<Ljava/io/File;>; */
/* renamed from: wq1  reason: default package */
/* compiled from: FileResource */
public class wq1 implements rn1 {
    public final T f;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.io.File */
    /* JADX WARN: Multi-variable type inference failed */
    public wq1(File file) {
        Objects.requireNonNull(file, "Argument must not be null");
        this.f = file;
    }

    @Override // defpackage.rn1
    public void a() {
    }

    @Override // defpackage.rn1
    public final /* bridge */ /* synthetic */ int b() {
        return 1;
    }

    @Override // defpackage.rn1
    public Class c() {
        return this.f.getClass();
    }

    @Override // defpackage.rn1
    public final Object get() {
        return this.f;
    }
}
