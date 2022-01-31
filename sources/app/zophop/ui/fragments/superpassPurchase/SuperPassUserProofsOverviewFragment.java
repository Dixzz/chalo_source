package app.zophop.ui.fragments.superpassPurchase;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import app.zophop.models.mTicketing.PassApplicationActionRequired;
import app.zophop.models.mTicketing.PassApplicationRejectionReasons;
import app.zophop.models.mTicketing.ProfileRejectionReason;
import app.zophop.models.mTicketing.ProofDocumentProps;
import app.zophop.models.mTicketing.ProofRejectionReason;
import app.zophop.models.mTicketing.ProofUploadDetails;
import app.zophop.models.mTicketing.ProofUploadStatus;
import app.zophop.models.mTicketing.RejectionStatus;
import app.zophop.pubsub.eventbus.events.ImageUploadUrlEvent;
import app.zophop.ui.viewmodels.superpassPurchase.SuperPassPurchaseSharedViewModel;
import com.razorpay.AnalyticsConstants;
import defpackage.ga1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: SuperPassUserProofsOverviewFragment.kt */
public final class SuperPassUserProofsOverviewFragment extends ul0<sx> {
    public static final /* synthetic */ int m = 0;
    public ga1 g;
    public final j56 h = h.B(this, z86.a(SuperPassPurchaseSharedViewModel.class), new d(this), new e(this));
    public uu i;
    public r<String[]> j;
    public r<Intent> k;
    public r<Intent> l;

    /* compiled from: FragmentViewModelLazy.kt */
    public static final class a extends o86 implements h76<Fragment> {
        public final /* synthetic */ Fragment f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Fragment fragment) {
            super(0);
            this.f = fragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public Fragment invoke() {
            return this.f;
        }
    }

    /* compiled from: FragmentViewModelLazy.kt */
    public static final class b extends o86 implements h76<gi> {
        public final /* synthetic */ h76 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(h76 h76) {
            super(0);
            this.f = h76;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public gi invoke() {
            gi viewModelStore = ((hi) this.f.invoke()).getViewModelStore();
            n86.d(viewModelStore, "ownerProducer().viewModelStore");
            return viewModelStore;
        }
    }

    /* compiled from: SuperPassUserProofsOverviewFragment.kt */
    public static final class c extends o86 implements h76<ci> {
        public final /* synthetic */ SuperPassUserProofsOverviewFragment f;
        public final /* synthetic */ Bundle g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(SuperPassUserProofsOverviewFragment superPassUserProofsOverviewFragment, Bundle bundle) {
            super(0);
            this.f = superPassUserProofsOverviewFragment;
            this.g = bundle;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public ci invoke() {
            return new ga1.a(this.f, this.g);
        }
    }

    /* compiled from: FragmentViewModelLazy.kt */
    public static final class d extends o86 implements h76<gi> {
        public final /* synthetic */ Fragment f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Fragment fragment) {
            super(0);
            this.f = fragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public gi invoke() {
            return hj1.j(this.f, "requireActivity()", "requireActivity().viewModelStore");
        }
    }

    /* compiled from: FragmentViewModelLazy.kt */
    public static final class e extends o86 implements h76<ci> {
        public final /* synthetic */ Fragment f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(Fragment fragment) {
            super(0);
            this.f = fragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public ci invoke() {
            ve requireActivity = this.f.requireActivity();
            n86.d(requireActivity, "requireActivity()");
            return requireActivity.getDefaultViewModelProviderFactory();
        }
    }

