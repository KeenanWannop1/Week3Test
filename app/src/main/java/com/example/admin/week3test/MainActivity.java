package com.example.admin.week3test;


public class MainActivity {
    static boolean[][] roomsVisited = new boolean[9][9];
    static int counter = 0;

    public static void main(String[] args) {
        Room[][] verticalTrue = new Room[][] {  {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) }, {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) }, {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) }, {new Room(false), new Room(true), new Room(false), new Room(true), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false) }, {new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) }, {new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) }, {new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) }, {new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) }, {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) }, {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) } };
        Room[][] horizontalTrue = new Room[][] { {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) }, {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) }, {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) }, {new Room(false), new Room(true), new Room(true), new Room(true), new Room(true), new Room(true), new Room(false), new Room(false), new Room(false) }, {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) }, {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) },  {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) }, {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) }, {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) }, {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) } };
        Room[][] noInfection = new Room[][] { {new Room(true), new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) }, {new Room(false), new Room(true), new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) }, {new Room(true), new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) }, {new Room(false), new Room(true), new Room(false), new Room(true), new Room(false), new Room(true), new Room(false), new Room(false), new Room(false) }, {new Room(false), new Room(true), new Room(false), new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false) }, {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(true), new Room(false), new Room(false), new Room(false) }, {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(true), new Room(false), new Room(false) }, {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) }, {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) }, {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) }};
        boolean isOutbreak = isOutbreak(verticalTrue);
        boolean isOutbreak1 = isOutbreak(horizontalTrue);
        boolean isOutbreak2 = isOutbreak(noInfection);
        System.out.println(isOutbreak);
        System.out.println(isOutbreak1);
        System.out.println(isOutbreak2);

    }

    private static boolean isOutbreak(Room[][] floor) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                checkRoom(floor, i, j);
                if (counter >= 5) return true;
                roomsVisited = new boolean[10][10];
                counter = 0;
            }
        }
        return false;
    }


    private static boolean[] roomsAround(Room[][] floor, int i, int j) {
        boolean[] roomsAround = {false, false, false, false};
        if ( i > 0)
            if( floor[i - 1][j].isInfected) roomsAround[0] = true;
        if (j > 0)
            if(floor[i][j - 1].isInfected) roomsAround[1] = true;
        if (i < 9)
            if(floor[i + 1][j].isInfected ) roomsAround[2] = true;
        if (j < 9)
            if(floor[i][j + 1].isInfected ) roomsAround[3] = true;
        return roomsAround;
    }

    private static void checkRoom(Room[][] floor, int i, int j) {
        boolean[] roomsAround;
        roomsVisited[i][j] = true;
        if (floor[i][j].isInfected) {
            counter++;
            roomsAround = roomsAround(floor, i, j);
            if(i>0) {
                if (!roomsVisited[i - 1][j]) {
                    //Left room is infected
                    if (roomsAround[0]) {
                        checkRoom(floor, i - 1, j);
                    }
                }
            }
            if(j<9) {
                if (!roomsVisited[i][j + 1]) {
                    //Above room is infected
                    if (roomsAround[1]) {
                        checkRoom(floor, i, j + 1);
                    }
                }
            }
            if(i<9) {
                if (!roomsVisited[i + 1][j]) {
                    //Right room is infected
                    if (roomsAround[2]) {
                        checkRoom(floor, i + 1, j);
                    }
                }
            }
            if (j>0) {
                if (!roomsVisited[i][j - 1]) {
                    //Below room is infected
                    if (roomsAround[3]) {
                        checkRoom(floor, i, j - 1);
                    }
                }
            }
        }
    }
}



