package com.harunkor.retrofitbasicsample

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class RealeStateModel(

  val price: Int,
  val id: String,
  val type: String,
  val img_src: String
): Parcelable
