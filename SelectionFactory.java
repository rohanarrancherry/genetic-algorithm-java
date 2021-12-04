public class SelectionFactory {
    public Selection createSelection(String selectionType){
        Selection chromosomeSelection = null;
        if (selectionType.equals(String.valueOf(Utilities.SELECTIONS.RouletteWheelSelection))) {
            chromosomeSelection = new RouletteWheelSelection();
        }
        return chromosomeSelection;
    }
}
