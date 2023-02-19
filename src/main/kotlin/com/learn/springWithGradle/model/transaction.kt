package com.learn.springWithGradle.model

import com.learn.springWithGradle.repositroy.TransactionDBModel
import java.util.*

class TransferIn(
    val targetAccount: String,
    val amount: Double,
    val remarks: String?
)

class TransferRecord(
    val targetAccount: String,
    val amount: Double,
    val remarks: String?,
    val date: Date,
    val id: String,
)

fun TransferIn.toTransactionDBModel() = TransactionDBModel(
    targetAccount = this.targetAccount,
    amount = this.amount,
    remarks = this.remarks
)

fun TransactionDBModel.toTransferRecord() = TransferRecord(
    id = this.id.toString(),
    date = this.date,
    targetAccount = this.targetAccount,
    amount = this.amount,
    remarks = this.remarks,
)