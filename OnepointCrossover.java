
public class OnepointCrossover implements Crossover{
    public Chromosome crossover(Chromosome firstParent, Chromosome secondParent){
        System.out.println("One Point Crossover is running...");
        String childChromosome = "";
        int lengthOfFirstParent = firstParent.chromosome.length();
        int crossoverPoint = Utilities.randomNumber(0,lengthOfFirstParent);
        for (int i=0; i<lengthOfFirstParent; i++) {

            if (i<crossoverPoint) { //TODO: create a function for setting this variable name
                childChromosome += firstParent.chromosome.charAt(i);
            }
            else
                childChromosome += secondParent.chromosome.charAt(i);

        }

        return new Chromosome(childChromosome);
    }
}
