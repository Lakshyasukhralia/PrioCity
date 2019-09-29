package com.sukhralia.priocity

import java.time.Instant
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

data class IssueRequest(val id:String,val region:String,val priority:Float,val issue:String,val createDate: String =
    DateTimeFormatter
        .ofPattern("yyyy-MM-dd HH:mm:ss")
        .withZone(ZoneOffset.UTC)
        .format(Instant.now()))