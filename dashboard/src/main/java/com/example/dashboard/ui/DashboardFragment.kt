package com.example.dashboard.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.dashboard.R
import com.google.android.gms.common.wrappers.InstantApps.isInstantApp
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

private val loadModules by lazy {loadKoinModules(viewModelModule)}
private fun injectFeatures() = loadModules

class DashboardFragment : Fragment(){

    private val dashboardViewModel by viewModel<DashboardViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Load the modules
        injectFeatures()

        //Load fragment
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)

        //Screen text
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        //Check if instant app or not
        val instantExpText: TextView = root.findViewById(R.id.text_instantExperience)
        if (isInstantApp(context)){
            instantExpText.text = getString(R.string.instant_detect_true)
        } else {
            instantExpText.text = getString(R.string.instant_detect_false)
        }

        return root
    }
}

