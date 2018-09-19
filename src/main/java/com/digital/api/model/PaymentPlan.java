package com.digital.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Defines a plan for payment (when a party wants to spread his payments)
 **/

/**
 * Defines a plan for payment (when a party wants to spread his payments)
 */
@ApiModel(description = "Defines a plan for payment (when a party wants to spread his payments)")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2018-09-17T08:21:26.946+05:30")

public class PaymentPlan   {
  private String baseType = null;

  private String schemaLocation = null;

  private String type = null;

  private Integer numberOfPayments = null;

  private String paymentFrequency = null;

  private Integer priority = null;

  private String status = null;

  private Money totalAmount = null;

  private TimePeriod validFor = null;

  private PaymentMethodRef paymentMethod = null;

  public PaymentPlan baseType(String baseType) {
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

  public PaymentPlan schemaLocation(String schemaLocation) {
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
  public PaymentPlan numberOfPayments(Integer numberOfPayments) {
    this.numberOfPayments = numberOfPayments;
    return this;
  }

   /**
   * Number of payments used to spread the global payment
   * @return numberOfPayments
  **/
  @ApiModelProperty(value = "Number of payments used to spread the global payment")
  public Integer getNumberOfPayments() {
    return numberOfPayments;
  }

  public void setNumberOfPayments(Integer numberOfPayments) {
    this.numberOfPayments = numberOfPayments;
  }

  public PaymentPlan paymentFrequency(String paymentFrequency) {
    this.paymentFrequency = paymentFrequency;
    return this;
  }

   /**
   * Frequency of the payments, such as monthly and bimonthly
   * @return paymentFrequency
  **/
  @ApiModelProperty(value = "Frequency of the payments, such as monthly and bimonthly")
  public String getPaymentFrequency() {
    return paymentFrequency;
  }

  public void setPaymentFrequency(String paymentFrequency) {
    this.paymentFrequency = paymentFrequency;
  }

  public PaymentPlan priority(Integer priority) {
    this.priority = priority;
    return this;
  }

   /**
   * Priority of the payment plan
   * @return priority
  **/
  @ApiModelProperty(value = "Priority of the payment plan")
  public Integer getPriority() {
    return priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  public PaymentPlan status(String status) {
    this.status = status;
    return this;
  }

   /**
   * Status of the payment plan (effective, ineffective)
   * @return status
  **/
  @ApiModelProperty(value = "Status of the payment plan (effective, ineffective)")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public PaymentPlan totalAmount(Money totalAmount) {
    this.totalAmount = totalAmount;
    return this;
  }

   /**
   * Amount paid
   * @return totalAmount
  **/
  @ApiModelProperty(value = "Amount paid")
  public Money getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(Money totalAmount) {
    this.totalAmount = totalAmount;
  }

  public PaymentPlan type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Type of payment plan
   * @return type
  **/
  @ApiModelProperty(value = "Type of payment plan")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public PaymentPlan validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

   /**
   * Validity period of the payment plan
   * @return validFor
  **/
  @ApiModelProperty(value = "Validity period of the payment plan")
  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public PaymentPlan paymentMethod(PaymentMethodRef paymentMethod) {
    this.paymentMethod = paymentMethod;
    return this;
  }

   /**
   * Get paymentMethod
   * @return paymentMethod
  **/
  @ApiModelProperty(value = "")
  public PaymentMethodRef getPaymentMethod() {
    return paymentMethod;
  }

  public void setPaymentMethod(PaymentMethodRef paymentMethod) {
    this.paymentMethod = paymentMethod;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentPlan paymentPlan = (PaymentPlan) o;
    return Objects.equals(this.baseType, paymentPlan.baseType) &&
        Objects.equals(this.schemaLocation, paymentPlan.schemaLocation) &&
        Objects.equals(this.type, paymentPlan.type) &&
        Objects.equals(this.numberOfPayments, paymentPlan.numberOfPayments) &&
        Objects.equals(this.paymentFrequency, paymentPlan.paymentFrequency) &&
        Objects.equals(this.priority, paymentPlan.priority) &&
        Objects.equals(this.status, paymentPlan.status) &&
        Objects.equals(this.totalAmount, paymentPlan.totalAmount) &&
        Objects.equals(this.type, paymentPlan.type) &&
        Objects.equals(this.validFor, paymentPlan.validFor) &&
        Objects.equals(this.paymentMethod, paymentPlan.paymentMethod);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, type, numberOfPayments, paymentFrequency, priority, status, totalAmount, type, validFor, paymentMethod);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentPlan {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    numberOfPayments: ").append(toIndentedString(numberOfPayments)).append("\n");
    sb.append("    paymentFrequency: ").append(toIndentedString(paymentFrequency)).append("\n");
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    totalAmount: ").append(toIndentedString(totalAmount)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    paymentMethod: ").append(toIndentedString(paymentMethod)).append("\n");
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

