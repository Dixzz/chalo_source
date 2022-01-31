package com.rabbitmq.client.impl;

public class Version {
    private final int _major;
    private final int _minor;

    public Version(int i, int i2) {
        this._major = i;
        this._minor = i2;
    }

    public static boolean checkVersion(Version version, Version version2) {
        return version.adjust().equals(version2.adjust());
    }

    public Version adjust() {
        return (getMajor() == 8 && getMinor() == 0) ? new Version(0, 8) : this;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Version)) {
            return false;
        }
        Version version = (Version) obj;
        if (getMajor() == version.getMajor() && getMinor() == version.getMinor()) {
            return true;
        }
        return false;
    }

    public int getMajor() {
        return this._major;
    }

    public int getMinor() {
        return this._minor;
    }

    public int hashCode() {
        return getMinor() + (getMajor() * 31);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("");
        i0.append(getMajor());
        i0.append("-");
        i0.append(getMinor());
        return i0.toString();
    }
}
