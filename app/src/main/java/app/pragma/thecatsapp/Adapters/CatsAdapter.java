package app.pragma.thecatsapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import app.pragma.thecatsapp.Models.Cat;
import app.pragma.thecatsapp.R;

public class CatsAdapter extends RecyclerView.Adapter<CatsAdapter.CatViewHolder> {
    private Context context;
    private List<Cat> cats;

    public CatsAdapter(Context context, List<Cat> cats) {
        this.context = context;
        this.cats = cats;
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cat, parent, false);
        return new CatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        Cat cat = cats.get(position);
        holder.bind(cat);
    }

    @Override
    public int getItemCount() {
        return cats.size();
    }

    public static class CatViewHolder extends RecyclerView.ViewHolder {
        TextView txtCatBreedName, txtCatOrigin, txtCatIntelligence;
        ImageView imgCat;

        public CatViewHolder(@NonNull View itemView) {
            super(itemView);

            txtCatBreedName = itemView.findViewById(R.id.txtCatBreedName);
            txtCatOrigin = itemView.findViewById(R.id.txtCatOrigin);
            txtCatIntelligence = itemView.findViewById(R.id.txtCatIntelligence);
            imgCat = itemView.findViewById(R.id.imgCat);
        }

        public void bind(Cat cat) {
            txtCatBreedName.setText(cat.getBreedName());
            txtCatOrigin.setText(cat.getOrigin());
            txtCatIntelligence.setText("Inteligencia: "+ cat.getIntelligence());

            // Usa Glide para cargar la imagen en el ImageView
            Glide.with(itemView.getContext())
                    .load("https://cdn2.thecatapi.com/images/"+cat.getImageUrl()+".jpg")
                    .error(R.drawable.gato_error) // Imagen en caso de error
                    .into(imgCat);
        }

    }
}