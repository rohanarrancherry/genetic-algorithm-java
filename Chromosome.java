public class Chromosome
{
    String chromosome;
    Crossover crossover;

    public Chromosome(String chromosome){
        this.chromosome = chromosome;
    };

    public void setCrossover(Crossover crossover){
        this.crossover = crossover;
    }

    public String toString(){
        return "Chromosome" + this.chromosome + ":Fitness" + String.valueOf(getFitness());
    }

    public int getFitness(){
        return calculateFitness();
    }

    public Chromosome crossover(Chromosome secondParent){
        return crossover.crossover(this, secondParent);
    }


    // Calculate fitness score, it is the number of
    // characters in string which differ from target
    // string.

    public int calculateFitness(){
        int fitness = 0;
        int targetLength = Utilities.TARGET.length();
        for (int i=0; i<targetLength; i++){
            if (this.chromosome.charAt(i) == Utilities.TARGET.charAt(i)){
                fitness++;
            }
        }
        return fitness;
    }


}