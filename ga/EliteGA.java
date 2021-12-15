package ga;

import main.Utilities;

/**
 * This class is for setting the Elite Strategy for the genetic algorithm
 * We use constructor to set the Strategy. Strategy pattern is used here
 * */
public class EliteGA extends GA{

    public EliteGA(){
        setSelection(String.valueOf(Utilities.SELECTIONS.RouletteWheelSelection));
        setCrossover(String.valueOf(Utilities.CROSSOVERS.OnePointCrossover));
        setMutation(String.valueOf(Utilities.MUTATIONS.RandomResetMutation));
        setReplacement(String.valueOf(Utilities.REPLACEMENT.Elite));
    }
}
