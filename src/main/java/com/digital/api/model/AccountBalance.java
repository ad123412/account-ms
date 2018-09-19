package com.digital.api.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Balances linked to the account
 **/

/**
 * Balances linked to the account
 */
@ApiModel(description = "Balances linked to the account")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2018-09-17T08:21:26.946+05:30")
@Document(indexName = "balance", type = "account")
public class AccountBalance   {

  @Id
  private String id;

  private String baseType = null;

  private String schemaLocation = null;

  private String type = null;

  private Money amount = null;

  private TimePeriod validFor = null;

  public AccountBalance baseType(String baseType) {
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

  public AccountBalance schemaLocation(String schemaLocation) {
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
  public AccountBalance amount(Money amount) {
    this.amount = amount;
    return this;
  }

   /**
   * Balance amount
   * @return amount
  **/
  @ApiModelProperty(required = true, value = "Balance amount")
  public Money getAmount() {
    return amount;
  }

  public void setAmount(Money amount) {
    this.amount = amount;
  }

  public AccountBalance type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Type of the balance : deposit balance, disputed balance, loyalty balance, receivable balance...
   * @return type
  **/
  @ApiModelProperty(required = true, value = "Type of the balance : deposit balance, disputed balance, loyalty balance, receivable balance...")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public AccountBalance validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

   /**
   * Balance validity period
   * @return validFor
  **/
  @ApiModelProperty(required = true, value = "Balance validity period")
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
    AccountBalance accountBalance = (AccountBalance) o;
    return Objects.equals(this.baseType, accountBalance.baseType) &&
        Objects.equals(this.schemaLocation, accountBalance.schemaLocation) &&
        Objects.equals(this.type, accountBalance.type) &&
        Objects.equals(this.amount, accountBalance.amount) &&
        Objects.equals(this.type, accountBalance.type) &&
        Objects.equals(this.validFor, accountBalance.validFor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, type, amount, type, validFor);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountBalance {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

