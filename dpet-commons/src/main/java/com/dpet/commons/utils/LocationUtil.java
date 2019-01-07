package com.dpet.commons.utils;

public class LocationUtil {
	/**
	 * 计算地球上任意两点(经纬度)距离
	 *
	 * @param long1 第一点经度
	 * @param lat1  第一点纬度
	 * @param long2 第二点经度
	 * @param lat2  第二点纬度
	 * @return 返回距离 单位：公里
	 */
	public static double distanceByLongNLat(double long1, double lat1, double long2, double lat2) {
	    double a, b, R;
	    R = 6378137;//地球半径
	    lat1 = lat1 * Math.PI / 180.0;
	    lat2 = lat2 * Math.PI / 180.0;
	    a = lat1 - lat2;
	    b = (long1 - long2) * Math.PI / 180.0;
	    double d;
	    double sa2, sb2;
	    sa2 = Math.sin(a / 2.0);
	    sb2 = Math.sin(b / 2.0);
	    d = 2 * R * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1) * Math.cos(lat2) * sb2 * sb2)) / 1000;
	    return d;
	}

	/**
	 * 根据经纬度和半径计算经纬度范围
	 *
	 * @param raidus 单位公里
	 * @return minLat, minLng, maxLat, maxLng
	 */
	public static double[] getAround(double lat, double lon, int raidus) {

		double latitude = lat;
		double longitude = lon;

		double degree = (24901 * 1609) / 360.0;
	    double raidusMile = raidus * 1000;

	    double dpmLat = 1 / degree;
	    double radiusLat = Math.abs(dpmLat * raidusMile);
	    double minLat = latitude - radiusLat;
	    double maxLat = latitude + radiusLat;

	    double mpdLng = degree * Math.cos(latitude * (Math.PI / 180));
	    double dpmLng = 1 / mpdLng;
	    double radiusLng = Math.abs(dpmLng * raidusMile);
	    double minLng = longitude - radiusLng;
	    double maxLng = longitude + radiusLng;
	    
	    return new double[]{minLat, minLng, maxLat, maxLng};
	}
}
