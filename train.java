public class train {
    public void run(){
        Population population = Utilities.createSnakePopulation();
        Game game = new Game();
        game.setPopulation(population);
    }
}
