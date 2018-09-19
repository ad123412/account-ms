package com.digital.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.elasticsearch.annotations.Document;


/**
 * BillingCycleSpecification reference. A description of when to initiate a billing cycle and the various sub steps of a billing cycle.
 **/

/**
 * BillingCycleSpecification reference. A description of when to initiate a billing cycle and the various sub steps of a billing cycle.
 */
@ApiModel(description = "BillingCycleSpecification reference. A description of when to initiate a billing cycle and the various sub steps of a billing cycle.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2018-09-17T08:21:26.946+05:30")
@Document(indexName = "billingcyclespecification", type = "account")
public class BillingCycleSpecificationRef   {
  private String referredType = null;

  private Integer dateShift = null;

  private String frequency = null;

  private String href = null;

  private String id = null;

  private String name = null;

  public BillingCycleSpecificationRef referredType(String referredType) {
    this.referredType = referredType;
    return this;
  }

   /**
   * Generic attribute indicating the name of the class type of the referred resource entity.
   * @return referredType
  **/
  @ApiModelProperty(value = "Generic attribute indicating the name of the class type of the referred resource entity.")
  public String getReferredType() {
    return referredType;
  }

  public void setReferredType(String referredType) {
    this.referredType = referredType;
  }

  public BillingCycleSpecificationRef dateShift(Integer dateShift) {
    this.dateShift = dateShift;
    return this;
  }

   /**
   * An offset of a billing/settlement date. The offset is expressed as number of days with regard to the start of the billing/settlement period.
   * @return dateShift
  **/
  @ApiModelProperty(value = "An offset of a billing/settlement date. The offset is expressed as number of days with regard to the start of the billing/settlement period.")
  public Integer getDateShift() {
    return dateShift;
  }

  public void setDateShift(Integer dateShift) {
    this.dateShift = dateShift;
  }

  public BillingCycleSpecificationRef frequency(String frequency) {
    this.frequency = frequency;
    return this;
  }

   /**
   * Frequency of the billing cycle (monthly for instance)
   * @return frequency
  **/
  @ApiModelProperty(value = "Frequency of the billing cycle (monthly for instance)")
  public String getFrequency() {
    return frequency;
  }

  public void setFrequency(String frequency) {
    this.frequency = frequency;
  }

  public BillingCycleSpecificationRef href(String href) {
    this.href = href;
    return this;
  }

   /**
   * Reference of the billing cycle specification
   * @return href
  **/
  @ApiModelProperty(value = "Reference of the billing cycle specification")
  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public BillingCycleSpecificationRef id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Unique identifier of the billing cycle specification
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of the billing cycle specification")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public BillingCycleSpecificationRef name(String name) {
    this.name = name;
    return this;
  }

   /**
   * A short descriptive name
   * @return name
  **/
  @ApiModelProperty(value = "A short descriptive name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BillingCycleSpecificationRef billingCycleSpecificationRef = (BillingCycleSpecificationRef) o;
    return Objects.equals(this.referredType, billingCycleSpecificationRef.referredType) &&
        Objects.equals(this.dateShift, billingCycleSpecificationRef.dateShift) &&
        Objects.equals(this.frequency, billingCycleSpecificationRef.frequency) &&
        Objects.equals(this.href, billingCycleSpecificationRef.href) &&
        Objects.equals(this.id, billingCycleSpecificationRef.id) &&
        Objects.equals(this.name, billingCycleSpecificationRef.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(referredType, dateShift, frequency, href, id, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BillingCycleSpecificationRef {\n");
    
    sb.append("    referredType: ").append(toIndentedString(referredType)).append("\n");
    sb.append("    dateShift: ").append(toIndentedString(dateShift)).append("\n");
    sb.append("    frequency: ").append(toIndentedString(frequency)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

