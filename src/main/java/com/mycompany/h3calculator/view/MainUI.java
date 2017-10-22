package com.mycompany.h3calculator.view;

import com.mycompany.h3calculator.controller.ArmyController;
import com.mycompany.h3calculator.controller.CalculatorController;
import com.mycompany.h3calculator.controller.HeroController;
import com.mycompany.h3calculator.model.Army;
import com.mycompany.h3calculator.model.Hero;
import com.mycompany.h3calculator.model.Report;
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
    private final ArmyController armyController;
    private final CalculatorController calculatorController;

    private Validator<String> numberValidator;
    private Panel heroOnePanel;
    private Panel heroTwoPanel;
    private Panel reportPanel;

    private Label minDmgLabel = new Label("Min dmg: ");
    private Label maxDmgLabel = new Label("Max dmg: ");
    private Label minUnitsDestroyedLabel = new Label("Minimal amount of destroyed units: ");
    private Label maxUnitsDestroyedLabel = new Label("Maximal amount of destroyed units: ");

    private boolean heroOneSet = false;
    private boolean heroTwoSet = false;

    @Autowired
    public MainUI(HeroController heroController, ArmyController armyController, CalculatorController calculatorController) {
        this.heroController = heroController;
        this.armyController = armyController;
        this.calculatorController = calculatorController;
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setupValidator();
        setupPanelHeroOne();
        setupPanelHeroTwo();
        setupReportPanel();
        setupView();
    }

    private void setupValidator() {
        numberValidator = (Validator<String>) (value, context) -> {
            if (StringUtils.isNumeric(value)) return ValidationResult.ok();
            else return ValidationResult.error("enter number");
        };
    }

    private void setupView() {
        //GridLayout layout = new GridLayout();
        HorizontalLayout layout = new HorizontalLayout();
        //layout.setColumns(4);
        //layout.setRows(4);
        layout.setSpacing(true);
        layout.setMargin(true);
        layout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        //layout.addComponent(heroOnePanel, 1, 1, 1, 1);
        //layout.addComponent(heroTwoPanel, 2, 1, 2, 1);
        //layout.addComponent(reportPanel, 3, 1, 3, 1);

        layout.addComponent(heroOnePanel);
        layout.addComponent(heroTwoPanel);
        layout.addComponent(reportPanel);

        setContent(layout);
    }

    private void setupPanelHeroOne() {
        heroOnePanel = new Panel("Hero One");
        heroOnePanel.setWidth("50%");
        heroOnePanel.setContent(buildForm(HeroNumber.HERO_ONE));
    }

    private void setupPanelHeroTwo() {
        heroTwoPanel = new Panel("Hero Two");
        heroTwoPanel.setWidth("50%");
        heroTwoPanel.setContent(buildForm(HeroNumber.HERO_TWO));
    }

    private void setupReportPanel() {
        reportPanel = new Panel("Report");
        reportPanel.setWidth("400");
        reportPanel.setContent(buildReport());
    }

    private Component buildReport() {
        FormLayout content = new FormLayout();

        Button calculateButton = new Button("Calculate");
        calculateButton.addStyleName(ValoTheme.BUTTON_PRIMARY);
        calculateButton.addClickListener(event -> {
            if (heroOneSet && heroTwoSet) {
                Report report = calculatorController.calculate();

                minDmgLabel.setValue("Min dmg: " + report.getMinDmg());
                maxDmgLabel.setValue("max dmg: " + report.getMaxDmg());
                minUnitsDestroyedLabel.setValue("Minimal amount of destroyed units: " + report.getMinUnitsDestroyed());
                maxUnitsDestroyedLabel.setValue("Maximal amount of destroyed units: " + report.getMaxUnitsDestroyed());
            }
        });

        content.addComponent(calculateButton);
        content.addComponent(minDmgLabel);
        content.addComponent(maxDmgLabel);
        content.addComponent(minUnitsDestroyedLabel);
        content.addComponent(maxUnitsDestroyedLabel);

        return content;
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
        Label unitNumberLabel = new Label("Number of units: ");
        unitNumberLabel.setStyleName(ValoTheme.LABEL_SMALL);

        TextField attackField = new TextField();
        attackField.setStyleName(ValoTheme.TEXTFIELD_TINY);
        TextField defenceField = new TextField();
        defenceField.setStyleName(ValoTheme.TEXTFIELD_TINY);
        TextField powerField = new TextField();
        powerField.setStyleName(ValoTheme.TEXTFIELD_TINY);
        TextField knowledgeField = new TextField();
        knowledgeField.setStyleName(ValoTheme.TEXTFIELD_TINY);
        TextField unitNumberField = new TextField();
        unitNumberField.setStyleName(ValoTheme.TEXTAREA_TINY);

        ComboBox<com.mycompany.h3calculator.model.Unit> unitComboBox = new ComboBox<>();
        unitComboBox.setItems(armyController.getAllUnits());
        unitComboBox.setItemCaptionGenerator(com.mycompany.h3calculator.model.Unit::getName);
        unitComboBox.setEmptySelectionAllowed(false);

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
        new Binder<Army>().forField(unitNumberField)
                .withValidator(numberValidator)
                .withConverter(new StringToIntegerConverter("enter number"))
                .bind(Army::getNumberOfUnits, Army::setNumberOfUnits);

        Button addButton = new Button("Set");
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
                    armyController.addArmyOne(new Army(unitComboBox.getValue(), Integer.parseInt(unitNumberField.getValue())));
                    heroOneSet = true;
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
                    armyController.addArmyTwo(new Army(unitComboBox.getValue(), Integer.parseInt(unitNumberField.getValue())));
                    heroTwoSet = true;
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

        content.addComponent(unitNumberLabel);
        content.addComponent(unitNumberField);

        content.addComponent(unitComboBox);

        content.addComponent(addButton);
        return content;
    }

    private enum HeroNumber {
        HERO_ONE,
        HERO_TWO
    }

}
