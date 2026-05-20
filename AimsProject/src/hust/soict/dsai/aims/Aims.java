package hust.soict.dsai.aims;

import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;

public class Aims {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Store store = new Store();
        Cart cart = new Cart();

        // Sample data
        Book book = new Book("Java", "Education", 15.5f);

        DigitalVideoDisc dvd = new DigitalVideoDisc(
                "Lion King",
                "Animation",
                "Roger Allers",
                87,
                19.95f);

        CompactDisc cd = new CompactDisc(
                "Greatest Hits",
                "Music",
                "Unknown",
                45,
                18.0f,
                "Taylor Swift");

        store.addMedia(book);
        store.addMedia(dvd);
        store.addMedia(cd);

        int choice;

        do {

            showMenu();

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    viewStore(store, cart);
                    break;

                case 2:
                    System.out.println("Update store feature");
                    break;

                case 3:
                    cart.print();
                    break;

                case 0:
                    System.out.println("Exit program");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 0);
    }

    // Main menu
    public static void showMenu() {

        System.out.println("AIMS:");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    // Store menu
    public static void storeMenu() {

        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    // Menu details
    public static void mediaDetailsMenu() {

        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    // View store
    public static void viewStore(Store store, Cart cart) {

        int choice;

        do {

            store.print();

            storeMenu();

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    seeMediaDetails(store, cart);
                    break;

                case 2:
                    addMediaToCart(store, cart);
                    break;

                case 3:
                    playMedia(store);
                    break;

                case 4:
                    cart.print();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 0);
    }

    // Search by title
    public static Media findMediaByTitle(Store store, String title) {

        for (Media media : store.getItemsInStore()) {

            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }

        return null;
    }

    // Get details
    public static void seeMediaDetails(Store store, Cart cart) {

        System.out.print("Enter media title: ");

        String title = scanner.nextLine();

        Media media = findMediaByTitle(store, title);

        if (media == null) {

            System.out.println("Media not found");
            return;
        }

        System.out.println(media);

        mediaDetailsMenu();

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {

            case 1:

                cart.addMedia(media);
                break;

            case 2:

                if (media instanceof Playable) {

                    ((Playable) media).play();

                } else {

                    System.out.println("This media cannot be played");
                }

                break;

            case 0:
                break;

            default:
                System.out.println("Invalid choice");
        }
    }

    // Add media to cart
    public static void addMediaToCart(Store store, Cart cart) {

        System.out.print("Enter media title: ");

        String title = scanner.nextLine();

        Media media = findMediaByTitle(store, title);

        if (media == null) {

            System.out.println("Media not found");
            return;
        }

        cart.addMedia(media);

        System.out.println("Number of media in cart: "
                + cart.getItemsOrdered().size());
    }

    // Play media
    public static void playMedia(Store store) {

        System.out.print("Enter media title: ");

        String title = scanner.nextLine();

        Media media = findMediaByTitle(store, title);

        if (media == null) {

            System.out.println("Media not found");
            return;
        }

        if (media instanceof Playable) {

            ((Playable) media).play();

        } else {

            System.out.println("This media cannot be played");
        }
    }
}