package com.prashant.android.miwok

import com.prashant.android.miwok.Word.Constants.NO_IMAGE_PROVIDED

class Word (miwokParam:String,defaultParam:String,resourceId:Int){

    object Constants{
        const val NO_IMAGE_PROVIDED = -1
    }

    constructor(miwokParam:String, defaultParam:String) : this(
        miwokParam,defaultParam, NO_IMAGE_PROVIDED)

    var miwokText:String = miwokParam
        private set
    var defaultText:String = defaultParam
        private set
    var resource:Int = resourceId
        private set

    fun hasImage() : Boolean { return resource!= NO_IMAGE_PROVIDED }

}