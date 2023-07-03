package com.sourcepoint.pocsourcepointclient.network

import kotlinx.serialization.Serializable

@Serializable
data class MetadataResponse(
    @Serializable
    val gdpr: GDPRMetaDataResponse? = null,
    @Serializable
    val ccpa: CCPAMetaDataResponse? = null
)

@Serializable
data class GDPRMetaDataResponse(
    @Serializable
    val applies: Boolean
)

@Serializable
data class CCPAMetaDataResponse(
    @Serializable
    val applies: Boolean
)

