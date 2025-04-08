package vn.lequanghuy;

public class FavouriteMovies {
    String movieImageFileName;
    String movieName;

    public FavouriteMovies(String movieImageFileName, String movieName) {
        this.movieImageFileName = movieImageFileName;
        this.movieName = movieName;
    }

    public String getMovieImageFileName() {
        return movieImageFileName;
    }

    public void setMovieImageFileName(String movieImageFileName) {
        this.movieImageFileName = movieImageFileName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}
