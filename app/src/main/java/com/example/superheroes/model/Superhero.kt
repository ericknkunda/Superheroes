package com.example.superheroes.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import java.io.FileDescriptor

data class Superhero(
    @StringRes val superheroName: Int,
    @StringRes val superheroDescriptor: Int,
    @DrawableRes val superheroImage: Int
    )
