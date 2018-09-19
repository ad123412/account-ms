package com.digital.api.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Account reference. A account may be a party account or a financial account.
 **/

/**
 * Account reference. A account may be a party account or a financial account.
 */
@ApiModel(description = "Account reference. A account may be a party account or a financial account.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2018-09-17T08:21:26.946+05:30")

public class AccountRef   {
  private String referredType = null;

  private String description = null;

  private String href = null;

  private String id = null;

  private String name = null;

  public AccountRef referredType(String referredType) {
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

  public AccountRef description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Detailed description of the account
   * @return description
  **/
  @ApiModelProperty(value = "Detailed description of the account")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public AccountRef href(String href) {
    this.href = href;
    return this;
  }

   /**
   * Reference of the account
   * @return href
  **/
  @ApiModelProperty(value = "Reference of the account")
  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public AccountRef id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Unique identifier of the account
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of the account")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public AccountRef name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name of the account
   * @return name
  **/
  @ApiModelProperty(value = "Name of the account")
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
    AccountRef accountRef = (AccountRef) o;
    return Objects.equals(this.referredType, accountRef.referredType) &&
        Objects.equals(this.description, accountRef.description) &&
        Objects.equals(this.href, accountRef.href) &&
        Objects.equals(this.id, accountRef.id) &&
        Objects.equals(this.name, accountRef.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(referredType, description, href, id, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountRef {\n");
    
    sb.append("    referredType: ").append(toIndentedString(referredType)).append("\n");
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

