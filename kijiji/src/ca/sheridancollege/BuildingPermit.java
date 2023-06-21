/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege;

import java.util.Scanner;

public class BuildingPermit {
    private String[] permits = {"BP2023-001", "BP2023-002", "BP2023-003", "BP2023-004"};
    private String[] categories = {"Residential", "Commercial", "Industrial", "Agricultural"};

    private String permit;
    private String category;

    public BuildingPermit(String permit, String category) {
        this.permit = permit;
        this.category = category;
    }

    public String[] getPermits() {
        return permits;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setPermit(String permit) {
        this.permit = permit;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPermit() {
        return permit;
    }

    public String getCategory() {
        return category;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BuildingPermit buildingPermit = new BuildingPermit("", "");

        System.out.print("Enter the permit number: ");
        String permitNumber = scanner.nextLine();

        while (!isValidPermit(permitNumber, buildingPermit.getPermits())) {
            System.out.println("Invalid permit number. Please try again.");
            System.out.print("Enter the permit number: ");
            permitNumber = scanner.nextLine();
        }

        System.out.println("Select a category:");

        String[] categories = buildingPermit.getCategories();
        for (int i = 0; i < categories.length; i++) {
            System.out.println((i + 1) + ". " + categories[i]);
        }

        int categoryChoice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        while (categoryChoice < 1 || categoryChoice > categories.length) {
            System.out.println("Invalid category choice. Please try again.");
            categoryChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
        }

        String selectedCategory = categories[categoryChoice - 1];
        buildingPermit.setPermit(permitNumber);
        buildingPermit.setCategory(selectedCategory);

        System.out.println("Building permit successfully created!");
        System.out.println("Permit: " + buildingPermit.getPermit());
        System.out.println("Category: " + buildingPermit.getCategory());

        scanner.close();
    }

    private static boolean isValidPermit(String permitNumber, String[] permits) {
        for (String permit : permits) {
            if (permit.equals(permitNumber)) {
                return true;
            }
        }
        return false;
    }
}
