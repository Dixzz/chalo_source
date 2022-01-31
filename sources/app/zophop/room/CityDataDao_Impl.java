package app.zophop.room;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class CityDataDao_Impl implements CityDataDao {
    private final wl __db;
    private final ql<CityData> __insertionAdapterOfCityData;
    private final ql<CityData> __insertionAdapterOfCityData_1;
    private final bm __preparedStmtOfRemoveCityData;
    private final bm __preparedStmtOfRemoveTypeData;

    public CityDataDao_Impl(wl wlVar) {
        this.__db = wlVar;
        this.__insertionAdapterOfCityData = new ql<CityData>(wlVar) {
            /* class app.zophop.room.CityDataDao_Impl.AnonymousClass1 */

            @Override // defpackage.bm
            public String createQuery() {
                return "INSERT OR REPLACE INTO `CityData` (`type`,`cityName`,`mode`,`dataId`,`data`,`etag`,`version`) VALUES (?,?,?,?,?,?,?)";
            }

            public void bind(sm smVar, CityData cityData) {
                if (cityData.getType() == null) {
                    smVar.E0(1);
                } else {
                    smVar.z(1, cityData.getType());
                }
                if (cityData.getCityName() == null) {
                    smVar.E0(2);
                } else {
                    smVar.z(2, cityData.getCityName());
                }
                if (cityData.getMode() == null) {
                    smVar.E0(3);
                } else {
                    smVar.z(3, cityData.getMode());
                }
                if (cityData.getDataId() == null) {
                    smVar.E0(4);
                } else {
                    smVar.z(4, cityData.getDataId());
                }
                if (cityData.getData() == null) {
                    smVar.E0(5);
                } else {
                    smVar.z(5, cityData.getData());
                }
                if (cityData.getEtag() == null) {
                    smVar.E0(6);
                } else {
                    smVar.z(6, cityData.getEtag());
                }
                smVar.d0(7, (long) cityData.getVersion());
            }
        };
        this.__insertionAdapterOfCityData_1 = new ql<CityData>(wlVar) {
            /* class app.zophop.room.CityDataDao_Impl.AnonymousClass2 */

            @Override // defpackage.bm
            public String createQuery() {
                return "INSERT OR ABORT INTO `CityData` (`type`,`cityName`,`mode`,`dataId`,`data`,`etag`,`version`) VALUES (?,?,?,?,?,?,?)";
            }

            public void bind(sm smVar, CityData cityData) {
                if (cityData.getType() == null) {
                    smVar.E0(1);
                } else {
                    smVar.z(1, cityData.getType());
                }
                if (cityData.getCityName() == null) {
                    smVar.E0(2);
                } else {
                    smVar.z(2, cityData.getCityName());
                }
                if (cityData.getMode() == null) {
                    smVar.E0(3);
                } else {
                    smVar.z(3, cityData.getMode());
                }
                if (cityData.getDataId() == null) {
                    smVar.E0(4);
                } else {
                    smVar.z(4, cityData.getDataId());
                }
                if (cityData.getData() == null) {
                    smVar.E0(5);
                } else {
                    smVar.z(5, cityData.getData());
                }
                if (cityData.getEtag() == null) {
                    smVar.E0(6);
                } else {
                    smVar.z(6, cityData.getEtag());
                }
                smVar.d0(7, (long) cityData.getVersion());
            }
        };
        this.__preparedStmtOfRemoveTypeData = new bm(wlVar) {
            /* class app.zophop.room.CityDataDao_Impl.AnonymousClass3 */

            @Override // defpackage.bm
            public String createQuery() {
                return "DELETE FROM CityData where cityName = ? and type = ? ";
            }
        };
        this.__preparedStmtOfRemoveCityData = new bm(wlVar) {
            /* class app.zophop.room.CityDataDao_Impl.AnonymousClass4 */

            @Override // defpackage.bm
            public String createQuery() {
                return "DELETE FROM CityData where cityName = ?";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // app.zophop.room.CityDataDao
    public List<CityData> getDataForType(String str, String str2) {
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        yl e = yl.e("SELECT * FROM CityData where cityName = ? and type = ? ", 2);
        if (str2 == null) {
            e.E0(1);
        } else {
            e.z(1, str2);
        }
        if (str == null) {
            e.E0(2);
        } else {
            e.z(2, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor b = hm.b(this.__db, e, false, null);
        try {
            int L = h.L(b, "type");
            int L2 = h.L(b, "cityName");
            int L3 = h.L(b, "mode");
            int L4 = h.L(b, "dataId");
            int L5 = h.L(b, "data");
            int L6 = h.L(b, "etag");
            int L7 = h.L(b, "version");
            ArrayList arrayList = new ArrayList(b.getCount());
            while (b.moveToNext()) {
                if (b.isNull(L)) {
                    str3 = null;
                } else {
                    str3 = b.getString(L);
                }
                if (b.isNull(L2)) {
                    str4 = null;
                } else {
                    str4 = b.getString(L2);
                }
                if (b.isNull(L3)) {
                    str5 = null;
                } else {
                    str5 = b.getString(L3);
                }
                if (b.isNull(L4)) {
                    str6 = null;
                } else {
                    str6 = b.getString(L4);
                }
                if (b.isNull(L5)) {
                    str7 = null;
                } else {
                    str7 = b.getString(L5);
                }
                CityData cityData = new CityData(str3, str4, str7, str5, str6);
                if (b.isNull(L6)) {
                    str8 = null;
                } else {
                    str8 = b.getString(L6);
                }
                cityData.setEtag(str8);
                cityData.setVersion(b.getInt(L7));
                arrayList.add(cityData);
            }
            return arrayList;
        } finally {
            b.close();
            e.f();
        }
    }

    @Override // app.zophop.room.CityDataDao
    public void insert(CityData cityData) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfCityData.insert(cityData);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // app.zophop.room.CityDataDao
    public void insertAll(List<CityData> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfCityData_1.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // app.zophop.room.CityDataDao
    public void removeCityData(String str) {
        this.__db.assertNotSuspendingTransaction();
        sm acquire = this.__preparedStmtOfRemoveCityData.acquire();
        if (str == null) {
            acquire.E0(1);
        } else {
            acquire.z(1, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.F();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfRemoveCityData.release(acquire);
        }
    }

    @Override // app.zophop.room.CityDataDao
    public void removeTypeData(String str, String str2) {
        this.__db.assertNotSuspendingTransaction();
        sm acquire = this.__preparedStmtOfRemoveTypeData.acquire();
        if (str2 == null) {
            acquire.E0(1);
        } else {
            acquire.z(1, str2);
        }
        if (str == null) {
            acquire.E0(2);
        } else {
            acquire.z(2, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.F();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfRemoveTypeData.release(acquire);
        }
    }
}
