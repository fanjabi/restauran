package Entities;

import Entities.Base.Meal;

public class Drink implements Meal {

    public enum Type {
        SODA,
        JUICE,
        WATER,
        ALCOHOL,
        CARBONATED
    }

    private String name;
    private double volume;
    private Type type;

    public Drink(String name, double volume, Type type) {
        this.name = name;
        this.volume = volume;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String toCSV() {
        return this.getClass().getSimpleName() + "," +
                getName() + "," +
                getVolume() + "," +
                getType().name();
    }

    public Drink(String[] values) throws UnsupportedOperationException {
        if(!values[0].equals(this.getClass().getSimpleName())) {
            throw new UnsupportedOperationException("Wrong object type provided");
        }

        this.name = values[1];
        this.volume = Double.parseDouble(values[2]);
        this.type = Type.valueOf(values[3]);
    }

    @Override
    public String toString() {
        return "Drink {\n" +
                "  name='" + name + "',\n" +
                "  volume=" + volume + ",\n" +
                "  type=" + type.name() + ",\n" +
                "}";
    }
}
