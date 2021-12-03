import java.util.ArrayList;

public abstract class Selection {
    Population population;
    Selection(Population population){
        this.population = population;
    }

    public abstract Chromosome select(Population population);
}
