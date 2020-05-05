import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;

import java.util.Scanner;

public class MainClient {
    public static void main(String[] args) {
        String[] servers = {"localhost:11211"};
        SockIOPool pool = SockIOPool.getInstance("Kino");
        pool.setServers( servers );
        pool.setFailover( true );
        pool.setInitConn( 10 );
        pool.setMinConn( 5 );
        pool.setMaxConn( 250 );
        pool.setMaintSleep( 30 );
        pool.setNagle( false );
        pool.setSocketTO( 3000 );
        pool.setAliveCheck( true );
        pool.initialize();
        MemCachedClient client = new MemCachedClient("Kino");
        MAdd mAdd = new MAdd();
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("|=================> System zarządzania kinem <=================|");
            System.out.println("1.Filmy");
            System.out.println("===> 1a.Dodaj film");
            System.out.println("===> 1b.Wyświetl wszystkie filmy");
            System.out.println("===> 1c.Usuń film");
            System.out.println("2.Repertuary");
            System.out.println("===> 2a.Dodaj repertuar");
            System.out.println("===> 2b.Wyświetl wszystkie repertuary");
            System.out.println("===> 2c.Usuń repertuar");;
            System.out.println("3.Bielty");
            System.out.println("===> 3a.Dodaj bilet");
            System.out.println("===> 3b.Wyświetl wszystkie bilety");
            System.out.println("===> 3c.Usuń bilet");
            System.out.println("Wybór:");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1a":
                    System.out.println("Tytuł filmu:");
                    String name = scanner.nextLine();
                    System.out.println("Kategoria:");
                    String category = scanner.nextLine();
                    System.out.println("Producent:");
                    String producer = scanner.nextLine();
                    System.out.println("Czas trwania filmu (minuty):");
                    int lengthTime = scanner.nextInt();
                    scanner.nextLine();
                    mAdd.addMovie(name, category, producer, lengthTime, client);
                    break;
                case "1b":
                    System.out.println(client.get("keyMovie"));
                    break;
                case "1c":
                    client.delete("keyMovie");
                    break;
                case "2a":
                    System.out.println("Data (dd.mm.rrrr):");
                    String date = scanner.nextLine();
                    System.out.println("Godzina rozpoczęcia (hh.mm):");
                    String time = scanner.nextLine();
                    System.out.println("Tytuł filmu:");
                    String movieName = scanner.nextLine();
                    System.out.println("Kategoria filmu:");
                    category = scanner.nextLine();
                    System.out.println("Cena:");
                    double price = scanner.nextDouble();
                    System.out.println("Sala:");
                    int room = scanner.nextInt();
                    mAdd.addRepertuar(date, time, movieName, category, price, room, client);
                    break;
                case "2b":
                    System.out.println(client.get("keyRepertuar"));
                    break;
                case "2c":
                    client.delete("keyRepertuar");
                    break;
                case "3a":
                    System.out.println("Imie i nazwsiko klienta:");
                    String clientName = scanner.nextLine();
                    System.out.println("Nazwa filmu:");
                    movieName = scanner.nextLine();
                    System.out.println("Cena:");
                    price = scanner.nextDouble();
                    System.out.println("Sala:");
                    room = scanner.nextInt();
                    System.out.println("Numer miejsca:");
                    int seatNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Rodzaj biletu:");
                    String ticketType = scanner.nextLine();
                    mAdd.addTicket(clientName, movieName, price, room, seatNumber, ticketType, client);
                    break;
                case "3b":
                    System.out.println(client.get("keyTicket"));
                    break;
                case "3c":
                    client.delete("keyTicket");
                    break;
                default:
                    System.out.println("Brak takiej opcji");
            }
        } while(true);
    }
}
