package com.company.entites;

public class Necklace {
   private int necklace_id;
   private String necklace_name;
   private double necklace_Weight;
   private double necklace_cost;
   private int number_stones;

    public Necklace(int necklace_id, String necklace_name, double necklace_Weight, double necklace_cost, int number_stones) {
        this.necklace_id = necklace_id;
        this.necklace_name = necklace_name;
        this.necklace_Weight = necklace_Weight;
        this.necklace_cost = necklace_cost;
        this.number_stones = number_stones;
    }

    public Necklace(String necklace_name, double necklace_Weight, double necklace_cost, int number_stones) {
        this.necklace_name = necklace_name;
        this.necklace_Weight = necklace_Weight;
        this.necklace_cost = necklace_cost;
        this.number_stones = number_stones;
    }

    public int getNecklace_id() {
        return necklace_id;
    }

    public void setNecklace_id(int necklace_id) {
        this.necklace_id = necklace_id;
    }

    public String getNecklace_name() {
        return necklace_name;
    }

    public void setNecklace_name(String necklace_name) {
        this.necklace_name = necklace_name;
    }

    public double getNecklace_Weight() {
        return necklace_Weight;
    }

    public void setNecklace_Weight(double necklace_Weight) {
        this.necklace_Weight = necklace_Weight;
    }

    public double getNecklace_cost() {
        return necklace_cost;
    }

    public void setNecklace_cost(double necklace_cost) {
        this.necklace_cost = necklace_cost;
    }

    public int getNumber_stones() {
        return number_stones;
    }

    public void setNumber_stones(int number_stones) {
        this.number_stones = number_stones;
    }

    @Override
    public String toString() {
        return "Necklace{" +
                "necklace_id=" + necklace_id +
                ", necklace_name='" + necklace_name + '\'' +
                ", necklace_Weight=" + necklace_Weight +
                ", necklace_cost=" + necklace_cost +
                ", number_stones=" + number_stones +
                '}';
    }
}
