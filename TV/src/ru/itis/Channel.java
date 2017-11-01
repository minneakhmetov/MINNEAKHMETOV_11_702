package ru.itis;

public class Channel {
    String name;

    static int number = 4;

    Broadcast[] broadcasts = new Broadcast[number];

    public Channel(String name) {
        setName(name);
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(String name){
        return this.name;
    }

    void addBroadcast(Broadcast broadcast) {
        for (int i = 0; i < number-1; i++) {
            if (broadcasts[i] == null) {
                broadcasts[i] = broadcast;
                break;
            }
        }
    }



    //public void setBroadcast(Broadcast broadcast) {
    // Broadcast[] broadcasts = new Broadcast[amount];
    //}
}
