public class Runner {

    public static void main(String args[]){
        GA geneticAlgo = new GA();
        geneticAlgo.setSelection(String.valueOf(Utilities.SELECTIONS.RankSelection));
        geneticAlgo.setCrossover(String.valueOf(Utilities.CROSSOVERS.OnePointCrossover));
        geneticAlgo.setMutation(String.valueOf(Utilities.MUTATIONS.CustomMutation));
        geneticAlgo.run();
    }
}

