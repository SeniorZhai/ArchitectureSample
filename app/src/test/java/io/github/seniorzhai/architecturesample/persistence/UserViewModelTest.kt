package io.github.seniorzhai.architecturesample.persistence

import android.arch.core.executor.testing.InstantTaskExecutorRule
import io.github.seniorzhai.architecturesample.ui.UserViewModel
import io.reactivex.Flowable
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class UserViewModelTest {
    @get:Rule var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock private lateinit var dataSource: UserDao

    @Captor private lateinit var userArgumentCaptor: ArgumentCaptor<User>

    private lateinit var viewModel: UserViewModel

    @Before fun setUp() {
        MockitoAnnotations.initMocks(this)

        viewModel = UserViewModel(dataSource)
    }

    @Test fun getUserName_whenNoUserSaved() {
        `when`(dataSource.getUserById(UserViewModel.USER_ID)).thenReturn(Flowable.empty<User>())

        viewModel.userName()
                .test()
                .assertNoValues()
    }

    @Test fun getUserName_whenUserSaved() {
        val user = User(userName = "user name")
        `when`(dataSource.getUserById(UserViewModel.USER_ID)).thenReturn(Flowable.just(user))

        viewModel.userName()
                .test()
                .assertValue("user name")
    }

    @Test fun updateUserName_updatesNameInDataSource() {
        viewModel.updateUserName("new user name")
                .test()
                .assertComplete()

        verify<UserDao>(dataSource).insertUser(capture(userArgumentCaptor))
        assertThat(userArgumentCaptor.value.userName, Matchers.`is`("new user name"))
    }
}

fun <T> capture(argumentCaptor: ArgumentCaptor<T>): T = argumentCaptor.capture()