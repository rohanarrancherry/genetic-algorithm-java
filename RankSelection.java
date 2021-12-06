import java.util.ArrayList;

public class RankSelection implements Selection{

    public Chromosome select(Population population){


        population.sort();

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
