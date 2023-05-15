package app.pragma.thecatsapp.ViewModels;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;


import java.util.List;

import app.pragma.thecatsapp.Models.Cat;
import app.pragma.thecatsapp.Repositories.CatsRepository;

public class ViewModelCat extends ViewModel {
    private CatsRepository catsRepository;

    public ViewModelCat() {
        catsRepository = CatsRepository.getInstance();
    }

    public LiveData<List<Cat>> getCats() {
        return catsRepository.getCats();
    }
}

