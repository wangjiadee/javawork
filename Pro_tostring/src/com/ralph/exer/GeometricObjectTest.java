package com.ralph.exer;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class GeometricObjectTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(GeometricObject.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @org.junit.Test
    public void getWeight() {
    }

    @org.junit.Test
    public void getColor() {
    }

    @org.junit.Test
    public void setColor() {
    }

    @org.junit.Test
    public void setWeight() {
    }
}
