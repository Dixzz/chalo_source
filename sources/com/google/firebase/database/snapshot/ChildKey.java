package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.utilities.Utilities;
import com.rabbitmq.client.ConnectionFactory;

public class ChildKey implements Comparable<ChildKey> {
    private static final ChildKey INFO_CHILD_KEY = new ChildKey(".info");
    private static final ChildKey MAX_KEY = new ChildKey("[MAX_KEY]");
    private static final ChildKey MIN_KEY = new ChildKey("[MIN_KEY]");
    private static final ChildKey PRIORITY_CHILD_KEY = new ChildKey(".priority");
    private final String key;

    public static class IntegerChildKey extends ChildKey {
        private final int intValue;

        public IntegerChildKey(String str, int i) {
            super(str);
            this.intValue = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.firebase.database.snapshot.ChildKey, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(ChildKey childKey) {
            return ChildKey.super.compareTo(childKey);
        }

        @Override // com.google.firebase.database.snapshot.ChildKey
        public int intValue() {
            return this.intValue;
        }

        @Override // com.google.firebase.database.snapshot.ChildKey
        public boolean isInt() {
            return true;
        }

        @Override // com.google.firebase.database.snapshot.ChildKey
        public String toString() {
            StringBuilder i0 = hj1.i0("IntegerChildName(\"");
            i0.append(((ChildKey) this).key);
            i0.append("\")");
            return i0.toString();
        }
    }

    public static ChildKey fromString(String str) {
        Integer tryParseInt = Utilities.tryParseInt(str);
        if (tryParseInt != null) {
            return new IntegerChildKey(str, tryParseInt.intValue());
        }
        if (str.equals(".priority")) {
            return PRIORITY_CHILD_KEY;
        }
        Utilities.hardAssert(!str.contains(ConnectionFactory.DEFAULT_VHOST));
        return new ChildKey(str);
    }

    public static ChildKey getInfoKey() {
        return INFO_CHILD_KEY;
    }

    public static ChildKey getMaxName() {
        return MAX_KEY;
    }

    public static ChildKey getMinName() {
        return MIN_KEY;
    }

    public static ChildKey getPriorityKey() {
        return PRIORITY_CHILD_KEY;
    }

    public String asString() {
        return this.key;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ChildKey)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return this.key.equals(((ChildKey) obj).key);
    }

    public int hashCode() {
        return this.key.hashCode();
    }

    public int intValue() {
        return 0;
    }

    public boolean isInt() {
        return false;
    }

    public boolean isPriorityChildName() {
        return equals(PRIORITY_CHILD_KEY);
    }

    public String toString() {
        return hj1.a0(hj1.i0("ChildKey(\""), this.key, "\")");
    }

    private ChildKey(String str) {
        this.key = str;
    }

    public int compareTo(ChildKey childKey) {
        ChildKey childKey2;
        if (this == childKey) {
            return 0;
        }
        ChildKey childKey3 = MIN_KEY;
        if (this == childKey3 || childKey == (childKey2 = MAX_KEY)) {
            return -1;
        }
        if (childKey == childKey3 || this == childKey2) {
            return 1;
        }
        if (isInt()) {
            if (!childKey.isInt()) {
                return -1;
            }
            int compareInts = Utilities.compareInts(intValue(), childKey.intValue());
            return compareInts == 0 ? Utilities.compareInts(this.key.length(), childKey.key.length()) : compareInts;
        } else if (childKey.isInt()) {
            return 1;
        } else {
            return this.key.compareTo(childKey.key);
        }
    }
}
