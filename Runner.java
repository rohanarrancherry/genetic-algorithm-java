import java.io.FileInputStream;
import java.io.IOException;
import java.util.Comparator;
import java.util.Properties;
import java.util.Random;
import java.util.ArrayList;

public class Runner {

    public static void main(String args[]){

        boolean found = false;
        int generation = 0;
        ArrayList<Chromosome> population = new ArrayList<Chromosome>();
        population = Utilities.createPopulation();

        while(!found){
            population.sort(Comparator.comparingInt(Chromosome::getFitness));
            // checking whether the top chromosome is the output
            if(population.get(0).getFitness() <= 0)
            {
                break;
            }

            // create a new generation
            ArrayList<Chromosome> newPopulation = new ArrayList<Chromosome>();

            // Performing elitism
            // transferring x% of the previous generation to the

            for (int i=0; i<Utilities.POPULATION*Utilities.ELITISM_RATE; i++){
                newPopulation.add(population.get(i));
            }

            // creating the remaining population by crossover and mutation
            for (int i=0; i<Utilities.POPULATION*(1-Utilities.ELITISM_RATE); i++){
                Chromosome firstParent = population.get(Utilities.randomNumber(0,Utilities.POPULATION/2));
                Chromosome secondParent = population.get(Utilities.randomNumber(0,Utilities.POPULATION/2));
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

