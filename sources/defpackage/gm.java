package defpackage;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: gm  reason: default package */
/* compiled from: CopyLock */
public class gm {
    public static final Map<String, Lock> e = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public final File f1280a;
    public final Lock b;
    public final boolean c;
    public FileChannel d;

    public gm(String str, File file, boolean z) {
        Lock lock;
        File file2 = new File(file, hj1.S(str, ".lck"));
        this.f1280a = file2;
        String absolutePath = file2.getAbsolutePath();
        Map<String, Lock> map = e;
        synchronized (map) {
            lock = map.get(absolutePath);
            if (lock == null) {
                lock = new ReentrantLock();
                map.put(absolutePath, lock);
            }
        }
        this.b = lock;
        this.c = z;
    }

    public void a() {
        FileChannel fileChannel = this.d;
        if (fileChannel != null) {
            try {
                fileChannel.close();
            } catch (IOException unused) {
            }
        }
        this.b.unlock();
    }
}
