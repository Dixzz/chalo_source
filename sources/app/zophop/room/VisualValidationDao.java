package app.zophop.room;

import app.zophop.models.mTicketing.VisualValidationActivationDetails;
import java.util.List;

/* compiled from: VisualValidationDao.kt */
public interface VisualValidationDao {
    Object deleteSelectActivationDetails(List<Long> list, k66<? super s56> k66);

    List<VisualValidationActivationDetails> getAllVisualValidationDetailsList();

    Object insertActivationDetails(VisualValidationActivationDetails visualValidationActivationDetails, k66<? super s56> k66);
}
