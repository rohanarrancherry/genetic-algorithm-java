import java.util.ArrayList;

public class RouletteWheelSelection extends Selection{
    ArrayList<Chromosome> population;

    RouletteWheelSelection(Population population) {
        super(population);
    }

    public Chromosome select(Population population){
        int fitnessSum=0;
        Chromosome selected = null;
        for(Chromosome x : population.population){
            fitnessSum += x.getFitness();
        }
        int randomNumber = Utilities.randomNumber(0, fitnessSum);
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