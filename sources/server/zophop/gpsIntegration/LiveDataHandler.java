package server.zophop.gpsIntegration;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.maps.model.LatLng;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import server.zophop.Constants;
import server.zophop.GpsAnalytics.RoutePrediction;
import server.zophop.dataLayer.Firebase.SessionData;
import server.zophop.dataLayer.Firebase.StaticData;
import server.zophop.dataLayer.Firebase.VehicleData;
import server.zophop.gpsIntegration.models.VehicleCheckinInfo;
import server.zophop.gpsIntegration.models.VehicleGPSInfo;
import server.zophop.logging.LoggingConstants;
import server.zophop.logicLayer.DataContainer;
import server.zophop.models.CheckOutType;
import server.zophop.models.HaltState;
import server.zophop.models.HaltStatus;
import server.zophop.models.HaltValidate;
import server.zophop.models.IHaltValidation;
import server.zophop.models.Meta;
import server.zophop.models.Point;
import server.zophop.models.Route;
import server.zophop.models.SimpleLogger;
import server.zophop.models.Source;
import server.zophop.models.Stop;
import server.zophop.models.Stream;
import server.zophop.queue.IQueue;
import server.zophop.routeValidation.BusOnRouteValidator;
import server.zophop.routeValidation.IValidator;
import server.zophop.routeValidation.RouteDeviationValidator;
import server.zophop.routeValidation.RouteDirectionValidator;
import server.zophop.routeValidation.RoutePolylineDirectionValidator;
import server.zophop.utils.DataMapCreator;
import server.zophop.utils.DataObjectCreator;
import server.zophop.utils.DistanceUtils;
import server.zophop.utils.SlackAlertsUtils;

public class LiveDataHandler {
    private static final int MIN_BUS_TRAVEL_DISTANCE = 15;
    public IValidator _busOnRouteValidator;
    private DataContainer _dataContainer;
    private EventHandler _eventHandler;
    public IHaltValidation _haltValidation = new HaltValidate();
    private DataMapCreator _mapCreator;
    private DataObjectCreator _objectCreator;
    public IValidator _routeDeviationValidator;
    public IValidator _routeDirectionValidator;
    public IValidator _routePoylineDirectionValidator;
    private RoutePrediction _routePrediction = new RoutePrediction();

    public LiveDataHandler(IQueue iQueue, DataContainer dataContainer) {
        this._dataContainer = dataContainer;
        this._objectCreator = new DataObjectCreator();
        this._eventHandler = new EventHandler(iQueue);
        this._mapCreator = new DataMapCreator();
        this._busOnRouteValidator = new BusOnRouteValidator(dataContainer);
        this._routeDeviationValidator = new RouteDeviationValidator(dataContainer);
        this._routeDirectionValidator = new RouteDirectionValidator(dataContainer);
        this._routePoylineDirectionValidator = new RoutePolylineDirectionValidator();
    }

    private void checkOut(final VehicleCheckinInfo vehicleCheckinInfo, final CheckOutType checkOutType, long j, String str) {
        final String city = vehicleCheckinInfo.getCity();
        String mode = vehicleCheckinInfo.getMode();
        String agency = vehicleCheckinInfo.getAgency();
        final String vehicleId = vehicleCheckinInfo.getVehicleId();
        final String streamId = vehicleCheckinInfo.getStreamId();
        VehicleData.checkOutIfOpen(city, mode, agency, vehicleId, streamId, checkOutType, new Runnable() {
            /* class server.zophop.gpsIntegration.LiveDataHandler.AnonymousClass2 */

            public void run() {
                vehicleCheckinInfo.checkOut();
                LiveDataHandler.this._eventHandler.fireStreamRemovedTask(streamId, vehicleId, checkOutType, city);
            }
        }, j, str, isUpdateStatus(vehicleCheckinInfo.getStatus()));
    }

