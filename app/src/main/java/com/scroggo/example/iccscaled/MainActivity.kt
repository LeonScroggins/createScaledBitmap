package com.scroggo.example.iccscaled

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val images = listOf<String>("EPSON  Gray - Gamma 2.2.jpg")
        for ((index, image) in images.withIndex()) {
            val imageView = findViewById<ImageView>(R.id.image_0_normal)
            val source = ImageDecoder.createSource(assets, image)
            val bitmap = ImageDecoder.decodeBitmap(source)
            imageView.setImageBitmap(bitmap)

            val scaledImageView = findViewById<ImageView>(R.id.image_0_scaled)
            val scaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.width / 4,
                    bitmap.height / 4, true)
            scaledImageView.setImageBitmap(scaledBitmap)
        }
    }
}
