package population;

import main.Utilities;
import selection.Selection;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * The Population class is a Singleton class with a private constructor and a static Instance of itself.
 * Population provides a static method getInstance() to get its static instance outside the Singleton class.
 * The Elitism methods implemented in the project acts on this only instance of population and the
 * weaker Chromosomes are removed from this instance. New Chromosomes created in each generation is
 * added to this same Population Instance.
 */
public class Population {
    /**
     * The population is a data member of the Population class which is an ArrayList of the Chromosome
     * object.
     */
    public ArrayList<Chromosome> population;

    /**
     * selection is a data member of the Population class which stores the type of selection strategy used
     * for the chromosome selection from the population.
     */
    Selection selection;

    /**
     * Static volatile instance of Population class
     */
    private static volatile Population p;

    /**
     * The private constructor of the Population class that takes an ArrayList of Chromosomes as
     * argument and sets it to the population data member of the class.
     * @param population
     */
    private Population(ArrayList<Chromosome> population) {
        this.population = population;
    }

    /**
     * The getInstance() method of the Population class returns the only instance of itself
     * to the outide of the class. It used DoubleCheckedLocking mechanism for Object creation.
     * A local variable result is assigned the static volatile instance 'p' of the Population '
     * class to check if the instance is null to improve performance since checking the
     * static volatile instance is expensive in terms of resource utilization.
     *
     *
     * @param population
     * @return result (Stores the static volatile instance p of Population class)
     */
    public static Population getInstance(ArrayList<Chromosome> population) {      //DoubleCheckedLocking object creation
        Population result = p; // local variable result is used to improve performance
        if (result == null) {
            synchronized (Population.class){
                if (result == null) {
                    p = new Population(population);
                    result = p;
                }
            }
        }
        return result;
    }


    /**
     * The setSelection() method takes an object of the Selection class as an argument and
     * assigns it to the selection data member of the Population class.
     *
     * @param selection
     */
    public void setSelection(Selection selection){
        this.selection = selection;
    }

    /**
     * The getSelectionName() method returns the type of Selection strategy used at the time being
     * for the Chromosome selection.
     * @return selection.getClass().getName()
     */
    public String getSelectionName(){
        return selection.getClass().getName();
    }

    /**
     * The select method returns the chromosome that is selected from the Population Instance
     * using the Selection mechanism.
     * @return
     */
    public Chromosome select(){
        return selection.select(this);
    }

    /**
     * The sort() method sorts the Population which comprises of the ArrayList of Chromosomes
     * in the descending order of their fitness value.
     */
    public void sort(){
        population.sort(Comparator.comparingInt(Chromosome::getFitness).reversed());
    }

    /**
     * The ascendingSort() method sorts the Population which comprises of the ArrayList of Chromosomes
     * in the ascending order of their fitness value.
     */
    public void ascendingSort(){
        population.sort(Comparator.comparingInt(Chromosome::getFitness));
    }

    /**
     * The get() method takes an integer value as the argument and returns the chromosome
     * at that index value in the Chromosome ArrayList in the Population instance.
     * @param index
     * @return
     */
    public Chromosome get(int index){
        return population.get(index);
    }

    /**
     * The add() method takes a Chromosome object c as the argument and adds it to the
     * Chromosome ArrayList in the Population instance.
     * @param c
     */
    public void add(Chromosome c){
        population.add(c);
    }

    /**
     * The performElitism() method uses the value of ELITISM_RATE and POPULATION static variable
     * in the Utilities class to determine the percentage of population (No. of Chromosomes) to be removed from the
     * Population instance.
     */
    public void performElitism(){
        int removed = 0;
        while (removed < (1- Utilities.ELITISM_RATE)*Utilities.POPULATION) {
            population.remove(population.size() - 1);
            removed++;
        }
    }
}
