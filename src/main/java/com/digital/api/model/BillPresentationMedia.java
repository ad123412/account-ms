package com.digital.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * A mean of communicating a bill, supported by the associated bill format. For example, post mail, email, web page.
 **/

/**
 * A mean of communicating a bill, supported by the associated bill format. For example, post mail, email, web page.
 */
@ApiModel(description = "A mean of communicating a bill, supported by the associated bill format. For example, post mail, email, web page.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2018-09-17T08:21:26.946+05:30")

public class BillPresentationMedia   {
  private String baseType = null;

  private String schemaLocation = null;

  private String type = null;

  private String description = null;

  private String href = null;

  private String id = null;

  private String name = null;

  public BillPresentationMedia baseType(String baseType) {
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

  public BillPresentationMedia schemaLocation(String schemaLocation) {
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

  public BillPresentationMedia type(String type) {
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

  public BillPresentationMedia description(String description) {
    this.description = description;
    return this;
  }

   /**
   * An explanatory text describing this bill presentation media
   * @return description
  **/
  @ApiModelProperty(value = "An explanatory text describing this bill presentation media")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BillPresentationMedia href(String href) {
    this.href = href;
    return this;
  }

   /**
   * Reference of the bill presentation media
   * @return href
  **/
  @ApiModelProperty(value = "Reference of the bill presentation media")
  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public BillPresentationMedia id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Unique identifier of the bill presentation media
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of the bill presentation media")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public BillPresentationMedia name(String name) {
    this.name = name;
    return this;
  }

   /**
   * A short descriptive name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "A short descriptive name")
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
    BillPresentationMedia billPresentationMedia = (BillPresentationMedia) o;
    return Objects.equals(this.baseType, billPresentationMedia.baseType) &&
        Objects.equals(this.schemaLocation, billPresentationMedia.schemaLocation) &&
        Objects.equals(this.type, billPresentationMedia.type) &&
        Objects.equals(this.description, billPresentationMedia.description) &&
        Objects.equals(this.href, billPresentationMedia.href) &&
        Objects.equals(this.id, billPresentationMedia.id) &&
        Objects.equals(this.name, billPresentationMedia.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, type, description, href, id, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BillPresentationMedia {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

