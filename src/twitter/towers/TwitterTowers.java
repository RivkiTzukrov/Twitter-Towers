package twitter.towers;

import java.util.Scanner;

public class TwitterTowers {

    public static void rectangular_tower(int height, int width) {
        if (width == height || Math.abs(width - height) < 6) {
            System.out.println("Area of the rectangle: " + height * width + ".");
            return;
        }
        System.out.println("Perimeter of the rectangle: " + 2 * (height + width) + ".");
    }

    public static void triangular_tower(int height, int width) {
        double perimeter = Math.sqrt(width / 2 * width / 2 + height * height) * 2 + width;
        System.out.println("Perimeter of the triangle: " + perimeter + ".");
        if (width % 2 == 0 || width > height * 2) {
            System.out.println("The triangle cannot be printed.");
            return;
        }
        int lines = (width + 1) / 2;
        int any_line = (height - 2) / (lines - 2);
        int line3 = (height - 2) % (lines - 2) + any_line;
        int stars = 5;

        // print first line
        for (int i = 0; i < (width - 1) / 2; i++) {
            System.out.print(" ");
        }
        System.out.println("*");

        // print lines of 3 stars
        for (int i = 0; i < line3; i++) {
            for (int j = 0; j < (width - 3) / 2; j++) {
                System.out.print(" ");
            }
            System.out.println("***");
        }

        //print other lines
        for (; stars < width; stars += 2) {
            for (int i = 0; i < any_line; i++) {
                for (int j = 0; j < (width - stars) / 2; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < stars; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }

        // print last line
        for (int j = 0; j < width; j++) {
            System.out.print("*");
        }
    }

    public static void menu() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("\nTo create a rectangle tower type 1,\n"
                    + "to create a triangular tower type 2,\nto exit type 3");
            int inp = input.nextInt();
            switch (inp) {
                case 1: {
                    System.out.println("insert height and width for the rectangle");
                    int height = input.nextInt(), width = input.nextInt();
                    rectangular_tower(height, width);
                    break;
                }
                case 2: {
                    System.out.println("insert height and width for the triangular");
                    int height = input.nextInt(), width = input.nextInt();
                    triangular_tower(height, width);
                    break;
                }
                case 3:
                    return;
                default:
                    break;
            }
        }

    }

    public static void main(String[] args) {
        menu();
    }

}
