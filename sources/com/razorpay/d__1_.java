package com.razorpay;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* compiled from: AdvertisingIdUtil */
public class d__1_ {

    /* renamed from: a  reason: collision with root package name */
    public static File f693a;

    public static void a(String str, Throwable th) {
    }

    public static boolean a(String str) {
        File file = new File(f693a.getPath(), str);
        if (!file.exists()) {
            return true;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            fileInputStream.close();
            objectInputStream.close();
            if (!a(((CacheEntry) objectInputStream.readObject()).expiryTime)) {
                return false;
            }
            return true;
        } catch (Exception e) {
            AnalyticsUtil.reportError(e, AnalyticsConstants.WARNING, e.getMessage());
            a("Error fetching cache entry", e);
            return true;
        }
    }

    public static String b(String str) {
        File file = new File(f693a.getPath(), str);
        if (!file.exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            CacheEntry cacheEntry = (CacheEntry) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
            if (a(cacheEntry.expiryTime)) {
                new File(f693a.getPath(), str).delete();
                return null;
            }
            String.format("%s fetched successfully from cache", str);
            return cacheEntry.data;
        } catch (Exception e) {
            AnalyticsUtil.reportError(e, AnalyticsConstants.WARNING, e.getMessage());
            a("Error fetching cache entry", e);
            return null;
        }
    }

    private static boolean a(long j) {
        return j <= 0 || System.currentTimeMillis() > j;
    }

    public static void a(String str, String str2, long j) {
        File file = new File(f693a.getPath(), str);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                AnalyticsUtil.reportError(e, "error", e.getMessage());
                a("Could not store string in cache", e);
            }
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            CacheEntry cacheEntry = new CacheEntry(str2, j + System.currentTimeMillis());
            objectOutputStream.writeObject(cacheEntry);
            objectOutputStream.close();
            fileOutputStream.close();
            String.format("%s stored successfully in cache with expiry time of %d", str, Long.valueOf(cacheEntry.expiryTime));
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2, "error", e2.getMessage());
            a("Could not store string in cache", e2);
        }
    }
}
