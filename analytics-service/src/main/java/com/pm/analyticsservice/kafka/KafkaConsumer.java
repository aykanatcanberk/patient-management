package com.pm.analyticsservice.kafka;

import com.google.protobuf.InvalidProtocolBufferException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import patient.events.PatientEvent;

@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "patient" , groupId = "analytics-service")
    public void consume(byte[] event) {
        try {
            PatientEvent patient = PatientEvent.parseFrom(event);
            log.info("Patient Id: {}, Patient Name: {}, Email: {}"
                    , patient.getPatientId(), patient.getName(), patient.getEmail());

        } catch (InvalidProtocolBufferException e) {
            log.error("Error parsing event {}", e.getMessage());
        }
    }
}
