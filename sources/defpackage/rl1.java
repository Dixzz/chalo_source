package defpackage;

import com.rabbitmq.client.StringRpcServer;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/* renamed from: rl1  reason: default package */
/* compiled from: Util */
public final class rl1 {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f3093a = Charset.forName("US-ASCII");

    static {
        Charset.forName(StringRpcServer.STRING_ENCODING);
    }

    public static void a(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    a(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete file: " + file2);
                }
            }
            return;
        }
        throw new IOException("not a readable directory: " + file);
    }
}
