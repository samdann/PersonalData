package com.blackchain.com.blackchain.adapters.couchsurfing.domain

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.ZonedDateTime

data class MessagesWrapper(
    @JsonProperty("messages") val messages: Messages
)

data class Messages(
    @JsonProperty("messages") val messages: List<MessageThread>
)

data class MessageThread(
    @JsonProperty("user_ids_concatenated") val userIdsConcatenated: String,
    @JsonProperty("created_at") val createdAt: ZonedDateTime,
    @JsonProperty("updated_at") val updatedAt: ZonedDateTime,
    @JsonProperty("cushions_id") val cushionsId: String,
    @JsonProperty("cushions_uid") val cushionsUid: String,
    @JsonProperty("cushions_requestor_uid") val cushionsRequestorUid: String,
    @JsonProperty("cushions_chat_id") val cushionsChatId: String?,
    @JsonProperty("cushions_last_couch_stay_id") val cushionsLastCouchStayId: String?,
    @JsonProperty("messages") val messages: List<Message>
)

data class Message(
    @JsonProperty("id") val id: Long,
    @JsonProperty("system_message") val systemMessage: Map<String, Any>,
    @JsonProperty("message_thread_id") val messageThreadId: Long,
    @JsonProperty("author_id") val authorId: Long,
    @JsonProperty("body") val body: String,
    @JsonProperty("deleted_at") val deletedAt: ZonedDateTime?,
    @JsonProperty("created_at") val createdAt: ZonedDateTime,
    @JsonProperty("updated_at") val updatedAt: ZonedDateTime,
    @JsonProperty("cushions_uid") val cushionsUid: String
)