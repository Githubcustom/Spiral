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

        do {
            isEdgeFound = false;
            while ( dx > 0 && x < maxX ||
                    dx < 0 && x > minX ||
                    dy > 0 && y < maxY ||
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
            int oldDx = dx;
            dx = -dy;
            dy = oldDx;
        } while (isEdgeFound);

        return spiral;
    }
}
