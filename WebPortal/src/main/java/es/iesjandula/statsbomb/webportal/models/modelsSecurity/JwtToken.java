package es.iesjandula.statsbomb.webportal.models.modelsSecurity;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 04/03/2023
 */
public class JwtToken
{

    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
