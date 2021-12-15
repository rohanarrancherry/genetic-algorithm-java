package crossover;

import main.Utilities;

public class CrossoverFactory {
    public Crossover createCrossover(String crossoverType){
        Crossover crossover = null;
        if (crossoverType.equals(String.valueOf(Utilities.CROSSOVERS.CustomCrossover))) {
            crossover = new CustomCrossover();
        }
        else if(crossoverType.equals(String.valueOf(Utilities.CROSSOVERS.OnePointCrossover)))
            crossover = new OnepointCrossover();
        return crossover;
    }
}