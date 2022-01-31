package defpackage;

import androidx.recyclerview.widget.RecyclerView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Objects;
import java.util.Properties;

/* renamed from: bu4  reason: default package */
public final class bu4 {
    public static final nv4 h = new nv4("SliceMetadataManager");

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f476a = new byte[RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST];
    public final bs4 b;
    public final String c;
    public final int d;
    public final long e;
    public final String f;
    public int g;

    public bu4(bs4 bs4, String str, int i, long j, String str2) {
        this.b = bs4;
        this.c = str;
        this.d = i;
        this.e = j;
        this.f = str2;
        this.g = -1;
    }

    public final void a(String str, long j, long j2, int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", "1");
        properties.put("fileName", str);
        properties.put("fileOffset", String.valueOf(j));
        properties.put("remainingBytes", String.valueOf(j2));
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.g));
        FileOutputStream fileOutputStream = new FileOutputStream(m());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            jw4.f1988a.a(th, th);
        }
        throw th;
    }

    public final void b(byte[] bArr, int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", "2");
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.g));
        FileOutputStream fileOutputStream = new FileOutputStream(m());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
            bs4 bs4 = this.b;
            String str = this.c;
            int i2 = this.d;
            long j = this.e;
            String str2 = this.f;
            Objects.requireNonNull(bs4);
            File file = new File(bs4.q(str, i2, j, str2), "checkpoint_ext.dat");
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(bArr);
                fileOutputStream2.close();
                return;
            } catch (Throwable th) {
                jw4.f1988a.a(th, th);
            }
            throw th;
            throw th;
        } catch (Throwable th2) {
            jw4.f1988a.a(th, th2);
        }
    }

    public final void c(int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", "3");
        properties.put("fileOffset", String.valueOf(i().length()));
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.g));
        FileOutputStream fileOutputStream = new FileOutputStream(m());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            jw4.f1988a.a(th, th);
        }
        throw th;
    }

    public final void d(int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", "4");
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.g));
        FileOutputStream fileOutputStream = new FileOutputStream(m());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            jw4.f1988a.a(th, th);
        }
        throw th;
    }

    public final au4 e() throws IOException {
        File p = this.b.p(this.c, this.d, this.e, this.f);
        if (p.exists()) {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(p);
            try {
                properties.load(fileInputStream);
                fileInputStream.close();
                if (properties.getProperty("fileStatus") == null || properties.getProperty("previousChunk") == null) {
                    throw new os4("Slice checkpoint file corrupt.");
                }
                try {
                    int parseInt = Integer.parseInt(properties.getProperty("fileStatus"));
                    String property = properties.getProperty("fileName");
                    long parseLong = Long.parseLong(properties.getProperty("fileOffset", "-1"));
                    long parseLong2 = Long.parseLong(properties.getProperty("remainingBytes", "-1"));
                    int parseInt2 = Integer.parseInt(properties.getProperty("previousChunk"));
                    this.g = Integer.parseInt(properties.getProperty("metadataFileCounter", "0"));
                    return new au4(parseInt, property, parseLong, parseLong2, parseInt2);
                } catch (NumberFormatException e2) {
                    throw new os4("Slice checkpoint file corrupt.", e2);
                }
            } catch (Throwable th) {
                jw4.f1988a.a(th, th);
            }
        } else {
            throw new os4("Slice checkpoint file does not exist.");
        }
        throw th;
    }

    public final void f(byte[] bArr) throws IOException {
        this.g++;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(l(), String.format("%s-LFH.dat", Integer.valueOf(this.g))));
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.close();
                return;
            } catch (Throwable th) {
                jw4.f1988a.a(th, th);
            }
            throw th;
        } catch (IOException e2) {
            throw new os4("Could not write metadata file.", e2);
        }
    }

    public final void g(byte[] bArr, InputStream inputStream) throws IOException {
        this.g++;
        FileOutputStream fileOutputStream = new FileOutputStream(i());
        try {
            fileOutputStream.write(bArr);
            int read = inputStream.read(this.f476a);
            while (read > 0) {
                fileOutputStream.write(this.f476a, 0, read);
                read = inputStream.read(this.f476a);
            }
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            jw4.f1988a.a(th, th);
        }
        throw th;
    }

    public final void h(long j, byte[] bArr, int i, int i2) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(i(), "rw");
        try {
            randomAccessFile.seek(j);
            randomAccessFile.write(bArr, i, i2);
            randomAccessFile.close();
            return;
        } catch (Throwable th) {
            jw4.f1988a.a(th, th);
        }
        throw th;
    }

    public final File i() {
        return new File(l(), String.format("%s-NAM.dat", Integer.valueOf(this.g)));
    }

    public final int j() throws IOException {
        File p = this.b.p(this.c, this.d, this.e, this.f);
        if (!p.exists()) {
            return 0;
        }
        FileInputStream fileInputStream = new FileInputStream(p);
        try {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
            if (Integer.parseInt(properties.getProperty("fileStatus", "-1")) == 4) {
                return -1;
            }
            if (properties.getProperty("previousChunk") != null) {
                return Integer.parseInt(properties.getProperty("previousChunk")) + 1;
            }
            throw new os4("Slice checkpoint file corrupt.");
        } catch (Throwable th) {
            jw4.f1988a.a(th, th);
        }
        throw th;
    }

    public final void k(byte[] bArr, int i) throws IOException {
        this.g++;
        FileOutputStream fileOutputStream = new FileOutputStream(i());
        try {
            fileOutputStream.write(bArr, 0, i);
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            jw4.f1988a.a(th, th);
        }
        throw th;
    }

    public final File l() {
        File q = this.b.q(this.c, this.d, this.e, this.f);
        if (!q.exists()) {
            q.mkdirs();
        }
        return q;
    }

    public final File m() throws IOException {
        File p = this.b.p(this.c, this.d, this.e, this.f);
        p.getParentFile().mkdirs();
        p.createNewFile();
        return p;
    }
}
