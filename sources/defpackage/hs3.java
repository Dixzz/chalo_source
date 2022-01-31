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

/* renamed from: hs3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final /* synthetic */ class hs3 implements ws3 {
    public final Context f;

    public hs3(Context context) {
        this.f = context;
    }

    @Override // defpackage.ws3
    public final Object zza() {
        us3 us3;
        Context context = this.f;
        us3 us32 = ts3.f;
        String str = Build.TYPE;
        String str2 = Build.TAGS;
        if (!((str.equals("eng") || str.equals("userdebug")) && (str2.contains("dev-keys") || str2.contains("test-keys")))) {
            return us32;
        }
        if (tr3.a() && !context.isDeviceProtectedStorage()) {
            context = context.createDeviceProtectedStorageContext();
        }
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            StrictMode.allowThreadDiskWrites();
            try {
                File file = new File(context.getDir("phenotype_hermetic", 0), "overrides.txt");
                us3 = file.exists() ? new vs3(file) : us32;
            } catch (RuntimeException unused) {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                us3 = us32;
            }
            if (!us3.b()) {
                return us32;
            }
            File file2 = (File) us3.c();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
                try {
                    HashMap hashMap = new HashMap();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            String[] split = readLine.split(" ", 3);
                            if (split.length == 3) {
                                String str3 = split[0];
                                String decode = Uri.decode(split[1]);
                                String decode2 = Uri.decode(split[2]);
                                if (!hashMap.containsKey(str3)) {
                                    hashMap.put(str3, new HashMap());
                                }
                                ((Map) hashMap.get(str3)).put(decode, decode2);
                            } else if (readLine.length() != 0) {
                                "Invalid: ".concat(readLine);
                            } else {
                                new String("Invalid: ");
                            }
                        } else {
                            String.valueOf(file2).length();
                            es3 es3 = new es3(hashMap);
                            bufferedReader.close();
                            return new vs3(es3);
                        }
                    }
                } catch (Throwable th) {
                    dt3.f887a.a(th, th);
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
