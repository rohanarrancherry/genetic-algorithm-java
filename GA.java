public class GA {
    String selectionType;  //= String.valueOf(Utilities.SELECTIONS.RouletteWheelSelection);
    String crossoverType; //= String.valueOf(Utilities.CROSSOVERS.CustomCrossover);
    String mutationType; //= String.valueOf(Utilities.MUTATIONS.CustomMutation);

    public void setSelection(String selectionType){
        this.selectionType = selectionType;
    }

    public void setCrossover(String crossoverType){
        this.crossoverType = crossoverType;
    }

    public void setMutation(String mutationType){
        this.mutationType = mutationType;
    }

    public void run(){
        boolean found = false;
        int generation = 0;
        Population population;
        population = Utilities.createPopulation();

        while(!found){
            // sorting the population according to the fitness value of the chromosomes
            population.sort();
            // checking whether the top chromosome is the target.
            if(population.get(0).getFitness() >= Utilities.TARGET.length())
            {
                break;
            }

            // Performing elitism
            // transferring x% of the previous generation to the
            // new generation
            population.performElitism();
            // creating factory objects for selection and crossover
            SelectionFactory selectionFactory = new SelectionFactory();
            CrossoverFactory crossoverFactory = new CrossoverFactory();
            MutationFactory mutationFactory = new MutationFactory();

            // creating the remaining population by crossover and mutation
            for (int i=0; i<Utilities.POPULATION*(1-Utilities.ELITISM_RATE); i++){
                // call factory method for selection, mention the type of selection
                Selection chromosomeSelection = selectionFactory.createSelection(selectionType);
                population.setSelection(chromosomeSelection);
                // Selection of parents
                Chromosome firstParent = population.select();
                Chromosome secondParent = population.select();
                // Crossover of parents
                Crossover crossover = crossoverFactory.createCrossover(crossoverType);
                firstParent.setCrossover(crossover);
                Chromosome child = firstParent.crossover(secondParent);
                // Do the mutation
                Mutation mutation = mutationFactory.createMutation(mutationType);
                child.setMutation(mutation);
                child.mutate();
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
