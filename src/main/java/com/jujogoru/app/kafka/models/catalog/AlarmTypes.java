package com.jujogoru.app.kafka.models.catalog;

/**
 * Listing of <strong>types</strong> for an alarm.
 */
public enum AlarmTypes {

  /**
   * Alarm type for bigger prices.
   */
  BIGGER,

  /**
   * Alarm type for lower prices.
   */
  LOWER,

  /**
   * Alarm type for equal prices.
   */
  EQUALS,

  /**
   * Alarm type for prices percentage variation.
   */
  PERCENTAGE_VARIATION
}