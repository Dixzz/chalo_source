package com.google.firebase.database.core.utilities;

public final class Pair<T, U> {
    private final T first;
    private final U second;

    public Pair(T t, U u) {
        this.first = t;
        this.second = u;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Pair.class != obj.getClass()) {
            return false;
        }
        Pair pair = (Pair) obj;
        T t = this.first;
        if (t == null ? pair.first != null : !t.equals(pair.first)) {
            return false;
        }
        U u = this.second;
        U u2 = pair.second;
        return u == null ? u2 == null : u.equals(u2);
    }

    public T getFirst() {
        return this.first;
    }

    public U getSecond() {
        return this.second;
    }

    public int hashCode() {
        T t = this.first;
        int i = 0;
        int hashCode = (t != null ? t.hashCode() : 0) * 31;
        U u = this.second;
        if (u != null) {
            i = u.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("Pair(");
        i0.append((Object) this.first);
        i0.append(",");
        i0.append((Object) this.second);
        i0.append(")");
        return i0.toString();
    }
}
