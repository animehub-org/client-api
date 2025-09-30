package org.animefoda.client.exception;

public class ReCaptchaException extends BaseError {
    public ReCaptchaException() {
        super("ReCaptcha not valid", ErrorCode.INVALID_CAPTCHA);
    }
}
