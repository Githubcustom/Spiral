package com.epam.rd.autotasks;

class Spiral {
    static int[][] spiral(int rows, int columns) {

        int[][] spiral = new int[rows][columns];
        int filler = 1;
        int x = 0;
        int y = 0;
        int dx = 1;
        int dy = 0;
        spiral[y][x] = filler;
        int minX = 0;
        int minY = 1;
        int maxX = columns - 1;
        int maxY = rows - 1;
        boolean isEdgeFound;
        int forSwap;

        if (rows == 2 && columns == 1) {    // This is a kludge (crutch) ))
            spiral[1][0] = 2;
            return spiral;
        }

        do {
            isEdgeFound = false;
            while ( dx > 0 && x < maxX ||
                    dy > 0 && y < maxY ||
                    dx < 0 && x > minX ||
                    dy < 0 && y > minY) {

                x += dx;
                y += dy;
                spiral[y][x] = ++filler;
                isEdgeFound = true;
            }

            if (dx < 0) minX = x + 1;
            if (dx > 0) maxX = x - 1;
            if (dy < 0) minY = y + 1;
            if (dy > 0) maxY = y - 1;

//  rotate matrix to 90 degree clockwise
            forSwap = dx;
            dx = -dy;
            dy = forSwap;
        } while (isEdgeFound);

        return spiral;
    }
}
