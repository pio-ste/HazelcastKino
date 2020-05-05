import Model.Movie;
import Model.Repertuar;
import Model.Ticket;
import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import com.hazelcast.query.Predicate;
import com.hazelcast.query.Predicates;

import java.net.UnknownHostException;
import java.util.Collection;

public class HPredicate {
    public void findMovieByNameAndLengthTime(String movieName, int lengthTime) throws UnknownHostException {
        ClientConfig clientConfig = HConfig.getClientConfig();
        final HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
        IMap<Long, Movie> movies = client.getMap("movies");
        Predicate<?,?> namePredicate = Predicates.equal("name", movieName);
        Predicate<?,?> lengthTimePredicate = Predicates.greaterThan("lengthTime", lengthTime);
        Collection<Movie> collection = movies.values(Predicates.and(namePredicate, lengthTimePredicate));
        for (Movie m : collection) {
            System.out.println(m);
        }
    }

    public void findRepertuarByDateTimeAndPrice(String date, String time, double price) throws UnknownHostException {
        ClientConfig clientConfig = HConfig.getClientConfig();
        final HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
        IMap<Long, Repertuar> repertuars = client.getMap("repertuars");
        Predicate<?,?> datePredicate = Predicates.equal("date", date);
        Predicate<?,?> timePredicate = Predicates.equal("time", time);
        Predicate<?,?> pricePredicate = Predicates.lessThan("price", price);
        Collection<Repertuar> collection = repertuars.values(Predicates.and(datePredicate, timePredicate, pricePredicate));
        for (Repertuar r : collection) {
            System.out.println(r);
        }
    }

    public void findTicketBetweenPrice(double priceFrom, double priceTo, String movieName) throws UnknownHostException {
        ClientConfig clientConfig = HConfig.getClientConfig();
        final HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
        IMap<Long, Ticket> tickets = client.getMap("tickets");
        Predicate<?,?> priceBetweenPredicate = Predicates.between("price", priceFrom, priceTo);
        Predicate<?,?> movieNamePredicate = Predicates.equal("movieName", movieName);
        Collection<Ticket> collection = tickets.values(Predicates.and(priceBetweenPredicate, movieNamePredicate));
        for (Ticket t : collection) {
            System.out.println(t);
        }
    }
}
