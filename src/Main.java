import Entities.Base.Meal;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Meal> meals = MealDataHandler.getMeals();

        for(Meal meal: meals) {
            System.out.println(meal);
        }
    }
}