import Model.Movie;
import Model.Repertuar;
import Model.Ticket;

import java.net.UnknownHostException;
import java.util.Map;
import java.util.Random;

public class HMapPut {
    final private static Random r = new Random(System.currentTimeMillis());

    public void putMovie(String name, String category, String producer, int lengthTime, Map<Long, Movie> moviesInstance) throws UnknownHostException {
        Long key = (long) Math.abs(r.nextInt());
        Movie movie = new Movie(name, category, producer, lengthTime);
        System.out.println("Dodano" + key + " => " + movie);
        moviesInstance.put(key,movie);
    }
    public void putRepertuar(String date, String time, String movieName, String category, double price, int room, Map<Long, Repertuar> repertuarsInstance) throws UnknownHostException {
        Long key = (long) Math.abs(r.nextInt());
        Repertuar repertuar = new Repertuar(date, time, movieName, category, price, room);
        System.out.println("Dodano" + key + " => " + repertuar);
        repertuarsInstance.put(key, repertuar);
    }

    public void putTicket(String clientName, String movieName, double price, int room, int seatNumber, String ticketType, Map<Long, Ticket> ticketsInstance) throws UnknownHostException {
        Long key = (long) Math.abs(r.nextInt());
        Ticket ticket = new Ticket(clientName, movieName, price, room, seatNumber, ticketType);
        System.out.println("Dodano" + key + " => " + ticket);
        ticketsInstance.put(key, ticket);
    }
}
