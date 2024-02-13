package org.example;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class RootTest {

    @Test
    public void getMinTime() {
        Root root = new Root();
        ArrayList<Ticket> tickets = new ArrayList<>();
        Ticket ticket1 = new Ticket();
        ticket1.setArrivalDate("12.05.18");
        ticket1.setArrivalTime("22:10");
        ticket1.setDepartureDate("12.05.18");
        ticket1.setDepartureTime("16:20");
        ticket1.setCarrier("TK");
        ticket1.setOriginName("Владивосток");
        ticket1.setDestinationName("Тель-Авив");
        tickets.add(ticket1);

        Ticket ticket2 = new Ticket();
        ticket2.setArrivalDate("12.05.18");
        ticket2.setArrivalTime("23:50");
        ticket2.setDepartureDate("12.05.18");
        ticket2.setDepartureTime("17:20");
        ticket2.setCarrier("SU");
        ticket2.setOriginName("Владивосток");
        ticket2.setDestinationName("Тель-Авив");
        tickets.add(ticket2);

        root.setTickets(tickets);

        root.getMinTime();
    }

    @Test
    public void differenceAveragePriceAndMedian() {
        Root root = new Root();
        ArrayList<Ticket> tickets = new ArrayList<>();
        Ticket ticket1 = new Ticket();
        ticket1.setOriginName("Владивосток");
        ticket1.setDestinationName("Тель-Авив");
        ticket1.setPrice(100);
        tickets.add(ticket1);

        Ticket ticket2 = new Ticket();
        ticket2.setOriginName("Владивосток");
        ticket2.setDestinationName("Тель-Авив");
        ticket2.setPrice(200);
        tickets.add(ticket2);

        Ticket ticket3 = new Ticket();
        ticket3.setOriginName("Владивосток");
        ticket3.setDestinationName("Тель-Авив");
        ticket3.setPrice(300);
        tickets.add(ticket3);

        root.setTickets(tickets);

        long expectedDifference = (200 - 200); // expectedDifference = (averagePrice - median) = (200 - 200) = 0

        assertEquals(expectedDifference, root.differenceAveragePriceAndMedian(tickets));
    }
}
