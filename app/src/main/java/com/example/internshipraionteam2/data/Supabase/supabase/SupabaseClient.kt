package com.example.internshipraionteam2.data.Supabase.supabase

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.GoTrue
import io.github.jan.supabase.storage.Storage

object SupabaseClient {
    val client = createSupabaseClient(
        supabaseUrl = "https://ujpaetwqzaklppgsqvof.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InVqcGFldHdxemFrbHBwZ3Nxdm9mIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDE5NzIxMTEsImV4cCI6MjA1NzU0ODExMX0.IK7VCUjxSzqcTxOGp-HDOPEoXiunPnmcameta0IJBww"
    ){
        install(GoTrue)
        install(Storage)
    }
}