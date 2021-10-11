package com.albert.domain.usecase.staff

import com.albert.data.ConferenceRepository
import com.albert.shared.model.User
import com.albert.shared.result.Result
import com.albert.test.MainCoroutineRule
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class GetStaffUseCaseTest {
    @get:Rule
    var coroutineRule = MainCoroutineRule()

    private val repository : ConferenceRepository = mock()

    @Test
    fun successExecute() = runBlocking {
        // given
        val useCase = GetStaffUseCase(repository, coroutineRule.testDispatcher)
        whenever(repository.getStaffs())
            .thenReturn(
                listOf(
                    User(
                        name = "Droid Knights",
                        photoUrl = ""
                    ),
                    User(
                        name = "Android",
                        photoUrl = ""
                    )
                )
            )

        // when
        val result = useCase.invoke()

        // then
        assertThat(result, `is`(IsInstanceOf(Result.Success::class.java)))

        val successResult = result as Result.Success
        assertEquals(2, successResult.data.size)

        println(result)
        assertEquals("Android", successResult.data[0].name)
        assertEquals("Droid Knights", successResult.data[1].name)
    }

    @Test
    fun errorExecute() = runBlocking {
        // given
        val useCase = GetStaffUseCase(repository, coroutineRule.testDispatcher)
        whenever(repository.getStaffs())
            .thenThrow(IllegalStateException("Test"))

        // when
        val result = useCase.invoke()

        // then
        assertThat(result, `is`(IsInstanceOf(Result.Error::class.java)))

        val errorResult = result as Result.Error
        assertEquals("Test", errorResult.exception.message)
    }
}