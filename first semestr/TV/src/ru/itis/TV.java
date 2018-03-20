package ru.itis;

public class TV {
    int amount = 10;
    Channel[] channels = new Channel[amount];

    private static final TV instance;

    private TV() {
    }

    static {
        instance = new TV();
    }

    public static TV getInstance() {
        return instance;
    }

    void addChannel(Channel channel) {
        for (int i = 0; i < amount-1; i++) {
            if (channels[i] == null) {
                channels[i] = channel;
                break;
            }
        }
    }
}
