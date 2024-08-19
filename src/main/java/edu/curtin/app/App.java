package edu.curtin.app;

import java.util.*;

/**
 * Entry point into the application. To change the package, and/or the name of this class, make
 * sure to update the 'mainClass = ...' line in build.gradle.
 */
public class App

{
    private static final String fileName = "grid.txt";
    public static void main(String[] args) 
    {

        List<Terrain> grid = ReadFile.readMap(fileName);
        String[] coords = ReadCoords.readCoords(fileName);

        System.out.println("File loaded successfully.");
        boolean repeat = true;
        Scanner sc = new Scanner(System.in);
        int menuOption, gridCoordsX, gridCoordsY, floors, foundation, construction;
        int configure = 2;

        while(repeat == true) {
            
            System.out.println("\nWelcome to the city planner. Please choose one of the below options.\n1.Build structure\n2.Build city using configure option: " + configure + "\n3.Configure\n4.Quit");
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
            }

            menuOption = sc.nextInt();

            switch (menuOption) {
                case 1:
                do{
                    System.out.println("Enter the row for the structure to be built between 1 and " + coords[0]+" : ");
                    while (!sc.hasNextInt()){
                        System.out.println("Invalid input. Please enter a number.");
                        sc.next();
                    }
                    gridCoordsX = sc.nextInt();
                } while(gridCoordsX < 1 || gridCoordsX > Integer.parseInt(coords[0]));

                do{
                    System.out.println("Enter the column for the structure to be built between 1 and " + coords[1]+" : ");
                    while (!sc.hasNextInt()){
                        System.out.println("Invalid input. Please enter a number.");
                        sc.next();
                    }
                    gridCoordsY = sc.nextInt();
                } while(gridCoordsY < 1 || gridCoordsY > Integer.parseInt(coords[1]));

                do{
                    System.out.println("Enter the number of floors for the structure greater than 0: ");
                    while(!sc.hasNextInt()){
                        System.out.println("Invalid input. Please enter a number.");
                        sc.next();
                    }
                    floors = sc.nextInt();
                } while(floors < 1);

                do{
                    System.out.println("Enter the foundation type : (1) slab or (2) stilts ");
                    while(!sc.hasNextInt()){
                        System.out.println("Invalid input. Please enter a number.");
                        sc.next();
                    }
                    foundation = sc.nextInt();
                } while(foundation != 1 && foundation != 2);

                do{
                    System.out.println("Enter the construction material type : (1) wood, (2) stone, (3) brick, (4) concrete");
                    while(!sc.hasNextInt()){
                        System.out.println("Invalid input. Please enter a number.");
                        sc.next();
                    }
                    construction = sc.nextInt();
                } while(construction != 1 && construction != 2 && construction != 3 && construction != 4);

                System.out.println(BuildStructure.buildStructure(BuildStructure.findStructure(grid,coords,gridCoordsX,gridCoordsY),floors,foundation,construction));
                break;

                case 2:
                if(configure == 1){
                do{
                    System.out.println("Enter the number of floors for the structure greater than 0: ");
                    while(!sc.hasNextInt()){
                        System.out.println("Invalid input. Please enter a number.");
                        sc.next();
                    }
                    floors = sc.nextInt();
                } while(floors < 1);

                do{
                    System.out.println("Enter the foundation type : (1) slab or (2) stilts ");
                    while(!sc.hasNextInt()){
                        System.out.println("Invalid input. Please enter a number.");
                        sc.next();
                    }
                    foundation = sc.nextInt();
                } while(foundation != 1 && foundation != 2);

                do{
                    System.out.println("Enter the construction material type : (1) wood, (2) stone, (3) brick, (4) concrete");
                    while(!sc.hasNextInt()){
                        System.out.println("Invalid input. Please enter a number.");
                        sc.next();
                    }
                    construction = sc.nextInt();
                } while(construction != 1 && construction != 2 && construction != 3 && construction != 4);

                    BuildUniform builder = new BuildUniform();
                    builder.buildStructure(grid, coords, floors, foundation, construction);
                }
                else if (configure == 2){

                    BuildRandom builder = new BuildRandom();
                    builder.buildStructure(grid, coords, 1, 1, 1);
                }
                else if (configure == 3){
                    BuildCentral builder = new BuildCentral();
                    builder.buildStructure(grid, coords, 1, 1, 1);
                }
                    break;

                case 3:
                do{
                    System.out.println("Choose a city construction approach : (1) Uniform, (2) Random, (3) Central.");
                    while(!sc.hasNextInt()){
                        System.out.println("Invalid input. Please enter a number.");
                        sc.next();
                    }
                    configure = sc.nextInt();
                } while(configure != 1 && configure != 2 && configure != 3 );
                    break;

                case 4:
                    System.out.println("Exiting program");
                    repeat=false;
                    break;


                default:
                    System.out.println("Invalid menu option.");
                    break;
            }
            
        }
        sc.close();
    }
}
