package com.dpet.commons.utils;

import java.text.DecimalFormat;

public class DoubleUtils {

	public static double formatDouble2(double d) {
		DecimalFormat df = new DecimalFormat("######0.00");
		return Double.parseDouble(df.format(d));
	}
}
