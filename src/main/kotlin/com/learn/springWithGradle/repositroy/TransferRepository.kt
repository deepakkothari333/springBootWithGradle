package com.learn.springWithGradle.repositroy

import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface TransferRepository: CrudRepository<TransactionDBModel,UUID> {
}