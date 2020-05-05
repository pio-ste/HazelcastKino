import Model.Movie;
import Model.Repertuar;
import Model.Ticket;

import java.util.Map;
import java.util.Scanner;

public class HUpdate {

    public void updateMovie(long key, Map<Long, Movie> moviesInstance) {
        String name, newName, category, newCategory, producer, newProducer;
        int lengthTime, newLengthTime,decision ;
        Scanner scanner = new Scanner(System.in);
        name = moviesInstance.get(key).getName();
        category = moviesInstance.get(key).getCategory();
        producer = moviesInstance.get(key).getProducer();
        lengthTime = moviesInstance.get(key).getLengthTime();
        Movie movie = new Movie(name,category, producer, lengthTime);

        System.out.println("Wybierz które pole chcesz edytować.");
        System.out.println("1. Tytuł filmu \n2. kategorię\n3. Producenta\n4. Czas trania");
        decision = scanner.nextInt();
        scanner.nextLine();
        switch (decision){
            case 1:
                System.out.println("Wpisz tytuł filmu:");
                newName = scanner.nextLine();
                movie.setName(newName);
                moviesInstance.replace(key, movie);
                break;
            case 2:
                System.out.println("Wpisz kategorię:");
                newCategory = scanner.nextLine();
                movie.setCategory(newCategory);
                moviesInstance.replace(key, movie);
                break;
            case 3:
                System.out.println("Wpisz producenta");
                newProducer = scanner.nextLine();
                movie.setProducer(newProducer);
                moviesInstance.replace(key, movie);
                break;
            case 4:
                System.out.println("Wpisz czas trwania filmu");
                newLengthTime = scanner.nextInt();
                movie.setLengthTime(newLengthTime);
                moviesInstance.replace(key, movie);
                break;
            default:
                System.out.println("Brak takiej opcji");
        }
        System.out.println("Zaktualizowano" + key + " => " + movie);
    }

    public void updateRepertuar(long key, Map<Long, Repertuar> repertuarsInstance) {
        String date, newDate,  time, newTime,  movieName, newMovieName,  category, newCategory;
        double price, newPrice;
        int room, newRoom, decision;
        Scanner scanner = new Scanner(System.in);
        date = repertuarsInstance.get(key).getDate();
        time = repertuarsInstance.get(key).getTime();
        movieName = repertuarsInstance.get(key).getMovieName();
        category = repertuarsInstance.get(key).getCategory();
        price = repertuarsInstance.get(key).getPrice();
        room = repertuarsInstance.get(key).getRoom();
        Repertuar repertuar = new Repertuar(date, time, movieName, category, price, room);
        System.out.println("Wybierz które pole chcesz edytować.");
        System.out.println("1. Data \n2. Godzina\n3. Tytuł filmu\n4. Kategoria\n5. Cena\n6. Sala");
        decision = scanner.nextInt();
        scanner.nextLine();
        switch (decision){
            case 1:
                System.out.println("Wpisz date:");
                newDate = scanner.nextLine();
                repertuar.setDate(newDate);
                repertuarsInstance.replace(key, repertuar);
                break;
            case 2:
                System.out.println("Wpisz godzinę rozpoczęcia filmu");
                newTime = scanner.nextLine();
                repertuar.setTime(newTime);
                repertuarsInstance.replace(key, repertuar);
                break;
            case 3:
                System.out.println("Wpisz tytuł filmu");
                newMovieName = scanner.nextLine();
                repertuar.setMovieName(newMovieName);
                repertuarsInstance.replace(key, repertuar);
                break;
            case 4:
                System.out.println("Wpisz kategorię:");
                newCategory = scanner.nextLine();
                repertuar.setCategory(newCategory);
                repertuarsInstance.replace(key, repertuar);
                break;
            case 5:
                System.out.println("Wpisz cenę");
                newPrice = scanner.nextDouble();
                scanner.nextLine();
                repertuar.setPrice(newPrice);
                repertuarsInstance.replace(key, repertuar);
                break;
            case 6:
                System.out.println("Wpisz salę");
                newRoom = scanner.nextInt();
                scanner.nextLine();
                repertuar.setRoom(newRoom);
                repertuarsInstance.replace(key, repertuar);
                break;
            default:
                System.out.println("Brak takiej opcji");
        }
        System.out.println("Zaktualizowano" + key + " => " + repertuar);
    }

