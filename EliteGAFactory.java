public class EliteGAFactory extends GAFactory{
    @Override
    GA createGA() {
        GA geneticAlgo = new EliteGA();
        return geneticAlgo;
    }
}