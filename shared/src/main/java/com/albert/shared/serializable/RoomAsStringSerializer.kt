package com.albert.shared.serializable

import com.albert.shared.Room
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind

import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

class RoomAsStringSerializer : KSerializer<Room> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor(javaClass.name, PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: Room) {
        encoder.encodeString(value.name)
    }

    override fun deserialize(decoder: Decoder): Room {
        val decodeString = decoder.decodeString()
        return Room.values().find { it.name.lowercase() == decodeString.lowercase() } ?: Room.Etc
    }
}