import java.util.ArrayList;

public class NeuralNetwork {

    // make it configurable
    int numInputs=9, numHiddenNodes=10, numOutputs=4, bitsPerWeight=8;

    public double sigmoid(double s){
        return 1 / (1+Math.exp(-s));
    }

    public ArrayList<Integer> chromosomeToWeights(){

    }
}
