package com.learn.springWithGradle.builder

import com.learn.springWithGradle.repositroy.TransactionDBModel
import java.math.BigDecimal
import java.util.*

data class TransactionDBModelBuilder(
    val targetAccount: String = "ABC123456789",
    val amount: Double = 1000000.5,
    val remarks: String? = "Remarks",
    val id: String = UUID.randomUUID().toString(),
    val date: Date = Date()
) {
    fun build() = TransactionDBModel(
        targetAccount = targetAccount,
        amount = amount,
        remarks = remarks
    )
}