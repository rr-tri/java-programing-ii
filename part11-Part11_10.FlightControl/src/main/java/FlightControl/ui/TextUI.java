/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.ui;

import FlightControl.domain.Airplane;
import FlightControl.domain.Flight;
import FlightControl.logic.FlightControl;
import java.util.Scanner;

/**
 *
 * @author rr
 */
public class TextUI {

    private final FlightControl flightControl;
    private final Scanner scanner;

    public TextUI(FlightControl flightControl, Scanner scanner) {
        this.flightControl = flightControl;
        this.scanner = scanner;
    }

    public void start() {
        // let's start in two parts -- first start the asset control,
        // then the flight control
        startAssetControl();
        System.out.println();
        startFlightControl();
        System.out.println();
    }

    private void startAssetControl() {
        System.out.println("Airport Asset Control");
        System.out.println("--------------------");
        System.out.println();

        OUTER:
        while (true) {
            System.out.println("Choose an action:");
            System.out.println("[1] Add an airplane");
            System.out.println("[2] Add a flight");
            System.out.println("[x] Exit Airport Asset Control");
            System.out.print("> ");
            String answer = this.scanner.nextLine();
            switch (answer) {
                case "1":
                    addAirplane();
                    break;
                case "2":
                    addFlight();
                    break;
                case "x":
                    break OUTER;
                default:
                    break;
            }
        }
    }

    private void addAirplane() {
        System.out.print("Give the airplane id: ");
        String id = this.scanner.nextLine();
        System.out.print("Give the airplane capacity: ");
        int capacity = Integer.parseInt(this.scanner.nextLine());

        this.flightControl.addAirplane(id, capacity);
    }

    private void addFlight() {
        System.out.print("Give the airplane id: ");
        Airplane airplane = askForAirplane();
        System.out.print("Give the departure airport id: ");
        String departureID = this.scanner.nextLine();
        System.out.print("Give the target airport id: ");
        String destinationID = this.scanner.nextLine();

        this.flightControl.addFlight(airplane, departureID, destinationID);
    }

    private void startFlightControl() {
        System.out.println("Flight Control");
        System.out.println("------------");
        System.out.println();

        OUTER:
        while (true) {
            System.out.println("Choose an action:");
            System.out.println("[1] Print airplanes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print airplane details");
            System.out.println("[x] Quit");
            System.out.print("> ");
            String answer = this.scanner.nextLine();
            switch (answer) {
                case "1":
                    printAirplanes();
                    break;
                case "2":
                    printFlights();
                    break;
                case "3":
                    printAirplaneDetails();
                    break;
                case "x":
                    break OUTER;
                default:
                    break;
            }
        }
    }

    private void printAirplanes() {
        flightControl.getAirplanes().forEach((plane) -> {
            System.out.println(plane);
        });
    }

    private void printFlights() {
        flightControl.getFlights().stream().map((flight) -> {
            System.out.println(flight);
            return flight;
        }).forEachOrdered((_item) -> {
            System.out.println("");
        });
    }

    private void printAirplaneDetails() {
        System.out.print("Give the airplane id: ");
        Airplane plane = askForAirplane();
        System.out.println(plane);
        System.out.println();
    }

    private Airplane askForAirplane() {
        Airplane airplane = null;
        while (airplane == null) {
            String id = this.scanner.nextLine();
            airplane = flightControl.getAirplane(id);

            if (airplane == null) {
                System.out.println("No airplane with the id " + id + ".");
            }
        }

        return airplane;
    }
}
