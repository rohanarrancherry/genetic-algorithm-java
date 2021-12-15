package population;

import crossover.Crossover;
import main.Utilities;
import mutation.Mutation;

/**
 * The Chromosome used in the Genetic Algorithm in this project represents a String
 * created with a collection of genes(characters) taken from ascii (0-126).
 * The size of this String depends on the size of the TARGET String defined in the
 * Utilities class.
 */
public class Chromosome
{
    /**
     * The data member chromosome represents the actual String that represents the Chromosome instance.
     */
    public String chromosome;

    /**
     * The data member crossover stores the type of Crossover that the chromosome uses as a parent to
     * create a new child Chromosome.
     */
    Crossover crossover;

    /**
     * The data member mutation stores the type of Mutation that is applied while a Crossover between
     * two chromosomes occurs to create a child chromosome.
     */
    Mutation mutation;

    /**
     * Parameterized Constructor of Chromosome class taking String as an argument which is
     * assigned to the chromosome data member of the class.
     * @param chromosome (String)
     */
    public Chromosome(String chromosome){
        this.chromosome = chromosome;
    }

    /**
     * The setCrossover() method takes a Crossover object as an argument and assigns it to
     * the crossover data member of the Chromosome class.
     * @param crossover
     */
    public void setCrossover(Crossover crossover){
        this.crossover = crossover;
    }

    /**
     * The setMutation() method takes a Mutation object as an argument and assigns it to
     * the mutation data member of the Chromosome class.
     * @param mutation
     */
    public void setMutation(Mutation mutation){
        this.mutation = mutation;
    }

    /**
     * The mutate() method defined in the Mutation interface is a member function
     * of the Chromosome class.
     */
    public void mutate(){
        mutation.mutate(this);
    }

    /**
     * The toString() method of the Chromosome class returns the chromosome date member
     * concatenated with the Fitness value of the chromosome.
     */
    public String toString(){
        return "Chromosome" + this.chromosome + ":Fitness" + getFitness();
    }

    /**
     * The getFitness() method returns the value of the calculateFitness() method
     * of the Chromosome which calls the getFitness() method.
     * @return Chromosome.calculateFitness() (integer)
     */
    public int getFitness(){
        return calculateFitness();
    }

    /**
     * The crossover() method of the Chromosome class takes another Chromosome
     * as an argument and returns the child Chromosome which is created when
     * crossover occurs between the Chromosome that calls the method and the
     * Chromosome that is passed as argument.
     *
     * @param secondParent
     * @return Chromosome (Child Chromosome)
     */
    public Chromosome crossover(Chromosome secondParent){
        return crossover.crossover(this, secondParent);
    }


    /**
     * The calculateFitness() method counts the number of equalities between the
     * data member chromosome string and the TARGET string defined in the Utilities class
     * and returns the count as an integer. It returns the minimum value 0 if there is
     * no match between the strings and a maximum value of sizeOf(TARGET) if both of
     * the strings match exactly.
     *
     * @return fitness (integer)
     */
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