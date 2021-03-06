package com.github.czyzby.context.inject;

import com.github.czyzby.autumn.annotation.Component;
import com.github.czyzby.autumn.annotation.Initiate;
import com.github.czyzby.autumn.annotation.Inject;
import com.github.czyzby.kiwi.log.Logger;
import com.github.czyzby.kiwi.log.LoggerService;

/** An example of circular dependency.
 *
 * @author MJ */
@Component
public class CircularSister {
    /** Kiwi logger for this class. */
    private static final Logger LOGGER = LoggerService.forClass(CircularSister.class);

    /** This will be automatically injected. */
    @Inject SomeComponent someComponent;
    /** This is a circular dependency - both sibling classes depend on each other. */
    @Inject CircularBrother bro;

    /** Thanks to {@link Initiate} annotation, this method will be automatically invoked during context creation. */
    @Initiate
    public void onInit() {
        LOGGER.info("Injected values: {0}, {1}. I'm {2}.", someComponent, bro, this);
    }

    @Override
    public String toString() {
        return "(CircularSister[hashCode=" + hashCode() + "])";
    }
}
