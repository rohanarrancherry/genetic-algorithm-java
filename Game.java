import java.util.ArrayList;

public class Game {
    boolean play = true;
    boolean restart = false;
    // make it configurable
    int rows = 10;
    int columns = rows;
    Snake snake = new Snake(rows, columns);

    //create a function for randomly generating this
    Point fruitPosition = generateRandomFruitPosition();
    int score = 0;
    int highScore = 0;
    Population population;

    public void setPopulation(Population population) {
        this.population = population;
    }

    public Point generateRandomFruitPosition(){

        int randomRow = Utilities.randomNumber(0, rows);
        int randomColumn = Utilities.randomNumber(0, rows);
        Point randomFruitPosition = new Point(randomRow, randomColumn);
         while (snake.body.contains(randomFruitPosition)){
             randomRow = Utilities.randomNumber(0, rows);
             randomColumn = Utilities.randomNumber(0, rows);
             randomFruitPosition.row = randomRow;
             randomFruitPosition.column = randomColumn;
         }
         return randomFruitPosition;

    }

    public void moveSnake(){
        // get the direction from the neural networks
        // now randomly generating some direction
        String direction;
        int randomDirection = Utilities.randomNumber(0,4);
        if (randomDirection == 1){
            direction = "up";
        }
        else if (randomDirection == 2){
            direction = "down";
        }
        else if (randomDirection == 3){
            direction = "left";
        }
        else if (randomDirection == 4){
            direction = "right";
        }
        // need to check if this is required in neural networks
        else {
            if (snake.directions.isEmpty()){
                direction = "right";
            }
            else {
                direction = snake.directions.getFirst();
            }
        }
        // adding the direction to deque
        snake.directions.addFirst(direction);
        // removing the last element that is from right side
        if (snake.directions.size() > snake.body.size()){
            snake.directions.removeLast();
        }
        snake.updatePositions();
    }

    public void checkCollisions(){
        checkFruitCollision();
        checkWallCollision();
        checkBodyCollision();
    }

    public void checkFruitCollision(){
        if (snake.body.get(0).equals(fruitPosition)){
            //extending snakes length
            snake.extendSnake();
            // generating new fruit
            fruitPosition = generateRandomFruitPosition();
            //increasing the score
            score++;
        }
    }

    public void checkWallCollision(){
        Point snakeHead = snake.body.get(0);
        if (snakeHead.row < 0 || snakeHead.column <0 || snakeHead.row >= rows || snakeHead.column>=columns){
            gameOver();
        }
    }

    public void checkBodyCollision(){
        ArrayList<Point> withoutSnakeHead = new ArrayList<>();
        if (snake.body.size()>1){
            Point snakeHead = snake.body.get(0);
            for(int i=0; i<snake.body.size(); i++){
                if (i==0){
                    continue;
                }
                withoutSnakeHead.add(snake.body.get(i));
            }
            if (withoutSnakeHead.contains(snakeHead)){
                gameOver();
            }
        }
    }

    public void gameOver(){
        // do update the weights using GA
        snake = new Snake(rows, columns);
        fruitPosition = generateRandomFruitPosition();
        restart = true;
        if (score > highScore){
            highScore = score;
        }
        score = 0;
    }
}
