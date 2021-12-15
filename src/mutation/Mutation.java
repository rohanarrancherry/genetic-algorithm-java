package mutation;

import population.Chromosome;

/**
 * This is an Interface for Mutation operation. Every mutation function may or may not
 * return a Chromosome with a change. Object will take one chromosome as an Argument
 * */
public interface Mutation {
    void mutate(Chromosome chromosome);
}
