package app.zophop.room;

import java.util.List;

public interface CityDataDao {
    List<CityData> getDataForType(String str, String str2);

    void insert(CityData cityData);

    void insertAll(List<CityData> list);

    void removeCityData(String str);

    void removeTypeData(String str, String str2);
}
