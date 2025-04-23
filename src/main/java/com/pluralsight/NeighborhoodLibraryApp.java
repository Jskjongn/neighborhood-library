package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibraryApp {

    // Creates an array of Book objects from the constructor to add 20 books with ID, ISBN, and title
    static Book[] theBooks = {
            new Book(1, "87238623", "The Recognition Sutras"),
            new Book(2, "68735734", "The Art of Happiness"),
            new Book(3, "90621347", "Thinking, Fast and Slow"),
            new Book(4, "28579835", "How to Win Friends & Influence People"),
            new Book(5, "96734573", "Critical Thinking, Logic & Problem Solving"),
            new Book(6, "83475873", "The 1-Page Marketing Plan"),
            new Book(7, "56435456", "This Is Marketing"),
            new Book(8, "56567888", "The 4-Hour Workweek"),
            new Book(9, "93747646", "The Art of War"),
            new Book(10, "11723763", "Tao Te Ching"),
            new Book(11, "67935733", "Rich Dad Poor Dad"),
            new Book(12, "35785498", "Richest Man in Babylon"),
            new Book(13, "49809234", "The 48 Laws of Power"),
            new Book(14, "23983838", "Lessons in Stoicism"),
            new Book(15, "74985859", "How to Think Like a Roman Emperor"),
            new Book(16, "85497459", "A History of Western Philosophy"),
            new Book(17, "56908345", "Beyond Good and Evil"),
            new Book(18, "23958585", "The Body Keeps the Score"),
            new Book(19, "39578384", "Moby-Dick"),
            new Book(20, "19473233", "1984"),
    };

    // creates new scanner to take in user input
    static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args) {

        // greets user before home screen
        System.out.println("Greetings! Welcome to the Neighborhood Tiny Library!");
        System.out.println("Please take a book or two : )");

        // sets value for loop
        boolean appRunning = true;

        // while loop to keep prompts running after user chooses what to do
        while (appRunning) {
            // asks user what option they want to choose
            int homeScreenOption = storeHomeScreen();

            // switch statement for different choices like showing available books, showing checked out books, and exiting the app
            switch (homeScreenOption) {
                // shows available books
                case 1:
                    System.out.println("You choose - Show Available Books");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    // calls the method of the show available books and stores it
                    int userBookOption = showAvailableBooks();

                    // eats leftover
                    myScanner.nextLine();

                    // runs if the user choose a valid ID of a book they want
                    if (userBookOption != -1) {

                        // user enters name when checking out book and stores it
                        System.out.print("Please enter your name: ");
                        String userName = myScanner.nextLine();

                        // checks out the book
                        theBooks[userBookOption].checkOut(userName);

                    }
                    break;
                    // shows checked out books
                case 2:
                    System.out.println("You choose - Show Checked Out Books");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                    // calls show checked out books method
                    int bookReturn = showCheckedOutBooks();

                    // returns book if user entered a valid book ID and checks it in
                    if (bookReturn != -1) {
                        theBooks[bookReturn].checkIn();
                    }
                    break;
                    // stops the while loop and ends program if user chooses exit
                case 3:
                    System.out.println("You choose - Exit");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    appRunning = false;
                    break;
                    // If user didn't choose 1-3 then displays invalid input
                default:
                    System.out.println("Invalid choice - Please Choose Numbers 1-3");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            }

        }

    }

    // method to display home screen and options for user to choose
    static int storeHomeScreen() {

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // home screen options and prompts user to choose 1-3
        System.out.println("What would you like to do today?");
        System.out.println("1: Show Available Books");
        System.out.println("2: Show Checked Out Books");
        System.out.println("3: Exit");

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        return myScanner.nextInt();

    }

    // method to show books that haven't been checked out
    static int showAvailableBooks() {

        // displays what books are available
        System.out.println("Available books we currently have:\n");

        // loops through the length of the books list
        for (int index = 0; index < theBooks.length; index++) {

            // sets the index to current book
            Book currentBook = theBooks[index];

            // if is checked out is false then it combines the ID to the title and ISBN
            if (!currentBook.isCheckedOut()) {
                System.out.println(index + ": " + currentBook.getTitle() + " - " + currentBook.getIsbn());

            }

        }

        // eats leftover
        myScanner.nextLine();

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // asks user if they want to choose a book from available books
        System.out.println("Would you like to check out a book? (y/n)");
        String checkOutOption = myScanner.nextLine();

        // if answered yes (Y) then prompts user to enter the ID of what book
        if (checkOutOption.equalsIgnoreCase("y")) {
            System.out.println("You choose - (Y)");
            System.out.print("Please enter the ID of book to check out: ");

            // returns the ID
            return myScanner.nextInt();

        } else {
            // if answered no (N) then sends user back to home screen
            System.out.println("You choose - (N)");
            return -1;
        }


    }

    // method that shows what books that have been checked out
    static int showCheckedOutBooks() {

        // displays the books that are checked out
        System.out.println("Books currently Checked Out: ");

        // same loop to go through the length of the list
        for (int index = 0; index < theBooks.length; index++) {

            // sets the index to the current book
            Book currentBook = theBooks[index];

            // if is checked out is true then it displays the ID with the title, ISBN, and the name of who checked it out
            if (currentBook.isCheckedOut()) {
                System.out.println(index + ": " + currentBook.getTitle() + " - " + currentBook.getIsbn() + " - " + currentBook.getCheckedOutTo());

            }

        }

        // eats leftover
        myScanner.nextLine();

        // asks user if they want to check a book in or exit back home
        System.out.println("\nWould you like to check in a book or go back to home screen?");
        System.out.println("C - to Check In a book");
        System.out.println("X - to go back to the Home Screen");

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // stores user input
        String userOption = myScanner.nextLine();

        // if C is chosen then prompts user to enter the ID of book that was checked out
        if (userOption.equalsIgnoreCase("c")) {
            System.out.println("You choose - (C)");
            System.out.print("Please enter the ID of book to check in: ");

            // returns the ID
            return myScanner.nextInt();

        } else {
            // if X is chosen then sends user back to home screen options
            System.out.println("You choose - (X)");
            return -1;
        }

    }

}
