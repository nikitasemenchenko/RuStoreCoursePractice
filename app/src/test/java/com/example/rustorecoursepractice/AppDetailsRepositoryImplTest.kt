package com.example.rustorecoursepractice

import com.example.rustorecoursepractice.data.AppDetailsDto
import com.example.rustorecoursepractice.data.AppDetailsMapper
import com.example.rustorecoursepractice.data.AppDetailsRepositoryImpl
import com.example.rustorecoursepractice.data.AppsApi
import com.example.rustorecoursepractice.data.local.AppDetailsDao
import com.example.rustorecoursepractice.data.local.AppDetailsEntity
import com.example.rustorecoursepractice.data.local.AppDetailsEntityMapper
import com.example.rustorecoursepractice.domain.AppDetails
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.never
import org.mockito.kotlin.any
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class AppDetailsRepositoryImplTest {
    private val api = mock<AppsApi>()
    private val mapper = mock<AppDetailsMapper>()
    private val dao = mock<AppDetailsDao>()
    private val entityMapper = mock<AppDetailsEntityMapper>()

    private val repository = AppDetailsRepositoryImpl(
        api = api,
        mapper = mapper,
        dao = dao,
        entityMapper = entityMapper
    )

    @Test
    fun `getAppById returns entity`() = runTest {
        val entity = AppDetailsEntity(
            id = "1",
            name = "Max",
            developer = "VK",
            category = "Messenger",
            ageRating = 0,
            size = 50.0,
            iconUrl = "Icon",
            screenshots = listOf("screenshot"),
            description = "desc",
            isInWishlist = true
        )

        val domain  = AppDetails(
            id = "1",
            name = "Max",
            developer = "VK",
            category = "Messenger",
            ageRating = 0,
            size = 50.0,
            iconUrl = "Icon",
            screenshotUrlList = listOf("screenshot"),
            description = "desc",
            isInWishList = true
        )

        whenever(dao.getAppDetails("1")).thenReturn(flowOf(entity))
        whenever(entityMapper.toDomain(entity)).thenReturn(domain)

        val result = repository.getAppById("1").first()

        assertEquals(domain, result)
        // проверяем что Dao возвращает entity не идя в Api
    }

    @Test
    fun `getAppById doesnt call api when entity exists`() = runTest {
        val entity = AppDetailsEntity(
            id = "1",
            name = "Max",
            developer = "VK",
            category = "Messenger",
            ageRating = 0,
            size = 50.0,
            iconUrl = "Icon",
            screenshots = listOf("screenshot"),
            description = "desc",
            isInWishlist = true
        )

        val domain  = AppDetails(
            id = "1",
            name = "Max",
            developer = "VK",
            category = "Messenger",
            ageRating = 0,
            size = 50.0,
            iconUrl = "Icon",
            screenshotUrlList = listOf("screenshot"),
            description = "desc",
            isInWishList = true
        )

        whenever(dao.getAppDetails("1")).thenReturn(flowOf(entity))
        whenever(entityMapper.toDomain(entity)).thenReturn(domain)

        repository.getAppById("1").first()

        verify(api, never()).getAppById(any())
    }

    @Test
    fun `getAppById loads from api when dao returns null`() = runTest {
        val dto = AppDetailsDto(
            id = "1",
            name = "Max",
            developer = "VK",
            category = "Messenger",
            ageRating = 0,
            size = 50.0,
            iconUrl = "Icon",
            screenshotUrlList = listOf("screenshot"),
            description = "desc"
        )
        val domain  = AppDetails(
            id = "1",
            name = "Max",
            developer = "VK",
            category = "Messenger",
            ageRating = 0,
            size = 50.0,
            iconUrl = "Icon",
            screenshotUrlList = listOf("screenshot"),
            description = "desc",
            isInWishList = true
        )
        val entity = AppDetailsEntity(
            id = "1",
            name = "Max",
            developer = "VK",
            category = "Messenger",
            ageRating = 0,
            size = 50.0,
            iconUrl = "Icon",
            screenshots = listOf("screenshot"),
            description = "desc",
            isInWishlist = true
        )

        whenever(dao.getAppDetails("1")).thenReturn(flowOf(null))
        whenever(api.getAppById("1")).thenReturn(dto)
        whenever(mapper.toDomain(dto)).thenReturn(domain)
        whenever(entityMapper.toEntity(domain)).thenReturn(entity)

        val result = repository.getAppById("1").first()

        assertEquals(domain, result)
        verify(api).getAppById("1")
    }

    @Test
    fun `getAppById saves api data to dao`() = runTest {
        val dto = AppDetailsDto(
            id = "1",
            name = "Max",
            developer = "VK",
            category = "Messenger",
            ageRating = 0,
            size = 50.0,
            iconUrl = "Icon",
            screenshotUrlList = listOf("screenshot"),
            description = "desc"
        )
        val domain  = AppDetails(
            id = "1",
            name = "Max",
            developer = "VK",
            category = "Messenger",
            ageRating = 0,
            size = 50.0,
            iconUrl = "Icon",
            screenshotUrlList = listOf("screenshot"),
            description = "desc",
            isInWishList = true
        )
        val entity = AppDetailsEntity(
            id = "1",
            name = "Max",
            developer = "VK",
            category = "Messenger",
            ageRating = 0,
            size = 50.0,
            iconUrl = "Icon",
            screenshots = listOf("screenshot"),
            description = "desc",
            isInWishlist = true
        )

        whenever(dao.getAppDetails("1")).thenReturn(flowOf(null))
        whenever(api.getAppById("1")).thenReturn(dto)
        whenever(mapper.toDomain(dto)).thenReturn(domain)
        whenever(entityMapper.toEntity(domain)).thenReturn(entity)

        repository.getAppById("1").first()

        verify(dao).insertAppDetails(entity)
    }

    @Test
    fun `toggleWishlist changes false to true`() = runTest {
        val entity = AppDetailsEntity(
            id = "1",
            name = "Max",
            developer = "VK",
            category = "Messenger",
            ageRating = 0,
            size = 50.0,
            iconUrl = "Icon",
            screenshots = listOf("screenshot"),
            description = "desc",
            isInWishlist = false
        )

        whenever(dao.getAppDetails("1")).thenReturn(flowOf(entity))

        repository.toggleWishlist("1")

        verify(dao).updateWishlistStatus("1", true)
    }

}