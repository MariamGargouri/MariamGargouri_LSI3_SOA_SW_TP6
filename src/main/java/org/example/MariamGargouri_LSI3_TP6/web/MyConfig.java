package org.example.MariamGargouri_LSI3_TP6.web;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // pour indiquer que cette classe contient la configuration de notre application
public class MyConfig {
    @Bean//retourne l'objet (le bean) que Spring doit gérer.
    public ResourceConfig resourceConfig(){
        ResourceConfig jersyServlet = new ResourceConfig();
        jersyServlet.register(CompteRestJAXAPI.class);
        return jersyServlet;
    }
}
