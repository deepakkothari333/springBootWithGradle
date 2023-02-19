package com.learn.springWithGradle.builder

import com.learn.springWithGradle.model.TransferIn

data class TransferInBuilder (
    val targetAccount: String = "ABC123456789",
    val amount: Double = 1000.50,
    val remarks: String? = "Transfer IN"
){
    fun build() = TransferIn(
        targetAccount = targetAccount,
        amount = amount,
        remarks = remarks
    )
}