package crossover;

import population.Chromosome;

public interface Crossover {
    Chromosome crossover(Chromosome firstParent, Chromosome secondParent);
}
