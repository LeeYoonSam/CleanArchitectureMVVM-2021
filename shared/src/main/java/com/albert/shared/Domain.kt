package com.albert.shared

import kotlinx.serialization.Serializable

@JvmInline
value class JsonRawString(val value: String)

@Serializable
@JvmInline
value class HexColor(val value: String)