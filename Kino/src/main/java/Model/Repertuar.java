package Model;

import java.io.Serializable;

public class Repertuar implements Serializable {
    private static final long serialVersionUID = 1L;

    private String date;
    private String time;
    private String movieName;
    private String category;
    private double price;
    private int room;

    public Repertuar(String date, String time, String movieName, String category, double price, int room) {
        this.date = date;
        this.time = time;
        this.movieName = movieName;
        this.category = category;
        this.price = price;
        this.room = room;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Model.Repertuar{" +
                "data: '" + date + '\'' +
                ", godzina rozpoczęcia: '" + time + '\'' +
                ", tytuł filmu: '" + movieName + '\'' +
                ", kategoria: '" + category + '\'' +
                ", cena: " + price +
                ", numer sali: " + room +
                '}';
    }
}
