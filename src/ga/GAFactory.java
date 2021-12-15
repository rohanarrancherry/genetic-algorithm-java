package ga;

/**
 * Abstract class for creating various GA Strategies, creation
 * of GA object is done by the child class.
 */
public abstract class GAFactory {

    public GA getGA(){
        GA ga = createGA();
        return ga;
    }
    abstract GA createGA();

}