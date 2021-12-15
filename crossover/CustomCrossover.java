package crossover;

import main.Utilities;
import population.Chromosome;

/**
 * The CustomCrossover class implements one of the Crossover criteria used in
 * the Genetic Algorithm. At each iteration in the crossover() method in this
 * class, the first parent or the second parent is chosen at random and the
 * gene(character) of that parent is assigned to the Crossover Point of the
 * child Chromosome. The iteration stops when the Child Chromosome has the
 * length of the Parent Chromosomes.
 */
public class CustomCrossover implements Crossover{
    /**
     * The crossover() method of the CustomCrossover takes two objects of Chromosome
     * class as the arguments and returns a new child Chromosome created using these
     * two parent Chromosomes.
     * @param firstParent
     * @param secondParent
     * @return Chromosome(childChromosome)
     */
    public Chromosome crossover(Chromosome firstParent, Chromosome secondParent){
        float probability;
        String childChromosome = "";
        int lengthOfFirstParent = firstParent.chromosome.length();
        for (int i=0; i<lengthOfFirstParent; i++) {

            probability = Utilities.randomNumber(0, 100) / 100;

            // take the constant value from settings
            if (probability < 0.45) { //TODO: create a function for setting this variable name
                childChromosome += firstParent.chromosome.charAt(i);
            }
            else if (probability <= 1) {
                childChromosome += secondParent.chromosome.charAt(i);
            }
        }

        return new Chromosome(childChromosome);
    }
}
