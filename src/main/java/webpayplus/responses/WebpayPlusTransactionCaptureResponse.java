package webpayplus.responses;

import lombok.*;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@ToString
public class WebpayPlusTransactionCaptureResponse {
    private String authorizationCode;
    private String authorizationDate;
    private double capturedAmount;
    private byte responseCode;
}
