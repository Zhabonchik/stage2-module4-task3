package com.mjc.stage2.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComponent extends AbstractTextComponent {
    protected List<AbstractTextComponent> componentList = new ArrayList<>();

    public TextComponent(TextComponentType componentType) {
        super(componentType);
    }

    @Override
    public String operation() {
        StringBuilder sb = new StringBuilder();
        for (AbstractTextComponent textComponent: componentList) {
            if (this.getComponentType() == TextComponentType.SENTENCE) {
                sb.append(" ");
            }
            sb.append(textComponent.operation());
        }
        return sb.toString().trim();
    }

    @Override
    public void add(AbstractTextComponent textComponent) {
        this.componentList.add(textComponent);
    }

    @Override
    public void remove(AbstractTextComponent textComponent) {
        if (this.componentList.remove(textComponent)) {
        }
    }

    @Override
    public int getSize() {
        return this.componentList.stream().map(AbstractTextComponent::getSize).reduce(0, Integer::sum);
    }
}