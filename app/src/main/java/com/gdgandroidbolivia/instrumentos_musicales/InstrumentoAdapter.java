package com.gdgandroidbolivia.instrumentos_musicales;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 15/10/2017.
 */

public class InstrumentoAdapter extends RecyclerView.Adapter<InstrumentoAdapter.InstrumentoViewholder>{
    List<Instrumento> dataset;
    Context context;
    onInstrumentoSelectedListener onInstrumentoSelectedListener;

    public interface onInstrumentoSelectedListener{
        void onInstrumentoSelected(Instrumento instrumento);
    }
    public InstrumentoAdapter(Context context, onInstrumentoSelectedListener onInstrumentoSelectedListener) {
        this.context = context;
        this.dataset = new ArrayList<>();
        this.onInstrumentoSelectedListener = onInstrumentoSelectedListener;
    }

    @Override
    public InstrumentoViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_instrumento,parent,false);
        return new InstrumentoViewholder(view);
    }

    @Override
    public void onBindViewHolder(InstrumentoViewholder holder, int position) {
        Instrumento instrumento = dataset.get(position);
        holder.nombre.setText(instrumento.getNombre());
        holder.imagen.setImageResource(instrumento.getImagen());
        holder.setOnInstrumentoSelectedListener(instrumento, onInstrumentoSelectedListener);

    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class InstrumentoViewholder extends RecyclerView.ViewHolder {
        View cardView;
        ImageView imagen;
        TextView nombre;
        public InstrumentoViewholder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_main);
            imagen = itemView.findViewById(R.id.imagen_item);
            nombre = itemView.findViewById(R.id.texto_item);

        }
        public void setOnInstrumentoSelectedListener(final Instrumento instrumento, final onInstrumentoSelectedListener onInstrumentoSelectedListener) {
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onInstrumentoSelectedListener.onInstrumentoSelected(instrumento);
                }
            });
        }
    }

    public void setDataset(List<Instrumento> instrumento) {
        if (instrumento == null){
            dataset = new ArrayList<>();
        }
        else{
            dataset = instrumento;
        }
        notifyDataSetChanged();
    }
}
