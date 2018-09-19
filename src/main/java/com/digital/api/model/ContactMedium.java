package com.digital.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.elasticsearch.annotations.Document;


/**
 * Indicates the contact medium that could be used to contact the party.
 **/

/**
 * Indicates the contact medium that could be used to contact the party.
 */
@ApiModel(description = "Indicates the contact medium that could be used to contact the party.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2018-09-17T08:21:26.946+05:30")
public class ContactMedium   {
  private String baseType = null;

  private String schemaLocation = null;

  private String type = null;

  private Boolean preferred = null;

  private TimePeriod validFor = null;

  private MediumCharacteristic characteristic = null;

  public ContactMedium baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

   /**
   * Generic attribute indicating the base class type of the extension class of the current object. Useful only when the class type of the current  object is unknown to the implementation.
   * @return baseType
  **/
  @ApiModelProperty(value = "Generic attribute indicating the base class type of the extension class of the current object. Useful only when the class type of the current  object is unknown to the implementation.")
  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }

  public ContactMedium schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

   /**
   * Generic attribute containing the link to the schema that defines the structure of the class type of the current object.
   * @return schemaLocation
  **/
  @ApiModelProperty(value = "Generic attribute containing the link to the schema that defines the structure of the class type of the current object.")
  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public ContactMedium type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Generic attribute containing the name of the resource class type
   * @return type

  @ApiModelProperty(value = "Generic attribute containing the name of the resource class type")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
    **/

  public ContactMedium preferred(Boolean preferred) {
    this.preferred = preferred;
    return this;
  }

   /**
   * If true, indicates that is the preferred contact medium
   * @return preferred
  **/
  @ApiModelProperty(value = "If true, indicates that is the preferred contact medium")
  public Boolean getPreferred() {
    return preferred;
  }

  public void setPreferred(Boolean preferred) {
    this.preferred = preferred;
  }

  /**
  public ContactMedium type(String type) {
    this.type = type;
    return this;
  }
   **/

   /**
   * Type of the contact medium, such as: email address, telephone number, postal address
   * @return type
  **/
  @ApiModelProperty(value = "Type of the contact medium, such as: email address, telephone number, postal address")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ContactMedium validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

   /**
   * The time period that the contact medium is valid for
   * @return validFor
  **/
  @ApiModelProperty(value = "The time period that the contact medium is valid for")
  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public ContactMedium characteristic(MediumCharacteristic characteristic) {
    this.characteristic = characteristic;
    return this;
  }

   /**
   * Get characteristic
   * @return characteristic
  **/
  @ApiModelProperty(value = "")
  public MediumCharacteristic getCharacteristic() {
    return characteristic;
  }

  public void setCharacteristic(MediumCharacteristic characteristic) {
    this.characteristic = characteristic;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContactMedium contactMedium = (ContactMedium) o;
    return Objects.equals(this.baseType, contactMedium.baseType) &&
        Objects.equals(this.schemaLocation, contactMedium.schemaLocation) &&
        Objects.equals(this.type, contactMedium.type) &&
        Objects.equals(this.preferred, contactMedium.preferred) &&
        Objects.equals(this.validFor, contactMedium.validFor) &&
        Objects.equals(this.characteristic, contactMedium.characteristic);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, type, preferred, type, validFor, characteristic);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContactMedium {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    preferred: ").append(toIndentedString(preferred)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    characteristic: ").append(toIndentedString(characteristic)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

