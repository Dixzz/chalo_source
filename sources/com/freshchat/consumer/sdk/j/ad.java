package com.freshchat.consumer.sdk.j;

import android.content.Context;
import android.net.Uri;
import androidx.recyclerview.widget.RecyclerView;
import com.rabbitmq.client.ConnectionFactory;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class ad {
    public static String a(InputStream inputStream, Charset charset) throws IOException {
        StringBuilder sb = new StringBuilder();
        try {
            char[] cArr = new char[RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST];
            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
                while (true) {
                    int read = inputStreamReader.read(cArr);
                    if (-1 == read) {
                        break;
                    }
                    sb.append(cArr, 0, read);
                }
            }
            a(inputStream);
            return sb.toString();
        } catch (Throwable th) {
            a(inputStream);
            throw th;
        }
    }

    public static void a(Closeable... closeableArr) {
        if (closeableArr != null) {
            for (Closeable closeable : closeableArr) {
                if (closeable != null) {
                    try {
                        closeable.close();
                    } catch (Exception e) {
                        ai.e("FRESHCHAT_WARNING", "Failed to close closeable", e);
                    }
                }
            }
        }
    }

    public static InputStream aE(String str) {
        try {
            return new BufferedInputStream(new FileInputStream(str));
        } catch (Exception e) {
            ai.e("FRESHCHAT_WARNING", "Exception while reading input stream from File", e);
            return null;
        }
    }

    public static String aF(String str) {
        return (str == null || str.startsWith("http://") || str.startsWith("https://") || str.startsWith("content://") || !str.startsWith(ConnectionFactory.DEFAULT_VHOST)) ? str : hj1.S("file:///", str.substring(1, str.length()));
    }

    public static InputStream d(Context context, Uri uri) {
        if (uri == null) {
            return null;
        }
        try {
            return context.getContentResolver().openInputStream(uri);
        } catch (Exception e) {
            ai.e("FRESHCHAT_WARNING", "Exception while reading input stream from URI", e);
            return null;
        }
    }
}
