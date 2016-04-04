package com.github.czyzby.lml.parser.impl.tag.actor.provider;

import com.github.czyzby.lml.parser.LmlParser;
import com.github.czyzby.lml.parser.impl.tag.actor.AnimatedImageLmlTag;
import com.github.czyzby.lml.parser.tag.LmlTag;
import com.github.czyzby.lml.parser.tag.LmlTagProvider;

/** Provides animated image tags.
 *
 * @author MJ */
public class AnimatedImageLmlTagProvider implements LmlTagProvider {
    @Override
    public LmlTag create(final LmlParser parser, final LmlTag parentTag, final String rawTagData) {
        return new AnimatedImageLmlTag(parser, parentTag, rawTagData);
    }
}