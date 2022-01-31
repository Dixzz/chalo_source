package com.google.firebase.perf.internal;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.StorageUnit;
import com.google.firebase.perf.util.Utils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GaugeMetadataManager {
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private final ActivityManager activityManager;
    private final Context applicationContext;
    private final String currentProcessName;
    private final ActivityManager.MemoryInfo memoryInfo;
    private final Runtime runtime;

    public GaugeMetadataManager(Context context) {
        this(Runtime.getRuntime(), context);
    }

    private String getCurrentProcessName() {
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = this.activityManager.getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return this.applicationContext.getPackageName();
    }

    public int getDeviceRamSizeKb() {
        return Utils.saturatedIntCast(StorageUnit.BYTES.toKilobytes(this.memoryInfo.totalMem));
    }

    public int getMaxAppJavaHeapMemoryKb() {
        return Utils.saturatedIntCast(StorageUnit.BYTES.toKilobytes(this.runtime.maxMemory()));
    }

    public int getMaxEncouragedAppJavaHeapMemoryKb() {
        return Utils.saturatedIntCast(StorageUnit.MEGABYTES.toKilobytes((long) this.activityManager.getMemoryClass()));
    }

    public String getProcessName() {
        return this.currentProcessName;
    }

    public int readTotalRAM(String str) {
        String readLine;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
            do {
                try {
                    readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        bufferedReader.close();
                        return 0;
                    }
                } catch (Throwable unused) {
                }
            } while (!readLine.startsWith("MemTotal"));
            Matcher matcher = Pattern.compile("\\d+").matcher(readLine);
            int parseInt = matcher.find() ? Integer.parseInt(matcher.group()) : 0;
            bufferedReader.close();
            return parseInt;
            throw th;
        } catch (IOException e) {
            AndroidLogger androidLogger = logger;
            StringBuilder l0 = hj1.l0("Unable to read '", str, "' file: ");
            l0.append(e.getMessage());
            androidLogger.warn(l0.toString(), new Object[0]);
        } catch (NumberFormatException e2) {
            AndroidLogger androidLogger2 = logger;
            StringBuilder l02 = hj1.l0("Unable to parse '", str, "' file: ");
            l02.append(e2.getMessage());
            androidLogger2.warn(l02.toString(), new Object[0]);
        }
    }

    public GaugeMetadataManager(Runtime runtime2, Context context) {
        this.runtime = runtime2;
        this.applicationContext = context;
        ActivityManager activityManager2 = (ActivityManager) context.getSystemService("activity");
        this.activityManager = activityManager2;
        ActivityManager.MemoryInfo memoryInfo2 = new ActivityManager.MemoryInfo();
        this.memoryInfo = memoryInfo2;
        activityManager2.getMemoryInfo(memoryInfo2);
        this.currentProcessName = getCurrentProcessName();
    }
}