    @Override // defpackage.rl0
    public qo e() {
        View inflate = getLayoutInflater().inflate(R.layout.fragment_super_pass_user_proofs_overview, (ViewGroup) null, false);
        int i2 = R.id.activation_text;
        TextView textView = (TextView) inflate.findViewById(R.id.activation_text);
        if (textView != null) {
            i2 = R.id.bottom_padding;
            View findViewById = inflate.findViewById(R.id.bottom_padding);
            if (findViewById != null) {
                i2 = R.id.bottom_sheet_next_btn;
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.bottom_sheet_next_btn);
                if (linearLayout != null) {
                    i2 = R.id.btn_next;
                    TextView textView2 = (TextView) inflate.findViewById(R.id.btn_next);
                    if (textView2 != null) {
                        i2 = R.id.guideline_left;
                        Guideline guideline = (Guideline) inflate.findViewById(R.id.guideline_left);
                        if (guideline != null) {
                            i2 = R.id.guideline_right;
                            Guideline guideline2 = (Guideline) inflate.findViewById(R.id.guideline_right);
                            if (guideline2 != null) {
                                i2 = R.id.proofs_overview_recycler_view;
                                RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.proofs_overview_recycler_view);
                                if (recyclerView != null) {
                                    sx sxVar = new sx((ConstraintLayout) inflate, textView, findViewById, linearLayout, textView2, guideline, guideline2, recyclerView);
                                    n86.d(sxVar, "inflate(layoutInflater)");
                                    return sxVar;
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // defpackage.ul0
    public void f() {
        Bundle bundle = new Bundle();
        boolean z = true;
        boolean z2 = j().h == PassApplicationActionRequired.REINITIATE;
        boolean z3 = j().h == PassApplicationActionRequired.REAPPLY;
        if (j().h != PassApplicationActionRequired.FRESH) {
            z = false;
        }
        bundle.putBoolean("keyShouldReInitiate", z2);
        bundle.putBoolean("keyShouldReapply", z3);
        bundle.putBoolean("keyIsFreshApplicationFlow", z);
        this.g = (ga1) ((ai) h.B(this, z86.a(ga1.class), new b(new a(this)), new c(this, bundle))).getValue();
    }

    @Override // defpackage.ul0
    public void g() {
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, false, 0);
        ga1 ga1 = this.g;
        if (ga1 != null) {
            if (!ga1.i) {
                if (ga1 != null) {
                    ga1.h.f(getViewLifecycleOwner(), new w51(this));
                } else {
                    n86.l("viewModel");
                    throw null;
                }
            }
            j().d().f(getViewLifecycleOwner(), new p51(this));
            return;
        }
        n86.l("viewModel");
        throw null;
    }

    @Override // defpackage.ul0
    public void h() {
        ProfileRejectionReason profileRejectionReason;
        boolean z;
        yj yjVar;
        Resources resources;
        Resources resources2;
        List<ProfileRejectionReason> profileRejectionReasonsList;
        List<ProofRejectionReason> proofRejectionReasonsList;
        Boolean bool = Boolean.TRUE;
        boolean z2 = j().g;
        PassApplicationRejectionReasons passApplicationRejectionReasons = j().i;
        List<String> generalRejectionReasonsList = passApplicationRejectionReasons == null ? null : passApplicationRejectionReasons.getGeneralRejectionReasonsList();
        ga1 ga1 = this.g;
        if (ga1 != null) {
            PassApplicationRejectionReasons passApplicationRejectionReasons2 = j().i;
            ArrayList arrayList = new ArrayList();
            if (!(passApplicationRejectionReasons2 == null || (proofRejectionReasonsList = passApplicationRejectionReasons2.getProofRejectionReasonsList()) == null)) {
                for (ProofRejectionReason proofRejectionReason : proofRejectionReasonsList) {
                    if (proofRejectionReason.getStatus() == RejectionStatus.INVALID) {
                        arrayList.add(proofRejectionReason);
                    }
                }
            }
            if (arrayList.isEmpty() || !ga1.k) {
                ga1.c.b("keyAreAllProofsUploaded", bool);
            }
            ga1 ga12 = this.g;
            if (ga12 != null) {
                PassApplicationRejectionReasons passApplicationRejectionReasons3 = j().i;
                if (passApplicationRejectionReasons3 != null && (profileRejectionReasonsList = passApplicationRejectionReasons3.getProfileRejectionReasonsList()) != null) {
                    Iterator<ProfileRejectionReason> it = profileRejectionReasonsList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ProfileRejectionReason next = it.next();
                        if (n86.a(next.getProofId(), "NAME") && next.getStatus() == RejectionStatus.INVALID) {
                            profileRejectionReason = next;
                            break;
                        }
                    }
                }
                profileRejectionReason = null;
                if (profileRejectionReason == null || ga12.k) {
                    ga12.c.b("keyIsNameChangeCompleted", bool);
                }
                ga1 ga13 = this.g;
                if (ga13 != null) {
                    boolean z3 = ga13.j && !arrayList.isEmpty();
                    ga1 ga14 = this.g;
                    if (ga14 != null) {
                        boolean z4 = !ga14.i && (!ga14.j || !arrayList.isEmpty());
                        ve activity = c();
                        ga1 ga15 = this.g;
                        if (ga15 != null) {
                            su suVar = new su(activity, z2, z3, generalRejectionReasonsList, profileRejectionReason, ga15.l, new e61(this));
                            if (z4) {
                                ve activity2 = c();
                                List<ProofDocumentProps> list = j().u;
                                n86.c(list);
                                Map<String, ProofUploadDetails> d2 = j().d().d();
                                n86.c(d2);
                                n86.d(d2, "sharedViewModel.proofUploadDetailsMap.value!!");
                                Map<String, ProofUploadDetails> map = d2;
                                ga1 ga16 = this.g;
                                if (ga16 != null) {
                                    z = false;
                                    uu uuVar = new uu(activity2, list, map, ga16.j, arrayList, new f61(this));
                                    this.i = uuVar;
                                    yjVar = new yj(suVar, uuVar);
                                } else {
                                    n86.l("viewModel");
                                    throw null;
                                }
                            } else {
                                z = false;
                                yjVar = new yj(suVar);
                            }
                            T t = this.f;
                            n86.c(t);
                            RecyclerView recyclerView = ((sx) t).c;
                            recyclerView.setAdapter(yjVar);
                            recyclerView.setLayoutManager(new LinearLayoutManager(c()));
                            recyclerView.setHasFixedSize(true);
                            T t2 = this.f;
                            n86.c(t2);
                            ((sx) t2).b.setAlpha(0.4f);
                            T t3 = this.f;
                            n86.c(t3);
                            ((sx) t3).b.setEnabled(z);
                            ga1 ga17 = this.g;
                            if (ga17 != null) {
                                if (ga17.i) {
                                    T t4 = this.f;
                                    n86.c(t4);
                                    ((sx) t4).b.setAlpha(1.0f);
                                    T t5 = this.f;
                                    n86.c(t5);
                                    ((sx) t5).b.setEnabled(true);
                                    T t6 = this.f;
                                    n86.c(t6);
                                    TextView textView = ((sx) t6).b;
                                    ve activity3 = c();
                                    textView.setText((activity3 == null || (resources2 = activity3.getResources()) == null) ? null : resources2.getString(R.string.reapply_caps));
                                    T t7 = this.f;
                                    n86.c(t7);
                                    ((sx) t7).b.setOnClickListener(new r51(this));
                                } else {
                                    T t8 = this.f;
                                    n86.c(t8);
                                    TextView textView2 = ((sx) t8).b;
                                    ve activity4 = c();
                                    textView2.setText((activity4 == null || (resources = activity4.getResources()) == null) ? null : resources.getString(R.string.next_caps));
                                    T t9 = this.f;
                                    n86.c(t9);
                                    ((sx) t9).b.setOnClickListener(new s51(this));
                                }
                                zz zzVar = new zz("proofs overview screen open", null, 2);
                                zzVar.a("source", j().e);
                                ui1.l0(zzVar);
                                return;
                            }
                            n86.l("viewModel");
                            throw null;
                        }
                        n86.l("viewModel");
                        throw null;
                    }
                    n86.l("viewModel");
                    throw null;
                }
                n86.l("viewModel");
                throw null;
            }
            n86.l("viewModel");
            throw null;
        }
        n86.l("viewModel");
        throw null;
    }

    public final void i(ed1 ed1) {
        ed1.a("source", "userProofOverviewFragment");
        ed1.a(AnalyticsConstants.FLOW, j().f);
        ed1.a("isSuperPass", Boolean.TRUE);
    }

    public final SuperPassPurchaseSharedViewModel j() {
        return (SuperPassPurchaseSharedViewModel) this.h.getValue();
    }

    public final void k() {
        if (c() != null) {
            Intent g0 = vn.g0(this);
            String stringExtra = g0.getStringExtra("output");
            if (stringExtra != null) {
                ga1 ga1 = this.g;
                if (ga1 != null) {
                    Objects.requireNonNull(ga1);
                    n86.e(stringExtra, "lLocalImageUri");
                    ga1.e.setProofImageLocalUri(stringExtra);
                    ga1.c.b("keyEditedProofUploadDetails", ga1.e);
                } else {
                    n86.l("viewModel");
                    throw null;
                }
            }
            r<Intent> rVar = this.k;
            if (rVar != null) {
                rVar.a(g0, null);
            } else {
                n86.l("photoChooser");
                throw null;
            }
        }
    }

    public final void l(boolean z) {
        ed1 ed1 = new ed1("camera permission denied dialog displayed", Long.MIN_VALUE);
        ed1.a("isDismissed", Boolean.valueOf(z));
        i(ed1);
        ui1.m0(ed1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        n86.e(context, AnalyticsConstants.CONTEXT);
        super.onAttach(context);
        r<String[]> registerForActivityResult = registerForActivityResult(new u(), new v51(this));
        n86.d(registerForActivityResult, "registerForActivityResul… }\n            \n        }");
        this.j = registerForActivityResult;
        r<Intent> registerForActivityResult2 = registerForActivityResult(new w(), new u51(this));
        n86.d(registerForActivityResult2, "registerForActivityResul…)\n            }\n        }");
        this.k = registerForActivityResult2;
        r<Intent> registerForActivityResult3 = registerForActivityResult(new w(), new q51(this));
        n86.d(registerForActivityResult3, "registerForActivityResul…}\n            }\n        }");
        this.l = registerForActivityResult3;
    }

    @Override // defpackage.rl0, androidx.fragment.app.Fragment
    public void onDestroyView() {
        jz5.b().o(this);
        super.onDestroyView();
    }

    public final void onEvent(ImageUploadUrlEvent imageUploadUrlEvent) {
        n86.e(imageUploadUrlEvent, "lEvent");
        String proofId = imageUploadUrlEvent.getProofId();
        String configRequestId = imageUploadUrlEvent.getConfigRequestId();
        String localImageUri = imageUploadUrlEvent.getLocalImageUri();
        if (imageUploadUrlEvent.getResponseType() == ad1.SUCCESS) {
            SuperPassPurchaseSharedViewModel j2 = j();
            n86.d(proofId, "lProofId");
            n86.d(localImageUri, "lLocalImageUri");
            String imageUrl = imageUploadUrlEvent.getImageUrl();
            n86.d(imageUrl, "lEvent.imageUrl");
            n86.d(configRequestId, "lUploadRequestId");
            j2.i(proofId, localImageUri, imageUrl, configRequestId, ProofUploadStatus.UPLOAD_SUCCESSFUL);
        } else if (imageUploadUrlEvent.getResponseType() == ad1.FAILED) {
            SuperPassPurchaseSharedViewModel j3 = j();
            n86.d(proofId, "lProofId");
            n86.d(localImageUri, "lLocalImageUri");
            String str = new String();
            n86.d(configRequestId, "lUploadRequestId");
            j3.i(proofId, localImageUri, str, configRequestId, ProofUploadStatus.UPLOAD_FAILED);
        }
    }
}