    private void checkoutOldEntries(final VehicleCheckinInfo vehicleCheckinInfo, final CheckOutType checkOutType, long j) {
        final String city = vehicleCheckinInfo.getCity();
        String mode = vehicleCheckinInfo.getMode();
        String agency = vehicleCheckinInfo.getAgency();
        final String vehicleId = vehicleCheckinInfo.getVehicleId();
        final String streamId = vehicleCheckinInfo.getStreamId();
        VehicleData.checkOutIfOpen(city, mode, agency, vehicleId, streamId, checkOutType, new Runnable() {
            /* class server.zophop.gpsIntegration.LiveDataHandler.AnonymousClass3 */

            public void run() {
                vehicleCheckinInfo.checkOut();
                LiveDataHandler.this._eventHandler.fireStreamRemovedTask(streamId, vehicleId, checkOutType, city);
            }
        }, j, "", isUpdateStatus(vehicleCheckinInfo.getStatus()));
    }

    private void checkoutTrip(final VehicleCheckinInfo vehicleCheckinInfo, final CheckOutType checkOutType, long j, String str) {
        final String city = vehicleCheckinInfo.getCity();
        String mode = vehicleCheckinInfo.getMode();
        String agency = vehicleCheckinInfo.getAgency();
        final String vehicleId = vehicleCheckinInfo.getVehicleId();
        final String streamId = vehicleCheckinInfo.getStreamId();
        VehicleData.endTripIfStarted(city, mode, agency, vehicleId, streamId, checkOutType, new Runnable() {
            /* class server.zophop.gpsIntegration.LiveDataHandler.AnonymousClass4 */

            public void run() {
                vehicleCheckinInfo.checkOutSession();
                LiveDataHandler.this._eventHandler.fireStreamRemovedTask(streamId, vehicleId, checkOutType, city);
            }
        }, j, str, isUpdateStatus(vehicleCheckinInfo.getStatus()));
    }

    private Meta createMeta(VehicleGPSInfo vehicleGPSInfo, Route route, Point point, String str) {
        int nextStopIndex = getNextStopIndex(point, route, str);
        double calculateSpeed = calculateSpeed(point, vehicleGPSInfo.getLastPoint(), vehicleGPSInfo.getLastSpeed(), vehicleGPSInfo.getMode());
        Stop stop = this._dataContainer.getStop(str, route.getStationType(), route.getStop(route.getStopSequence().size() - 1));
        return new Meta(route.getStop(nextStopIndex), route.getStop(nextStopIndex - 1), calculateSpeed, (int) (DistanceUtils.straightDistance(point.getLatitude(), point.getLongitude(), stop.getLat(), stop.getLon()) / calculateSpeed));
    }

    private Stream createStream(Route route, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        String uniqueStreamId = SessionData.getUniqueStreamId(str2);
        SimpleLogger.warning("new stream created with id " + uniqueStreamId);
        SimpleLogger.warning("source " + str);
        Stream stream = new Stream(str2, str4, uniqueStreamId, str5, route.getId(), str6, str7, str, System.currentTimeMillis());
        stream.setRouteName(route.getName());
        stream.setStationType(str3);
        return stream;
    }

    private void forwardHaltStateToSlack(VehicleGPSInfo vehicleGPSInfo, HaltState haltState, boolean z, Route route) {
        if (z && vehicleGPSInfo.getHaltState().getHaltStatus().equals(HaltStatus.HARD_HALT)) {
            forwardToSlack("state changed", vehicleGPSInfo, haltState, route);
        }
    }

    private void forwardToSlack(String str, VehicleGPSInfo vehicleGPSInfo, HaltState haltState, Route route) {
        if (!vehicleGPSInfo.getCity().equalsIgnoreCase("kolkata")) {
            StringBuilder k0 = hj1.k0(str, " : ");
            k0.append(vehicleGPSInfo.getCity());
            k0.append(" : ");
            k0.append(vehicleGPSInfo.getAgency());
            k0.append(" : ");
            k0.append(vehicleGPSInfo.getVehicleId());
            k0.append(" :  : ");
            k0.append(haltState.getHaltPoint().getTime());
            k0.append(" : ");
            k0.append(haltState.getHaltStatus());
            k0.append(" : ");
            k0.append(route.getName());
            k0.append(" : ");
            k0.append(route.getId());
            SlackAlertsUtils.send(k0.toString());
        }
    }

