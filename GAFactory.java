public abstract class GAFactory {

    public GA getGA(String selection, String crossOver, String mutation ){
        GA ga = createGA(selection, crossOver, mutation);
        return ga;
    }
    abstract GA createGA(String selection, String crossOver, String mutation);

}