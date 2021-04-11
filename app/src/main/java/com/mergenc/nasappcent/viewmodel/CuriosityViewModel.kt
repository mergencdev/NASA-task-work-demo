package com.mergenc.nasappcent.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mergenc.nasappcent.model.Camera
import com.mergenc.nasappcent.model.ModelC
import com.mergenc.nasappcent.model.Photo
import com.mergenc.nasappcent.model.Rover

class CuriosityViewModel : ViewModel() {
    val marsPhotos = MutableLiveData<List<ModelC>>()
    val photosError = MutableLiveData<Boolean>()
    val photosLoading = MutableLiveData<Boolean>()

    fun refreshData() {
        val marsPhoto = ModelC(
            Photo(
                Camera("Front Hazard Avoidance Camera", 20, "FHAZ", 5),
                "2015-05-30",
                102693,
                "www.ss.com",
                Rover(5, "2012-08-06", "2011-11-26", "Curiosity", "active"), 1000
            )
        )

        val marsPhoto1 = ModelC(
            Photo(
                Camera("Front Hazard Avoidance Camera", 20, "FHAZ", 5),
                "2015-05-30",
                102693,
                "www.ss.com",
                Rover(5, "2012-08-06", "2011-11-26", "Curiosity", "active"), 1000
            )
        )

        val marsPhoto2 = ModelC(
            Photo(
                Camera("Front Hazard Avoidance Camera", 20, "FHAZ", 5),
                "2015-05-30",
                102693,
                "www.ss.com",
                Rover(5, "2012-08-06", "2011-11-26", "Curiosity", "active"), 1000
            )
        )

        var marsDataList = arrayListOf<ModelC>(marsPhoto, marsPhoto1, marsPhoto2)

        marsPhotos.value = marsDataList
        photosError.value = false
        photosLoading.value = false
    }
}