package Model;

import java.io.Serializable;

public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;

    private String clientName;
    private String movieName;
    private double price;
    private int room;
    private int seatNumber;
    private String ticketType;

    public Ticket(String clientName, String movieName, double price, int room, int seatNumber, String ticketType) {
        this.clientName = clientName;
        this.movieName = movieName;
        this.price = price;
        this.room = room;
        this.seatNumber = seatNumber;
        this.ticketType = ticketType;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
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

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    @Override
    public String toString() {
        return "Bilet{" +
                "klient: '" + clientName + '\'' +
                ", tytuł filmu: '" + movieName + '\'' +
                ", cena: " + price +
                ", sala:" + room +
                ", numer siedzenia:" + seatNumber +
                ", rodzaj biletu:'" + ticketType + '\'' +
                '}';
    }
}
