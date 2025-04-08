package vn.lequanghuy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ItemMoviesHolder> {

    Context context;
    ArrayList<FavouriteMovies> lstData;

    public MovieAdapter(Context context, ArrayList<FavouriteMovies> lstData) {
        this.context = context;
        this.lstData = lstData;
    }

    @NonNull
    @Override
    public ItemMoviesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater truyen_layout = LayoutInflater.from(context);
        View vItem = truyen_layout.inflate(R.layout.movie_item, parent, false);
        ItemMoviesHolder viewHolderCreated = new ItemMoviesHolder(vItem);
        return viewHolderCreated;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemMoviesHolder holder, int position) {
        // Lấy đối tượng hiển thị
        FavouriteMovies favouriteMoviesHienThi = lstData.get(position);
        // Trích thông tin
        String name = favouriteMoviesHienThi.getMovieName();
        String tenFileAnh = favouriteMoviesHienThi.getMovieImageFileName();
        // Đặt vào các trường thông tin của Holder
        holder.tvMovieName.setText(name);
        // Đặt ảnh
        String packageName = holder.itemView.getContext().getPackageName();
        int imageID = holder.itemView.getResources().getIdentifier(tenFileAnh, "mipmap", packageName);
        holder.ivMovies.setImageResource(imageID);
    }

    @Override
    public int getItemCount() {
        return lstData.size();
    }

    class ItemMoviesHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvMovieName;
        ImageView ivMovies;

        // Tìm điều khiển tương ứng của layout movie_item
        public ItemMoviesHolder(@NonNull View itemView) {
            super(itemView);
            tvMovieName = itemView.findViewById(R.id.tvMovieName);
            ivMovies = itemView.findViewById(R.id.imageViewMovie);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // Code
            int viTriDuocClick = getAdapterPosition();
            FavouriteMovies phanTuDuocClick =  lstData.get(viTriDuocClick);
            // Truy xuất thông tin
            String ten = phanTuDuocClick.getMovieName();
            String tenFile = phanTuDuocClick.movieImageFileName;
            //Toast tên
            String chuoiThongBao = "Bạn vừa click vào: " + ten;
            Toast.makeText(v.getContext(),chuoiThongBao, Toast.LENGTH_SHORT).show();


        }
    }
}
