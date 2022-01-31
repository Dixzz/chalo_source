package com.freshchat.consumer.sdk.j;

import android.content.Context;
import android.os.Process;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.appindexing.Indexable;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class ai {
    public static File aR(Context context) {
        String str;
        int myPid = Process.myPid();
        if (myPid > 0) {
            str = Integer.toString(myPid) + "):";
        } else {
            str = null;
        }
        ar arVar = new ar();
        arVar.v(Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL);
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(u(10000)).getInputStream()), RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                } else if (!cl() || readLine.contains(str)) {
                    arVar.add(readLine);
                }
            }
        } catch (IOException e) {
            e("FRESHCHAT", "Mobihelp could not retrieve data from LogCat", e);
        }
        File q = q(context, "debuglog");
        try {
            q.createNewFile();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(q, true));
            Iterator it = arVar.iterator();
            while (it.hasNext()) {
                bufferedWriter.append((CharSequence) ((String) it.next()));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            return q;
        } catch (IOException unused) {
            return null;
        }
    }

    public static boolean ck() {
        return false;
    }

    private static boolean cl() {
        return aw.eV() && Process.myPid() > 0;
    }

    public static void d(Context context, String str, String str2) {
        Toast.makeText(context, str2, 0).show();
    }

    public static void d(String str, String str2) {
    }

    public static void e(String str, String str2) {
    }

    public static void e(String str, String str2, Throwable th) {
    }

    public static void i(String str, String str2) {
    }

    private static File q(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            return File.createTempFile(str, ".txt", context.getCacheDir());
        } catch (IOException unused) {
            return null;
        }
    }

    private static String u(int i) {
        return "logcat -d -v time" + " -t " + i + " dalvikvm:I AndroidRuntime:E HOTLINE:S HOTLINE_WARNING:S HOTLINE_SERVICE:S *:D";
    }

    public static void w(String str, String str2) {
    }

    public static void w(String str, String str2, Throwable th) {
    }
}
