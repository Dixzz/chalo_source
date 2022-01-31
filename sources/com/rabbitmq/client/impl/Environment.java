package com.rabbitmq.client.impl;

import java.util.concurrent.ThreadFactory;

public class Environment {
    public static boolean isAllowedToModifyThreads() {
        try {
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager == null) {
                return true;
            }
            securityManager.checkPermission(new RuntimePermission("modifyThread"));
            securityManager.checkPermission(new RuntimePermission("modifyThreadGroup"));
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }

    public static Thread newThread(ThreadFactory threadFactory, Runnable runnable, String str) {
        Thread newThread = threadFactory.newThread(runnable);
        if (isAllowedToModifyThreads()) {
            newThread.setName(str);
        }
        return newThread;
    }

    public static Thread newThread(ThreadFactory threadFactory, Runnable runnable, String str, boolean z) {
        Thread newThread = newThread(threadFactory, runnable, str);
        if (isAllowedToModifyThreads()) {
            newThread.setDaemon(z);
        }
        return newThread;
    }
}
