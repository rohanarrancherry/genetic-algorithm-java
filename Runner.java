import java.io.FileInputStream;
import java.io.IOException;
import java.util.Comparator;
import java.util.Properties;
import java.util.Random;
import java.util.ArrayList;

public class Runner {

    public static void main(String args[]){
        GA geneticAlgo = new GA();
        geneticAlgo.setSelection(String.valueOf(Utilities.SELECTIONS.RouletteWheelSelection));
        geneticAlgo.setCrossover(String.valueOf(Utilities.CROSSOVERS.CustomCrossover));
        geneticAlgo.run();
    }
}

