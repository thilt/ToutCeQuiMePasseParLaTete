package com.tibo.dev.common;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: tibo
 * Date: 14/07/11
 * Time: 12:40
 * To change this template use File | Settings | File Templates.
 */
public class SafeList<E> extends ArrayList<E> implements List<E>{

    /**
     * Get ieme element of the list
     * @param i index of the element to retrieve
     * @return the element
     */
    @Override
    public E get(int i) {
        if (i > this.size()){
            return null;
        }
        return super.get(i);    //To change body of overridden methods use File | Settings | File Templates.
    }

    /**
     * Get the first element of the list
     * @return an Object
     */
    public E getFirst(){
         if (this.size()<1){
            return null;
        }
        return get(0);
    }

    /**
     * Get the last element of the list
     * @return
     */
    public E getLast(){
        if (this.size()<1){
            return null;
        }
        return get(this.size()-1);
    }
}
