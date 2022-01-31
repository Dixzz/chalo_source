package defpackage;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: jt4  reason: default package */
public final /* synthetic */ class jt4 implements FilenameFilter {

    /* renamed from: a  reason: collision with root package name */
    public final String f1978a;

    public jt4(String str) {
        this.f1978a = str;
    }

    public final boolean accept(File file, String str) {
        return str.startsWith(String.valueOf(this.f1978a).concat("-")) && str.endsWith(".apk");
    }
}
