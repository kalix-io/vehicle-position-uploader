package com.matthewcasperson.vehicleposition.domain.entities;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Builder
@Jacksonized
@Data
public class VehiclePosition {
  private float speed;
  private float odometer;
  private float latitude;
  private float longitude;
  private float bearing;
}
