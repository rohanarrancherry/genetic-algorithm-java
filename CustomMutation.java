public class CustomMutation implements Mutation{
    @Override
    public void mutate(Chromosome chromosome) {
        int someRand = Utilities.randomNumber(0, 100);
        double probability = ((double) someRand) / 100;
        if (probability<= Utilities.MUTATION_RATE){
            int randomIndex = Utilities.randomNumber(0, Utilities.TARGET.length()-1);
            char randomChar = Utilities.asciiToString(Utilities.randomNumber(0,126)).charAt(0);
            StringBuilder newChromosome = new StringBuilder(chromosome.chromosome);
            newChromosome.setCharAt(randomIndex, randomChar);
            chromosome.chromosome = String.valueOf(newChromosome);
            if (chromosome.chromosome.length() !=40 ){
                System.out.println("Break herere");
            }
        }
    }
}
