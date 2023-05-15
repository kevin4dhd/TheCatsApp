package app.pragma.thecatsapp.Data;

import java.util.List;

import app.pragma.thecatsapp.Models.Cat;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiCats {
    @Headers("x-api-key: bda53789-d59e-46cd-9bc4-2936630fde39")
    @GET("breeds")
    Call<List<Cat>> getCats();
}