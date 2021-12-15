public class GA {
    String selectionType = String.valueOf(Utilities.SELECTIONS.RouletteWheelSelection);
    String crossoverType = String.valueOf(Utilities.CROSSOVERS.CustomCrossover);
    String mutationType = String.valueOf(Utilities.MUTATIONS.CustomMutation);
    String replacementType = String.valueOf(Utilities.MUTATIONS.CustomMutation);

    public void setSelection(String selectionType){
        this.selectionType = selectionType;
    }

    public void setCrossover(String crossoverType){
        this.crossoverType = crossoverType;
    }

    public void setMutation(String mutationType){
        this.mutationType = mutationType;
    }

    public void setReplacement(String replacementType){
        this.replacementType = replacementType;
    }

    public void run(){
        int MAX_GENERATIONS = 10000;
        boolean found = false;
        int generation = 0;
        Population population;
        population = Utilities.createPopulation();
        int noOfChildsToBeCreated = 0;

        while(!found && generation<MAX_GENERATIONS){
            population.sort();
            if(population.get(0).getFitness() >= Utilities.TARGET.length())
            {
                break;
            }
            SelectionFactory selectionFactory = new SelectionFactory();
            CrossoverFactory crossoverFactory = new CrossoverFactory();
            MutationFactory mutationFactory = new MutationFactory();
//            ReplacementFactory replacementFactory = new ReplacementFactory();

//
            // creating the remaining population by crossover and mutation

            if (replacementType.equals(String.valueOf(Utilities.REPLACEMENT.Elite))){
                noOfChildsToBeCreated = (int) (Utilities.POPULATION*(1-Utilities.ELITISM_RATE));
                population.performElitism();
            }
            else{
                noOfChildsToBeCreated = Utilities.POPULATION;
            }

            for (int i=0; i<noOfChildsToBeCreated; i++){
                // call factory method for selection, mention the type of selection
                Selection chromosomeSelection = selectionFactory.createSelection(selectionType);
                population.setSelection(chromosomeSelection);
                Chromosome firstParent = population.select();
                Chromosome secondParent = population.select();
                Crossover crossover = crossoverFactory.createCrossover(crossoverType);
                firstParent.setCrossover(crossover);
                Chromosome child = firstParent.crossover(secondParent);
                Mutation mutation = mutationFactory.createMutation(mutationType);
                child.setMutation(mutation);
                child.mutate();
                if (replacementType.equals(String.valueOf(Utilities.REPLACEMENT.NonElite))){
                    population.sort();
                    if (population.get(population.population.size()-1).getFitness() < child.getFitness()){
                        population.population.remove(population.population.size()-1);
                        population.add(child);
                    }
                }
                else{
                    population.add(child);
                }
            }

            System.out.println("********************************************");
            System.out.println("Generation: " + generation + "\nFittest String: " + population.get(0).chromosome +
                    "\nFitness: " + population.get(0).getFitness());
            generation++;
        }

        System.out.println("\n\n$$$$$$$$$$$$$$$$$$$FINAL$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("Generation: " + generation + "\nOutput String: " + population.get(0).chromosome +
                "\nFitness: " + population.get(0).getFitness());
    }
}
