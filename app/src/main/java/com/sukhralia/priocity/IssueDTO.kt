package com.sukhralia.priocity

import java.io.Serializable

data class IssueDTO(val id:String = "",val region:String = "",val priority:Float = 0f,val issue:String = "",val createDate: String = ""):Serializable