    private Route getReverseRoute(VehicleCheckinInfo vehicleCheckinInfo, Route route) {
        Route reverseRouteByRrKey = getReverseRouteByRrKey(vehicleCheckinInfo, route);
        if (reverseRouteByRrKey != null) {
            return reverseRouteByRrKey;
        }
        return null;
    }

    private Route getReverseRouteByRrKey(VehicleCheckinInfo vehicleCheckinInfo, Route route) {
        String reverseRouteId = route.getReverseRouteId();
        SimpleLogger.warning(" reverse route id : " + reverseRouteId);
        if (reverseRouteId == null || reverseRouteId.trim().length() <= 0) {
            return null;
        }
        return StaticData.getRouteFromFirebase(vehicleCheckinInfo.getCity(), route.getStationType(), reverseRouteId);
    }

    private Route getReverseRouteByTerminalStopsName(VehicleCheckinInfo vehicleCheckinInfo, Route route) {
        List<Route> allBusRoutes = this._dataContainer.getAllBusRoutes(vehicleCheckinInfo.getCity());
        if (allBusRoutes == null || allBusRoutes.size() == 0) {
            return null;
        }
        for (Route route2 : allBusRoutes) {
            if (route.getFirstStop().equalsIgnoreCase(route2.getLastStop())) {
                return route2;
            }
        }
        return null;
    }

    private boolean hasReachedLastStop(VehicleCheckinInfo vehicleCheckinInfo, Point point, Route route) {
        Stop stop = this._dataContainer.getStop(vehicleCheckinInfo.getCity(), vehicleCheckinInfo.getMode(), route.getStop(route.getStopSequence().size() - 1));
        if (DistanceUtils.straightDistance(stop.getLat(), stop.getLon(), point.getLatitude(), point.getLongitude()) < 500.0d) {
            return true;
        }
        return false;
    }

    private boolean isBusMoved(VehicleGPSInfo vehicleGPSInfo, Point point) {
        return DistanceUtils.straightDistance(vehicleGPSInfo.getLastPoint().getLatitude(), vehicleGPSInfo.getLastPoint().getLongitude(), point.getLatitude(), point.getLongitude()) > 15.0d;
    }

    private boolean isOldPacket(VehicleGPSInfo vehicleGPSInfo, Point point) {
        return vehicleGPSInfo.getLastPoint().getTime() > point.getTime();
    }

    private boolean isPolylineCity(String str) {
        return str.equalsIgnoreCase("indore") || str.equalsIgnoreCase("guwahati") || str.equalsIgnoreCase("jaipur") || str.equalsIgnoreCase("bhopal");
    }

    private boolean isUpdateStatus(String str) {
        return str == null || str.equalsIgnoreCase("") || (!str.equalsIgnoreCase("Not Receiving Gps Data") && !str.equalsIgnoreCase("Not Running"));
    }

    private boolean isValidPacket(Point point) {
        long currentTimeMillis = System.currentTimeMillis() - point.getTime();
        return currentTimeMillis < 900000 && currentTimeMillis > 0;
    }

    private void logRouteReversingEvent(VehicleCheckinInfo vehicleCheckinInfo, Route route) {
        if (vehicleCheckinInfo.getCity().equalsIgnoreCase("indore")) {
            this._eventHandler.fireCheckOutTask(vehicleCheckinInfo.getVehicleId());
        }
        if (route != null && vehicleCheckinInfo.getCity().equalsIgnoreCase("indore")) {
            this._eventHandler.fireCheckInTask(vehicleCheckinInfo.getVehicleId(), route);
        }
    }

    private void logWrongDispatching(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        HashMap n0 = hj1.n0(Constants.VEHICLE_ID, str3, "city", str);
        n0.put("agency", str2);
        n0.put(LoggingConstants.ROUTE_ID, str4);
        n0.put("routeName", str5);
        n0.put("timeStamp", Long.valueOf(System.currentTimeMillis()));
        n0.put("source", str6);
        n0.put(LoggingConstants.FIRST_STOP, str7);
        n0.put(LoggingConstants.LAST_STOP, str7);
        n0.put("email", str9);
        this._eventHandler.addWrongDispatchingTask(n0);
    }

