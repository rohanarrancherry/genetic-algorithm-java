import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;

public class Snake {
    /**
     * This class represent Snake in the snake game
     *
     */
    int rows = 0, columns = 0;
    ArrayList<Point> body;
    Deque<String> directions = new ArrayDeque<>();


    //snake constructor
    Snake(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        this.body.add(initializeSnake());
    }

    private Point initializeSnake(){
        return new Point(rows/2, 1);
    }

    public void updatePositions(){
        Iterator<String> iter = directions.iterator();
        String direction = "";
        // update each element in the body of the snake
        for(int i=0; i< body.size(); i++){
            // only for the first element
            if (i==0){
                direction = directions.getFirst();
            }
            else if (iter.hasNext()){
                direction = iter.next();
            }

            if (direction == "up"){
                body.get(i).row = body.get(i).row - 1;
            }
            else if (direction == "down"){
                body.get(i).row = body.get(i).row + 1;
            }
            else if (direction == "left"){
                body.get(i).column = body.get(i).column - 1;
            }
            else {
                body.get(i).column = body.get(i).column + 1;
            }

        }
    }

    public void extendSnake(){
        Point snakeTail = body.get(body.size()-1);
        String tailDirection = directions.getLast();

        if (tailDirection == "left"){
            body.add(new Point(snakeTail.row, snakeTail.column+1));
        }
        else if (tailDirection == "right"){
            body.add(new Point(snakeTail.row, snakeTail.column-1));
        }
        else if (tailDirection == "up"){
            body.add(new Point(snakeTail.row+1, snakeTail.column));
        }
        else {
            body.add(new Point(snakeTail.row-1, snakeTail.column));
        }

    }
}

