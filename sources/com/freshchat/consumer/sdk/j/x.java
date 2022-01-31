package com.freshchat.consumer.sdk.j;

import android.content.Context;
import com.freshchat.consumer.sdk.beans.Message;
import java.io.File;
import java.io.IOException;

public class x {
    public static File a(Context context, File file, String str) {
        if (context == null || file == null || as.isEmpty(str)) {
            return null;
        }
        File file2 = new File(file, str);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    public static File aE(Context context) {
        Exception e;
        File file;
        try {
            file = context.getExternalCacheDir();
            if (file != null) {
                try {
                    if (file.canWrite()) {
                        return file;
                    }
                } catch (Exception e2) {
                    e = e2;
                    q.a(e);
                    return file;
                }
            }
            return context.getCacheDir();
        } catch (Exception e3) {
            e = e3;
            file = null;
            q.a(e);
            return file;
        }
    }

    public static File aF(Context context) throws IOException {
        return c(context, "JPEG_", ".jpg");
    }

    public static File b(Context context, Message message) {
        if (context == null || message == null || message.getChannelId() <= 0 || as.isEmpty(message.getAlias())) {
            return null;
        }
        return new File(j(context, Long.toString(message.getChannelId())), message.getAlias());
    }

    public static void bs(String str) {
        try {
            f(new File(str));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File c(Context context, String str, String str2) throws IOException {
        try {
            String str3 = str + System.currentTimeMillis();
            File ck = ck(context);
            if (ck == null) {
                return null;
            }
            return File.createTempFile(str3, str2, ck);
        } catch (IOException e) {
            throw e;
        } catch (Exception e2) {
            q.a(e2);
            return null;
        }
    }

    private static File ck(Context context) {
        File a2;
        File a3;
        File aE = aE(context);
        if (aE == null || !aE.canWrite() || (a2 = a(context, aE, "freshchat")) == null || (a3 = a(context, a2, "tmp")) == null || !a3.canWrite()) {
            return null;
        }
        return a3;
    }

    public static void cl(Context context) {
        try {
            File ck = ck(context);
            if (ck != null && ck.exists() && ck.isDirectory()) {
                e(ck);
            }
        } catch (Exception e) {
            q.a(e);
        }
    }

    public static void e(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    e(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete file: " + file2);
                }
            }
            return;
        }
        throw new IllegalArgumentException("not a directory: " + file);
    }

    public static void f(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static File j(Context context, String str) {
        File externalFilesDir = aa.aL(context) ? context.getExternalFilesDir(null) : context.getCacheDir();
        StringBuilder sb = new StringBuilder();
        sb.append(externalFilesDir.getAbsolutePath());
        String str2 = File.separator;
        File file = new File(hj1.c0(sb, str2, "freshchat", str2, str));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
