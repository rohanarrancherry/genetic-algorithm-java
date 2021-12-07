public class Point {
    public int row;
    public int column;

    public Point(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public boolean equals(Point p2){
        if (this.column == p2.column && this.row == p2.row){
            return true;
        }
        return false;
    }
}