    private void reverseRoute(VehicleGPSInfo vehicleGPSInfo, VehicleCheckinInfo vehicleCheckinInfo, Point point, Route route, String str) {
        StringBuilder i0 = hj1.i0("route reversal :");
        i0.append(vehicleCheckinInfo.getVehicleId());
        i0.append(" : ");
        i0.append(vehicleCheckinInfo.getRouteId());
        SimpleLogger.debug(i0.toString());
        Route reverseRoute = getReverseRoute(vehicleCheckinInfo, route);
        if (reverseRoute != null) {
            updateCheckin(vehicleCheckinInfo, CheckOutType.autoReversal, reverseRoute, vehicleGPSInfo, Source.autoReversal, point, str);
        } else {
            StringBuilder i02 = hj1.i0("reverse route not found ");
            i02.append(vehicleCheckinInfo.getVehicleId());
            SimpleLogger.warning(i02.toString());
        }
        logRouteReversingEvent(vehicleCheckinInfo, reverseRoute);
    }

    private void startStream(Point point, final VehicleCheckinInfo vehicleCheckinInfo, final VehicleGPSInfo vehicleGPSInfo, Route route, String str, String str2) {
        StringBuilder i0 = hj1.i0("inside start stream ");
        i0.append(vehicleCheckinInfo.getStreamId());
        i0.append(" :");
        i0.append(route.getId());
        SimpleLogger.warning(i0.toString());
        String city = vehicleCheckinInfo.getCity();
        String mode = vehicleCheckinInfo.getMode();
        String agency = vehicleCheckinInfo.getAgency();
        String vehicleId = vehicleCheckinInfo.getVehicleId();
        final Stream createStream = createStream(route, str, city, mode, agency, vehicleId, route.getStopSequence().get(0), route.getStopSequence().get(route.getStopSequence().size() - 1));
        createStream.setOperator(str2);
        vehicleGPSInfo.setLastSpeed(point.getSpeed());
        VehicleData.updateStreamIdInVehicleCheckinInfo(city, mode, agency, vehicleId, createStream.getStreamId(), point.getTime(), new Runnable() {
            /* class server.zophop.gpsIntegration.LiveDataHandler.AnonymousClass1 */

            public void run() {
                SimpleLogger.warning(" inside new start of stream");
                SimpleLogger.warning(" stream is before setting streamid " + createStream.toString());
                vehicleCheckinInfo.setStreamId(createStream.getStreamId());
                SimpleLogger.warning(" stream is after setting streamid " + createStream.toString());
                SimpleLogger.warning("inside start stream runnable " + createStream.getStreamId() + " :" + createStream.getRouteId());
                LiveDataHandler.this._eventHandler.fireStreamAddedTask(vehicleGPSInfo.getVehicleId(), createStream);
            }
        });
    }

    private void storeVehicleInformation(VehicleGPSInfo vehicleGPSInfo) {
        VehicleData.updateVehicleInformation(vehicleGPSInfo.getCity(), vehicleGPSInfo.getMode(), vehicleGPSInfo.getAgency(), vehicleGPSInfo.getVehicleId(), this._mapCreator.getVehicleMap(vehicleGPSInfo));
    }

    private boolean testForCheckIn(VehicleCheckinInfo vehicleCheckinInfo) {
        return vehicleCheckinInfo.routeExists();
    }

    private boolean testForCheckOut(VehicleGPSInfo vehicleGPSInfo, VehicleCheckinInfo vehicleCheckinInfo, Point point, Route route) {
        if (!vehicleCheckinInfo.routeExists()) {
            return true;
        }
        boolean validate = this._routeDeviationValidator.validate(vehicleGPSInfo, vehicleCheckinInfo, route, point);
        if (validate) {
            this._eventHandler.fireRouteDeviationCheckoutTask(vehicleCheckinInfo, route, point, DistanceUtils.getDistanceToClosestStop(this._dataContainer, route, vehicleCheckinInfo.getCity(), vehicleCheckinInfo.getMode(), point));
        }
        return validate;
    }

