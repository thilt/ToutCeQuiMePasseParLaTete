package com.tibo.dev.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: tibo
 * Date: 03/03/11
 * Time: 21:53
 * To change this template use File | Settings | File Templates.
 */
public class Hope {

    private enum configuration{
        A("TOTO"){
            @Override
            public String getTexte() {
                return "TATA";  //To change body of implemented methods use File | Settings | File Templates.
            }
        };

        private String t;

        private configuration(String s){
            this.t = s;
        }

        public String getT(){
            return this.t;
        }

        public abstract String getTexte();

    }

    public Hope() {
    }

    public static void main(String[] args){
        System.out.println(configuration.A.getT());
        System.out.println(configuration.A.getTexte());
    }

    public Connection openConnection(){
        try {
            Connection connection = DriverManager.getConnection("", "", "");
            connection.
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

}
