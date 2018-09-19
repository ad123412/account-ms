package com.digital.api.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;


/**
 * Significant connection between accounts. For instance an aggregating account for a list of shop branches each having its own billing account.
 **/

/**
 * Significant connection between accounts. For instance an aggregating account for a list of shop branches each having its own billing account.
 */
@ApiModel(description = "Significant connection between accounts. For instance an aggregating account for a list of shop branches each having its own billing account.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2018-09-17T08:21:26.946+05:30")
@Document(indexName = "relationship", type = "account")
public class AccountRelationship   {

  @Id
  private String id;

  private String relationshipType = null;

  private TimePeriod validFor = null;

  private AccountRef account = null;

  public AccountRelationship relationshipType(String relationshipType) {
    this.relationshipType = relationshipType;
    return this;
  }

   /**
   * Type of relationship
   * @return relationshipType
  **/
  @ApiModelProperty(required = true, value = "Type of relationship")
  public String getRelationshipType() {
    return relationshipType;
  }

  public void setRelationshipType(String relationshipType) {
    this.relationshipType = relationshipType;
  }

  public AccountRelationship validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

   /**
   * Validity period of that relationship
   * @return validFor
  **/
  @ApiModelProperty(required = true, value = "Validity period of that relationship")
  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public AccountRelationship account(AccountRef account) {
    this.account = account;
    return this;
  }

   /**
   * Get account
   * @return account
  **/
  @ApiModelProperty(value = "")
  public AccountRef getAccount() {
    return account;
  }

  public void setAccount(AccountRef account) {
    this.account = account;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountRelationship accountRelationship = (AccountRelationship) o;
    return Objects.equals(this.relationshipType, accountRelationship.relationshipType) &&
        Objects.equals(this.validFor, accountRelationship.validFor) &&
        Objects.equals(this.account, accountRelationship.account);
  }

  @Override
  public int hashCode() {
    return Objects.hash(relationshipType, validFor, account);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountRelationship {\n");
    
    sb.append("    relationshipType: ").append(toIndentedString(relationshipType)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    account: ").append(toIndentedString(account)).append("\n");
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

