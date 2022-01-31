package app.zophop.room;

import androidx.lifecycle.LiveData;
import app.zophop.models.mTicketing.digitalTripReceipt.ProductActivationDetails;
import app.zophop.models.mTicketing.digitalTripReceipt.SuperPassTripReceipt;
import java.util.List;

/* compiled from: DigitalTripReceiptDao.kt */
public interface DigitalTripReceiptDao {
    Object deleteSelectActivationDetails(List<Long> list, k66<? super s56> k66);

    Object deleteSelectSuperPassTripReceipts(String str, k66<? super s56> k66);

    Object deleteSuperPassTripReceipt(String str, long j, long j2, k66<? super s56> k66);

    List<ProductActivationDetails> getAllProductActivationDetailsList();

    LiveData<List<SuperPassTripReceipt>> getAllSuperPassTripReceiptsList(String str);

    LiveData<SuperPassTripReceipt> getSuperPassTripReceipt(String str, long j);

    Object insertActivationDetails(ProductActivationDetails productActivationDetails, k66<? super s56> k66);

    Object insertSuperPassTripReceipt(SuperPassTripReceipt superPassTripReceipt, k66<? super s56> k66);

    Object insertSuperPassTripReceiptsList(List<SuperPassTripReceipt> list, k66<? super s56> k66);
}
