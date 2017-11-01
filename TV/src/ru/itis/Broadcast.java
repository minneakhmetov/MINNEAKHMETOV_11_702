package ru.itis;



public class Broadcast {
    String name;
    int begin;
    int end;

    public Broadcast(String name, int begin, int end) {
        setName(name);
        setBegin(begin);
        setEnd(end);
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(String name){
        return this.name;
    }

    public void setBegin(int begin){
        this.begin = begin;
    }

    public int getBegin(){
        return this.begin;
    }

    public void setEnd(int end){
        this.end = end;
    }

    public int getEnd(){
        return this.end;
    }


}
