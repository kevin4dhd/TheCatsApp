package app.pragma.thecatsapp.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import app.pragma.thecatsapp.Adapters.CatsAdapter;
import app.pragma.thecatsapp.Models.Cat;
import app.pragma.thecatsapp.R;
import app.pragma.thecatsapp.ViewModels.ViewModelCat;

public class ViewCats extends AppCompatActivity {

    private ViewModelCat viewModelCat;
    private RecyclerView catsRecyclerView;
    private CatsAdapter catsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cats);

        catsRecyclerView = findViewById(R.id.catsRecyclerView);
        catsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewModelCat = new ViewModelProvider(this).get(ViewModelCat.class);

        viewModelCat.getCats().observe(this, new Observer<List<Cat>>() {
            @Override
            public void onChanged(List<Cat> cats) {
                if (catsAdapter == null) {
                    catsAdapter = new CatsAdapter(ViewCats.this, cats);
                    catsRecyclerView.setAdapter(catsAdapter);
                }
            }
        });
    }
}