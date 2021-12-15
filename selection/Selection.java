package selection;

import population.Chromosome;
import population.Population;

public interface Selection {
//    Population population=null;
    public Chromosome select(Population population);
}
