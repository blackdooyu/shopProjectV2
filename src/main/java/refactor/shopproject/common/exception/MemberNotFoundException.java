package refactor.shopproject.common.exception;

public class MemberNotFoundException extends TotalException{

    public MemberNotFoundException() {
        super(ErrorCode.MEMBER_NOT_FOUND);
    }
}
