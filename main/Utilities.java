package main;

import population.Chromosome;
import population.Population;

import java.util.ArrayList;
import java.util.Random;

/**
 * This is the Utilities class of the project.
 * It contains all the static variables and methods used for the
 * proper functioning of Genetic Algorithm in the project.
 * Variables and Methods defined in this class are used by
 * objects of multiple classes.
 */
public class Utilities {

    /**
     * Static variable TARGET is the string that is predicted using the project.
     * It is preset in the variable here, and not provided as input at runtime
     * just to show the proper comparison and working of Genetic Algorithm
     * using different configurations(Selection Type/ CrossOver Type, Mutation Type etc.)
     */
    public static String TARGET = "Hello, I'm found using Genetic Algorithm";

    /**
     * Static variable POPULATION represents the number of chromosomes in a generation.
     */
    public static int POPULATION = 100;

    /**
     * Static variable ELITISM_RATE represents the percentage of POPULATION selcted for the
     * next generation of chromosomes from the existing generation
     */
    public static double ELITISM_RATE = 0.1;

    /**
     * Static variable MUTATION_RATE represents the percentage of mutation applied during
     * crossover of existing chromosome parents to produce a new chromosome child.
     */
    public static double MUTATION_RATE = 0.1;

    /**
     * The Enum SELECTIONS represents the collection of Selection Types implemented in the project
     * used in various modes of Genetic Algorithm strategies.
     */
    public enum SELECTIONS {
        RouletteWheelSelection,
        RankSelection
    }

    /**
     * The Enum CROSSOVERS represents the collection of Crossover Types implemented in the project
     * used in various modes of Genetic Algorithm strategies.
     */
    public enum CROSSOVERS {
        CustomCrossover,
        OnePointCrossover
    }

    /**
     * The Enum MUTATIONS represents the collection of Mutation Types implemented in the project
     * used in various modes of Genetic Algorithm strategies.
     */
    public enum MUTATIONS {
        CustomMutation,
        SwapMutation
    }

    /**
     * The Enum REPLACEMENT represents the collection of Replacement Types implemented in the project
     * used in various modes of Genetic Algorithm strategies.
     */
    public enum REPLACEMENT {
        Elite,
        NonElite
    }

    /**
     * The static method randomNumber() takes integer parameters lowerBound and upperBound and
     * returns a random integer number randomNumber >= lowerBound and <= upperBound.
     * @param lowerBound (integer)
     * @param upperBound (integer)
     *
     * @return randomNumber (integer)
     */
    public static int randomNumber(int lowerBound, int upperBound){
        upperBound = upperBound + 1;
        int randomNumber;
        Random rand = new Random();
        randomNumber = rand.nextInt(upperBound-lowerBound) + lowerBound;
        return randomNumber;
    }

    /**
     * The Static method asciiToString() method takes an integer number as parameter and
     * returns the ASCII character represented by that number
     * @param randNumber
     * @return str (String)
     */
    public static String asciiToString(int randNumber){
        // should we use char?
        String str;
        str = Character.toString((char) randNumber);
        return str;
    }


    /**
     * The Static method createPopulation() returns a Population that is an ArrayList of
     * chromosomes, of size 100(value of static variable POPULATION).
     * The method uses the generateRandomChromosome() method to generate a random
     * chromosome which is added to the ArrayList in each iteration,
     * till it reaches the desired Population size.
     *
     * @return Population.getInstance(population) (ArrayList<Chromosome>)
     */
    public static Population createPopulation(){

        ArrayList<Chromosome> population = new ArrayList<>();
        for (int i=0; i<POPULATION; i++){
            population.add(generateRandomChromosome());
        }
        return Population.getInstance(population);
    }


    /**
     * The Static method generateRandomChromosome creates a random Chromosome which is a
     * String (collection of characters(genes)).
     * The length of the String is determined from the size of the predefined static
     * variable TARGET and uses the asciiToString() method to generate a random character
     * for each position in the String.
     * @return randomChromosome (Chromosome). A string that is a collection of characters(genes).
     */
    public static Chromosome generateRandomChromosome(){
        String randomChromosome = "";
        int targetLength = TARGET.length();
        for(int i=0; i<targetLength; i++){
            randomChromosome += Utilities.asciiToString(randomNumber(0, 126)); //convert this into a common function
        }
        return new Chromosome(randomChromosome);
    }
}
