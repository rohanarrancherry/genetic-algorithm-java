public class EliteGAFactory extends GAFactory{
    @Override
    GA createGA() {
        GA geneticAlgo = new GA();
        return geneticAlgo;
    }
}