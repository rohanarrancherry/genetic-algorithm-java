package ga;

public abstract class GAFactory {

    public GA getGA(){
        GA ga = createGA();
        return ga;
    }
    abstract GA createGA();

}