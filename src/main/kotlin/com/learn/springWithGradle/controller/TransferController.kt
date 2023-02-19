package com.learn.springWithGradle.controller

import com.learn.springWithGradle.model.TransferIn
import com.learn.springWithGradle.model.TransferRecord
import com.learn.springWithGradle.model.toTransactionDBModel
import com.learn.springWithGradle.model.toTransferRecord
import com.learn.springWithGradle.repositroy.TransferRepository
import org.apache.coyote.Response
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/transfer")
class TransferController(val repository: TransferRepository) {

    @PostMapping("/new")
    fun newTransfer(@RequestBody transferIn: TransferIn) = ResponseEntity.ok(repository.save(transferIn.toTransactionDBModel()))

    @GetMapping("/all")
    fun getAllTransfer(): List<TransferRecord> = repository.findAll().map { it.toTransferRecord() }
}