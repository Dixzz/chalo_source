package app.zophop.room;

import android.content.Context;
import java.util.List;

public class CityDataRepository {
    private final CityDataDao _cityDataDao;
    private final String city = hj1.C(xt.f3961a);

    public CityDataRepository(Context context) {
        this._cityDataDao = AppDatabase.getDatabase(context).getCityDataDao();
    }

    public List<CityData> getData(String str) {
        if (this._cityDataDao == null) {
            b00 b00 = b00.f358a;
            b00.a().b(new Error("Error at the city data dao"));
        }
        return this._cityDataDao.getDataForType(str, this.city);
    }

    public void insertAllData(List<CityData> list) {
        this._cityDataDao.insertAll(list);
    }

    public void insertData(CityData cityData) {
        this._cityDataDao.insert(cityData);
    }

    public void removeCityData() {
        this._cityDataDao.removeCityData(this.city);
    }

    public void removeTypeData(String str) {
        this._cityDataDao.removeTypeData(str, this.city);
    }
}
