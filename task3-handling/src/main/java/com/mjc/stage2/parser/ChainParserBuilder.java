package com.mjc.stage2.parser;

import java.util.ArrayList;
import java.util.List;

public class ChainParserBuilder {
    private final List<AbstractTextParser> parsers = new ArrayList<>();

    public ChainParserBuilder() {
    }

    public ChainParserBuilder setParser(AbstractTextParser abstractTextParser) {
        parsers.add(abstractTextParser);
        if (parsers.size() > 1) {
            AbstractTextParser previousParser = parsers.get(parsers.size()-2);
            previousParser.setNextParser(abstractTextParser);
        }
        return this;
    }

    public AbstractTextParser build() {
        return parsers.size() > 0 ? parsers.get(0) : null;
    }
}