    private boolean testForRouteReversal(VehicleGPSInfo vehicleGPSInfo, VehicleCheckinInfo vehicleCheckinInfo, Point point, Route route, String str) {
        boolean z;
        if (route.hasPolyline()) {
            z = this._routePoylineDirectionValidator.validate(vehicleGPSInfo, vehicleCheckinInfo, route, point);
        } else {
            z = this._routeDirectionValidator.validate(vehicleGPSInfo, vehicleCheckinInfo, route, point);
        }
        return !z;
    }

    private void updateCheckin(VehicleCheckinInfo vehicleCheckinInfo, CheckOutType checkOutType, Route route, VehicleGPSInfo vehicleGPSInfo, Source source, Point point, String str) {
        String city = vehicleCheckinInfo.getCity();
        String mode = vehicleCheckinInfo.getMode();
        String agency = vehicleCheckinInfo.getAgency();
        String vehicleId = vehicleCheckinInfo.getVehicleId();
        String id = route.getId();
        String name = route.getName();
        String streamId = vehicleCheckinInfo.getStreamId();
        VehicleData.updateCheckinCheckout(city, mode, agency, vehicleId, id, name, streamId, route.getFirstStop(), route.getLastStop(), source.toString(), new no6(this, vehicleCheckinInfo, id, vehicleGPSInfo, point, streamId, vehicleId, checkOutType, city));
    }

    public /* synthetic */ void a(VehicleCheckinInfo vehicleCheckinInfo, String str, VehicleGPSInfo vehicleGPSInfo, Point point, String str2, String str3, CheckOutType checkOutType, String str4) {
        vehicleCheckinInfo.checkOutSession();
        vehicleCheckinInfo.checkIn(str);
        vehicleGPSInfo.setLastSpeed(point.getSpeed());
        this._eventHandler.fireStreamRemovedTask(str2, str3, checkOutType, str4);
    }

    public double calculateSpeed(Point point, Point point2, double d, String str) {
        int i = str.equals("bus") ? 20 : 30;
        double straightDistance = DistanceUtils.straightDistance(point.getLatitude(), point.getLongitude(), point2.getLatitude(), point2.getLongitude());
        double C0 = (double) hj1.C0(point2, point.getTime(), 1000);
        double speed = (d * 0.9d) + (0.1d * (C0 <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? point.getSpeed() > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? point.getSpeed() : 0.5d : straightDistance / C0));
        double d2 = (double) i;
        if (speed > d2) {
            return d2;
        }
        if (speed < 0.5d) {
            return 0.5d;
        }
        return speed;
    }

    public int getNextStopIndex(Point point, Route route, String str) {
        double latitude = point.getLatitude();
        double longitude = point.getLongitude();
        List<String> stopSequence = route.getStopSequence();
        double d = 1.0E9d;
        int i = 0;
        int i2 = -1;
        while (i < stopSequence.size()) {
            int i3 = i + 1;
            if (i3 != stopSequence.size()) {
                Stop stop = this._dataContainer.getStop(str, route.getStationType(), stopSequence.get(i));
                Stop stop2 = this._dataContainer.getStop(str, route.getStationType(), stopSequence.get(i3));
                double straightDistance = DistanceUtils.straightDistance(latitude, longitude, stop.getLat(), stop.getLon());
                double straightDistance2 = DistanceUtils.straightDistance(latitude, longitude, stop2.getLat(), stop2.getLon());
                double straightDistance3 = DistanceUtils.straightDistance(stop2.getLat(), stop2.getLon(), stop.getLat(), stop.getLon());
                if (straightDistance3 > straightDistance && straightDistance3 > straightDistance2) {
                    return i3;
                }
                if (straightDistance < d) {
                    d = straightDistance;
                    i2 = i;
                }
                i = i3;
            } else if (i2 > 0) {
                return i2;
            } else {
                return 1;
            }
        }
        if (i2 > 0) {
            return i2;
        }
        return 1;
    }

    public VehicleCheckinInfo getVehicleCheckinInformation(String str, String str2, String str3, String str4) {
        Map vehicleCheckinInfo = VehicleData.getVehicleCheckinInfo(str, str2, str3, str4);
        if (vehicleCheckinInfo == null) {
            return null;
        }
        return DataObjectCreator.createVehicleCheckinInfo(str, str2, str3, str4, vehicleCheckinInfo);
    }

