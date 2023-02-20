package cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {
    private static final Scanner scanner = new Scanner(System.in);
    private static final char VACANT_SEAT = 'S';
    private static final char BOOKED_SEAT = 'B';
    private static final int SMALL_CINEMA_SIZE = 60;
    private static final int PRICE_FRONT_SEATS = 10;
    private static final int PRICE_BACK_SEATS = 8;
    private static int numberOfRows;
    private static int numberOfSeats;

    private static char[][] seats;

    public static void main(String[] args) {

        fillSeats();
        printSeats();

//        calculateIncome(numberOfRows, numberOfSeats);

        bookSeat();
        printSeats();
    }

    private static void fillSeats() {

        System.out.println("Enter the number of rows:");
        numberOfRows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        numberOfSeats = scanner.nextInt();

        seats = new char[numberOfRows][numberOfSeats];

        for (char[] row : seats) {
            Arrays.fill(row, VACANT_SEAT);
        }
    }

    private static void printSeats() {

        System.out.println("Cinema:");
        printSeatNumbers();

        for (int rowIndex = 0; rowIndex < seats.length; rowIndex++) {

            int rowNumber = rowIndex + 1;
            StringBuilder rowSeatsStatus = new StringBuilder("" + rowNumber);

            char[] row = seats[rowIndex];

            for (char seatStatus : row) {
                rowSeatsStatus.append(" ").append(seatStatus);
            }
            System.out.println(rowSeatsStatus);
        }
        System.out.println();
    }

    private static void printSeatNumbers() {

        int rowLength = seats[0].length;
        StringBuilder seatNumbers = new StringBuilder(" ");

        for (int seatNumber = 1; seatNumber <= rowLength; seatNumber++) {
            seatNumbers.append(" ").append(seatNumber);
        }
        System.out.println(seatNumbers);
    }

    private static void calculateIncome(int numberOfRows, int numberOfSeats) {
        int income;
        int totalNumberOfSeats = numberOfRows * numberOfSeats;

        if (totalNumberOfSeats <= SMALL_CINEMA_SIZE) {
            income = totalNumberOfSeats * PRICE_FRONT_SEATS;
        } else {
            int frontRows = numberOfRows / 2;
            int frontSeats = frontRows * numberOfSeats;
            int backRows = numberOfRows - frontRows;
            int backSeats = backRows * numberOfSeats;
            income = (frontSeats * PRICE_FRONT_SEATS) + (backSeats * PRICE_BACK_SEATS);
        }
        System.out.printf("Total income:\n$%d\n", income);
    }

    private static void bookSeat() {

        System.out.println("Enter a row number:");
        int rowNumber = scanner.nextInt();

        System.out.println("Enter a seat number in that row:");
        int seatNumber = scanner.nextInt();

        int ticketPrice;
        int totalNumberOfSeats = numberOfRows * numberOfSeats;
        int frontRows = numberOfRows / 2;
        if ((totalNumberOfSeats <= SMALL_CINEMA_SIZE) || (rowNumber <= frontRows)) {
            ticketPrice = PRICE_FRONT_SEATS;
        } else {
            ticketPrice = PRICE_BACK_SEATS;
        }

        int rowIndex = rowNumber - 1;
        int seatIndex = seatNumber - 1;
        seats[rowIndex][seatIndex] = BOOKED_SEAT;

        System.out.printf("Ticket price: $%d\n\n", ticketPrice);
    }
}