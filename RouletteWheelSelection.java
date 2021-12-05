public class RouletteWheelSelection implements Selection{

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
