package com.example.permission_model

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.basicofkotlin.databinding.SixPermissionMedelBinding
import java.io.File
import java.io.FileOutputStream

class PermissionModel : AppCompatActivity(), View.OnClickListener {

    // Variables
    private lateinit var binding: SixPermissionMedelBinding
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>
    private var isExternalPermission = false
    private var isCameraPermission = false
    private var isLocationPermission = false
    private var cameraRequestCode = 100
    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { getImage ->
        val imageBitmap = getImage.data?.extras?.get("data") as Bitmap
        saveImage(imageBitmap)
        binding.imgPhoto.setImageBitmap(imageBitmap)
    }

    //Override Functions
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SixPermissionMedelBinding.inflate(layoutInflater)
        val view = binding.root
        binding.onClicked = this
        setContentView(view)
        singlePermission(Manifest.permission.ACCESS_FINE_LOCATION, cameraRequestCode)
        permissionLauncher = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permission ->
            isExternalPermission = permission[Manifest.permission.READ_EXTERNAL_STORAGE] ?: isExternalPermission
            isCameraPermission = permission[Manifest.permission.CAMERA] ?: isCameraPermission
        }
    }

    // Function
    override fun onClick(view: View) {
        when(view.id) {
            binding.btnCreatePdf.id -> startCreating()
        }
    }

    private fun startCreating() {
        if (isCameraPermission && isExternalPermission) {
            captureImages()
        } else {
            checkPermission()
        }
    }

    private fun captureImages() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply {
            launcher.launch(this)
        }
    }

    private fun saveImage(image: Bitmap) {
        val root = Environment.getExternalStorageDirectory().toString()
        val myDir = File("$root/Download")
        if (!myDir.exists())
            myDir.mkdirs()
        val imageName = "Image.jpg"
        val file = File(myDir, imageName)
        try {
            val out = FileOutputStream(file)
            image.compress(Bitmap.CompressFormat.JPEG, 100, out)
            out.flush()
            out.close()
        } catch (e: Exception) {
            Log.d("Error", e.message.toString())
        }
    }

    private fun checkPermission() {
        isExternalPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
        isCameraPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
        val requestPermission: MutableList<String> = ArrayList()
        if (!isExternalPermission)
            requestPermission.add(Manifest.permission.READ_EXTERNAL_STORAGE)
        if(!isCameraPermission)
            requestPermission.add(Manifest.permission.CAMERA)
        if(requestPermission.isNotEmpty()) {
            permissionLauncher.launch(requestPermission.toTypedArray())
        }
    }

    private fun singlePermission(permission: String, requestCode: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
                ActivityCompat.requestPermissions(this, arrayOf(permission), requestCode)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
            isLocationPermission = true
        else
            Toast.makeText(this, "Not Granted", Toast.LENGTH_SHORT).show()
    }

}