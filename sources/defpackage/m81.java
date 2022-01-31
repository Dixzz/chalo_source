package defpackage;

import app.zophop.models.ProductGroup;
import app.zophop.models.mTicketing.CardRechargeConfiguration;
import app.zophop.models.mTicketing.ProductConfiguration;
import app.zophop.models.mTicketing.ProductConfigurationMap;
import app.zophop.pubsub.eventbus.events.ProductConfigurationFetchedEvent;
import app.zophop.ui.adapters.ProductInfo;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@y66(c = "app.zophop.ui.viewmodels.HomeScreenMainFragmentViewModel$processProductConfigDataFetchEvent$1", f = "HomeScreenMainFragmentViewModel.kt", l = {}, m = "invokeSuspend")
/* renamed from: m81  reason: default package */
/* compiled from: HomeScreenMainFragmentViewModel.kt */
public final class m81 extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public final /* synthetic */ ProductConfigurationFetchedEvent f;
    public final /* synthetic */ d81 g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m81(ProductConfigurationFetchedEvent productConfigurationFetchedEvent, d81 d81, k66<? super m81> k66) {
        super(2, k66);
        this.f = productConfigurationFetchedEvent;
        this.g = d81;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        return new m81(this.f, this.g, k66);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public Object invoke(mb6 mb6, k66<? super s56> k66) {
        return new m81(this.f, this.g, k66).invokeSuspend(s56.f3190a);
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        ProductGroup productGroup;
        boolean z;
        s56 s56 = s56.f3190a;
        p66 p66 = p66.COROUTINE_SUSPENDED;
        hd3.Y2(obj);
        ed1 ed1 = new ed1("configuration fetched", Long.MIN_VALUE);
        ProductConfigurationFetchedEvent productConfigurationFetchedEvent = this.f;
        if (productConfigurationFetchedEvent == null || productConfigurationFetchedEvent.getResponseType() == null) {
            ed1.a("response", "true");
            return s56;
        }
        if (this.f.getResponseType() == ad1.SUCCESS) {
            ed1.a("response", "true");
            ProductConfigurationMap productConfigMap = this.f.getProductConfigMap();
            if (productConfigMap != null) {
                d81 d81 = this.g;
                Objects.requireNonNull(d81);
                List<String> t = ui1.t(xt.f3961a.k().d());
                HashMap<String, ProductInfo> A0 = vn.A0(t, productConfigMap);
                EnumMap enumMap = new EnumMap(ProductGroup.class);
                for (Map.Entry<String, ProductInfo> entry : A0.entrySet()) {
                    n86.d(entry, "lProductArrayMap.entries");
                    ProductInfo value = entry.getValue();
                    if (value.t) {
                        if (enumMap.containsKey(value.u)) {
                            HashSet hashSet = (HashSet) enumMap.get(value.u);
                            if (hashSet != null) {
                                hashSet.add(value);
                            }
                        } else {
                            ProductGroup productGroup2 = value.u;
                            n86.d(value, "iProduct");
                            ProductInfo[] productInfoArr = {value};
                            n86.e(productInfoArr, "elements");
                            HashSet hashSet2 = new HashSet(hd3.f2(1));
                            hd3.Z2(productInfoArr, hashSet2);
                            enumMap.put((Enum) productGroup2, (Object) hashSet2);
                        }
                    }
                }
                for (Map.Entry entry2 : enumMap.entrySet()) {
                    ProductGroup productGroup3 = (ProductGroup) entry2.getKey();
                    Iterator it = ((HashSet) entry2.getValue()).iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (((ProductInfo) it.next()).r) {
                                z = false;
                                break;
                            }
                        } else {
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        enumMap.remove(productGroup3);
                    }
                }
                Set keySet = enumMap.keySet();
                n86.d(keySet, "lProductInfoMap.keys");
                List<ProductGroup> B = y56.B(keySet);
                d81.s(B);
                n86.d(t, "lAgencyNameList");
                Iterator it2 = ((ArrayList) t).iterator();
                loop3:
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    String str = (String) it2.next();
                    Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                    String lowerCase = str.toLowerCase();
                    n86.d(lowerCase, "(this as java.lang.String).toLowerCase()");
                    List<ProductConfiguration> productConfiguration = productConfigMap.getProductConfiguration(lowerCase);
                    if (productConfiguration != null) {
                        for (ProductConfiguration productConfiguration2 : productConfiguration) {
                            if (CardRechargeConfiguration.Companion.isValidCardRechargeConfig(productConfiguration2) && productConfiguration2.getProductGroup() == (productGroup = ProductGroup.CARDRECHARGE)) {
                                ((ArrayList) B).add(productGroup);
                                break loop3;
                            }
                        }
                        continue;
                    }
                }
                d81.m().j(B);
            } else {
                ed1.a("response", "false");
                d81 d812 = this.g;
                d812.m().j(d812.i());
            }
        } else {
            ed1.a("response", "true");
            d81 d813 = this.g;
            d813.m().j(d813.i());
        }
        ui1.m0(ed1);
        return s56;
    }
}
