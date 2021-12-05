public class CrossoverFactory {
    public Crossover createCrossover(String crossoverType){
        Crossover crossover = null;
        if (crossoverType.equals(String.valueOf(Utilities.CROSSOVERS.CustomCrossover))) {
            crossover = new CustomCrossover();
        }
        return crossover;
    }
}
