package selection;

import main.Utilities;
import population.Chromosome;
import population.Population;

/**
 * The RankSelection class implements one of the Selection criteria
 * used in the Genetic Algorithm. Rank selection ranks the population
 * first, and then each chromosome is given a fitness based on this ranking.
 * After this, all chromosomes have a chance to be chosen.
 */
public class RankSelection implements Selection{
    /**
     * The select() method in the RankSelection takes an Instance of
     * the Population class as the argument and returns a Chromosome chosen from
     * the population.
     * @param population (Instance of Population)
     * @return selected (Chromosome object)
     */
    public Chromosome select(Population population){
        population.ascendingSort();
        int rank = 1;
        int rankSum=0;
        Chromosome selected = null;

        for(Chromosome x : population.population){
            rankSum += rank;
            rank++;
        }

        int randomNumber = Utilities.randomNumber(1, rankSum);
        rankSum = 0;
        rank= 1;
        for(Chromosome x : population.population){
            rankSum += rank;
            rank++;
            if (rankSum>=randomNumber){
                selected = x;
                break;
            }
        }
        return selected;
    }
}
