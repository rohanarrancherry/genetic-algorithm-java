package ga;

import main.Utilities;

public class EliteGA extends GA{

    public EliteGA(){
        setSelection(String.valueOf(Utilities.SELECTIONS.RouletteWheelSelection));
        setCrossover(String.valueOf(Utilities.CROSSOVERS.OnePointCrossover));
        setMutation(String.valueOf(Utilities.MUTATIONS.CustomMutation));
        setReplacement(String.valueOf(Utilities.REPLACEMENT.Elite));
    }
}
