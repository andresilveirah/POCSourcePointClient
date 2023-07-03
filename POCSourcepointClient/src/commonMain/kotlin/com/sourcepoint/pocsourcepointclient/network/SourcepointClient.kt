package com.sourcepoint.pocsourcepointclient.network

import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.serialization.json.Json

class SourcepointClient {
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    @Throws(Exception::class)
    suspend fun getMetaData(): String {
        val metaDataResponse: MetadataResponse = httpClient
            .get("https://cdn.privacy-mgmt.com/wrapper/v2/meta-data?accountId=22&env=localProd&propertyId=17801&includeData=%7B%0A%20%20%22TCData%22%3A%20%7B%0A%20%20%20%20%22type%22%3A%20%22RecordString%22%0A%20%20%7D%2C%0A%20%20%22actions%22%3A%20%7B%0A%20%20%20%20%22type%22%3A%20%22RecordString%22%0A%20%20%7D%2C%0A%20%20%22customVendorsResponse%22%3A%20%7B%0A%20%20%20%20%22type%22%3A%20%22RecordString%22%0A%20%20%7D%2C%0A%20%20%22cookies%22%3A%20%7B%0A%20%20%20%20%22type%22%3A%20%22RecordString%22%0A%20%20%7D%2C%0A%20%20%22localState%22%3A%20%7B%0A%20%20%20%20%22type%22%3A%20%22RecordString%22%0A%20%20%7D%2C%0A%20%20%22campaigns%22%3A%20%7B%0A%20%20%20%20%22type%22%3A%20%22RecordString%22%0A%20%20%7D%2C%0A%20%20%22translateMessage%22%3A%20true%2C%0A%20%20%22categories%22%3A%20true%0A%7D&metadata=%7B%0A%20%20%22ccpa%22%3A%20%7B%7D%2C%0A%20%20%22gdpr%22%3A%20%7B%0A%20%20%20%20%22groupPmId%22%3A%20null%0A%20%20%7D%0A%7D")
            .body()
        return metaDataResponse.toString()
    }
}