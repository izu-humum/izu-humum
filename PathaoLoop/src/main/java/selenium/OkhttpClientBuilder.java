package selenium;

import okhttp3.OkHttpClient;

public class OkhttpClientBuilder {

	private OkhttpClientBuilder() {
    }

    private static OkHttpClient.Builder okHttpBuilder;


    public static OkhttpClientBuilder builder() {
        okHttpBuilder = new OkHttpClient.Builder();
        return new OkhttpClientBuilder();
    }


//    public OkhttpClientBuilder addBasicAuthentication(final String userName, final String password) {
//        this.okHttpBuilder.
//                authenticator(
//                        (route, response) -> response.request().newBuilder().addHeader("Authorization", Credentials.basic(userName, password)).build());
//        return this;
//    }
//
//    public OkhttpClientBuilder addToken(final String token) {
//        this.okHttpBuilder.
//                authenticator(
//                        (route, response) -> response.request().newBuilder().addHeader("Authorization", token).build());
//        return this;
//    }
//
    public OkhttpClientBuilder addHeaders(final okhttp3.Headers headers) {
        OkhttpClientBuilder.okHttpBuilder.
                authenticator(
                        (route, response) -> response.request().newBuilder().headers(headers).build());
        return this;
    }
//
//    public OkhttpClientBuilder addBasicAuthenticationUsingInterceptor(final String key, final String value) {
//        this.okHttpBuilder.addInterceptor(chain -> {
//            Request build = chain.request().newBuilder().addHeader(key, value).build();
//            return chain.proceed(build);
//        });
//        return this;
//    }

    public OkHttpClient build() {
        return okHttpBuilder.build();
    }

}
