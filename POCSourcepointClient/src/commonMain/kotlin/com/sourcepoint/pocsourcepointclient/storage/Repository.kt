package com.sourcepoint.pocsourcepointclient.storage

import com.russhwolf.settings.get
import com.russhwolf.settings.set
import com.sourcepoint.pocsourcepointclient.Platform


// TODO (replace Platform with Settings)
// TODO (implement internal interface of Settings)
class Repository(val platform: Platform) {
    enum class Keys {
        MetaData
    }

    var cachedMetaData: String
        get() = platform.settings[Keys.MetaData.name, ""]
        set(value) { platform.settings[Keys.MetaData.name] = value }
}