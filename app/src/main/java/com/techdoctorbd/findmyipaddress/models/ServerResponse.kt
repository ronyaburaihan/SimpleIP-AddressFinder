package com.techdoctorbd.findmyipaddress.models

import com.google.gson.annotations.SerializedName

data class ServerResponse(
    @SerializedName("ip")
    val ip: String? = null,

    @SerializedName("ip_decimal")
    val ipDecimal: Int? = null,

    @SerializedName("country")
    val country: String? = null,

    @SerializedName("country_iso")
    val countryIso: String? = null,

    @SerializedName("country_eu")
    val countryEu: Boolean? = null,

    @SerializedName("region_name")
    val regionName: String? = null,

    @SerializedName("region_code")
    val regionCode: String? = null,
    @SerializedName("zip_code")
    val zipCode: String? = null,

    @SerializedName("city")
    val city: String? = null,

    @SerializedName("latitude")
    val latitude: Float? = null,

    @SerializedName("longitude")
    val longitude: Float? = null,

    @SerializedName("time_zone")
    val timeZone: String? = null,

    @SerializedName("asn_org")
    val asnOrg: String? = null
)