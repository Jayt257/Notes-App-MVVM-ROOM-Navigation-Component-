package com.jaytaravia.dailynotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.jaytaravia.dailynotes.database.NoteDatabase
import com.jaytaravia.dailynotes.repository.NoteRepository
import com.jaytaravia.dailynotes.viewmodel.NoteViewModel
import com.jaytaravia.dailynotes.viewmodel.NoteViewModelFactory


import com.mastercoding.notetakingapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var  noteViewModel : NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViewModel()



    }

    private fun setUpViewModel() {
        val noteRepository = NoteRepository(NoteDatabase(this))

        val viewModelProviderFactory = NoteViewModelFactory(application,
            noteRepository)

         noteViewModel = ViewModelProvider(
             this,
             viewModelProviderFactory)
             .get(NoteViewModel::class.java)
    }
}