    public VehicleGPSInfo getVehicleGPSInformation(String str, String str2, String str3, String str4) {
        Map vehicleGPSInfo = VehicleData.getVehicleGPSInfo(str, str2, str3, str4);
        if (vehicleGPSInfo == null) {
            return null;
        }
        return DataObjectCreator.createVehicleGPSInfo(str, str2, str3, str4, vehicleGPSInfo);
    }

    public void processCheckIn(String str, String str2, String str3, String str4, String str5, long j, String str6, String str7) {
        List<Route> routesByName = StaticData.getRoutesByName(str, str2, str5);
        Route route = null;
        if (!(routesByName == null || routesByName.size() == 0)) {
            for (Route route2 : routesByName) {
                if (route2.getAgency().equalsIgnoreCase(str3)) {
                    if (route == null) {
                        route = route2;
                    }
                    if (str6 != null && route2.getFirstStop().equals(str6)) {
                        route = route2;
                    }
                }
            }
        }
        if (route != null) {
            VehicleData.updateCheckinInVehicleCheckinInfo(str, str2, str3, str4, route.getId(), route.getName(), route.getFirstStop(), route.getLastStop(), str7, true);
            return;
        }
        SimpleLogger.severe("Dispatch: Route not found for checkin: " + str5);
    }

    public void processCheckInwithRouteId(String str, String str2, String str3, String str4, String str5, long j, String str6, String str7, String str8) {
        PrintStream printStream = System.out;
        printStream.println("checking in routeId  : " + str5 + " for city : " + str);
        Route route = this._dataContainer.getRoute(str, str2, str5);
        if (route != null) {
            String name = route.getName();
            String firstStop = route.getFirstStop();
            String lastStop = route.getLastStop();
            boolean isUpdateStatus = isUpdateStatus(str8);
            VehicleGPSInfo vehicleGPSInformation = getVehicleGPSInformation(str, str2, str3, str4);
            if (vehicleGPSInformation != null) {
                if (!Boolean.valueOf(this._busOnRouteValidator.validate(vehicleGPSInformation, null, route, null)).booleanValue()) {
                    logWrongDispatching(str, str3, str4, str5, name, str6, firstStop, lastStop, str7);
                    if (isUpdateStatus) {
                        VehicleData.AddStatusToDisaptch(str, str3, str2, str4, Constants.STATUS_INCORRECT_CHECK_IN);
                        PrintStream printStream2 = System.out;
                        printStream2.println("city: " + str + "bus no " + str4 + "dispatched on wrong route " + str5 + " !!! v:(");
                        return;
                    }
                    return;
                }
                VehicleData.updateCheckinInVehicleCheckinInfo(str, str2, str3, str4, str5, name, firstStop, lastStop, str6, isUpdateStatus);
            } else {
                return;
            }
        }
        PrintStream printStream3 = System.out;
        printStream3.println(" route with routeId : " + str5 + " for a city : " + str + " does not exist");
    }

    public VehicleCheckinInfo processCheckOut(String str, String str2, String str3, String str4, CheckOutType checkOutType, long j, String str5) throws Exception {
        VehicleCheckinInfo vehicleCheckinInformation = getVehicleCheckinInformation(str, str2, str3, str4);
        if (vehicleCheckinInformation != null) {
            checkOut(vehicleCheckinInformation, checkOutType, j, str5);
            return vehicleCheckinInformation;
        }
        throw new Exception("vehicle checkin info not found");
    }

