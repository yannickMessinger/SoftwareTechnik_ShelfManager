package ShelfManager.Lager.Exceptions;

public class RegalfachTraglastExceededException extends Exception {

    public RegalfachTraglastExceededException(){
        super("Traglast des Regals überschritten");
    }
}
