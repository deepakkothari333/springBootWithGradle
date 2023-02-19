package com.learn.springWithGradle.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.learn.springWithGradle.builder.TransactionDBModelBuilder
import com.learn.springWithGradle.builder.TransferInBuilder
import com.learn.springWithGradle.repositroy.TransferRepository
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest
internal class TransferControllerTest(@Autowired val mockMvc: MockMvc) {

    @MockkBean
    private lateinit var repository: TransferRepository

    fun `should save a new transfer with success`() {
        every { repository.save(any()) } returns mockk()
        mockMvc.perform(
            post("/transfer/new")
                .content(ObjectMapper().writeValueAsString(TransferInBuilder().build()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        ).andDo(print())
            .andExpect(status().is2xxSuccessful)
    }

    @Test
    fun `should get all transactions`() {

        every { repository.findAll() } returns listOf(TransactionDBModelBuilder().build())

        mockMvc.perform(get("/transfer/all").accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().is2xxSuccessful())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("\$[0].remarks").value("Remarks"))
    }

    @Test
    fun `should give bad request if no body`() {
        every { repository.save(any()) } returns mockk()
        mockMvc.perform(
            post("/transfer/new")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        ).andDo(print())
            .andExpect(status().is4xxClientError())
    }

}