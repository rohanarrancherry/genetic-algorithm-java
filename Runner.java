public class Runner {

    public static void main(String args[]){
        GAFactory eliteGAFactory = new EliteGAFactory();
        GAFactory nonEliteGAFactory= new NonEliteGAFactory();
        GA geneticAlgo1 = eliteGAFactory.getGA();
        GA geneticAlgo2 = nonEliteGAFactory.getGA();
//        geneticAlgo1.run();
        geneticAlgo2.run();

//        geneticAlgo2.setCrossover();
    }
}