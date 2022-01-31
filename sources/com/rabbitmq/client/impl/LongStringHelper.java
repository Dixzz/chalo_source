package com.rabbitmq.client.impl;

import com.rabbitmq.client.LongString;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class LongStringHelper {

    public static class ByteArrayLongString implements LongString {
        private final byte[] bytes;

        public ByteArrayLongString(byte[] bArr) {
            this.bytes = bArr;
        }

        public boolean equals(Object obj) {
            if (obj instanceof LongString) {
                return Arrays.equals(this.bytes, ((LongString) obj).getBytes());
            }
            return false;
        }

        @Override // com.rabbitmq.client.LongString
        public byte[] getBytes() {
            return this.bytes;
        }

        @Override // com.rabbitmq.client.LongString
        public DataInputStream getStream() throws IOException {
            return new DataInputStream(new ByteArrayInputStream(this.bytes));
        }

        public int hashCode() {
            return Arrays.hashCode(this.bytes);
        }

        @Override // com.rabbitmq.client.LongString
        public long length() {
            return (long) this.bytes.length;
        }

        @Override // com.rabbitmq.client.LongString
        public String toString() {
            try {
                return new String(this.bytes, "utf-8");
            } catch (UnsupportedEncodingException unused) {
                throw new Error("utf-8 encoding support required");
            }
        }
    }

    public static LongString asLongString(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new ByteArrayLongString(str.getBytes("utf-8"));
        } catch (UnsupportedEncodingException unused) {
            throw new Error("utf-8 encoding support required");
        }
    }

    public static LongString asLongString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return new ByteArrayLongString(bArr);
    }
}
