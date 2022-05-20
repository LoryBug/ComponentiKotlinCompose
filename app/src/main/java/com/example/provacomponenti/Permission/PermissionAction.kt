package com.example.provacomponenti.Permission

sealed class PermissionAction{
    object OnPermissionGranted : PermissionAction()
    object OnPermissionDenied : PermissionAction()
}
