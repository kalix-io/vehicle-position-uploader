package com.matthewcasperson.vehicleposition.domain;

import com.matthewcasperson.vehicleposition.domain.entities.VehiclePosition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class VehiclePositionScheduledUpload {

  private static final Logger LOG = LoggerFactory.getLogger(VehiclePositionScheduledUpload.class);

  @Scheduled(fixedRate = 30000)
  public void reportCurrentTime() {
    LOG.info("Saving a new vehicle position");

    final ResponseEntity<Void> response = WebClient.create("https://frosty-moon-3947.us-east1.kalix.app")
        .post()
        .uri("/position")
        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .body(Mono.just(VehiclePosition.builder()
            .bearing((float) Math.random() * 360.0f)
            .latitude((float) Math.random() * 90.0f)
            .longitude((float) Math.random() * 90.0f)
            .speed((float) Math.random() * 100.0f)
            .odometer((float) Math.random() * 50000.0f)
            .build()
        ), VehiclePosition.class)
        .retrieve()
        .toBodilessEntity()
        .block();

      LOG.info("Response was " + response.getStatusCodeValue());
  }
}
