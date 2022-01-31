package com.rabbitmq.utility;

import java.util.BitSet;

public class IntAllocator {
    private final BitSet freeSet;
    private final int hiRange;
    private int lastIndex = 0;
    private final int loRange;
    private final int numberOfBits;

    public IntAllocator(int i, int i2) {
        this.loRange = i;
        int i3 = i2 + 1;
        this.hiRange = i3;
        int i4 = i3 - i;
        this.numberOfBits = i4;
        BitSet bitSet = new BitSet(i4);
        this.freeSet = bitSet;
        bitSet.set(0, i4);
    }

    private void stringInterval(StringBuilder sb, int i, int i2) {
        sb.append(this.loRange + i);
        if (i + 1 != i2) {
            sb.append("..");
            sb.append((i2 - 1) + this.loRange);
        }
    }

    public int allocate() {
        int nextSetBit = this.freeSet.nextSetBit(this.lastIndex);
        if (nextSetBit < 0) {
            nextSetBit = this.freeSet.nextSetBit(0);
        }
        if (nextSetBit < 0) {
            return -1;
        }
        this.lastIndex = nextSetBit;
        this.freeSet.clear(nextSetBit);
        return nextSetBit + this.loRange;
    }

    public void free(int i) {
        this.freeSet.set(i - this.loRange);
    }

    public boolean reserve(int i) {
        int i2 = i - this.loRange;
        if (!this.freeSet.get(i2)) {
            return false;
        }
        this.freeSet.clear(i2);
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IntAllocator{allocated = [");
        int nextClearBit = this.freeSet.nextClearBit(0);
        if (nextClearBit < this.numberOfBits) {
            int nextSetBit = this.freeSet.nextSetBit(nextClearBit + 1);
            if (nextSetBit < 0) {
                nextSetBit = this.numberOfBits;
            }
            stringInterval(sb, nextClearBit, nextSetBit);
            int nextClearBit2 = this.freeSet.nextClearBit(nextSetBit + 1);
            while (nextClearBit2 < this.numberOfBits) {
                int nextSetBit2 = this.freeSet.nextSetBit(nextClearBit2);
                if (nextSetBit2 < 0) {
                    nextSetBit2 = this.numberOfBits;
                }
                sb.append(", ");
                stringInterval(sb, nextClearBit2, nextSetBit2);
                nextClearBit2 = this.freeSet.nextClearBit(nextSetBit2 + 1);
            }
        }
        sb.append("]}");
        return sb.toString();
    }
}
