package com.tibo.dev.common;

/**
 * Created by IntelliJ IDEA.
 * User: tibo
 * Date: 19/09/11
 * Time: 22:13
 * To change this template use File | Settings | File Templates.
 */
public class EqualsHelper {

    public static boolean isEquals(Object o1, Object o2) {
		return (o1 == null) ? (o2 == null) : o1.equals(o2);
	}

    public static int hashCodeOf(Object obj) {
		return (obj == null) ? 0 : obj.hashCode();
	}

    public static int hashCodeOf(boolean b) {
		return (b ? 1 : 0);
	}

    public static int hashCodeOf(long value) {
		return (int)(value ^ (value >>> 32));
	}
}
