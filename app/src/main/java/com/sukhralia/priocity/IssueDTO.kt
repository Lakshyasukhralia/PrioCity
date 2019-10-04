package com.sukhralia.priocity

import android.os.Parcel
import android.os.Parcelable

data class IssueDTO(val id:String = "",val region:String = "",val priority:Float = 0f,val subject:String = "",val issue:String = "",val createDate: String = ""):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readFloat(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ){}

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(region)
        parcel.writeFloat(priority)
        parcel.writeString(subject)
        parcel.writeString(issue)
        parcel.writeString(createDate)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<IssueDTO> {
        override fun createFromParcel(parcel: Parcel): IssueDTO {
            return IssueDTO(parcel)
        }

        override fun newArray(size: Int): Array<IssueDTO?> {
            return arrayOfNulls(size)
        }
    }
}