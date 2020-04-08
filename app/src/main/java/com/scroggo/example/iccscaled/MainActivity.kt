package com.scroggo.example.iccscaled

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private fun getId(num: Int, scaled: Boolean): Int {
        return resources.getIdentifier("image_${num}_${if (scaled) "scaled" else "normal"}",
                "id", packageName)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val images = listOf<String>("EPSON  Gray - Gamma 2.2.jpg",
                "Generic Gray Gamma 2.2 Profile.jpg",
                "Happy-Test-Screen_Generic Gray Gamma 2.2 Profile.jpg",
                "Test-Screen_GIMP built-in D65 Grayscale with sRGB TRC.jpg")
        for ((index, image) in images.withIndex()) {
            val imageView = findViewById<ImageView>(getId(index, false))
            val source = ImageDecoder.createSource(assets, image)
            val bitmap = ImageDecoder.decodeBitmap(source)
            imageView.setImageBitmap(bitmap)

            val scaledImageView = findViewById<ImageView>(getId(index, true))
            val scaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.width / 4,
                    bitmap.height / 4, true)
            scaledImageView.setImageBitmap(scaledBitmap)
        }
    }
}
