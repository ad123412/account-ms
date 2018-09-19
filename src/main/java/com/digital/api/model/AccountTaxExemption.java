package com.digital.api.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;


/**
 * Proof of freedom from taxes imposed by a taxing jurisdiction
 **/

/**
 * Proof of freedom from taxes imposed by a taxing jurisdiction
 */
@ApiModel(description = "Proof of freedom from taxes imposed by a taxing jurisdiction")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2018-09-17T08:21:26.946+05:30")
@Document(indexName = "accounttaxexemption", type = "account")
public class AccountTaxExemption   {

  @Id
  private String id;

  private String baseType = null;

  private String schemaLocation = null;

  private String type = null;

  private String certificateNumber = null;

  private String issuingJurisdiction = null;

  private String reason = null;

  private TimePeriod validFor = null;

  public AccountTaxExemption baseType(String baseType) {
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

  public AccountTaxExemption schemaLocation(String schemaLocation) {
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

  public AccountTaxExemption type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Generic attribute containing the name of the resource class type
   * @return type
  **/
  @ApiModelProperty(value = "Generic attribute containing the name of the resource class type")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public AccountTaxExemption certificateNumber(String certificateNumber) {
    this.certificateNumber = certificateNumber;
    return this;
  }

   /**
   * Identifier of a document that shows proof of exemption from taxes for the taxing jurisdiction
   * @return certificateNumber
  **/
  @ApiModelProperty(value = "Identifier of a document that shows proof of exemption from taxes for the taxing jurisdiction")
  public String getCertificateNumber() {
    return certificateNumber;
  }

  public void setCertificateNumber(String certificateNumber) {
    this.certificateNumber = certificateNumber;
  }

  public AccountTaxExemption issuingJurisdiction(String issuingJurisdiction) {
    this.issuingJurisdiction = issuingJurisdiction;
    return this;
  }

   /**
   * Name of the taxing jurisdiction for which taxes are exempt
   * @return issuingJurisdiction
  **/
  @ApiModelProperty(required = true, value = "Name of the taxing jurisdiction for which taxes are exempt")
  public String getIssuingJurisdiction() {
    return issuingJurisdiction;
  }

  public void setIssuingJurisdiction(String issuingJurisdiction) {
    this.issuingJurisdiction = issuingJurisdiction;
  }

  public AccountTaxExemption reason(String reason) {
    this.reason = reason;
    return this;
  }

   /**
   * Reason of the tax exemption
   * @return reason
  **/
  @ApiModelProperty(value = "Reason of the tax exemption")
  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public AccountTaxExemption validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

   /**
   * Period for which the exemption is valid
   * @return validFor
  **/
  @ApiModelProperty(required = true, value = "Period for which the exemption is valid")
  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountTaxExemption accountTaxExemption = (AccountTaxExemption) o;
    return Objects.equals(this.baseType, accountTaxExemption.baseType) &&
        Objects.equals(this.schemaLocation, accountTaxExemption.schemaLocation) &&
        Objects.equals(this.type, accountTaxExemption.type) &&
        Objects.equals(this.certificateNumber, accountTaxExemption.certificateNumber) &&
        Objects.equals(this.issuingJurisdiction, accountTaxExemption.issuingJurisdiction) &&
        Objects.equals(this.reason, accountTaxExemption.reason) &&
        Objects.equals(this.validFor, accountTaxExemption.validFor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, type, certificateNumber, issuingJurisdiction, reason, validFor);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountTaxExemption {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    certificateNumber: ").append(toIndentedString(certificateNumber)).append("\n");
    sb.append("    issuingJurisdiction: ").append(toIndentedString(issuingJurisdiction)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
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

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}

