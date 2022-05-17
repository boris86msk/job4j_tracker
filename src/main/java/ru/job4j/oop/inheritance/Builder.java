package ru.job4j.oop.inheritance;

public class Builder extends Engineer {
    private String buildingMaterial;

    public Builder(String name, String surname, String education, int birthday, String branch, String buildingMaterial) {
        super(name, surname, education, birthday, branch);
        this.buildingMaterial = buildingMaterial;
    }

    public String priceConstruction() {
        return "price list";
    }
}
