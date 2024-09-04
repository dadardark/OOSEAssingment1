package edu.curtin.app;

import java.util.*;
import java.util.logging.*;
import java.io.*;

/* 
 * 19817082 | Jacob Arvino | OOSE Assignment 1
 * Main class of the function. Reads in a user inputted file and displays the menu UI.
*/

public class App
{
    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) 
    {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Please enter filename: ");
            String fileName = sc.nextLine();
            System.out.print("\033\143");
            List<Terrain> grid;
            String[] coords;

            try{
                grid = ReadFile.readMap(fileName);
                coords = ReadCoords.readCoords(fileName);
            }catch(IOException e) {
                logger.severe("Invalid filename. Failed to read.");
                throw new NumberFormatException();
            }

            if(grid.size() != Integer.parseInt(coords[0])*Integer.parseInt(coords[1])){
                logger.severe("Missing entries: " + grid.size() + " recorded entries, " +  Integer.parseInt(coords[0])*Integer.parseInt(coords[1]) + " expected entries");
                throw new NumberFormatException();
            }

            boolean repeat = true;
            int menuOption, gridCoordsX, gridCoordsY, floors, foundation, construction;
            int configure = 2;

            while(repeat == true && grid != null) {
                System.out.println("\nWelcome to the city planner. Please choose one of the below options.\n\n1.Build structure\n\n2.Build city using configure option: " + configure + "\n\n3.Configure\n\n4.Quit");
                while (!sc.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    sc.next();
                }

                menuOption = sc.nextInt();

                switch (menuOption) {
                    case 1:
                    do{
                        System.out.print("\033\143");
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
                        System.out.print("\033\143");
                    } while(construction != 1 && construction != 2 && construction != 3 && construction != 4);

                    System.out.println(BuildStructure.buildStructure(BuildStructure.findStructure(grid,coords,gridCoordsX,gridCoordsY),floors,foundation,construction));
                    break;

                    case 2:
                    if(configure == 1){
                    do{
                        System.out.print("\033\143");
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
                        System.out.print("\033\143");
                    } while(construction != 1 && construction != 2 && construction != 3 && construction != 4);

                        BuildUniform builder = new BuildUniform();
                        builder.buildStructure(grid, coords, floors, foundation, construction);
                    }
                    else if (configure == 2){
                        System.out.print("\033\143");

                        BuildRandom builder = new BuildRandom();
                        builder.buildStructure(grid, coords, 1, 1, 1);
                    }
                    else if (configure == 3){
                        System.out.print("\033\143");
                        BuildCentral builder = new BuildCentral();
                        builder.buildStructure(grid, coords, 1, 1, 1);
                    }
                        break;

                    case 3:
                    do{
                        System.out.print("\033\143");
                        System.out.println("Choose a city construction approach : (1) Uniform, (2) Random, (3) Central.");
                        while(!sc.hasNextInt()){
                            System.out.println("Invalid input. Please enter a number.");
                            sc.next();
                        }
                        configure = sc.nextInt();
                        System.out.print("\033\143");
                    } while(configure != 1 && configure != 2 && configure != 3 );
                        break;

                    case 4:
                        System.out.print("\033\143");
                        System.out.println("Exiting program");
                        repeat=false;
                        break;


                    default:
                        System.out.println("Invalid menu option.");
                        break;
                }    
            }
        } catch (NumberFormatException e) {
            logger.severe("Invalid input format");
        } catch(InvalidCoordException e) {
            logger.severe("Invalid grid dimensions");
            System.out.println(e.getMessage());
        }
        
    }
}
