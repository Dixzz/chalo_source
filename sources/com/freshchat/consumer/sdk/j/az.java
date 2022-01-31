package com.freshchat.consumer.sdk.j;

import android.content.Context;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.rabbitmq.client.ConnectionFactory;

public class az {

    public interface a {
        void a(c cVar);

        void fQ();
    }

    public enum b {
        TYPE_IMAGE("image/*");
        
        private String type;

        private b(String str) {
            this.type = str;
        }

        public String getType() {
            return this.type;
        }
    }

    public enum c {
        INVALID_PARAMS,
        UNKNOWN_TYPE,
        INVALID_TYPE
    }

    private static String V(String str) {
        if (as.isEmpty(str)) {
            return null;
        }
        return str.split(ConnectionFactory.DEFAULT_VHOST)[0];
    }

    public static void a(Context context, Uri uri, b bVar, a aVar) {
        if (context != null && uri != null && aVar != null && bVar != null) {
            String e = e(context, uri);
            if (as.isEmpty(e)) {
                aVar.a(c.UNKNOWN_TYPE);
            } else if (as.m(V(bVar.getType()), V(e))) {
                aVar.fQ();
            } else {
                aVar.a(c.INVALID_TYPE);
            }
        } else if (aVar != null) {
            aVar.a(c.INVALID_PARAMS);
        } else {
            ai.e("FRESHCHAT_WARNING", "Invalid parameters. Can not validate Uri.");
        }
    }

    private static String e(Context context, Uri uri) {
        String mimeTypeFromExtension;
        if (context == null || uri == null) {
            return null;
        }
        try {
            if (as.m(uri.getScheme(), "content")) {
                mimeTypeFromExtension = context.getContentResolver().getType(uri);
            } else {
                mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(uri.toString()).toLowerCase());
            }
            return mimeTypeFromExtension;
        } catch (Exception e) {
            ai.e("FRESHCHAT", e.toString());
            return null;
        }
    }
}
