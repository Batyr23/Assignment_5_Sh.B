package com.company.entites;

public class Stone {
   private int Stone_id;
   private String name;
   private double Stone_Weight;
   private double Stone_cost;

    public Stone(int stone_id, String name, double stone_Weight, double stone_cost) {
        Stone_id = stone_id;
        this.name = name;
        Stone_Weight = stone_Weight;
        Stone_cost = stone_cost;
    }

    public Stone(String name, double stone_Weight, double stone_cost) {
        this.name = name;
        Stone_Weight = stone_Weight;
        Stone_cost = stone_cost;
    }

    public int getStone_id() {
        return Stone_id;
    }

    public void setStone_id(int stone_id) {
        Stone_id = stone_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getStone_Weight() {
        return Stone_Weight;
    }

    public void setStone_Weight(double stone_Weight) {
        Stone_Weight = stone_Weight;
    }

    public double getStone_cost() {
        return Stone_cost;
    }

    public void setStone_cost(double stone_cost) {
        Stone_cost = stone_cost;
    }

    @Override
    public String toString() {
        return "Stone{" +
                "Stone_id=" + Stone_id +
                ", name='" + name + '\'' +
                ", Stone_Weight=" + Stone_Weight +
                ", Stone_cost=" + Stone_cost +
                '}';
    }
}
