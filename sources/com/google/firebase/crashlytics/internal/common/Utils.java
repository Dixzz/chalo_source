package com.google.firebase.crashlytics.internal.common;

import android.os.Looper;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class Utils {
    private static final FilenameFilter ALL_FILES_FILTER = new FilenameFilter() {
        /* class com.google.firebase.crashlytics.internal.common.Utils.AnonymousClass1 */

        public boolean accept(File file, String str) {
            return true;
        }
    };
    private static final ExecutorService TASK_CONTINUATION_EXECUTOR_SERVICE = ExecutorUtils.buildSingleThreadExecutorService("awaitEvenIfOnMainThread task continuation executor");

    private Utils() {
    }

    public static <T> T awaitEvenIfOnMainThread(yi4<T> yi4) throws InterruptedException, TimeoutException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        yi4.i(TASK_CONTINUATION_EXECUTOR_SERVICE, Utils$$Lambda$1.lambdaFactory$(countDownLatch));
        if (Looper.getMainLooper() == Looper.myLooper()) {
            countDownLatch.await(4, TimeUnit.SECONDS);
        } else {
            countDownLatch.await();
        }
        if (yi4.q()) {
            return yi4.m();
        }
        if (yi4.o()) {
            throw new CancellationException("Task is already canceled");
        } else if (yi4.p()) {
            throw new IllegalStateException(yi4.l());
        } else {
            throw new TimeoutException();
        }
    }

    public static <T> yi4<T> callTask(Executor executor, final Callable<yi4<T>> callable) {
        final zi4 zi4 = new zi4();
        executor.execute(new Runnable() {
            /* class com.google.firebase.crashlytics.internal.common.Utils.AnonymousClass3 */

            public void run() {
                try {
                    ((yi4) callable.call()).h(new qi4<T, Void>() {
                        /* class com.google.firebase.crashlytics.internal.common.Utils.AnonymousClass3.AnonymousClass1 */

                        @Override // defpackage.qi4
                        public Void then(yi4<T> yi4) throws Exception {
                            if (yi4.q()) {
                                zi4 zi4 = zi4;
                                zi4.f4178a.t(yi4.m());
                                return null;
                            }
                            zi4 zi42 = zi4;
                            zi42.f4178a.u(yi4.l());
                            return null;
                        }
                    });
                } catch (Exception e) {
                    zi4.f4178a.u(e);
                }
            }
        });
        return zi4.f4178a;
    }

    public static int capFileCount(File file, int i, Comparator<File> comparator) {
        return capFileCount(file, ALL_FILES_FILTER, i, comparator);
    }

    public static int capSessionCount(File file, File file2, int i, Comparator<File> comparator) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        File[] listFiles2 = file2.listFiles(ALL_FILES_FILTER);
        if (listFiles == null) {
            listFiles = new File[0];
        }
        if (listFiles2 == null) {
            listFiles2 = new File[0];
        }
        arrayList.addAll(Arrays.asList(listFiles));
        arrayList.addAll(Arrays.asList(listFiles2));
        return capFileCount(arrayList, i, comparator);
    }

    public static <T> yi4<T> race(yi4<T> yi4, yi4<T> yi42) {
        final zi4 zi4 = new zi4();
        AnonymousClass2 r1 = new qi4<T, Void>() {
            /* class com.google.firebase.crashlytics.internal.common.Utils.AnonymousClass2 */

            @Override // defpackage.qi4
            public Void then(yi4<T> yi4) throws Exception {
                if (yi4.q()) {
                    zi4.this.b(yi4.m());
                    return null;
                }
                zi4.this.a(yi4.l());
                return null;
            }
        };
        yi4.h(r1);
        yi42.h(r1);
        return zi4.f4178a;
    }

    private static void recursiveDelete(File file) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                recursiveDelete(file2);
            }
        }
        file.delete();
    }

    public static int capFileCount(File file, FilenameFilter filenameFilter, int i, Comparator<File> comparator) {
        File[] listFiles = file.listFiles(filenameFilter);
        if (listFiles == null) {
            return 0;
        }
        return capFileCount(Arrays.asList(listFiles), i, comparator);
    }

    public static int capFileCount(List<File> list, int i, Comparator<File> comparator) {
        int size = list.size();
        Collections.sort(list, comparator);
        for (File file : list) {
            if (size <= i) {
                return size;
            }
            recursiveDelete(file);
            size--;
        }
        return size;
    }
}
