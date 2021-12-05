public class CustomCrossover implements Crossover{
    public Chromosome crossover(Chromosome firstParent, Chromosome secondParent){
        float probability;
        String childChromosome = "";
        int lengthOfFirstParent = firstParent.chromosome.length();
        for (int i=0; i<lengthOfFirstParent; i++) {

            probability = Utilities.randomNumber(0, 100) / 100;

            // take the constant value from settings
            if (probability < 0.45) { //TODO: create a function for setting this variable name
                childChromosome += firstParent.chromosome.charAt(i);
            }
            else if (probability < 0.90) {
                childChromosome += secondParent.chromosome.charAt(i);
            }
            else {
                // implement mutation here
                // ascii upper value is 126
                childChromosome += Mutation.asciiToString(Utilities.randomNumber(0,126));
            }
        }

        return new Chromosome(childChromosome);
    }
}
