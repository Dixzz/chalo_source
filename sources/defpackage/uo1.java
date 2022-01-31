package defpackage;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* renamed from: uo1  reason: default package */
/* compiled from: GlideExecutor */
public final class uo1 implements FilenameFilter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Pattern f3532a;

    public uo1(Pattern pattern) {
        this.f3532a = pattern;
    }

    public boolean accept(File file, String str) {
        return this.f3532a.matcher(str).matches();
    }
}
