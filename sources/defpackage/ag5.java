package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* renamed from: ag5  reason: default package */
/* compiled from: Helper */
public class ag5 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f161a;
    public final SharedPreferences b;

    public ag5(Context context) {
        this.f161a = context;
        this.b = context.getSharedPreferences("trill_sdk_data_3stream", 0);
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (char c : charArray) {
            if (!z || !Character.isLetter(c)) {
                if (Character.isWhitespace(c)) {
                    z = true;
                }
                sb.append(c);
            } else {
                sb.append(Character.toUpperCase(c));
                z = false;
            }
        }
        return sb.toString();
    }

    public String b(int i) {
        switch (i) {
            case 0:
                return "STATE_CREATED";
            case 1:
                return "STATE_INIT";
            case 2:
                return "STATE_PLAYER_CONFIGURED";
            case 3:
                return "STATE_PLAYING_STARTED";
            case 4:
                return "STATE_PLAYING_STOPPED";
            case 5:
                return "STATE_RECORDER_CONFIGURED";
            case 6:
                return "STATE_RECORDER_STARTED";
            case 7:
                return "STATE_RECORDER_PAUSED";
            case 8:
                return "STATE_RECORDER_STOPPED";
            default:
                return "UN_KNOW_STATE";
        }
    }
}
