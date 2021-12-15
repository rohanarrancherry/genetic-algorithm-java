package selection;

import main.Utilities;
import population.Chromosome;
import population.Population;

/**
 * The RouletteWheelSelection class implements one of the Selection criteria
 * used in the Genetic Algorithm. Parent Chromosomes are chosen based on their
 * fitness value. More the fitness value of a Chromosome, more the chance it
 * is to be selected for crossover.
 */
public class RouletteWheelSelection implements Selection{

    /**
     * The select() method in the RouletteWheelSelection takes an Instance of
     * the Population class as the argument and returns a Chromosome chosen from
     * the population.
     * @param population (Instance of population)
     * @return selected (Chromosome object)
     */
    public Chromosome select(Population population){
        int fitnessSum=0;
        Chromosome selected = null;
        for(Chromosome x : population.population){
            fitnessSum += x.getFitness();
        }
        int randomNumber = Utilities.randomNumber(0, fitnessSum);
        fitnessSum = 0;
        for(Chromosome x : population.population){
            fitnessSum += x.getFitness();
            if (fitnessSum>=randomNumber){
                selected = x;
                break;
            }
        }
        return selected;
    }
}
