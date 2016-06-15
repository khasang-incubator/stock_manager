package io.khasang.stockmanager.config;

import io.khasang.stockmanager.controller.JerseyController;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/test")
public class JerseyApp extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<>();
        classes.add(JerseyController.class);
        return classes;
    }
}