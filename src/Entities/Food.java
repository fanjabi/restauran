package Entities;

import Entities.Base.Meal;

public class Food implements Meal {
    public enum Type {
        MAIN_COURSE,
        DESSERT,
        SNACK,
        SALAD
    }

    private String name;
    private int calories;
    private Type type;

    public Food(String name, int calories, Type type) {
        this.name = name;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
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
                getCalories() + "," +
                getType().name();
    }

    public Food(String[] values) throws UnsupportedOperationException {
        if(!values[0].equals(this.getClass().getSimpleName())) {
            throw new UnsupportedOperationException("Wrong object type provided");
        }

        this.name = values[1];
        this.calories = Integer.parseInt(values[2]);
        this.type = Type.valueOf(values[3]);
    }

    @Override
    public String toString() {
        return "Food {\n" +
                "  name='" + name + "',\n" +
                "  calories=" + calories + ",\n" +
                "  type=" + type.name() + ",\n" +
                "}";
    }
}
