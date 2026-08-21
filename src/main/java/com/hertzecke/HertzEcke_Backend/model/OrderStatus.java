package com.hertzecke.HertzEcke_Backend.model;

public enum OrderStatus {
    PENDING,            // order created, payment not yet captured
    PAID,               // payment captured via PayPal
    SENT_TO_LIGHTSPEED, // pushed to Lightspeed POS successfully
    FAILED              // payment or Lightspeed step failed
}