package com.appsbg.model.poko.notifications

import com.squareup.moshi.Json

data class NotificationsWrapper(
    val notifications: List<Notification>
)