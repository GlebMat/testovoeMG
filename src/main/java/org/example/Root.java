package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Root {
    private ArrayList<Ticket> tickets;

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void getMinTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy H:mm:ss");

        Map<String, Long> minTravelTime = new HashMap<>();

        for (Ticket ticket : this.getTickets()) {
            LocalDateTime dateArrivalTime = LocalDateTime.parse(ticket.getArrivalDate() + " " + ticket.getArrivalTime() + ":00", formatter);
            LocalDateTime dateDepartureTime = LocalDateTime.parse(ticket.getDepartureDate() + " " + ticket.getDepartureTime() + ":00", formatter);
            long timeDiff = dateDepartureTime.until(dateArrivalTime, ChronoUnit.MINUTES);
            if (!minTravelTime.containsKey(ticket.getCarrier()) || timeDiff < minTravelTime.get(ticket.getCarrier())) {
                minTravelTime.put(ticket.getCarrier(), timeDiff);
            }
        }
        for (Map.Entry<String, Long> entry : minTravelTime.entrySet()) {
            System.out.println("Минимальное время полета компании " + entry.getKey() + " " + Root.convertMinutes(entry.getValue()));
        }

    }

    public static String convertMinutes(long time) {
        String result;
        long hour;
        String minute;
        hour = time / 60;
        if (time % 60 < 10) {
            minute = "0" + time % 60;
        } else {
            minute = String.valueOf(time % 60);
        }
        return hour + ":" + minute;
    }

    public long differenceAveragePriceAndMedian(List<Ticket> tickets) {
        long averagePrice;
        long  sum = 0;
        long median;
        long count = 0;
        List<Integer> prices = new ArrayList<>();

        for (Ticket ticket : this.getTickets()) {
            if(ticket.getOriginName().equals("Владивосток") && ticket.getDestinationName().equals("Тель-Авив")){
                sum += ticket.getPrice();
                prices.add(ticket.getPrice());
                count++;
            }

        }
        averagePrice = sum / count;
        Collections.sort(prices);
        if (prices.size() % 2 == 0) {
            median = (prices.get(prices.size() / 2 - 1) + prices.get(prices.size() / 2 )) / 2;
        }else{
            median = prices.get(prices.size()/2);
        }
         return averagePrice - median;
    }
}
