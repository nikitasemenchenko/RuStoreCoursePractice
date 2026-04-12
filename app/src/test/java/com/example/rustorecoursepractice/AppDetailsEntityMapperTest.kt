package com.example.rustorecoursepractice

import com.example.rustorecoursepractice.data.local.AppDetailsEntity
import com.example.rustorecoursepractice.data.local.AppDetailsEntityMapper
import com.example.rustorecoursepractice.domain.AppDetails
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Test

class AppDetailsEntityMapperTest {
    private val mapper = AppDetailsEntityMapper()

    @Test
    fun `toEntity maps all important fields`() {
        val domain  = AppDetails(
            id = "1",
            name = "Max",
            developer = "VK",
            category = "Messenger",
            ageRating = 0,
            size = 50.0,
            iconUrl = "Icon",
            screenshotUrlList = listOf("a", "b"),
            description = "desc",
            isInWishList = true
        )

        val result = mapper.toEntity(domain)

        assertEquals("1", result.id)
        assertEquals("Max", result.name)
        assertEquals("VK", result.developer)
        assertEquals(listOf("a", "b"), result.screenshots)
        assertTrue(result.isInWishlist)
    }

    @Test
    fun `toDomain maps all important fields`() {
        val entity = AppDetailsEntity(
            id = "1",
            name = "Max",
            developer = "VK",
            category = "Messenger",
            ageRating = 0,
            size = 50.0,
            iconUrl = "Icon",
            screenshots = listOf("a", "b"),
            description = "desc",
            isInWishlist = true
        )

        val result = mapper.toDomain(entity)

        assertEquals("1", result.id)
        assertEquals("Max", result.name)
        assertEquals("VK", result.developer)
        assertEquals(listOf("a", "b"), result.screenshotUrlList)
        assertTrue(result.isInWishList)
    }

}