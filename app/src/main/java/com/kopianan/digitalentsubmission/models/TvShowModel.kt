package com.kopianan.digitalentsubmission.models

import android.os.Parcel
import android.os.Parcelable


data class TvShowModel(val Title: String?,
val Released: String?,
val Year : String?,
val Runtime: String?,
val Genre: String?,
val Actors: String?,
val Plot: String?,
val Poster: String?,
val imdbRating: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(Title)
        parcel.writeString(Released)
        parcel.writeString(Year)
        parcel.writeString(Runtime)
        parcel.writeString(Genre)
        parcel.writeString(Actors)
        parcel.writeString(Plot)
        parcel.writeString(Poster)
        parcel.writeString(imdbRating)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TvShowModel> {
        override fun createFromParcel(parcel: Parcel): TvShowModel {
            return TvShowModel(parcel)
        }

        override fun newArray(size: Int): Array<TvShowModel?> {
            return arrayOfNulls(size)
        }
    }
}