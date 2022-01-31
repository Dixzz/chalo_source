package defpackage;

import android.content.Context;
import android.util.Base64;
import androidx.recyclerview.widget.RecyclerView;
import com.rabbitmq.client.LongString;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/* renamed from: mt4  reason: default package */
public final class mt4 {

    /* renamed from: a  reason: collision with root package name */
    public static ls4 f2444a;

    public static String a(List<File> list) throws NoSuchAlgorithmException, IOException {
        int read;
        MessageDigest instance = MessageDigest.getInstance("SHA256");
        byte[] bArr = new byte[RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST];
        for (File file : list) {
            FileInputStream fileInputStream = new FileInputStream(file);
            do {
                try {
                    read = fileInputStream.read(bArr);
                    if (read > 0) {
                        instance.update(bArr, 0, read);
                    }
                } catch (Throwable th) {
                    jw4.f1988a.a(th, th);
                }
            } while (read != -1);
            fileInputStream.close();
        }
        return Base64.encodeToString(instance.digest(), 11);
        throw th;
    }

    public static long b(byte[] bArr, int i) {
        return ((long) ((c(bArr, i + 2) << 16) | c(bArr, i))) & LongString.MAX_LENGTH;
    }

    public static int c(byte[] bArr, int i) {
        return ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
    }

    public static boolean d(int i) {
        return i == 1 || i == 7 || i == 2 || i == 3;
    }

    public static boolean e(int i) {
        return i == 5 || i == 6 || i == 4;
    }

    public static boolean f(int i) {
        return i == 2 || i == 7 || i == 3;
    }

    public static boolean g(int i, int i2) {
        if (i == 5) {
            if (i2 != 5) {
                return true;
            }
            i = 5;
        }
        if (i == 6 && i2 != 6 && i2 != 5) {
            return true;
        }
        if (i == 4 && i2 != 4) {
            return true;
        }
        if (i == 3 && (i2 == 2 || i2 == 7 || i2 == 1 || i2 == 8)) {
            return true;
        }
        if (i == 2) {
            return i2 == 1 || i2 == 8;
        }
        return false;
    }

    public static synchronized ls4 h(Context context) {
        ls4 ls4;
        synchronized (mt4.class) {
            if (f2444a == null) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    context = applicationContext;
                }
                nu4 nu4 = new nu4(context);
                hd3.y1(nu4, nu4.class);
                f2444a = new ls4(nu4);
            }
            ls4 = f2444a;
        }
        return ls4;
    }
}
