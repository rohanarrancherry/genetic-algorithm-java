import java.util.ArrayList;

public class RouletteWheelSelection {
    ArrayList<Chromosome> population;
    public RouletteWheelSelection(ArrayList<Chromosome> population){
        this.population = population;
    }

    public Chromosome select(){
        int fitnessSum=0;
        Chromosome selected = null;
        for(Chromosome x : population){
            fitnessSum += x.getFitness();
        }
        int randomNumber = Utilities.randomNumber(0, fitnessSum);
        for(Chromosome x : population){
            fitnessSum += x.getFitness();
            if (fitnessSum>=randomNumber){
                selected = x;
                break;
            }
        }
        return selected;
    }
}
