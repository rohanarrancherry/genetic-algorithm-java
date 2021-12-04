import java.util.ArrayList;
import java.util.Comparator;

public class GA {
    String selectionType = String.valueOf(Utilities.SELECTIONS.RouletteWheelSelection);

    public void run(){
        boolean found = false;
        int generation = 0;
        Population population;
        population = Utilities.createPopulation();

        while(!found){
            population.sort();
            // checking whether the top chromosome is the output
            if(population.get(0).getFitness() >= Utilities.TARGET.length())
            {
                break;
            }

            // Performing elitism
            // transferring x% of the previous generation to the
            population.performElitism();
            SelectionFactory selectionFactory = new SelectionFactory();
            // creating the remaining population by crossover and mutation
            for (int i=0; i<Utilities.POPULATION*(1-Utilities.ELITISM_RATE); i++){
                // call factory method for selection, mention the type of selection
                Selection chromosomeSelection = selectionFactory.createSelection(selectionType);
                population.setSelection(chromosomeSelection);
                Chromosome firstParent = population.select();
                Chromosome secondParent = population.select();
                Chromosome child = firstParent.crossover(secondParent);
                population.add(child);
            }
            System.out.println("Generation: " + generation + " String: " + population.get(0).chromosome +
                    " Fitness: " + population.get(0).getFitness());
            generation++;
        }

        System.out.println("Generation: " + generation + " String: " + population.get(0).chromosome +
                " Fitness: " + population.get(0).getFitness());
    }
}
