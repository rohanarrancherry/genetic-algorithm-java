package ga;

import main.Utilities;

/**
 * This class is for setting the Non-Elite Strategy for the genetic algorithm
 * We use constructor to set the Strategy. Strategy pattern is used here.
 * */
public class NonEliteGA extends GA{

    public NonEliteGA(){
        setSelection(String.valueOf(Utilities.SELECTIONS.RankSelection));
        setCrossover(String.valueOf(Utilities.CROSSOVERS.UniformCrossover));
        setMutation(String.valueOf(Utilities.MUTATIONS.SwapMutation));
        setReplacement(String.valueOf(Utilities.REPLACEMENT.NonElite));
    }



    // overriding the setReplacement since the programmer should not change the
    // property of EliteGA during runtime
    @Override
    public void setReplacement(String replacementType) {
        super.replacementType = String.valueOf(Utilities.REPLACEMENT.NonElite);
    }
}
