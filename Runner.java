public class Runner {

    public static void main(String args[]){
        GAFactory GAF = new EliteGAFactory();

        GA geneticAlgo = GAF.getGA();
//        geneticAlgo.setCrossover(String.valueOf(Utilities.CROSSOVERS.OnePointCrossover));
        geneticAlgo.run();
    }
}