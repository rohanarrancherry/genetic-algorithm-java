public class Runner {

    public static void main(String args[]){
        GAFactory GAF = new EliteGAFactory();

        GA geneticAlgo = GAF.getGA(String.valueOf(Utilities.SELECTIONS.RankSelection),
                String.valueOf(Utilities.CROSSOVERS.OnePointCrossover),
                String.valueOf(Utilities.MUTATIONS.CustomMutation));

        geneticAlgo.run();
    }
}