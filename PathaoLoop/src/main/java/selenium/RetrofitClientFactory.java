package selenium;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RetrofitClientFactory {
	private RetrofitClientFactory() {
    }

    public static <T> T createApiClient(Retrofit retrofit, Class<T> service) {
        return retrofit.create(service);
    }

    public static <T> Response<T> executeCall(Call<T> call) {
        Response<T> response = null;
        try {
            response = call.execute();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return response;
    }

}
