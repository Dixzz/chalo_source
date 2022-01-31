package defpackage;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: jo6  reason: default package */
/* compiled from: ReLinkerInstance */
public class jo6 implements FilenameFilter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1963a;

    public jo6(io6 io6, String str) {
        this.f1963a = str;
    }

    public boolean accept(File file, String str) {
        return str.startsWith(this.f1963a);
    }
}
