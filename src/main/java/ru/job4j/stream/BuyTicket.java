package ru.job4j.stream;

public class BuyTicket {
    static class Builder {

        private String name;
        private String surname;
        private double departure;
        private String transport;
        private String airline;
        private String route;
        private boolean baggage;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildSurname(String surname) {
            this.surname = surname;
            return this;
        }

        Builder buildDeparture(double departure) {
            this.departure = departure;
            return this;
        }

        Builder buildTransport(String transport) {
            this.transport = transport;
            return this;
        }

        Builder buildAirline(String airline) {
            this.airline = airline;
            return this;

        }

        Builder buildRoute(String route) {
            this.route = route;
            return this;
        }

        Builder buildBaggage(boolean baggage) {
            this.baggage = baggage;
            return this;
        }

        @Override
        public String toString() {
            return "Builder{"
                    + "name='" + name + '\''
                    + ", surname='" + surname + '\''
                    + ", departure=" + departure
                    + ", transport='" + transport + '\''
                    + ", airline='" + airline + '\''
                    + ", route='" + route + '\''
                    + ", baggage=" + baggage
                    + '}';
        }
    }

    public static void main(String[] args) {
        Builder client = new Builder().buildName("Alexander")
                .buildSurname("Makutsevich")
                .buildDeparture(15.07)
                .buildTransport("Plane")
                .buildAirline("S7")
                .buildRoute("Neryungri - Moscow")
                .buildBaggage(true);

        System.out.println(client);
    }
}
