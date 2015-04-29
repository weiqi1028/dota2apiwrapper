package com.weiqi.dota2.dota2apiwrapper;

public class Hero {
    private String name;
    private int id;
    private String localizedName;
    
    protected Hero(String name, int id, String localizedName) {
        this.name = name;
        this.id = id;
        this.localizedName = localizedName;
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
    private String getLocalizedName() {
        return localizedName;
    }
    private void setLocalizedName(String localizedName) {
        this.localizedName = localizedName;
    }
    
    public String toString() {
        String res = "";
        res += getName() + "\n";
        res += getId() + "\n";
        res += getLocalizedName() + "\n";
        return res;
    }
}
