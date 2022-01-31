package com.freshchat.consumer.sdk.j;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.content.FileProvider;
import com.freshchat.consumer.sdk.b.c;
import java.io.File;

public class an {
    public static final String TAG = "com.freshchat.consumer.sdk.j.an";

    public static Intent a(Context context, File file) {
        Uri uri;
        if (file == null) {
            try {
                Intent intent = new Intent();
                intent.putExtra("HAS_ERRORS", true);
                intent.putExtra("ERROR_MESSAGE", c.PICTURE_ATTACHMENT_FAILED_NO_STORAGE_ACCESS.toString());
                return intent;
            } catch (Exception e) {
                Intent intent2 = new Intent();
                intent2.putExtra("HAS_ERRORS", true);
                q.a(e);
                return intent2;
            }
        } else {
            if (!aw.fc() || !g.am(context)) {
                uri = Uri.fromFile(file);
            } else if (!g.al(context)) {
                Intent intent3 = new Intent();
                intent3.putExtra("HAS_ERRORS", true);
                intent3.putExtra("ERROR_MESSAGE", c.PICTURE_ATTACHMENT_FAILED_BAD_AUTHORITY.toString());
                return intent3;
            } else {
                uri = FileProvider.b(context, g.aj(context), file);
            }
            Intent intent4 = new Intent("android.media.action.IMAGE_CAPTURE");
            intent4.putExtra("output", uri);
            return intent4;
        }
    }
}
