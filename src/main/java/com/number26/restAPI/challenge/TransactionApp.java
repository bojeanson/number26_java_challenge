package com.number26.restAPI.challenge;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/services")
public class TransactionApp extends Application {
   private Set<Object> singletons = new HashSet<Object>();

   public TransactionApp() {
      singletons.add(new TransactionResource());
   }

   @Override
   public Set<Object> getSingletons() {
      return singletons;
   }
}