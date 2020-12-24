package com.baeldung2.osgi.sample.service.implementation2;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.framework.startlevel.BundleStartLevel;

import com.baeldung2.osgi.sample.service.definition2.Greeter2;
import com.quaero.Test;

import java.util.Hashtable;

public class GreeterImpl2 implements Greeter2, BundleActivator {

    private ServiceReference<Greeter2> reference;
    private ServiceRegistration<Greeter2> registration;

    @Override public String sayHiTo(String name) {
    	System.out.println("sayHiTo" + ":Testjar2:" + Test.getName());
        return "Hello " + name;
    }

    @Override public void start(BundleContext context) throws Exception {
//    	BundleStartLevel bundleStartLevel = context.getBundle().adapt(BundleStartLevel.class);
//    	System.out.println("Testjar2 : Start level default " + bundleStartLevel.getStartLevel());
//    	bundleStartLevel.setStartLevel(82);
//    	System.out.println("Testjar2 : Start level after" + bundleStartLevel.getStartLevel());
    	
        
        System.out.println("Registering service. OSGI Service-2");
        System.out.println(Test.getName());
        registration = context.registerService(Greeter2.class, new GreeterImpl2(), new Hashtable<String, String>());
        reference = registration.getReference();
        
    }

    @Override public void stop(BundleContext context) throws Exception {
        System.out.println("Unregistering service. OSGi service-2");
        registration.unregister();
    }
}
