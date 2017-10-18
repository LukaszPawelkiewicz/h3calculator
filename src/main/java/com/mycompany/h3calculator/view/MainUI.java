package com.mycompany.h3calculator.view;

import com.mycompany.h3calculator.model.Hero;
import com.vaadin.annotations.Theme;
import com.vaadin.data.Binder;
import com.vaadin.data.converter.StringToIntegerConverter;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

@SpringUI(path = "/")
@Theme("valo")
public class MainUI extends UI {

    private VerticalLayout layout;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setupLayout();
        addHeader();
        addHeroOneForm();
        addHeroTwoForm();
    }

    private void addHeroTwoForm() {
        TextField attackField = new TextField();
        TextField defenceField = new TextField();
        TextField powerField = new TextField();
        TextField knowledgeField = new TextField();

        new Binder<Hero>().forField(attackField)
                .withConverter(new StringToIntegerConverter("enter number"))
                .bind(Hero::getAttack, Hero::setAttack);
        new Binder<Hero>().forField(defenceField)
                .withConverter(new StringToIntegerConverter("enter number"))
                .bind(Hero::getDefence, Hero::setDefence);
        new Binder<Hero>().forField(powerField)
                .withConverter(new StringToIntegerConverter("enter number"))
                .bind(Hero::getPower, Hero::setPower);
        new Binder<Hero>().forField(knowledgeField)
                .withConverter(new StringToIntegerConverter("enter number"))
                .bind(Hero::getKnowledge, Hero::setKnowledge);

        layout.addComponent(attackField);
        layout.addComponent(defenceField);
        layout.addComponent(powerField);
        layout.addComponent(knowledgeField);
    }

    private void addHeroOneForm() {
    }

    private void setupLayout() {
        layout = new VerticalLayout();
        layout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        setContent(layout);
    }

    private void addHeader() {
        Label header = new Label("Heroes");
        header.addStyleName(ValoTheme.LABEL_H1);
        layout.addComponent(header);
    }

}
