package Model;

import java.io.Serializable;

public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String category;
    private String producer;
    private int lengthTime;

    public Movie(String name, String category, String producer, int lengthTime) {
        this.name = name;
        this.category = category;
        this.producer = producer;
        this.lengthTime = lengthTime;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getLengthTime() {
        return lengthTime;
    }

    public void setLengthTime(int lengthTime) {
        this.lengthTime = lengthTime;
    }

    @Override
    public String toString() {
        return "Film{" +
                "tytuł: '" + name + '\'' +
                ", kategoria: '" + category + '\'' +
                ", producent: '" + producer + '\'' +
                ", czas trwania: " + lengthTime +
                '}';
    }
}
