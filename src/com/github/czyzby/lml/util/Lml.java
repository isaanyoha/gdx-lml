package com.github.czyzby.lml.util;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.github.czyzby.lml.parser.LmlData;
import com.github.czyzby.lml.parser.LmlParser;

/** Utility class for simplified parser creation. Stores LML settings.
 *
 * @author MJ
 * @see LmlUtilities
 * @see LmlParserBuilder */
public class Lml {
    /** When action is referenced in LML template, its parser looks for registered ActorConsumers with the selected key
     * (as they do not rely on reflection and are cheaper to invoke). If no
     * {@link com.github.czyzby.lml.parser.action.ActorConsumer} is found, then the parser looks for
     * {@link com.github.czyzby.lml.parser.action.ActionContainer}'s containing the referenced action. When none of
     * action container's methods match the key, normally container's field with the given name is returned, provided it
     * exists. The action - instead of invoking a method - will extract and return current field's value. However,
     * extracting fields causes problems on GWT (probably due to LibGDX reflection implementation), so this
     * functionality can be globally turned off by setting this variable to false (default state). The rule of thumb is:
     * if you use multiple action containers and plan on releasing GWT client, keep this variable as false. If you need
     * field extraction, set to true. */
    public static boolean EXTRACT_FIELDS_AS_METHODS = false;

    /** Settings used by logging macros. By setting these values to false, you can disable a certain group of logs. This
     * can be very useful if you want to keep log macro invocations in LML templates for future development, while
     * disabling them in actual client applications. */
    public static boolean DEBUG_LOGS_ON = true, INFO_LOGS_ON = true, ERROR_LOGS_ON = true;

    /** Used during logging as message tag (first logging method argument). Helps to determine the origin of logged
     * messages. Defaults to "LML".
     *
     * @see com.badlogic.gdx.Application#debug(String, String)
     * @see com.badlogic.gdx.Application#log(String, String)
     * @see com.badlogic.gdx.Application#error(String, String) */
    public static String LOGGER_TAG = "LML";

    private Lml() {
    }

    /** @return a new {@link LmlParserBuilder}, allowing to easily create a new instance of {@link LmlParser}. */
    public static LmlParserBuilder parser() {
        return new LmlParserBuilder();
    }

    /** @param defaultSkin will be registered as the default skin. Cannot be null.
     * @return a new {@link LmlParserBuilder}, allowing to easily create a new instance of {@link LmlParser}. */
    public static LmlParserBuilder parser(final Skin defaultSkin) {
        return new LmlParserBuilder().skin(defaultSkin);
    }

    /** @param data contains data necessary to properly parse LML templates.
     * @return a new {@link LmlParserBuilder}, allowing to easily create a new instance of {@link LmlParser}.
     * @see com.github.czyzby.lml.parser.impl.DefaultLmlData */
    public static LmlParserBuilder parser(final LmlData data) {
        return new LmlParserBuilder(data);
    }
}
