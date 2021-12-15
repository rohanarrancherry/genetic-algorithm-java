package crossover;

import main.Utilities;
import population.Chromosome;

/**
 * The OnepointCrossover class implements one of the Crossover criteria used in
 * the Genetic Algorithm. One crossover point is chosen at random, and the binary string
 * from the chromosome's beginning to the crossover point is copied from one parent,
 * and the rest is copied from the second parent.
 */
public class OnepointCrossover implements Crossover{
    /**
     * The crossover() method of the OnepointCrossover takes two objects of Chromosome
     * class as the arguments and returns a new child Chromosome created using these
     * two parent Chromosomes.
     * @param firstParent
     * @param secondParent
     * @return Chromosome(childChromosome)
     */
    public Chromosome crossover(Chromosome firstParent, Chromosome secondParent){
        String childChromosome = "";
        int lengthOfFirstParent = firstParent.chromosome.length();
        int crossoverPoint = Utilities.randomNumber(0,lengthOfFirstParent);
        for (int i=0; i<lengthOfFirstParent; i++) {

            if (i<crossoverPoint) { //TODO: create a function for setting this variable name
                childChromosome += firstParent.chromosome.charAt(i);
            }
            else
                childChromosome += secondParent.chromosome.charAt(i);

        }

        return new Chromosome(childChromosome);
    }
}
