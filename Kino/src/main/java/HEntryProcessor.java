import Model.Repertuar;
import com.hazelcast.map.EntryProcessor;

import java.io.Serializable;
import java.util.Map;

public class HEntryProcessor implements EntryProcessor<Long, Repertuar, String>, Serializable {
    private static final long serialVersionUID = 1L;
    @Override
    public String process(Map.Entry<Long, Repertuar> entry) {
        Repertuar repertuar = entry.getValue();
        String movieName = repertuar.getMovieName();
        if (movieName.equals(movieName.toLowerCase())) {
            movieName = movieName.toUpperCase();
            repertuar.setMovieName(movieName);
        } else {
            movieName = movieName.toLowerCase();
            repertuar.setMovieName(movieName);
        }
        System.out.println("Przetwarzanie:" + repertuar);
        entry.setValue(repertuar);
        return movieName;
    }
}
