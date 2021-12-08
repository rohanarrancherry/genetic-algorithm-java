public class MutationFactory {
    public Mutation createMutation(String mutationType){
        Mutation mutation = null;
        if (mutationType.equals(String.valueOf(Utilities.MUTATIONS.CustomMutation))) {
            mutation = new CustomMutation();
        }
        return mutation;
    }
}
