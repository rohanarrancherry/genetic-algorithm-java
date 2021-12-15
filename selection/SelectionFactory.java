package selection;

import main.Utilities;

public class SelectionFactory {
    public Selection createSelection(String selectionType){
        Selection chromosomeSelection = null;
        if (selectionType.equals(String.valueOf(Utilities.SELECTIONS.RouletteWheelSelection))) {
            chromosomeSelection = new RouletteWheelSelection();
        }
        else if
         (selectionType.equals(String.valueOf(Utilities.SELECTIONS.RankSelection))) {
            chromosomeSelection = new RankSelection();
        }
        return chromosomeSelection;
    }
}
