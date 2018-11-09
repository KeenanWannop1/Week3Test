package com.example.admin.week3test;

public class Room {
    public final boolean isInfected;
    public boolean visited = false;

    Room(boolean infected) {
        isInfected = infected;
    }
}