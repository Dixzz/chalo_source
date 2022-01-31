package app.zophop.models;

import app.zophop.models.UniversalSearchItem;
import java.util.ArrayList;
import java.util.List;

public class UniversalSearchResults {
    public final List<UniversalSearchItem> _searchItemList;

    public UniversalSearchResults(List<UniversalSearchItem> list) {
        this._searchItemList = list;
    }

    public int getCount(UniversalSearchItem.UniversalSearchItemType universalSearchItemType) {
        int i = 0;
        for (UniversalSearchItem universalSearchItem : this._searchItemList) {
            if (universalSearchItem.getType().equals(universalSearchItemType)) {
                i++;
            }
        }
        return i;
    }

    public UniversalSearchItem getItemAt(int i) {
        return this._searchItemList.get(i);
    }

    public UniversalSearchItem.UniversalSearchItemType getItemType(int i) {
        return this._searchItemList.get(i).getType();
    }

    public List<UniversalSearchItem> getItems(UniversalSearchItem.UniversalSearchItemType universalSearchItemType) {
        ArrayList arrayList = new ArrayList();
        for (UniversalSearchItem universalSearchItem : this._searchItemList) {
            if (universalSearchItem.getType().equals(universalSearchItemType)) {
                arrayList.add(universalSearchItem);
            }
        }
        return arrayList;
    }

    public int getResultCount() {
        return this._searchItemList.size();
    }
}
