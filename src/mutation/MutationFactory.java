package mutation;

import main.Utilities;

/**
 * This a factory class which returns different types of crossovers*
 */
public class MutationFactory {
    public Mutation createMutation(String mutationType){
        Mutation mutation = null;
        if (mutationType.equals(String.valueOf(Utilities.MUTATIONS.RandomResetMutation))) {
            mutation = new RandomResetMutation();
        }
        else if(mutationType.equals(String.valueOf(Utilities.MUTATIONS.SwapMutation))){
            mutation = new SwapMutation();
        }
        return mutation;
    }
}