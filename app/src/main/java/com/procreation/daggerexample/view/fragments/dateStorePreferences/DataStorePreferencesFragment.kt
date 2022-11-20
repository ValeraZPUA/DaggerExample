package com.procreation.daggerexample.view.fragments.dateStorePreferences

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.procreation.daggerexample.databinding.FragmentDataStorePreferencesBinding
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class DataStorePreferencesFragment : Fragment() {

    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

    val EXAMPLE_COUNTER = stringPreferencesKey("example_key")

    private var _binding: FragmentDataStorePreferencesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDataStorePreferencesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListeners()
    }

    private fun setListeners() {
        binding.btnSave.setOnClickListener{
            lifecycleScope.launch {
                saveData()
            }
        }

        binding.btnLoad.setOnClickListener{
            lifecycleScope.launch {
                loadData()
            }
        }
    }

    private suspend fun saveData() {
        context?.dataStore?.edit {
            it[EXAMPLE_COUNTER] = binding.editText.text.toString()
        }
    }

    private suspend fun loadData() {

        binding.textView.text = context?.dataStore?.data?.first()?.get(EXAMPLE_COUNTER) ?: "DEF DATA"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}