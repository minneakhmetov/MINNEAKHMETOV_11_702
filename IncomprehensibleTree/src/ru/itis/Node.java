package ru.itis;

import java.time.temporal.ValueRange;
import java.util.ArrayList;

public class Node<T extends Comparable> {
     T value;
     Node[] nodes;
     Node parent;

     Node (T value){
         this.value = value;
     }
}
