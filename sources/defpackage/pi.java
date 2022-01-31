package defpackage;

import java.io.File;
import java.io.FileFilter;

/* renamed from: pi  reason: default package */
/* compiled from: MultiDexExtractor */
public class pi implements FileFilter {
    public pi(qi qiVar) {
    }

    public boolean accept(File file) {
        return !file.getName().equals("MultiDex.lock");
    }
}
