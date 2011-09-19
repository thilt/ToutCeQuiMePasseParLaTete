package com.tibo.dev.common;

/**
 * Created by IntelliJ IDEA.
 * User: tibo
 * Date: 19/09/11
 * Time: 22:13
 * To change this template use File | Settings | File Templates.
 */
public class EqualsHelper {

    /**
     * Returns the result of equals method on an Object
     * @param o1
     * @param o2
     * @return   true if o1 is the same as o2
     */
    public static boolean isEquals(Object o1, Object o2) {
		return (o1 == null) ? (o2 == null) : o1.equals(o2);
	}

    /**
     * Returns the hashcode of a given object
     * @param obj
     * @return
     */
    public static int hashCodeOf(Object obj) {
		return (obj == null) ? 0 : obj.hashCode();
	}

    /**
     * Returns the hashcode of a boolean
     * @param b
     * @return
     */
    public static int hashCodeOf(boolean b) {
		return (b ? 1 : 0);
	}

    /**
     * Returns the hascode of a long value
     * @param value
     * @return
     */
    public static int hashCodeOf(long value) {
		return (int)(value ^ (value >>> 32));
	}
}
