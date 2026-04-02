package com.example.rustorecoursepractice

import com.example.rustorecoursepractice.data.AppDetailsDto
import com.example.rustorecoursepractice.data.AppDetailsMapper
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import org.junit.Test

class AppMapperTest {
    private val mapper = AppDetailsMapper()

    private val dto = AppDetailsDto(
        id = "1",
        name = "VK",
        developer = "VK",
        category = "Messenger",
        ageRating = 12,
        size = 50.0,
        iconUrl = "icon",
        screenshotUrlList = listOf("s1", "s2"),
        description = "desc"
    )

    @Test
    fun `toDomain maps id correctly`() {
        val result = mapper.toDomain(dto)
        assertEquals("1", result.id)
    }

    @Test
    fun `toDomain maps name correctly`() {
        val result = mapper.toDomain(dto)
        assertEquals("VK", result.name)
    }

    @Test
    fun `toDomain wishlist default false`() {
        val result = mapper.toDomain(dto)
        assertFalse(result.isInWishList)
    }
}