package ru.itis;

import java.time.LocalTime;

public class Remote {

    LocalTime time = LocalTime.now();
    private String name;
    private long serial;
    private String firm;
    private String manufacturer;
    private int lifetime;
    TV tv = TV.getInstance();
    Channel channel;
    Broadcast broadcast;

    public Remote(Builder builder) {

        this.name = builder.name;
        this.serial = builder.serial;
        this.firm = builder.firm;
        this.manufacturer = builder.manufacturer;
        this.lifetime = builder.lifetime;


    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String name;
        private long serial;
        private String firm;
        private String manufacturer;
        private int lifetime;


        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder serial(long serial) {
            this.serial = serial;
            return this;
        }

        public Builder firm(String firm) {
            this.firm = firm;
            return this;
        }

        public Builder manufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
            return this;
        }

        public Builder lifetime(int lifetime) {
            this.lifetime = lifetime;
            return this;
        }

        public Remote build() {
            return new Remote(this);
        }
    }

    public String getName() {
        return name;
    }

    public String getFirm() {
        return firm;
    }

    public double getSerial() {
        return serial;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getLifetime() {
        return lifetime;
    }

    void switching(String name) {
        for (int i = 0; i < tv.amount - 1; i++) {
            if (name.equals(tv.channels[i].getName(name))) {
                System.out.println("Вы сейчас смотрите канал " + name);
                for (int j = 0; j < tv.channels[i].broadcasts.length-1; j++) {
                    int hour = time.getHour();
                    if ((hour >= tv.channels[i].broadcasts[j].begin) && (hour <= tv.channels[i].broadcasts[j].end)) {
                        System.out.println("Передача " + tv.channels[i].broadcasts[j].name);
                    }
                }
            }
        }
    }
}



