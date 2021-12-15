package ga;
/**
 * Factory for creating the EliteGA object*/
public class EliteGAFactory extends GAFactory{
    @Override
    GA createGA() {
        GA geneticAlgo = new EliteGA();
        return geneticAlgo;
    }
}