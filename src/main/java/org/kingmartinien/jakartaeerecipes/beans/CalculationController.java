package org.kingmartinien.jakartaeerecipes.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class CalculationController implements Serializable {
    private int num1;
    private int num2;
    private int result;

    private String calculationType;

    private static final String ADDITION = "addition";
    private static final String SUBTRACTION = "subtraction";
    private static final String MULTIPLICATION = "multiplication";
    private static final String DIVISION = "division";

    private List<SelectItem> calculationList;

    /**
     * Create a New instance of CalculationController
     */
    public CalculationController() {
        // Initialize variables
        this.num1 = 0;
        this.num2 = 0;
        this.result = 0;
        this.calculationType = null;

        // Initialize The list of values for the SelectOneMenu
        populateCalculationList();
        System.out.println("INITIALIZED THE BEANS!!!");
    }

    // Getters and Setters

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getCalculationType() {
        return calculationType;
    }

    public void setCalculationType(String calculationType) {
        this.calculationType = calculationType;
    }

    public List<SelectItem> getCalculationList() {
        return calculationList;
    }

    public void setCalculationList(List<SelectItem> calculationList) {
        this.calculationList = calculationList;
    }

    public void populateCalculationList() {
        this.calculationList = new ArrayList<>();
        this.calculationList.add(new SelectItem(ADDITION));
        this.calculationList.add(new SelectItem(SUBTRACTION));
        this.calculationList.add(new SelectItem(MULTIPLICATION));
        this.calculationList.add(new SelectItem(DIVISION));
    }

    public void performCalculation() {
        switch (this.getCalculationType()) {
            case ADDITION -> this.setResult(getNum1() + getNum2());
            case SUBTRACTION -> this.setResult(getNum1() - getNum2());
            case MULTIPLICATION -> this.setResult(getNum1() * getNum1());
            case DIVISION -> {
                try {
                    this.setResult(getNum1() / getNum2());
                } catch (Exception e) {
                    FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid Calculation",
                            "Invalid Calculation");
                    FacesContext.getCurrentInstance().addMessage(null, facesMsg);
                }
            }
        }
    }
}
