package app.pragma.thecatsapp.Repositories;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import app.pragma.thecatsapp.Data.ApiCats;
import app.pragma.thecatsapp.Data.RetrofitInstance;
import app.pragma.thecatsapp.Models.Cat;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CatsRepository {
    private static CatsRepository instance;
    private MutableLiveData<List<Cat>> cats;

    public static CatsRepository getInstance() {
        if (instance == null) {
            instance = new CatsRepository();
        }
        return instance;
    }

    public MutableLiveData<List<Cat>> getCats() {
        if (cats == null) {
            cats = new MutableLiveData<>();
            loadCats();
        }
        return cats;
    }

    private void loadCats() {
        ApiCats apiCats = RetrofitInstance.getRetrofitInstance().create(ApiCats.class);
        Call<List<Cat>> call = apiCats.getCats();
        call.enqueue(new Callback<List<Cat>>() {
            @Override
            public void onResponse(Call<List<Cat>> call, Response<List<Cat>> response) {
                cats.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Cat>> call, Throwable t) {
                // Tratar error
            }
        });
    }
}
