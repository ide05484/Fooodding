package com.fooding.api.fcm.service;

import com.fooding.api.fcm.service.dto.FcmMessageDto;
import com.google.firebase.messaging.FirebaseMessagingException;

public interface FcmMessageService {

	void sendMessages(Long ownerId, FcmMessageDto fcmMessageDto) throws FirebaseMessagingException;

	void sendMessagesToOwners(FcmMessageDto fcmMessageDto) throws FirebaseMessagingException;

}