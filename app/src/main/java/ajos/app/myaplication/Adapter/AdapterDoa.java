package ajos.app.myaplication.Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ajos.app.myaplication.DetailActivity;
import ajos.app.myaplication.Model.ModelDoa;
import ajos.app.myaplication.R;
import ajos.app.myaplication.ViewHolder.HolderDoa;

public class AdapterDoa extends RecyclerView.Adapter<HolderDoa> {

    private List<ModelDoa> doa = new ArrayList<>();

    public AdapterDoa(List<ModelDoa> doa) {
        this.doa = doa;
    }

    @Override
    public HolderDoa onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView =  LayoutInflater.from(parent.getContext()).inflate(R.layout.item_doa, parent, false);
        final HolderDoa holderDoa = new HolderDoa(itemView);

        holderDoa.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int position = holderDoa.getAdapterPosition();
                Intent intent = new Intent(holderDoa.itemView.getContext(), DetailActivity.class);
                intent.putExtra("id_doa", doa.get(position));

                holderDoa.itemView.getContext().startActivity(intent);

            }
        });

        return holderDoa;
    }

    @Override
    public void onBindViewHolder(HolderDoa holder, int position) {
        holder.title.setText(doa.get(position).getDoaTitle());
        holder.subtitle.setText(doa.get(position).getDoaSubtitle());
    }

    @Override
    public int getItemCount() {
        return doa.size();
    }
}
