package crossover;

import main.Utilities;

/**
 * This a factory class which returns different types of crossovers*/
public class CrossoverFactory {
    public Crossover createCrossover(String crossoverType){
        Crossover crossover = null;
        if (crossoverType.equals(String.valueOf(Utilities.CROSSOVERS.UniformCrossover))) {
            crossover = new UniformCrossover();
        }
        else if(crossoverType.equals(String.valueOf(Utilities.CROSSOVERS.OnePointCrossover)))
            crossover = new OnepointCrossover();
        return crossover;
    }
}
