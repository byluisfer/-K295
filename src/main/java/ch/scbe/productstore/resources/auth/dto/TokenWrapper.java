package ch.scbe.productstore.resources.auth.dto;

public class TokenWrapper {

    private String token;

    public TokenWrapper() {
        // no-args constructor
    }

    public TokenWrapper(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
