public class Chromosome
{
    String chromosome;

    public Chromosome(String chromosome){
        this.chromosome = chromosome;
    };

    public String toString(){
        return "Chromosome" + this.chromosome + ":Fitness" + String.valueOf(getFitness());
    }

    public int getFitness(){
        return calculateFitness();
    }

    public Chromosome crossover(Chromosome secondParent){
        /*
         * define which type of crossover is required
         * do this by implementing abstract factory pattern
         * */
        float probability;
        String childChromosome = "";
        int lengthOfFirstParent = this.chromosome.length();
        for (int i=0; i<lengthOfFirstParent; i++) {

            probability = Runner.randomNumber(0, 100) / 100;

            // take the constant value from settings
            if (probability < 0.45) { //TODO: create a function for setting this variable name
                childChromosome += this.chromosome.charAt(i);
            }
            else if (probability < 0.90) {
                childChromosome += secondParent.chromosome.charAt(i);
            }
            else {
                // implement mutation here
                // ascii upper value is 126
                childChromosome += Mutation.asciiToString(Runner.randomNumber(0,126));
            }
        }
        Chromosome childChromosomeObject = new Chromosome(childChromosome);
        return childChromosomeObject;
    }


    // Calculate fitness score, it is the number of
    // characters in string which differ from target
    // string.

    public int calculateFitness(){
        int fitness = 0;
        int targetLength = Runner.TARGET.length(); //can be reused if already in memory
        for (int i=0; i<targetLength; i++){
            if (this.chromosome.charAt(i) != Runner.TARGET.charAt(i)){
                fitness++;
            }
        }
        return fitness;
    }


}