import java.util.Comparator;
import java.util.Random;
import java.util.ArrayList;

public class Runner {
    public static String TARGET = "Hello, I'm found using Genetic Algorithm";
    public static int POPULATION = 100;


    public static int randomNumber(int lowerBound, int upperBound){
        upperBound = upperBound + 1;
        int randomNumber;
        Random rand = new Random();
        randomNumber = rand.nextInt(upperBound-lowerBound) + lowerBound;
        return randomNumber;
    }

    public static ArrayList<Chromosome> createPopulation(){
        ArrayList<Chromosome> population = new ArrayList<Chromosome>();
        for (int i=0; i<POPULATION; i++){
            population.add(generateRandomChromosome());
        }
        return population;
    }

    public static Chromosome generateRandomChromosome(){
        String randomChromosome = "";
        int targetLength = TARGET.length();
        for(int i=0; i<targetLength; i++){
            randomChromosome += Mutation.asciiToString(randomNumber(0, 126)); //convert this into a common function
        }
        return new Chromosome(randomChromosome);
    }


    public static void main(String args[]){
        boolean found = false;
        int generation = 0;
        ArrayList<Chromosome> population = new ArrayList<Chromosome>();
        population = createPopulation();

        while(!found){
            population.sort(Comparator.comparingInt(Chromosome::getFitness));
            // checking whether the top chromosome is the output
            if(population.get(0).getFitness() <= 0)
            {
                found = true;
                break;
            }

            // create a new generation
            ArrayList<Chromosome> newPopulation = new ArrayList<Chromosome>();

            // Performing elitism
            // transferring x% of the previous generation to the
            // new generation TODO: x should be taken from settings

            for (int i=0; i<POPULATION*0.1; i++){
                newPopulation.add(population.get(i));
            }

            // creating the remaining population by crossover and mutation
            for (int i=0; i<POPULATION*0.9; i++){
                Chromosome firstParent = population.get(randomNumber(0,50));
                Chromosome secondParent = population.get(randomNumber(0,50));
                Chromosome child = firstParent.crossover(secondParent);
                newPopulation.add(child);
            }
            //replacing old population with new population
            population = newPopulation;
            System.out.println("Generation: " + generation + " String: " + population.get(0).chromosome +
                    " Fitness: " + population.get(0).getFitness());
            generation++;
        }

        System.out.println("Generation: " + generation + " String: " + population.get(0).chromosome +
                " Fitness: " + population.get(0).getFitness());
    }
}

