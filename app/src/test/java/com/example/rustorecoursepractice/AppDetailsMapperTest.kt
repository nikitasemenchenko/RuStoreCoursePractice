package com.example.rustorecoursepractice

import com.example.rustorecoursepractice.data.AppDetailsDto
import com.example.rustorecoursepractice.data.AppDetailsMapper
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import org.junit.Test

class AppDetailsMapperTest {
    private val mapper = AppDetailsMapper()

    private val dto = AppDetailsDto(
        id = "1",
        name = "Max",
        developer = "VK",
        category = "Messenger",
        ageRating = 0,
        size = 50.0,
        iconUrl = "icon",
        screenshotUrlList = listOf("s1", "s2"),
        description = "desc"
    )

    @Test
    fun `AppDetailsMapper maps all important fields`(){
        val result = mapper.toDomain(dto)
        assertEquals("1", result.id)
        assertEquals("Max", result.name)
        assertEquals("VK", result.developer)
        assertEquals(listOf("s1", "s2"), result.screenshotUrlList)
        assertFalse(result.isInWishList)
    }
}