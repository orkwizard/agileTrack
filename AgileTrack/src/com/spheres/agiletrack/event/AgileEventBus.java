package com.spheres.agiletrack.event;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.SubscriberExceptionContext;
import com.google.common.eventbus.SubscriberExceptionHandler;
import com.spheres.agiletrack.view.AgiletrackUI;

public class AgileEventBus implements SubscriberExceptionHandler {

    private final EventBus eventBus = new EventBus(this);

    public static void post(final Object event) {
        AgiletrackUI.getAgileEventbus().eventBus.post(event);
    }

    public static void register(final Object object) {
    	AgiletrackUI.getAgileEventbus().eventBus.register(object);
    }

    public static void unregister(final Object object) {
    	AgiletrackUI.getAgileEventbus().eventBus.unregister(object);
    }

    @Override
    public final void handleException(final Throwable exception,
            final SubscriberExceptionContext context) {
        exception.printStackTrace();
    }
}
