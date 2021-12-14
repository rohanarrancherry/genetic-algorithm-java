public class EliteGAFactory extends GAFactory{
    @Override
    GA createGA(String selection, String crossOver, String mutation) {
        GA geneticAlgo = new GA();
        geneticAlgo.setSelection(selection);
        geneticAlgo.setCrossover(crossOver);
        geneticAlgo.setMutation(mutation);
        return geneticAlgo;
    }
}