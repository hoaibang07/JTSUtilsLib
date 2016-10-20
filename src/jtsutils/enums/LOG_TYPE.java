package jtsutils.enums;

/**
 * Enum định nghĩa các kiểu log
 * 
 * @author hbc
 *
 */
public enum LOG_TYPE {
	ERROR("error"),
    MESSAGE("message"),
    WARNING("warning");

    private String _message;

    LOG_TYPE(String message) {
        this._message = message;
    }

    /**
     * Tra ve thong bao cua loai log
     * @return
     */
    public String message() {
        return _message;
    }
}
