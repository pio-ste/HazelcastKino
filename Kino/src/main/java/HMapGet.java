import Model.Movie;
import Model.Repertuar;
import Model.Ticket;
import com.hazelcast.map.IMap;

import java.util.Map.Entry;

public class HMapGet {

    public void getMovie(IMap<Long, Movie> movies) {
        System.out.println("Lista filmów");
        for(Entry<Long, Movie> e : movies.entrySet()) {
            System.out.println(e.getKey() + " => " + e.getValue());
        }
    }

    public void getMovieById(long id, IMap<Long, Movie> movies) {
        System.out.println(movies.get(id));
    }

    public void getRepertuar(IMap<Long, Repertuar> repertuars) {
        System.out.println("Lista repertuarów");
        for(Entry<Long, Repertuar> e : repertuars.entrySet()) {
            System.out.println(e.getKey() + " => " + e.getValue());
        }
    }

    public void getTicket(IMap<Long, Ticket> tickets) {
        System.out.println("Lista biletów");
        for(Entry<Long, Ticket> e : tickets.entrySet()) {
            System.out.println(e.getKey() + " => " + e.getValue());
        }
    }

}
