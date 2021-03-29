package com.ralph.factory;

import com.ralph.bean.AirPlane;

/**
 * Description:静态工厂
 * Class:
 * Author:     ralph
 **/
public class AirPlaneStaticFactory {
    // AirPlaneStaticFactory.getAirPlane();
    public static AirPlane getAirPlane(String jzName){
        System.out.println("静态工厂被调用");
        AirPlane airPlane = new AirPlane();
        airPlane.setFdj("1");
        airPlane.setFjsName("2");
        airPlane.setJzName(jzName);
        airPlane.setPersomNum(123);
        airPlane.setYc("3");
        return airPlane;
    }
}
