package defpackage;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* renamed from: xf3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final /* synthetic */ class xf3 implements gg3 {
    public static final gg3 f = new xf3();

    @Override // defpackage.gg3
    public final Object get() {
        eg3 eg3;
        Context context = yf3.g;
        eg3 eg32 = dg3.f;
        String str = Build.TYPE;
        String str2 = Build.TAGS;
        String str3 = Build.HARDWARE;
        if (!((str.equals("eng") || str.equals("userdebug")) && (str3.equals("goldfish") || str3.equals("ranchu") || str3.equals("robolectric")) && (str2.contains("dev-keys") || str2.contains("test-keys")))) {
            return eg32;
        }
        if (if3.a() && !context.isDeviceProtectedStorage()) {
            context = context.createDeviceProtectedStorageContext();
        }
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            StrictMode.allowThreadDiskWrites();
            try {
                File file = new File(context.getDir("phenotype_hermetic", 0), "overrides.txt");
                eg3 = file.exists() ? new fg3(file) : eg32;
            } catch (RuntimeException unused) {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                eg3 = eg32;
            }
            if (!eg3.b()) {
                return eg32;
            }
            File file2 = (File) eg3.a();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
                try {
                    HashMap hashMap = new HashMap();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            String[] split = readLine.split(" ", 3);
                            if (split.length == 3) {
                                String str4 = split[0];
                                String decode = Uri.decode(split[1]);
                                String decode2 = Uri.decode(split[2]);
                                if (!hashMap.containsKey(str4)) {
                                    hashMap.put(str4, new HashMap());
                                }
                                ((Map) hashMap.get(str4)).put(decode, decode2);
                            } else if (readLine.length() != 0) {
                                "Invalid: ".concat(readLine);
                            } else {
                                new String("Invalid: ");
                            }
                        } else {
                            String.valueOf(file2).length();
                            uf3 uf3 = new uf3(hashMap);
                            bufferedReader.close();
                            return new fg3(uf3);
                        }
                    }
                } catch (Throwable th) {
                    jg3.f1922a.a(th, th);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
        throw th;
    }
}
