package main;

import ga.EliteGAFactory;
import ga.GA;
import ga.GAFactory;
import ga.NonEliteGAFactory;

/**
 * This is the Main class for running the GA
 * */
public class Runner {

    public static void main(String args[]){
        GAFactory eliteGAFactory = new EliteGAFactory();
        GAFactory nonEliteGAFactory= new NonEliteGAFactory();
        GA geneticAlgo1 = eliteGAFactory.getGA();
        GA geneticAlgo2 = nonEliteGAFactory.getGA();
        // Running the GA with Elite strategy
//         geneticAlgo1.run();
        // For running GA with Non Elite Strategy
//         geneticAlgo2.run();

        // demonstrating strategy pattern

        // by default Elite GA uses Roulette Wheel Selection we are changing the
        // selection method during runtime
         geneticAlgo1.setSelection(String.valueOf(Utilities.SELECTIONS.RouletteWheelSelection));
         geneticAlgo1.setMutation(String.valueOf(Utilities.MUTATIONS.SwapMutation));
         geneticAlgo1.run();
    }
}