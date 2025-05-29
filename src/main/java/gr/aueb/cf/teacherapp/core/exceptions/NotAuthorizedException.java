package gr.aueb.cf.teacherapp.core.exceptions;

public class NotAuthorizedException extends EntityGenericException{
    private static final String DEFAULT_CODE = "NotAuthorized";

    public NotAuthorizedException(String code, String message) {
        super(code + DEFAULT_CODE, message);

    }
}
