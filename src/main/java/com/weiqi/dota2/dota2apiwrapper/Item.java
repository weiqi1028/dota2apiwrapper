package com.weiqi.dota2.dota2apiwrapper;

public class Item {
    private int id;
    private String name;
    private int cost;
    private boolean secretShop;
    private boolean sideShop;
    private boolean recipe;
    
    protected Item(int id, String name, int cost, boolean secretShop, boolean sideShop, boolean recipe) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.secretShop = secretShop;
        this.sideShop = sideShop;
        this.recipe = recipe;
    }
    private int getId() {
        return id;
    }
    private void setId(int id) {
        this.id = id;
    }
    private String getName() {
        return name;
    }
    private void setName(String name) {
        this.name = name;
    }
    private int getCost() {
        return cost;
    }
    private void setCost(int cost) {
        this.cost = cost;
    }
    private boolean isSecretShop() {
        return secretShop;
    }
    private void setSecretShop(boolean secretShop) {
        this.secretShop = secretShop;
    }
    private boolean isSideShop() {
        return sideShop;
    }
    private void setSideShop(boolean sideShop) {
        this.sideShop = sideShop;
    }
    private boolean isRecipe() {
        return recipe;
    }
    private void setRecipe(boolean recipe) {
        this.recipe = recipe;
    }
    public String toString() {
        String res = "";
        res += "id: " + this.getId() + "\n";
        res += "name: " + this.getName() + "\n";
        res += "cost: " + this.getCost() + "\n";
        res += "secrect shop: " + this.isSecretShop() + "\n";
        res += "side shop: " + this.isSideShop() + "\n";
        res += "recipe: " + this.isRecipe() + "\n";
        return res;
    }
}
