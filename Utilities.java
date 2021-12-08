//import java.io.FileInputStream;
import java.util.ArrayList;
//import java.util.Properties;
import java.util.Random;

public class Utilities {

    // TODO: read from a config file
//    public Utilities(){
//        Properties prop=new Properties();
//        FileInputStream input= new FileInputStream("config.properties");
//        prop.load(input);
//        prop.getProperty("population")
//    }

    public static String TARGET = "Hello, I'm found using Genetic Algorithm";
    public static int POPULATION = 100;
    public static double ELITISM_RATE = 0.1;
    public enum SELECTIONS {
        RouletteWheelSelection,
    }
    public enum CROSSOVERS {
        CustomCrossover,
    }

    public static int randomNumber(int lowerBound, int upperBound){
        upperBound = upperBound + 1;
        int randomNumber;
        Random rand = new Random();
        randomNumber = rand.nextInt(upperBound-lowerBound) + lowerBound;
        return randomNumber;
    }

    public static Population createPopulation(){

        ArrayList<Chromosome> population = new ArrayList<>();
        for (int i=0; i<POPULATION; i++){
            population.add(generateRandomChromosome());
        }
        return Population.getInstance(population);
    }

    public static Population createSnakePopulation(){
        // todo: implement calculation of length
        int targetLength = 2032;

        ArrayList<Chromosome> population = new ArrayList<>();
        for (int i=0; i<POPULATION; i++){
            population.add(generateSnakeRandomChromosome(targetLength));
        }
        return Population.getInstance(population);
    }

    public static Chromosome generateSnakeRandomChromosome(int targetLength){
        String randomChromosome = "";
        for(int i=0; i<targetLength; i++){
            randomChromosome += randomNumber(0, 1); //convert this into a common function
        }
        return new Chromosome(randomChromosome);
    }


    public static Chromosome generateRandomChromosome(){
        String randomChromosome = "";
        int targetLength = TARGET.length();
        for(int i=0; i<targetLength; i++){
            randomChromosome += Mutation.asciiToString(randomNumber(0, 126)); //convert this into a common function
        }
        return new Chromosome(randomChromosome);
    }
}
