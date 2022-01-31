package defpackage;

import android.util.Log;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/* renamed from: sl6  reason: default package */
/* compiled from: AndroidLog.kt */
public final class sl6 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public static final sl6 f3226a = new sl6();

    @Override // java.util.logging.Handler
    public void close() {
    }

    public void flush() {
    }

    public void publish(LogRecord logRecord) {
        int i;
        int min;
        n86.f(logRecord, "record");
        rl6 rl6 = rl6.c;
        String loggerName = logRecord.getLoggerName();
        n86.b(loggerName, "record.loggerName");
        if (logRecord.getLevel().intValue() > Level.INFO.intValue()) {
            i = 5;
        } else {
            i = logRecord.getLevel().intValue() == Level.INFO.intValue() ? 4 : 3;
        }
        String message = logRecord.getMessage();
        n86.b(message, "record.message");
        Throwable thrown = logRecord.getThrown();
        n86.f(loggerName, "loggerName");
        n86.f(message, "message");
        String str = rl6.b.get(loggerName);
        if (str == null) {
            int i2 = 23;
            n86.e(loggerName, "$this$take");
            int length = loggerName.length();
            if (23 > length) {
                i2 = length;
            }
            str = loggerName.substring(0, i2);
            n86.d(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        if (Log.isLoggable(str, i)) {
            if (thrown != null) {
                StringBuilder k0 = hj1.k0(message, "\n");
                k0.append(Log.getStackTraceString(thrown));
                message = k0.toString();
            }
            int length2 = message.length();
            int i3 = 0;
            while (i3 < length2) {
                int m = ea6.m(message, '\n', i3, false, 4);
                if (m == -1) {
                    m = length2;
                }
                while (true) {
                    min = Math.min(m, i3 + 4000);
                    String substring = message.substring(i3, min);
                    n86.b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    Log.println(i, str, substring);
                    if (min >= m) {
                        break;
                    }
                    i3 = min;
                }
                i3 = min + 1;
            }
        }
    }
}
