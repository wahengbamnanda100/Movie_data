package com.example.movie_data;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private Context ctx;
    private Cursor mcursor;

    public MovieAdapter(Context context, Cursor cursor) {
        ctx = context;
        mcursor = cursor;
    }

    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View view = inflater.inflate(R.layout.row_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolder holder, int position) {
        if (!mcursor.moveToPosition(position)) {
            return ;
        }

        String name = mcursor.getString(mcursor.getColumnIndex(MovieContract.MovieEntry.COLUMN_MOVIE_NAME));
        String language = mcursor.getString(mcursor.getColumnIndex(MovieContract.MovieEntry.COLUMN_MOVIE_LANGUAGE));
        String genre = mcursor.getString(mcursor.getColumnIndex(MovieContract.MovieEntry.COLUMN_MOVIE_GENRE));

        holder.tvnames.setText(name);
        holder.tvlang.setText(language);
        holder.tvgenre.setText(genre);
    }

    @Override
    public int getItemCount() {
        return mcursor.getCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvnames, tvlang, tvgenre;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvnames = itemView.findViewById(R.id.tvmovieElementName);
            tvlang = itemView.findViewById(R.id.tvmovieelementLang);
            tvgenre = itemView.findViewById(R.id.tvmovieElementGenre);
        }
    }

    public void swapCursor(Cursor newCursor) {
        if (mcursor != null) {
            mcursor.close();
        }

        mcursor = newCursor;

        if (newCursor != null) {
            notifyDataSetChanged();
        }
    }
}
