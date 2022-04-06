package com.sunil.myapplication

import android.Manifest
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.sunil.myapplication.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private val PermissionsRequestCode = 123
    private lateinit var managePermissions: ManagePermissions
    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize a list of required permissions to request runtime
        val list = listOf<String>(
           // Manifest.permission.CAMERA,
           // Manifest.permission.READ_EXTERNAL_STORAGE
            Manifest.permission.BLUETOOTH_SCAN,
                    Manifest.permission.BLUETOOTH_CONNECT,

        )

        // Initialize a new instance of ManagePermissions class
        managePermissions = ManagePermissions(requireActivity(),list,PermissionsRequestCode)
        binding.buttonFirst.setOnClickListener {
           // findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
                managePermissions.checkPermissions()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}