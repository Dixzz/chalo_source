package j$.util.concurrent;

import java.security.PrivilegedAction;

class d implements PrivilegedAction<Boolean> {
    d() {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.security.PrivilegedAction
    public Boolean run() {
        return Boolean.valueOf(Boolean.getBoolean("java.util.secureRandomSeed"));
    }
}
