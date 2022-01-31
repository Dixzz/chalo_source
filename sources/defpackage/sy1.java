package defpackage;

import android.net.Uri;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* renamed from: sy1  reason: default package */
public final class sy1 extends Thread {
    public final /* synthetic */ Map f;

    public sy1(Map map) {
        this.f = map;
    }

    public final void run() {
        String message;
        Map map = this.f;
        Uri.Builder buildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
        for (String str : map.keySet()) {
            buildUpon.appendQueryParameter(str, (String) map.get(str));
        }
        String uri = buildUpon.build().toString();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri).openConnection();
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode < 200 || responseCode >= 300) {
                    String.valueOf(uri).length();
                }
            } finally {
                httpURLConnection.disconnect();
            }
        } catch (IndexOutOfBoundsException e) {
            message = e.getMessage();
            String.valueOf(uri).length();
            String.valueOf(message).length();
        } catch (IOException | RuntimeException e2) {
            message = e2.getMessage();
            String.valueOf(uri).length();
            String.valueOf(message).length();
        }
    }
}
