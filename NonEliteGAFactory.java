public class NonEliteGAFactory extends GAFactory{
    @Override
    GA createGA() {
        GA geneticAlgo = new NonEliteGA();
        return geneticAlgo;
    }
}