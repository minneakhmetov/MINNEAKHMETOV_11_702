package ru.itis;

public class Main {

    public static void main(String[] args) {
        TV tv = TV.getInstance();

         Channel theFirstChannel = new Channel("Первый");
         Channel tnt = new Channel("ТНТ");
         Channel ctc = new Channel("СТС");
         Channel russia = new Channel("Россия");
         Channel tnv = new Channel("ТНВ");
         Channel ntv = new Channel("НТВ");
         Channel match = new Channel("МАТЧ");
         Channel rentv = new Channel("РЕН-ТВ");
         Channel fishingtv = new Channel("РЫБАЛКА ТВ");
         Channel pervaground = new Channel("Перваграунд");
         tv.addChannel(theFirstChannel);
         tv.addChannel(tnt);
         tv.addChannel(ctc);
         tv.addChannel(russia);
         tv.addChannel(tnv);
         tv.addChannel(ntv);
         tv.addChannel(match);
         tv.addChannel(rentv);
         tv.addChannel(fishingtv);
         tv.addChannel(pervaground);
         Broadcast broadcast = new Broadcast("program", 0, 6);
         Broadcast broadcast1 = new Broadcast("PROGRAM", 6, 12);
         Broadcast broadcast2 = new Broadcast("prog", 12, 16);
         Broadcast broadcast3 = new Broadcast("PROG", 18, 23);
         theFirstChannel.addBroadcast(broadcast);
         theFirstChannel.addBroadcast(broadcast1);
         theFirstChannel.addBroadcast(broadcast2);
         theFirstChannel.addBroadcast(broadcast3);
         tnt.addBroadcast(broadcast);
         tnt.addBroadcast(broadcast1);
         tnt.addBroadcast(broadcast2);
         tnt.addBroadcast(broadcast3);
         ctc.addBroadcast(broadcast);
         ctc.addBroadcast(broadcast1);
         ctc.addBroadcast(broadcast2);
         ctc.addBroadcast(broadcast3);
         russia.addBroadcast(broadcast);
         russia.addBroadcast(broadcast1);
         russia.addBroadcast(broadcast2);
         russia.addBroadcast(broadcast3);
         tnv.addBroadcast(broadcast);
         tnv.addBroadcast(broadcast1);
         tnv.addBroadcast(broadcast2);
         tnv.addBroadcast(broadcast3);
         ntv.addBroadcast(broadcast);
         ntv.addBroadcast(broadcast1);
         ntv.addBroadcast(broadcast2);
         ntv.addBroadcast(broadcast3);
         match.addBroadcast(broadcast);
         match.addBroadcast(broadcast1);
         match.addBroadcast(broadcast2);
         match.addBroadcast(broadcast3);
         rentv.addBroadcast(broadcast);
         rentv.addBroadcast(broadcast1);
         rentv.addBroadcast(broadcast2);
         rentv.addBroadcast(broadcast3);
         fishingtv.addBroadcast(broadcast);
         fishingtv.addBroadcast(broadcast1);
         fishingtv.addBroadcast(broadcast2);
         fishingtv.addBroadcast(broadcast3);
         pervaground.addBroadcast(broadcast);
         pervaground.addBroadcast(broadcast1);
         pervaground.addBroadcast(broadcast2);
         pervaground.addBroadcast(broadcast3);
        Remote remote = Remote.builder()
                .name("ПУЛЬТ")
                .serial(917468030)
                .firm("Nigga")
                .manufacturer("Sony")
                .lifetime(34)
                .build();
        remote.switching("Первый");
        remote.switching("ТНТ");
    }


}
