package selection;

import population.Chromosome;
import population.Population;


/**
 * This is an Interface for Crossover operation. Every crossover fucntion should return
 * a Chromosome object taking two Chromosomes as an Argument
 * */
public interface Selection {
//    Population population=null;
    public Chromosome select(Population population);
}
