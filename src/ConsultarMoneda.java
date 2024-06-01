import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarMoneda {
    public Monedas buscarMonedas(String monedaInicial, String monedaFinal){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/bafabb837e00e6e32b8a13e3/pair/" + monedaInicial+"/" + monedaFinal);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try{
            HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Monedas.class);
        }
        catch (Exception e) {
            throw new RuntimeException("No se encontro la Divisa");
        }
    }
}
