package com.magnus.cerveja

import android.os.Parcel
import android.os.Parcelable

data class Valores1(var valor1: String?, var tamanho1: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(valor1)
        parcel.writeString(tamanho1)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Valores1> {
        override fun createFromParcel(parcel: Parcel): Valores1 {
            return Valores1(parcel)
        }

        override fun newArray(size: Int): Array<Valores1?> {
            return arrayOfNulls(size)
        }
    }
}