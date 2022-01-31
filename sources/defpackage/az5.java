package defpackage;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/* renamed from: az5  reason: default package */
/* compiled from: PropertiesConfigParser */
public class az5 implements iy5 {

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f356a;
    public final Map<String, String> b;
    public final Context c;

    public az5(Context context, List<String> list, Map<String, String> map) {
        this.c = context;
        this.f356a = list;
        this.b = map;
    }

    public static az5 a(Context context, String str) throws IOException {
        AssetManager assets = context.getResources().getAssets();
        String[] list = assets.list("");
        if (list == null || !Arrays.asList(list).contains(str)) {
            throw new FileNotFoundException(hj1.S("Unable to find properties file: ", str));
        }
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = assets.open(str);
            properties.load(inputStream);
            az5 b2 = b(context, properties);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    yj5.b(e, "Failed to close input stream.", new Object[0]);
                }
            }
            return b2;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    yj5.b(e2, "Failed to close input stream.", new Object[0]);
                }
            }
            throw th;
        }
    }

    public static az5 b(Context context, Properties properties) {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        for (String str : properties.stringPropertyNames()) {
            String property = properties.getProperty(str);
            if (property != null) {
                property = property.trim();
            }
            if (!hd3.G1(property)) {
                arrayList.add(str);
                hashMap.put(str, property);
            }
        }
        return new az5(context, arrayList, hashMap);
    }

    public boolean c(String str, boolean z) {
        String str2 = this.b.get(str);
        if (hd3.G1(str2)) {
            return z;
        }
        return Boolean.parseBoolean(str2);
    }

    public int d(String str, int i) {
        String str2 = this.b.get(str);
        if (hd3.G1(str2)) {
            return i;
        }
        return Color.parseColor(str2);
    }

    public int e() {
        return this.f356a.size();
    }

    public int f(String str) {
        return this.c.getResources().getIdentifier(this.b.get(str), "drawable", this.c.getPackageName());
    }

    public int g(String str, int i) {
        String str2 = this.b.get(str);
        if (hd3.G1(str2)) {
            return i;
        }
        return Integer.parseInt(str2);
    }

    public long h(String str, long j) {
        String str2 = this.b.get(str);
        if (hd3.G1(str2)) {
            return j;
        }
        return Long.parseLong(str2);
    }

    public String i(int i) {
        return this.f356a.get(i);
    }

    public String j(String str, String str2) {
        String str3 = this.b.get(str);
        return str3 == null ? str2 : str3;
    }

    public String[] k(String str) {
        String str2 = this.b.get(str);
        if (str2 == null) {
            return new String[0];
        }
        return str2.split("[, ]+");
    }
}
