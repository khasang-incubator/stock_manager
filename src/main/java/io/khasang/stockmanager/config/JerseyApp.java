package io.khasang.stockmanager.config;

import io.khasang.stockmanager.controller.JerseyLocationController;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/service")
public class JerseyApp extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<>();
        classes.add(JerseyLocationController.class);
        return classes;
    }
}