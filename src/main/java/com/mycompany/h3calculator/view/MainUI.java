package com.mycompany.h3calculator.view;

import com.mycompany.h3calculator.controller.HeroController;
import com.mycompany.h3calculator.controller.UnitController;
import com.mycompany.h3calculator.model.Hero;
import com.mycompany.h3calculator.repository.UnitRepository;
import com.vaadin.annotations.Theme;
import com.vaadin.data.Binder;
import com.vaadin.data.ValidationResult;
import com.vaadin.data.Validator;
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

    private final HeroController heroController;
    private final UnitController unitController;
    private final UnitRepository unitRepository;

    private Validator<String> numberValidator;
    private Panel heroOnePanel;
    private Panel heroTwoPanel;

    @Autowired
    public MainUI(HeroController heroController, UnitController unitController, UnitRepository unitRepository) {
        this.heroController = heroController;
        this.unitController = unitController;
        this.unitRepository = unitRepository;
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setupValidator();
        setupPanelOne();
        setupPanelTwo();
        setupView();
    }

    private void setupValidator() {
        numberValidator = (Validator<String>) (value, context) -> {
            if (StringUtils.isNumeric(value)) return ValidationResult.ok();
            else return ValidationResult.error("enter number");
        };
    }

    private void setupView() {
        GridLayout layout = new GridLayout();
        layout.setColumns(4);
        layout.setRows(4);
        layout.setSpacing(true);
        layout.setMargin(true);
        layout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        layout.addComponent(heroOnePanel, 1, 1, 1, 1);
        layout.addComponent(heroTwoPanel, 2, 1, 2, 1);

        setContent(layout);
    }

    private void setupPanelOne() {
        heroOnePanel = new Panel("Hero One");
        heroOnePanel.setWidth("50%");
        heroOnePanel.setContent(buildForm(HeroNumber.HERO_ONE));
    }

    private void setupPanelTwo() {
        heroTwoPanel = new Panel("Hero Two");
        heroTwoPanel.setWidth("50%");
        heroTwoPanel.setContent(buildForm(HeroNumber.HERO_TWO));
    }

    private FormLayout buildForm(HeroNumber heroNumber) {
        FormLayout content = new FormLayout();
        Label attackLabel = new Label("Attack: ");
        attackLabel.setStyleName(ValoTheme.LABEL_SMALL);
        Label defenceLabel = new Label("Defence: ");
        defenceLabel.setStyleName(ValoTheme.LABEL_SMALL);
        Label powerLabel = new Label("Power: ");
        powerLabel.setStyleName(ValoTheme.LABEL_SMALL);
        Label knowledgeLabel = new Label("Knowledge: ");
        knowledgeLabel.setStyleName(ValoTheme.LABEL_SMALL);

        TextField attackField = new TextField();
        attackField.setStyleName(ValoTheme.TEXTFIELD_TINY);
        TextField defenceField = new TextField();
        defenceField.setStyleName(ValoTheme.TEXTFIELD_TINY);
        TextField powerField = new TextField();
        powerField.setStyleName(ValoTheme.TEXTFIELD_TINY);
        TextField knowledgeField = new TextField();
        knowledgeField.setStyleName(ValoTheme.TEXTFIELD_TINY);

    //    ComboBox<com.mycompany.h3calculator.model.Unit> unitComboBox = new ComboBox<>();
    //    unitComboBox.setItems(unitRepository.getAllUnits());
    //    unitComboBox.setItemCaptionGenerator(com.mycompany.h3calculator.model.Unit::getName);
    //    unitComboBox.setEmptySelectionAllowed(false);

        new Binder<Hero>().forField(attackField)
                .withValidator(numberValidator)
                .withConverter(new StringToIntegerConverter("enter number"))
                .bind(Hero::getAttack, Hero::setAttack);
        new Binder<Hero>().forField(defenceField)
                .withValidator(numberValidator)
                .withConverter(new StringToIntegerConverter("enter number"))
                .bind(Hero::getDefence, Hero::setDefence);
        new Binder<Hero>().forField(powerField)
                .withValidator(numberValidator)
                .withConverter(new StringToIntegerConverter("enter number"))
                .bind(Hero::getPower, Hero::setPower);
        new Binder<Hero>().forField(knowledgeField)
                .withValidator(numberValidator)
                .withConverter(new StringToIntegerConverter("enter number"))
                .bind(Hero::getKnowledge, Hero::setKnowledge);

        Button addButton = new Button("Add");
        addButton.addStyleName(ValoTheme.BUTTON_PRIMARY);

        if (heroNumber == HeroNumber.HERO_ONE)
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

                    heroController.addHeroOne(hero);
                    //unitController.addUnitOne(unitComboBox.getValue());
                }
            });
        else if (heroNumber == HeroNumber.HERO_TWO)
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

                    heroController.addHeroTwo(hero);
                    //unitController.addUnitTwo(unitComboBox.getValue());
                }
            });

        content.addComponent(attackLabel);
        content.addComponent(attackField);

        content.addComponent(defenceLabel);
        content.addComponent(defenceField);

        content.addComponent(powerLabel);
        content.addComponent(powerField);

        content.addComponent(knowledgeLabel);
        content.addComponent(knowledgeField);

        //content.addComponent(unitComboBox);

        content.addComponent(addButton);
        return content;
    }

    private enum HeroNumber {
        HERO_ONE,
        HERO_TWO
    }

}
