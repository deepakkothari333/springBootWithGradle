package com.learn.springWithGradle.repositroy

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class TransactionDBModel(
    val targetAccount: String,
    val amount: Double,
    val remarks: String? = ""
) {

@Id
@GeneratedValue
    var id: UUID ? =null
    private set

    val date:Date = Date()
}