import java.util.ArrayList;
import java.util.Comparator;

/**
 * Singleton class for population
 */
public class Population {
    ArrayList<Chromosome> population;
    // selection is later set in the program
    Selection selection;
    private static volatile Population p;
    private Population(ArrayList<Chromosome> population) {
        this.population = population;
    }
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



//    Population(ArrayList<Chromosome> population){
//        this.population = population;
//    }

    public void setSelection(Selection selection){
        this.selection = selection;
    }

    public String getSelectionName(){
        return selection.getClass().getName();
    }

    public Chromosome select(){
        return selection.select(this);
    }

    public void sort(){
        population.sort(Comparator.comparingInt(Chromosome::getFitness));
    }

    public Chromosome get(int index){
        return population.get(index);
    }

    public void add(Chromosome c){
        population.add(c);
    }

    public void performElitism(){
        int removed = 0;
        // removing last population
        while (removed < (1-Utilities.ELITISM_RATE)*100) {
            population.remove(population.size() - 1);
            removed++;
        }
    }

}
