package com.baeldung.osgi.sample.service.implementation;

import com.baeldung.osgi.sample.service.definition.Greeter;
import com.quaero.Test;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.framework.startlevel.BundleStartLevel;

import java.util.Hashtable;

public class GreeterImpl implements Greeter, BundleActivator {

    private ServiceReference<Greeter> reference;
    private ServiceRegistration<Greeter> registration;

    @Override public String sayHiTo(String name) {
    	System.out.println("sayHiTo" + ":Testjar1:" + Test.getName());
        return "Hello " + name;
    }                              

    @Override public void start(BundleContext context) throws Exception {
       
//    	BundleStartLevel bundleStartLevel = context.getBundle().adapt(BundleStartLevel.class);
//    	System.out.println("Testjar1 : Start level " + bundleStartLevel.getStartLevel());
//    	bundleStartLevel.setStartLevel(81);
//    	System.out.println("Testjar1 : Start level after" + bundleStartLevel.getStartLevel());
        
    	System.out.println("Registering service.OSGi Service-1");
        System.out.println(Test.getName());
        registration = context.registerService(Greeter.class, new GreeterImpl(), new Hashtable<String, String>());
        reference = registration.getReference();
        
        
        
    }

    @Override public void stop(BundleContext context) throws Exception {
        System.out.println("Unregistering service. OSGi service-1");
        registration.unregister();
    }
}
