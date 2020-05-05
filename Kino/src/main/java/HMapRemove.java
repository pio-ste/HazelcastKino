import Model.Movie;
import Model.Repertuar;
import Model.Ticket;
import java.util.Map;

public class HMapRemove {
    public void removeMovie(long id, Map<Long, Movie> moviesInstance) {
        moviesInstance.remove(id);
    }

    public void removeRepertuar(long id, Map<Long, Repertuar> repertuarsInstance) {
        repertuarsInstance.remove(id);
    }

    public void removeTicket(long id, Map<Long, Ticket> ticketsInstance) {
        ticketsInstance.remove(id);
    }
}
