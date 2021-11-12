package com.example.recyclercard;

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

public class UsuarioAdaptador extends RecyclerView.Adapter<UsuarioAdaptador.ViewHolder> {
 //Clase adaptador de vista y modelo

    private List<Usuario>usuarioList;
    private Context context;

    //Crear constructor con parametros


    public UsuarioAdaptador(List<Usuario> usuarioList, Context context) {
        this.usuarioList = usuarioList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Pasar la tarjeta en un inflante para que se muestre en el recycler
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tarjeta_usuario, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Se manipulan los objetos
        holder.tvNombre.setText(usuarioList.get(position).getNombre());
        holder.tvEmail.setText(usuarioList.get(position).getEmail());

        //Para la imagen se utilizara una libreria denomina glide
        //la cual permite acceder a imagen por medio de Interne
        //Inv que es necesario incluir para poder utilizar esta libreria

        Glide.with(context)
                .load(usuarioList.get(position).getFoto())
                .centerCrop()
                .into(holder.imgFoto);
    }

    @Override
    public int getItemCount() {
        return usuarioList.size();
    }

    //Definnir una clase Interna que herede de RecycerView.ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder{
        //Enlazar los componentes en Layout o tarjeta
        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvEmail;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Enlaza elementos con la tarjeta de Usuario
            imgFoto = itemView.findViewById(R.id.img_foto);
            tvNombre = itemView.findViewById(R.id.tv_Nombre);
            tvEmail = itemView.findViewById(R.id.tv_email);

        }
    }
}
