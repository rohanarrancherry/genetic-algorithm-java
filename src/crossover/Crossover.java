package crossover;

import population.Chromosome;

/**
 * This is an Interface for Crossover operation. Every crossover fucntion should return
 * a Chromosome object taking two Chromosomes as an Argument
 * */
public interface Crossover {
    Chromosome crossover(Chromosome firstParent, Chromosome secondParent);
}
