import Model.Movie;
import Model.Repertuar;
import Model.Ticket;
import com.whalin.MemCached.MemCachedClient;

public class MAdd {

    public void addMovie(String name, String category, String producer, int lengthTime, MemCachedClient client){
        Movie movie = new Movie(name, category, producer, lengthTime);
        client.set("keyMovie", movie);
    }

    public void addRepertuar(String date, String time, String movieName, String category, double price, int room, MemCachedClient client) {
        Repertuar repertuar = new Repertuar(date, time, movieName, category, price, room);
        client.set("keyRepertuar", repertuar);
    }

    public void addTicket(String clientName, String movieName, double price, int room, int seatNumber, String ticketType, MemCachedClient client){
        Ticket ticket = new Ticket(clientName, movieName, price, room, seatNumber, ticketType);
        client.set("keyTicket", ticket);
    }
}
