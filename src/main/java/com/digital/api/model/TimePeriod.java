package com.digital.api.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.joda.deser.DateTimeDeserializer;
import com.fasterxml.jackson.datatype.joda.ser.DateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.joda.time.DateTime;



/**
 * A base / value business entity used to represent a period of time between two timepoints.
 **/

/**
 * A base / value business entity used to represent a period of time between two timepoints.
 */
@ApiModel(description = "A base / value business entity used to represent a period of time between two timepoints.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2018-09-17T08:21:26.946+05:30")

public class TimePeriod   {

  //private DateTime endDateTime = null;

  //private DateTime startDateTime = null;

  private String endDateTime = null;

  private String startDateTime = null;

  public TimePeriod endDateTime(String endDateTime) {
    this.endDateTime = endDateTime;
    return this;
  }

  public TimePeriod startDateTime(String startDateTime) {
    this.startDateTime = startDateTime;
    return this;
  }

  public String getEndDateTime() {
    return endDateTime;
  }

  public void setEndDateTime(String endDateTime) {
    this.endDateTime = endDateTime;
  }

  public String getStartDateTime() {
    return startDateTime;
  }

  public void setStartDateTime(String startDateTime) {
    this.startDateTime = startDateTime;
  }
}

