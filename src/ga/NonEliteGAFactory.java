package ga;

/**
 * Abstract class for creating various GA Strategies, creation
 * of GA object is done by the child class.
 */
public class NonEliteGAFactory extends GAFactory{
    @Override
    GA createGA() {
        GA geneticAlgo = new NonEliteGA();
        return geneticAlgo;
    }
}