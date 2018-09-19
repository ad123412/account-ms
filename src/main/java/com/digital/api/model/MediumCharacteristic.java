package com.digital.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Describes the contact medium characteristics that could be used to contact a party (an individual or an organization)
 **/

/**
 * Describes the contact medium characteristics that could be used to contact a party (an individual or an organization)
 */
@ApiModel(description = "Describes the contact medium characteristics that could be used to contact a party (an individual or an organization)")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2018-09-17T08:21:26.946+05:30")

public class MediumCharacteristic   {
  private String city = null;

  private String country = null;

  private String emailAddress = null;

  private String faxNumber = null;

  private String phoneNumber = null;

  private String postCode = null;

  private String stateOrProvince = null;

  private String street1 = null;

  private String street2 = null;

  private String type = null;

  public MediumCharacteristic city(String city) {
    this.city = city;
    return this;
  }

   /**
   * The city
   * @return city
  **/
  @ApiModelProperty(value = "The city")
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public MediumCharacteristic country(String country) {
    this.country = country;
    return this;
  }

   /**
   * The country
   * @return country
  **/
  @ApiModelProperty(value = "The country")
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public MediumCharacteristic emailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
    return this;
  }

   /**
   * Full email address in standard format
   * @return emailAddress
  **/
  @ApiModelProperty(value = "Full email address in standard format")
  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public MediumCharacteristic faxNumber(String faxNumber) {
    this.faxNumber = faxNumber;
    return this;
  }

   /**
   * The fax number of the contact
   * @return faxNumber
  **/
  @ApiModelProperty(value = "The fax number of the contact")
  public String getFaxNumber() {
    return faxNumber;
  }

  public void setFaxNumber(String faxNumber) {
    this.faxNumber = faxNumber;
  }

  public MediumCharacteristic phoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

   /**
   * The primary phone number of the contact
   * @return phoneNumber
  **/
  @ApiModelProperty(value = "The primary phone number of the contact")
  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public MediumCharacteristic postCode(String postCode) {
    this.postCode = postCode;
    return this;
  }

   /**
   * Postcode
   * @return postCode
  **/
  @ApiModelProperty(value = "Postcode")
  public String getPostCode() {
    return postCode;
  }

  public void setPostCode(String postCode) {
    this.postCode = postCode;
  }

  public MediumCharacteristic stateOrProvince(String stateOrProvince) {
    this.stateOrProvince = stateOrProvince;
    return this;
  }

   /**
   * State or province
   * @return stateOrProvince
  **/
  @ApiModelProperty(value = "State or province")
  public String getStateOrProvince() {
    return stateOrProvince;
  }

  public void setStateOrProvince(String stateOrProvince) {
    this.stateOrProvince = stateOrProvince;
  }

  public MediumCharacteristic street1(String street1) {
    this.street1 = street1;
    return this;
  }

   /**
   * Describes the street
   * @return street1
  **/
  @ApiModelProperty(value = "Describes the street")
  public String getStreet1() {
    return street1;
  }

  public void setStreet1(String street1) {
    this.street1 = street1;
  }

  public MediumCharacteristic street2(String street2) {
    this.street2 = street2;
    return this;
  }

   /**
   * Complementary street description
   * @return street2
  **/
  @ApiModelProperty(value = "Complementary street description")
  public String getStreet2() {
    return street2;
  }

  public void setStreet2(String street2) {
    this.street2 = street2;
  }

  public MediumCharacteristic type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Type of medium (fax, mobile phone...)
   * @return type
  **/
  @ApiModelProperty(value = "Type of medium (fax, mobile phone...)")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MediumCharacteristic mediumCharacteristic = (MediumCharacteristic) o;
    return Objects.equals(this.city, mediumCharacteristic.city) &&
        Objects.equals(this.country, mediumCharacteristic.country) &&
        Objects.equals(this.emailAddress, mediumCharacteristic.emailAddress) &&
        Objects.equals(this.faxNumber, mediumCharacteristic.faxNumber) &&
        Objects.equals(this.phoneNumber, mediumCharacteristic.phoneNumber) &&
        Objects.equals(this.postCode, mediumCharacteristic.postCode) &&
        Objects.equals(this.stateOrProvince, mediumCharacteristic.stateOrProvince) &&
        Objects.equals(this.street1, mediumCharacteristic.street1) &&
        Objects.equals(this.street2, mediumCharacteristic.street2) &&
        Objects.equals(this.type, mediumCharacteristic.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(city, country, emailAddress, faxNumber, phoneNumber, postCode, stateOrProvince, street1, street2, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MediumCharacteristic {\n");
    
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    emailAddress: ").append(toIndentedString(emailAddress)).append("\n");
    sb.append("    faxNumber: ").append(toIndentedString(faxNumber)).append("\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    postCode: ").append(toIndentedString(postCode)).append("\n");
    sb.append("    stateOrProvince: ").append(toIndentedString(stateOrProvince)).append("\n");
    sb.append("    street1: ").append(toIndentedString(street1)).append("\n");
    sb.append("    street2: ").append(toIndentedString(street2)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

