public class NonEliteGA extends GA{

    public NonEliteGA(){
        setSelection(String.valueOf(Utilities.SELECTIONS.RankSelection));
        setCrossover(String.valueOf(Utilities.CROSSOVERS.CustomCrossover));
        setMutation(String.valueOf(Utilities.MUTATIONS.CustomMutation));
        setReplacement(String.valueOf(Utilities.REPLACEMENT.NonElite));
    }

    @Override
    public void setReplacement(String replacementType) {
        super.setReplacement(replacementType);
    }
}
