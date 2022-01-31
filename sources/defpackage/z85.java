package defpackage;

/* renamed from: z85  reason: default package */
/* compiled from: DataMask */
public enum z85 {
    DATA_MASK_000 {
        @Override // defpackage.z85
        public boolean isMasked(int i, int i2) {
            return ((i + i2) & 1) == 0;
        }
    },
    DATA_MASK_001 {
        @Override // defpackage.z85
        public boolean isMasked(int i, int i2) {
            return (i & 1) == 0;
        }
    },
    DATA_MASK_010 {
        @Override // defpackage.z85
        public boolean isMasked(int i, int i2) {
            return i2 % 3 == 0;
        }
    },
    DATA_MASK_011 {
        @Override // defpackage.z85
        public boolean isMasked(int i, int i2) {
            return (i + i2) % 3 == 0;
        }
    },
    DATA_MASK_100 {
        @Override // defpackage.z85
        public boolean isMasked(int i, int i2) {
            return (((i2 / 3) + (i / 2)) & 1) == 0;
        }
    },
    DATA_MASK_101 {
        @Override // defpackage.z85
        public boolean isMasked(int i, int i2) {
            return (i * i2) % 6 == 0;
        }
    },
    DATA_MASK_110 {
        @Override // defpackage.z85
        public boolean isMasked(int i, int i2) {
            return (i * i2) % 6 < 3;
        }
    },
    DATA_MASK_111 {
        @Override // defpackage.z85
        public boolean isMasked(int i, int i2) {
            return ((((i * i2) % 3) + (i + i2)) & 1) == 0;
        }
    };

    public abstract boolean isMasked(int i, int i2);

    public final void unmaskBitMatrix(f45 f45, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < i; i3++) {
                if (isMasked(i2, i3)) {
                    f45.a(i3, i2);
                }
            }
        }
    }
}
