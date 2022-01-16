package models;

import net.bytebuddy.utility.RandomString;

/**
 * Объект тикета
 */
public class Ticket {

    /**
     * Название проблемы
     */
    private String title;
    private String queue;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public Ticket buildNewTicket() {
        Ticket ticket = new Ticket();
        ticket.setTitle(RandomString.make(8));
        ticket.setQueue("2");
        return ticket;
    }
}
