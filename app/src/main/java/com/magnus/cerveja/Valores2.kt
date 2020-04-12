package com.magnus.cerveja

import android.os.Parcel
import android.os.Parcelable

data class Valores2(var valorFinal: String?, var valorMaisCaro: String?, var cervejaBarata: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(valorFinal)
        parcel.writeString(valorMaisCaro)
        parcel.writeString(cervejaBarata)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Valores2> {
        override fun createFromParcel(parcel: Parcel): Valores2 {
            return Valores2(parcel)
        }

        override fun newArray(size: Int): Array<Valores2?> {
            return arrayOfNulls(size)
        }
    }
}