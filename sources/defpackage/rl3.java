package defpackage;

import java.util.HashMap;
import java.util.Map;

/* renamed from: rl3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class rl3 {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f3094a;
    public static final Map<String, Integer> b;

    static {
        String[] strArr = {"text1", "text2", "icon", "intent_action", "intent_data", "intent_data_id", "intent_extra_data", "suggest_large_icon", "intent_activity", "thing_proto"};
        f3094a = strArr;
        b = new HashMap(strArr.length);
        int i = 0;
        while (true) {
            String[] strArr2 = f3094a;
            if (i < strArr2.length) {
                b.put(strArr2[i], Integer.valueOf(i));
                i++;
            } else {
                return;
            }
        }
    }

    public static String a(int i) {
        if (i < 0) {
            return null;
        }
        String[] strArr = f3094a;
        if (i >= strArr.length) {
            return null;
        }
        return strArr[i];
    }
}