    public void updateTicket(long key, Map<Long, Ticket> ticketsInstance) {
        String clientName, newClientName,  movieName, newMovieName, ticketType, newTicketType;
        double price, newPrice;
        int room, newRoom, seatNumber, newSeatNumber, decision;
        Scanner scanner = new Scanner(System.in);
        clientName = ticketsInstance.get(key).getClientName();
        movieName = ticketsInstance.get(key).getMovieName();
        price = ticketsInstance.get(key).getPrice();
        room = ticketsInstance.get(key).getRoom();
        seatNumber = ticketsInstance.get(key).getSeatNumber();
        ticketType = ticketsInstance.get(key).getTicketType();
        Ticket ticket = new Ticket(clientName, movieName, price, room, seatNumber, ticketType);
        System.out.println("Wybierz które pole chcesz edytować.");
        System.out.println("1. Imie i nazwisko klienta \n2. Tytuł filmu\n3. Cena\n4. Sala\n5. Numer siedzenia\n6. Rodzaj biletu");
        decision = scanner.nextInt();
        scanner.nextLine();
        switch (decision){
            case 1:
                System.out.println("Wpisz imię i nazwisko klienta:");
                newClientName = scanner.nextLine();
                ticket.setClientName(newClientName);
                ticketsInstance.replace(key, ticket);
                break;
            case 2:
                System.out.println("Wpisz tytuł filmu");
                newMovieName = scanner.nextLine();
                ticket.setMovieName(newMovieName);
                ticketsInstance.replace(key, ticket);
                break;
            case 3:
                System.out.println("Wpisz cenę");
                newPrice = scanner.nextDouble();
                scanner.nextLine();
                ticket.setPrice(newPrice);
                ticketsInstance.replace(key, ticket);
                break;
            case 4:
                System.out.println("Wpisz salę:");
                newRoom = scanner.nextInt();
                scanner.nextLine();
                ticket.setRoom(newRoom);
                ticketsInstance.replace(key, ticket);
                break;
            case 5:
                System.out.println("Wpisz numer miejsca");
                newSeatNumber = scanner.nextInt();
                scanner.nextLine();
                ticket.setSeatNumber(newSeatNumber);
                ticketsInstance.replace(key, ticket);
                break;
            case 6:
                System.out.println("Wpisz rodzaj biletu");
                newTicketType = scanner.nextLine();
                ticket.setTicketType(newTicketType);
                ticketsInstance.replace(key, ticket);
                break;
            default:
                System.out.println("Brak takiej opcji");
        }
        System.out.println("Zaktualizowano" + key + " => " + ticket);
    }

    public void removeClientNameTicket(long key, Map<Long, Ticket> ticketsInstance) {
        String clientName, newClientName,  movieName, ticketType;
        double price;
        int room, seatNumber;
        clientName = ticketsInstance.get(key).getClientName();
        movieName = ticketsInstance.get(key).getMovieName();
        price = ticketsInstance.get(key).getPrice();
        room = ticketsInstance.get(key).getRoom();
        seatNumber = ticketsInstance.get(key).getSeatNumber();
        ticketType = ticketsInstance.get(key).getTicketType();
        Ticket ticket = new Ticket(clientName, movieName, price, room, seatNumber, ticketType);
        newClientName = " ";
        ticket.setClientName(newClientName);
        ticketsInstance.replace(key, ticket);
        System.out.println("Zaktualizowano" + key + " => " + ticket);
    }
}
