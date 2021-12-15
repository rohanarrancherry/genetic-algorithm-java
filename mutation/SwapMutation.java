package mutation;

import main.Utilities;
import population.Chromosome;

/**
 * The SwapMutation class implements one of the Mutation criteria used in
 * the Genetic Algorithm. The mutation on a Chromosome occurs only if the
 * probability of mutation calculated at runtime is less than or equal to
 * the value of the MUTATION_RATE variable defined in the Utilities class.
 * In the SwapMutation method, two points in the new Child Chromosome is selected
 * at random and the genes(characters) at these points are swapped.
 */
public class SwapMutation implements Mutation{
    /**
     * The mutate() method in the SwapMutation class takes a Chromosome object
     * as an argument and swaps two genes(characters) at any two random positions
     * in the Chromosome. Then the new String generated using this mutation method
     * is assigned to the chromosome data member of the Chromosome object passed as argument.
     * @param chromosome
     */
    @Override
    public void mutate(Chromosome chromosome) {

        int someRand = Utilities.randomNumber(0, 100);
        int l = chromosome.chromosome.length();
        int rand1 = Utilities.randomNumber(0, l);
        int rand2 = Utilities.randomNumber(0, l);
        while(rand1 == rand2)
            rand2 = Utilities.randomNumber(0, l);
        double probability = ((double) someRand) / 100;
        if (probability<= Utilities.MUTATION_RATE){

            StringBuilder newChromosome = new StringBuilder(chromosome.chromosome);
            char tempChar = newChromosome.charAt(rand1);
            newChromosome.setCharAt(rand1, newChromosome.charAt(rand2));
            newChromosome.setCharAt(rand2, tempChar);
            chromosome.chromosome = String.valueOf(newChromosome);
        }
    }
}