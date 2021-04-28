package com.example.bottomnavigation;

import android.os.Parcel;
import android.os.Parcelable;

public class Movies implements Parcelable{
    private String name;
    private String releaseDate;
    private String plot;
    private int poster;

    protected Movies(Parcel in) {
        name = in.readString();
        releaseDate = in.readString();
        plot = in.readString();
        poster = in.readInt();
    }

    public static final Creator<Movies> CREATOR = new Creator<Movies>(){
        @Override
        public Movies createFromParcel(Parcel in) {
            return new Movies(in);
        }

        public Movies[] newArray(int size) {
            return new Movies[size];
        }
    };

    public Movies() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(releaseDate);
        dest.writeString(plot);
        dest.writeInt(poster);
    }
}
