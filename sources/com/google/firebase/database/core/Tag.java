package com.google.firebase.database.core;

public final class Tag {
    private final long tagNumber;

    public Tag(long j) {
        this.tagNumber = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && Tag.class == obj.getClass() && this.tagNumber == ((Tag) obj).tagNumber;
    }

    public long getTagNumber() {
        return this.tagNumber;
    }

    public int hashCode() {
        long j = this.tagNumber;
        return (int) (j ^ (j >>> 32));
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("Tag{tagNumber=");
        i0.append(this.tagNumber);
        i0.append('}');
        return i0.toString();
    }
}
