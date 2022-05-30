package com.example.provacomponenti.permission

sealed class PermissionAction{
    object OnPermissionGranted : PermissionAction()
    object OnPermissionDenied : PermissionAction()
}
