package com.example.rustorecoursepractice

import com.example.rustorecoursepractice.domain.AppsRepository
import com.example.rustorecoursepractice.domain.GetAppListUseCase
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever
import com.example.rustorecoursepractice.domain.App
import junit.framework.TestCase.assertEquals
import org.mockito.kotlin.verify

class GetAppListUseCaseTest {
    private val repository: AppsRepository = mock()
    private val useCase = GetAppListUseCase(repository)

    @Test
    fun `returns apps from repository`() = runTest {
        val apps = listOf(
            App("1", "VK", "Desc", "Messenger", "icon")
        )
        whenever(repository.getApps()).thenReturn(apps)

        val result = useCase()

        assertEquals(apps, result)
    }

    @Test
    fun `calls repository one time`() = runTest {
        whenever(repository.getApps()).thenReturn(emptyList())

        useCase()

        verify(repository).getApps()
    }

    @Test
    fun `throws exception when repository throws exception`() = runTest {
        whenever(repository.getApps()).thenThrow(RuntimeException("error"))

        try {
            useCase()
            throw AssertionError("exception expected")
        } catch (e: RuntimeException) {
            assertEquals("error", e.message)
        }
    }
}