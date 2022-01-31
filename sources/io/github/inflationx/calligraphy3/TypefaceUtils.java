package io.github.inflationx.calligraphy3;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import com.rabbitmq.client.ConnectionFactory;
import java.util.HashMap;
import java.util.Map;

public final class TypefaceUtils {
    private static final Map<String, Typeface> sCachedFonts = new HashMap();
    private static final Map<Typeface, CalligraphyTypefaceSpan> sCachedSpans = new HashMap();

    private TypefaceUtils() {
    }

    public static CalligraphyTypefaceSpan getSpan(Typeface typeface) {
        if (typeface == null) {
            return null;
        }
        Map<Typeface, CalligraphyTypefaceSpan> map = sCachedSpans;
        synchronized (map) {
            if (!map.containsKey(typeface)) {
                CalligraphyTypefaceSpan calligraphyTypefaceSpan = new CalligraphyTypefaceSpan(typeface);
                map.put(typeface, calligraphyTypefaceSpan);
                return calligraphyTypefaceSpan;
            }
            return map.get(typeface);
        }
    }

    public static boolean isLoaded(Typeface typeface) {
        return typeface != null && sCachedFonts.containsValue(typeface);
    }

    public static Typeface load(AssetManager assetManager, String str) {
        Typeface typeface;
        Map<String, Typeface> map = sCachedFonts;
        synchronized (map) {
            try {
                if (!map.containsKey(str)) {
                    if (str.startsWith(ConnectionFactory.DEFAULT_VHOST)) {
                        typeface = Typeface.createFromFile(str);
                    } else {
                        typeface = Typeface.createFromAsset(assetManager, str);
                    }
                    map.put(str, typeface);
                    return typeface;
                }
                return map.get(str);
            } catch (Exception unused) {
                sCachedFonts.put(str, null);
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
