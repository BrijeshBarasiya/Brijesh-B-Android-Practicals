package com.example.intent_activity_fragment

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.basicofkotlin.databinding.ThreeDFragmentGalleryBinding


class Gallery : Fragment() {

    private lateinit var binding: ThreeDFragmentGalleryBinding
    private var requestCode = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ThreeDFragmentGalleryBinding.inflate(layoutInflater)
        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { getImage ->
            val data: Intent? = getImage.data
            val imgUri: Uri? = data?.data
            if (imgUri != null) {
                binding.gllyImage.setImageURI(imgUri)
            }
        }
        binding.fabGallary.setOnClickListener {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            launcher.launch(intent)
        }
        binding.fabPhoto.setOnClickListener {
            requestCode = 100
            startActivityForResult(Intent(MediaStore.ACTION_IMAGE_CAPTURE), requestCode)
        }
    }
    override fun onActivityResult(rcode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(rcode, resultCode, data)
        if (resultCode == RESULT_OK && rcode == requestCode) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            binding.gllyImage.setImageBitmap(imageBitmap)
        }
    }

}