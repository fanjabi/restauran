import Entities.Base.Meal;
import Entities.Food;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        addFood();

        List<Meal> meals = MealDataHandler.getMeals();

        for(Meal meal: meals) {
            System.out.println(meal);
        }
    }

    private static void addFood() {
        Scanner scanner = new Scanner(System.in);

        String name = "";

        while(name.isEmpty()) {
            System.out.println("Enter food name:");
            name = scanner.nextLine();
        }

        int calories = 0;
        boolean validCalories = false;
        while (!validCalories) {
            System.out.println("Enter calories:");
            try {
                calories = Integer.parseInt(scanner.nextLine());
                validCalories = true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number for calories.");
            }
        }

        System.out.println("Select food type:");
        Food.Type[] foodTypes = Food.Type.values();

        for (int i = 0; i < foodTypes.length; i++) {
            System.out.println((i + 1) + ". " + foodTypes[i]);
        }

        int typeChoice = 0;
        boolean validChoice = false;
        while (!validChoice) {
            System.out.println("Enter the number corresponding to the food type:");
            try {
                typeChoice = Integer.parseInt(scanner.nextLine());
                if (typeChoice >= 1 && typeChoice <= foodTypes.length) {
                    validChoice = true;
                } else {
                    System.out.println("Please enter a number between 1 and " + foodTypes.length);
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }

        Food.Type type = foodTypes[typeChoice - 1];

        scanner.close();

        Food newFood = new Food(name, calories, type);

        MealDataHandler.addMeal(newFood);
    }
}