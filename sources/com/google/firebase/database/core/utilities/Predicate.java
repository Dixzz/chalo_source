package com.google.firebase.database.core.utilities;

public interface Predicate<T> {
    public static final Predicate<Object> TRUE = new Predicate<Object>() {
        /* class com.google.firebase.database.core.utilities.Predicate.AnonymousClass1 */

        @Override // com.google.firebase.database.core.utilities.Predicate
        public boolean evaluate(Object obj) {
            return true;
        }
    };

    boolean evaluate(T t);
}
