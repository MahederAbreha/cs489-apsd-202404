package cs489.apsd.adsdentalsurgeries.exception;

public class PatientNotFoundException extends RuntimeException{
    public PatientNotFoundException(String message) {
        super(message);
    }
}
