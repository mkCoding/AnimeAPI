package com.hfad.animeapi.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.hfad.animeapi.data.model.CharactersModel
import com.hfad.animeapi.data.model.DataModel
import com.hfad.animeapi.data.repository.ApiRepository
import com.hfad.animeapi.data.repository.ApiRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.kotlin.whenever

/*
This annotation indicates that you are using experimental features of Kotlin coroutines
 */

@ExperimentalCoroutinesApi
class CharactersListViewModelTest {

    //@get:Rule - indicates a rule, should be applied when executing task
    @get:Rule

    //Used to execute live data instantly
    /*
       Additional notes:
       - InstantTaskExecutorRule is a rule provided by the AndroidX Test library
       - Used for testing code that uses LiveData in Android.
       - Ensures that tasks executed using LiveData are executed synchronously,
         which is crucial for testing LiveData-related code.
       - (Live data is asynchronous but test needs to be ran synchronously else
         it can lead to inconsistencies, unreliability and falls positive test)
     */
    var rule: TestRule = InstantTaskExecutorRule()

    //create data members for repository and viewModel
    private lateinit var repository: ApiRepository
    private lateinit var viewModel: CharactersListViewModel


    /*
    @Before - Indicates this method should be executed before each test
     */
    @Before
    fun setUp() {
        //Specifying that all the test should run synchronously (sequential order)
        Dispatchers.setMain(Dispatchers.Unconfined)

        // Initialize repository
        repository = mock(ApiRepositoryImpl::class.java) //mock the repository

        // Initialize ViewModel with mock repository
        viewModel = CharactersListViewModel(repository) //initialize the viewModel
    }


    /*
        @After indicates that this method is executed after each Test
     */
    @After
    fun tearDown() {
        //Ensures that each test is isolated and does not affect the behavior of other tests
        //or the application as a whole.
        Dispatchers.resetMain()
    }

    /*
       Test that gets all Characters when repository returns characters

       *Goal of this test*
       - Verify the functionality of the getAllCharacters method in CharactersListViewModel
     */
    @Test
    fun testGetAllCharactersWhenRepositoryReturnsCharacters() = runTest {


        //----------------------1. Prepare the Data-------------------
        /*
        Prepare test data preparation
        - Create list of DataModel objects with sample char names
         */
        val dataModelList = listOf(
            DataModel(name = "Character 1"), /*This does not need real character data from the API response. */
            DataModel(name = "Character 2")
        )

        //Use CharactersModel to wrap the list of DataModel objects
        val charactersModel = CharactersModel(data = dataModelList)

        //-----------------------2. Mock the repository method-----------------
        /*
        Configures the behavior of the mocked repository object.
        When(whenever) getCharacters() method is called, it should return charactersModel.
         */
        whenever(repository.getCharacters()).thenReturn(charactersModel)

        //---------------------3. Observe the LiveData-------------------------
        val observer = mock(Observer::class.java) as Observer<CharactersModel>

        //Observes the charactersList LiveData in the viewModel using the mock observer.
        viewModel.charactersList.observeForever(observer)

        //-------------------------4. Invoke View Model Method------------------
        //call the function from viewModel
        viewModel.getAllCharacters()

        //-------------------------5. Verify LiveData Update----------------------
        //verify if postValue was called with correct data
        verify(observer).onChanged(charactersModel) //test

        //-------------------------6. Verify Repository Call----------------------
        //verifies that the getCharacters() method of the repository is called.
        verify(repository).getCharacters() // test

        //---------------------------7. Clean Up ---------------------------------
        //Removes the observer from the charactersList LiveData to prevent memory leaks.
        viewModel.charactersList.removeObserver(observer)

    }



}