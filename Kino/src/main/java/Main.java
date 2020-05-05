import Model.Movie;
import Model.Repertuar;
import Model.Ticket;
import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

import java.net.UnknownHostException;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) throws UnknownHostException {
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.OFF);
        ClientConfig clientConfig = HConfig.getClientConfig();
        HazelcastInstance client = HazelcastClient.newHazelcastClient( clientConfig );
        IMap<Long, Movie> movies = client.getMap("movies");
        IMap<Long, Repertuar> repertuars = client.getMap("repertuars");
        IMap<Long, Ticket> tickets = client.getMap("tickets");
        Config config = HConfig.getConfig();
        HazelcastInstance instance = Hazelcast.newHazelcastInstance(config);
        Map<Long, Movie> moviesInstance = instance.getMap("movies");
        Map<Long, Repertuar> repertuarsInstance = instance.getMap("repertuars");
        Map<Long, Ticket> ticketsInstance = instance.getMap("tickets");
        HMapPut hMapPut = new HMapPut();
        HMapGet hMapGet = new HMapGet();
        HMapRemove hMapRemove = new HMapRemove();
        HPredicate hPredicate = new HPredicate();
        HUpdate hUpdate = new HUpdate();
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("|=================> System zarządzania kinem <=================|");
            System.out.println("1.Filmy");
            System.out.println("===> 1a.Dodaj film");
            System.out.println("===> 1b.Wyświetl wszystkie filmy");
            System.out.println("===> 1c.Usuń film");
            System.out.println("===> 1d.Szukaj filmu po id");
            System.out.println("===> 1e.Szukaj filmu po tytule i czasu trwania");
            System.out.println("===> 1f.Aktualizuj wybrany film");
            System.out.println("2.Repertuary");
            System.out.println("===> 2a.Dodaj repertuar");
            System.out.println("===> 2b.Wyświetl wszystkie repertuary");
            System.out.println("===> 2c.Usuń repertuar");
            System.out.println("===> 2d.Szukaj repertuaru po dacie, godzinie oraz cenie");
            System.out.println("===> 2e.Aktualizuj wybrany repertuar");
            System.out.println("===> 2f.Zmiana wielkości liter tytułom filmów");
            System.out.println("3.Bielty");
            System.out.println("===> 3a.Dodaj bilet");
            System.out.println("===> 3b.Wyświetl wszystkie bilety");
            System.out.println("===> 3c.Usuń bilet");
            System.out.println("===> 3d.Szukaj biletu w przedziale cenowym oraz po tytule filmu");
            System.out.println("===> 3e.Aktualzuj wybrany bilet");
            System.out.println("===> 3f.Usuwanie imienia i nazwiska klienta");
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
                        hMapPut.putMovie(name, category, producer, lengthTime, moviesInstance);
                        break;
                    case "1b":
                        hMapGet.getMovie(movies);
                        break;
                    case "1c":
                        hMapGet.getMovie(movies);
                        System.out.println("Wpisz id filmu który chcesz usunąć");
                        long id = scanner.nextLong();
                        hMapRemove.removeMovie(id, moviesInstance);
                        break;
                    case "1d":
                        System.out.println("Podaj id filmu który chcesz wyświetlić");
                        id = scanner.nextLong();
                        hMapGet.getMovieById(id, movies);
                        break;
                    case "1e":
                        System.out.println("Podaj tytuł filmu:");
                        String movieName = scanner.nextLine();
                        System.out.println("Podaj minimalną długość filmu:");
                        lengthTime = scanner.nextInt();
                        hPredicate.findMovieByNameAndLengthTime(movieName, lengthTime);
                        break;
                    case "1f":
                        hMapGet.getMovie(movies);
                        System.out.println("Wpisz numer klucza który chcesz aktualizować:");
                        long key = scanner.nextLong();
                        scanner.nextLine();
                        hUpdate.updateMovie(key, moviesInstance);
                        break;
                    case "2a":
                        System.out.println("Data (dd.mm.rrrr):");
                        String date = scanner.nextLine();
                        System.out.println("Godzina rozpoczęcia (hh.mm):");
                        String time = scanner.nextLine();
                        System.out.println("Tytuł filmu:");
                        movieName = scanner.nextLine();
                        System.out.println("Kategoria filmu:");
                        category = scanner.nextLine();
                        System.out.println("Cena:");
                        double price = scanner.nextDouble();
                        System.out.println("Sala:");
                        int room = scanner.nextInt();
                        hMapPut.putRepertuar(date, time, movieName, category, price, room, repertuarsInstance);
                        break;
                    case "2b":
                        hMapGet.getRepertuar(repertuars);
                        break;
                    case "2c":
                        hMapGet.getRepertuar(repertuars);
                        System.out.println("Wpisz id repertuaru który chcesz usunąć");
                        id = scanner.nextLong();
                        hMapRemove.removeRepertuar(id, repertuarsInstance);
                        break;
                    case "2d":
                        System.out.println("Wyszukiwanie repertuaru po dacie, godzinie oraz cenie:");
                        System.out.println("Data (dd.mm.rrrr):");
                        date = scanner.nextLine();
                        System.out.println("Godzina rozpoczęcia (hh.mm):");
                        time = scanner.nextLine();
                        System.out.println("Cena:");
                        price = scanner.nextDouble();
                        hPredicate.findRepertuarByDateTimeAndPrice(date, time, price);
                        break;
                    case "2e":
                        hMapGet.getRepertuar(repertuars);
                        System.out.println("Wpisz numer klucza który chcesz aktualizować:");
                        key = scanner.nextLong();
                        scanner.nextLine();
                        hUpdate.updateRepertuar(key, repertuarsInstance);
                        break;
                    case "2f":
                        repertuars.executeOnEntries(new HEntryProcessor());
                        for (Map.Entry<Long, Repertuar> entry : repertuars.entrySet()){
                            System.out.println(entry.getKey() + " => " + entry.getValue());
                        }
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
                        hMapPut.putTicket(clientName, movieName, price, room, seatNumber, ticketType, ticketsInstance);
                        break;
                    case "3b":
                        hMapGet.getTicket(tickets);
                        break;
                    case "3c":
                        hMapGet.getTicket(tickets);
                        System.out.println("Wpisz id biletu który chcesz usunąć");
                        id = scanner.nextLong();
                        hMapRemove.removeTicket(id, ticketsInstance);
                        break;
                    case "3d":
                        System.out.println("Wyszukiwanie biletu w przedziale cenowym oraz po tytule filmu");
                        System.out.println("Cena od:");
                        double priceFrom = scanner.nextDouble();
                        System.out.println("Cena do:");
                        double priceTo = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println("Tytuł filmu:");
                        movieName = scanner.nextLine();
                        hPredicate.findTicketBetweenPrice(priceFrom, priceTo, movieName);
                        break;
                    case "3e":
                        hMapGet.getTicket(tickets);
                        System.out.println("Wpisz numer klucza który chcesz aktualizować:");
                        key = scanner.nextLong();
                        scanner.nextLine();
                        hUpdate.updateTicket(key, ticketsInstance);
                        break;
                    case "3f":
                        hMapGet.getTicket(tickets);
                        System.out.println("Wpisz numer klucza w którym chcesz usunąć dane klienta:");
                        key = scanner.nextLong();
                        scanner.nextLine();
                        hUpdate.removeClientNameTicket(key, ticketsInstance);
                        break;
                    default:
                        System.out.println("Brak takiej opcji");
            }
        } while(true);
    }
}
