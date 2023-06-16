package com.example.bismillah.ui.bmi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.bismillah.databinding.FragmentBmiBinding
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException


class BmiFragment : Fragment() {

    private val client = OkHttpClient()

    private fun sendRequestToAPI() {

        val url = " https://backend-4ar4xydreq-et.a.run.app/api/generate-token"

        val request = Request.Builder()
            .url(url)
            .build()

        try {
            val response = client.newCall(request).execute()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private var _binding: FragmentBmiBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentBmiBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

   

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}