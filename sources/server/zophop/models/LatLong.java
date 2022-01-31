package server.zophop.models;

import com.google.maps.model.EncodedPolyline;
import com.google.maps.model.LatLng;
import com.rabbitmq.client.StringRpcServer;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class LatLong {
    public static void main(String[] strArr) throws UnsupportedEncodingException {
        for (LatLng latLng : new EncodedPolyline(URLDecoder.decode("ynhlCiknwMkGcA_Em@mLsBaJ}AiDk@qOcCsHsAwDm@mB[sCa@_J}AaBUuOgCiBOm@IgI_B}F{@{K{Aw@MiBMsDEqCGmDAgCD}FDu@?{JJuDBwADgCAmMVeEDmDJqAAi@B}@BkANg@@eEg@mAMe@@uCd@o@Fi@BqOToFNa@IWAsDIo@GQ?LeAF_@JeAEo@COU[q@o@{B{As@o@o@s@mAkBOY[w@Uw@Wq@a@w@yDgFg@aAOc@g@wB{A_IKUCUWeDAQgAkSEcBOIk@]wDkCkAs@GEm@AiD@aFFqODoL@C@k@H}@?ABCBC@L`DH~HAfEIhG@@@B@D?FGDG?ECaABuEGoBIqEe@oAQoCo@C?G?CAAAGRSEa@SFSQI_@SWM]Ug@]a@]o@g@WUSQ@@}BqBs@g@C?GAAEAC?Am@k@uCiBaA_@mGiCwD}AqBw@C@G@MCEI?SFGw@_KQoBAACAEG?QBI@?Gy@g@cHMeBAKOkAIq@EOe@Rg@Rg@Rc@Pe@Re@Re@Pg@R_@Pg@Rg@Rc@N]Ni@Pe@Pg@Pg@Ri@PIDg@Rg@Ri@Pg@Rg@Pg@Rg@Pg@Rg@R{@\\{@Z_Af@e@Xg@d@GB@?c@^a@\\c@`@YX[XSPE\\[\\KLS]g@m@KM?@]a@g@e@Y[e@e@a@c@c@a@a@_@GL]_@[c@@IMOMAECAAGOBM[gAKo@g@gEy@sGIo@?u@LyA^uC`AeHNmCCCACCK@I@C@CPKXEb@Gb@AtAI@EBCJGF@JDr@CbDQxB?nABoAG?XeC@sCJk@DIHMLUISCU?@@o@FWFo@VADA@ABSDQEEGYC}AFkDNO@iMrAsDf@kEdAsBb@qAR_CX}AReAJMDMJILi@nAMX{DzHuDxG[d@aDfFy@nAuFbIkA`B_@TqA|@yA`Ao@VSFqKvAmH`Aq@HCDEDOBUCGEQF_A?QAkGnAoBVaDj@sEz@_ADIBKCEECECOSSmCwCiEiEOMESQAe@Ju@|@yAzBwBdDQZ?Pk@x@s@nAiCdEOVeBxCcApAMRSXeEnFyAdBMh@_@|E_@~D?T@VLX`CtFdAxCd@tAlAfDRh@BPBZ@zEK`CEtBQxCIz@IVYp@k@xBe@`CMt@KCm@EaE_AqHgBIEWUiAg@c@KIGqBa@SECAiFmA}GqAaBc@_@Vk@ZWBMAqCg@y@YcGgC}DaB[OuAs@}AcAuCwBsB}AgAs@mBuA}E}CWSIuCKSKMqG{DVYr@yAnFwK~DcIdCgFJS{DgCmDwB@C\\oA", StringRpcServer.STRING_ENCODING)).decodePath()) {
            PrintStream printStream = System.out;
            printStream.println(latLng.lat + "," + latLng.lng);
            System.out.println(latLng.toString());
        }
    }
}
