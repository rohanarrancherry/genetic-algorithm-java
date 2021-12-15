package mutation;

import main.Utilities;
import population.Chromosome;

/**
 * The RandomResetMutation class implements one of the Mutation criteria used in
 * the Genetic Algorithm. The mutation on a Chromosome occurs only if the
 * probability of mutation calculated at runtime is less than or equal to
 * the value of the MUTATION_RATE variable defined in the Utilities class.
 * In the RandomResetMutation method, a point in the new Child Chromosome is selected
 * at random and a random gene( ASCII character) is generated which is assigned
 * to that random point in the Child Chromosome.
 */
public class RandomResetMutation implements Mutation{
    /**
     * The mutate() method in the RandomResetMutation class takes a Chromosome object
     * as an argument and swaps a gene(character) with a random character
     * at a random point anywhere in the Chromosome. Then the new String
     * generated using this mutation method is assigned to the chromosome
     * data member of the Chromosome object passed as argument.
     * @param chromosome
     */
    @Override
    public void mutate(Chromosome chromosome) {
        int someRand = Utilities.randomNumber(0, 100);
        double probability = ((double) someRand) / 100;
        if (probability<= Utilities.MUTATION_RATE){
            int randomIndex = Utilities.randomNumber(0, Utilities.TARGET.length()-1);
            char randomChar = Utilities.asciiToString(Utilities.randomNumber(0,126)).charAt(0);
            StringBuilder newChromosome = new StringBuilder(chromosome.chromosome);
            newChromosome.setCharAt(randomIndex, randomChar);
            chromosome.chromosome = String.valueOf(newChromosome);
        }
    }
}