    public void receivedPoint(String str, String str2, String str3, String str4, String str5, Point point, String str6, long j) {
        VehicleGPSInfo vehicleGPSInfo;
        Point point2;
        VehicleGPSInfo vehicleGPSInfo2;
        VehicleGPSInfo vehicleGPSInfo3;
        Point point3;
        Point point4 = point;
        VehicleCheckinInfo vehicleCheckinInformation = getVehicleCheckinInformation(str, str2, str3, str4);
        VehicleGPSInfo vehicleGPSInformation = getVehicleGPSInformation(str, str2, str3, str4);
        if (vehicleGPSInformation == null) {
            vehicleGPSInfo = new VehicleGPSInfo(str2, str, str3, str4, str5, null, point, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, null, 0, 0, new LatLng((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), new HaltState(HaltStatus.NO_HALT, point4));
            point2 = point4;
        } else if (!isOldPacket(vehicleGPSInformation, point4) || isValidPacket(point4)) {
            HaltState validate = this._haltValidation.validate(vehicleGPSInformation, point4);
            validate.getHaltStatus().equals(vehicleGPSInformation.getHaltState().getHaltStatus());
            vehicleGPSInformation.setHaltState(validate);
            if (vehicleCheckinInformation != null) {
                Route route = this._dataContainer.getRoute(str, str2, vehicleCheckinInformation.getRouteId());
                if (vehicleCheckinInformation.isCheckedIn()) {
                    boolean testForCheckOut = testForCheckOut(vehicleGPSInformation, vehicleCheckinInformation, point4, route);
                    if (!validate.getHaltStatus().equals(HaltStatus.HARD_HALT)) {
                        point3 = point4;
                        if (testForCheckOut) {
                            checkOut(vehicleCheckinInformation, CheckOutType.autoRouteDeviation, j, route.getId());
                            vehicleGPSInformation.setLastVisitedStopId(null);
                            vehicleGPSInformation.setReversalCount(0);
                        } else if (testForRouteReversal(vehicleGPSInformation, vehicleCheckinInformation, point, route, str)) {
                            reverseRoute(vehicleGPSInformation, vehicleCheckinInformation, point, route, str6);
                        } else {
                            Meta createMeta = createMeta(vehicleGPSInformation, route, point3, str);
                            StringBuilder i0 = hj1.i0("calculate meta ");
                            i0.append(createMeta.getNextStopId());
                            i0.append(", ");
                            i0.append(createMeta.getPreviousStopId());
                            i0.append(", ");
                            i0.append(createMeta.getSpeed());
                            i0.append(", ");
                            i0.append(createMeta.getDestinationEta());
                            SimpleLogger.info(i0.toString());
                            point4 = point3;
                            vehicleGPSInfo3 = vehicleGPSInformation;
                            this._eventHandler.fireAddPointTask(str4, vehicleCheckinInformation.getStreamId(), point, createMeta, str3, route, str, j, validate);
                            vehicleGPSInfo3.setLastSpeed(createMeta.getSpeed());
                        }
                    } else if (!hasReachedLastStop(vehicleCheckinInformation, point4, route) || !route.hasReverseRouteId()) {
                        point3 = point4;
                        forwardToSlack("trip end", vehicleGPSInformation, validate, route);
                        checkoutTrip(vehicleCheckinInformation, CheckOutType.halt, j, route.getId());
                    } else {
                        forwardToSlack("rr and te", vehicleGPSInformation, validate, route);
                        point3 = point4;
                        reverseRoute(vehicleGPSInformation, vehicleCheckinInformation, point, route, str6);
                    }
                    point2 = point3;
                } else {
                    vehicleGPSInfo3 = vehicleGPSInformation;
                    if (testForCheckIn(vehicleCheckinInformation) && !validate.getHaltStatus().equals(HaltStatus.HARD_HALT)) {
                        String source = vehicleCheckinInformation.getSource();
                        vehicleGPSInfo2 = vehicleGPSInfo3;
                        point2 = point4;
                        startStream(point, vehicleCheckinInformation, vehicleGPSInfo3, route, source, str6);
                        vehicleGPSInfo = vehicleGPSInfo2;
                    }
                }
                vehicleGPSInfo2 = vehicleGPSInfo3;
                point2 = point4;
                vehicleGPSInfo = vehicleGPSInfo2;
            } else {
                point2 = point4;
            }
            vehicleGPSInfo2 = vehicleGPSInformation;
            vehicleGPSInfo = vehicleGPSInfo2;
        } else {
            return;
        }
        vehicleGPSInfo.setLastPoint(point2);
        storeVehicleInformation(vehicleGPSInfo);
    }
}
