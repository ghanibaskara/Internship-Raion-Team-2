package com.example.internshipraionteam2.data.Supabase.supabase.utils

import android.content.Context
import android.net.Uri
import io.ktor.utils.io.errors.IOException

@Throws(IOException::class)
fun Uri.uriToByteArray(context: Context) =
    context.contentResolver.openInputStream(this)?.use { it.buffered().readBytes() }