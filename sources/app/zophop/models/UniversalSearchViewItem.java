package app.zophop.models;

public class UniversalSearchViewItem {
    private final Object _dataObject;
    private final Type _type;

    /* renamed from: app.zophop.models.UniversalSearchViewItem$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$app$zophop$models$UniversalSearchViewItem$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0016 */
        static {
            /*
                app.zophop.models.UniversalSearchViewItem.Type.values()
                r0 = 10
                int[] r0 = new int[r0]
                app.zophop.models.UniversalSearchViewItem.AnonymousClass1.$SwitchMap$app$zophop$models$UniversalSearchViewItem$Type = r0
                r1 = 1
                app.zophop.models.UniversalSearchViewItem$Type r2 = app.zophop.models.UniversalSearchViewItem.Type.FOOTER     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 4
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = app.zophop.models.UniversalSearchViewItem.AnonymousClass1.$SwitchMap$app$zophop$models$UniversalSearchViewItem$Type     // Catch:{ NoSuchFieldError -> 0x0016 }
                app.zophop.models.UniversalSearchViewItem$Type r2 = app.zophop.models.UniversalSearchViewItem.Type.HEADER     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r0 = app.zophop.models.UniversalSearchViewItem.AnonymousClass1.$SwitchMap$app$zophop$models$UniversalSearchViewItem$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                app.zophop.models.UniversalSearchViewItem$Type r1 = app.zophop.models.UniversalSearchViewItem.Type.ITEM     // Catch:{ NoSuchFieldError -> 0x001d }
                r1 = 3
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: app.zophop.models.UniversalSearchViewItem.AnonymousClass1.<clinit>():void");
        }
    }

    public enum Type {
        DIVIDER,
        HEADER,
        LOADER,
        ITEM,
        FOOTER,
        SEE_MORE,
        SEE_LESS,
        ERROR_STATE,
        EMPTY_STATE,
        QUERY_FAILED
    }

    public UniversalSearchViewItem(Type type, Object obj) {
        this._type = type;
        this._dataObject = obj;
        int ordinal = type.ordinal();
        if (ordinal != 1) {
            if (ordinal != 3) {
                if (ordinal != 4) {
                    return;
                }
            } else if (!(obj instanceof UniversalSearchItem)) {
                throw new RuntimeException("UniversalSearchItem needed to be passed for item");
            } else {
                return;
            }
        }
        if (!(obj instanceof String)) {
            throw new RuntimeException("String needed to be passed for header or footer");
        }
    }

    public Object getDataObject() {
        return this._dataObject;
    }

    public Type getType() {
        return this._type;
    }
}
