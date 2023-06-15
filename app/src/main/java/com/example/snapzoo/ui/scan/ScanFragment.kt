package com.example.snapzoo.ui.scan

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.snapzoo.databinding.FragmentScanBinding
import com.example.snapzoo.model.AnimalResponse
import com.example.snapzoo.rotateFile
import com.example.snapzoo.ui.CameraActivity
import com.example.snapzoo.ui.search.SearchFragment
import com.example.snapzoo.ui.detail.DetailActivity
import java.io.File


@Suppress("UNREACHABLE_CODE")
class ScanFragment : Fragment() {

    private lateinit var binding: FragmentScanBinding
    private lateinit var scanViewModel: ScanViewModel

    companion object {
        const val CAMERA_X_RESULT = 200
        const val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private fun checkCameraPermission() {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_DENIED
        ) {
            launchCameraPermission.launch(Manifest.permission.CAMERA)
        } else openCamera()
    }

    private val launchCameraPermission = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { result ->
        if (result) openCamera()
        else {
            Toast.makeText(
                requireContext(),
                "Tidak mendapatkan permission.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun openCamera() {
        val intent = Intent(requireContext(), CameraActivity::class.java)
        launcherIntentCamera.launch(intent)

    }

    private val launcherIntentCamera = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){
        if(it.resultCode == CAMERA_X_RESULT){
            val myFile = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
                it.data?.getSerializableExtra("picture", File::class.java)
            } else {
                @Suppress("DEPRECATION")
                it.data?.getSerializableExtra("picture")
            } as? File

            val isBackCamera = it.data?.getBooleanExtra("isBackCamera",true) as Boolean

            myFile?.let {file ->
                rotateFile(file,isBackCamera)
                 binding.previewImage.setImageBitmap(BitmapFactory.decodeFile(file.path))


                    binding.confirmButton.setOnClickListener {
                        showLoading(true)
                        sendImageToApi(file)
                    }



            }
        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScanBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()

        scanViewModel = ViewModelProvider(this).get(ScanViewModel::class.java)

        scanViewModel.isLoading.observe(viewLifecycleOwner, Observer { isLoading ->
            showLoading(isLoading)
        })

        scanViewModel.animalResponse.observe(viewLifecycleOwner, Observer { animalResponse ->
            navigateToDetail(animalResponse)
        })

        scanViewModel.errorMessage.observe(viewLifecycleOwner, { errorMessage ->
            errorMessage?.let {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        })


    }

    private fun setupClickListeners() {
        binding.cameraButton.setOnClickListener { startCamera() }

    }



    private fun startCamera() {

            checkCameraPermission()

    }

    private fun sendImageToApi(myFile : File){
        scanViewModel.sendImage(myFile)
    }



    private fun navigateToDetail(animalResponse: AnimalResponse) {


        val intent = Intent(requireContext(), DetailActivity::class.java)
        intent.putExtra(SearchFragment.INTENT_PARCELABLE, animalResponse)
        startActivity(intent)
    }

    private fun showLoading(loading: Boolean) {
        when(loading) {
            true -> {
                binding.confirmButton.visibility = View.GONE
                binding.progressBar.visibility = View.VISIBLE
            }
            false -> {
                binding.confirmButton.visibility = View.VISIBLE
                binding.progressBar.visibility = View.GONE
            }
        }
    }


}













