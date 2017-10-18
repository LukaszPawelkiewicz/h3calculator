package com.mycompany.h3calculator.view;

import com.mycompany.h3calculator.model.Hero;
import com.mycompany.h3calculator.system.HeroContainer;
import com.vaadin.annotations.Theme;
import com.vaadin.data.Binder;
import com.vaadin.data.converter.StringToIntegerConverter;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI(path = "/")
@Theme("valo")
public class MainUI extends UI {

    private final HeroContainer heroContainer;
    private VerticalLayout layout;

    @Autowired
    public MainUI(HeroContainer heroContainer) {
        this.heroContainer = heroContainer;
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setupLayout();
        addHeader();
        addHeroOneForm();
        addHeroTwoForm();
    }

    //todo make smth like panel
    private void addHeroOneForm() {
        Label attackLabel = new Label("Attack: ");
        Label defenceLabel = new Label("Defence: ");
        Label powerLabel = new Label("Power: ");
        Label knowledgeLabel = new Label("Knowledge: ");

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

        Button addButton = new Button("Add");
        addButton.addStyleName(ValoTheme.BUTTON_PRIMARY);
        addButton.addClickListener(event -> {
            if (StringUtils.isNumeric(attackField.getValue()) &&
                    StringUtils.isNumeric(defenceField.getValue()) &&
                    StringUtils.isNumeric(powerField.getValue()) &&
                    StringUtils.isNumeric(knowledgeField.getValue())) {
                Hero hero = new Hero();
                hero.setAttack(Integer.parseInt(attackField.getValue()));
                hero.setDefence(Integer.parseInt(defenceField.getValue()));
                hero.setPower(Integer.parseInt(powerField.getValue()));
                hero.setKnowledge(Integer.parseInt(knowledgeField.getValue()));

                heroContainer.setHeroOne(hero);
            }
        });

        layout.addComponent(attackLabel);
        layout.addComponent(attackField);

        layout.addComponent(defenceLabel);
        layout.addComponent(defenceField);

        layout.addComponent(powerLabel);
        layout.addComponent(powerField);

        layout.addComponent(knowledgeLabel);
        layout.addComponent(knowledgeField);

        layout.addComponent(addButton);
    }

    private void addHeroTwoForm() {
        Label attackLabel = new Label("Attack: ");
        Label defenceLabel = new Label("Defence: ");
        Label powerLabel = new Label("Power: ");
        Label knowledgeLabel = new Label("Knowledge: ");

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

        Button addButton = new Button("Add");
        addButton.addStyleName(ValoTheme.BUTTON_PRIMARY);
        addButton.addClickListener(event -> {
            if (StringUtils.isNumeric(attackField.getValue()) &&
                    StringUtils.isNumeric(defenceField.getValue()) &&
                    StringUtils.isNumeric(powerField.getValue()) &&
                    StringUtils.isNumeric(knowledgeField.getValue())) {
                Hero hero = new Hero();
                hero.setAttack(Integer.parseInt(attackField.getValue()));
                hero.setDefence(Integer.parseInt(defenceField.getValue()));
                hero.setPower(Integer.parseInt(powerField.getValue()));
                hero.setKnowledge(Integer.parseInt(knowledgeField.getValue()));

                heroContainer.setHeroTwo(hero);
            }
        });

        layout.addComponent(attackLabel);
        layout.addComponent(attackField);

        layout.addComponent(defenceLabel);
        layout.addComponent(defenceField);

        layout.addComponent(powerLabel);
        layout.addComponent(powerField);

        layout.addComponent(knowledgeLabel);
        layout.addComponent(knowledgeField);

        layout.addComponent(addButton);
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
