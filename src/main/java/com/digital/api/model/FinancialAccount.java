package com.digital.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;


/**
 * An account of money owed by a party to another entity in exchange for goods or services that have been delivered or used. A financial (account receivable account/account payable) aggregates the amounts of one or more party accounts (billing or settlement) owned by a given party.
 **/

/**
 * An account of money owed by a party to another entity in exchange for goods or services that have been delivered or used. A financial (account receivable account/account payable) aggregates the amounts of one or more party accounts (billing or settlement) owned by a given party.
 */
@ApiModel(description = "An account of money owed by a party to another entity in exchange for goods or services that have been delivered or used. A financial (account receivable account/account payable) aggregates the amounts of one or more party accounts (billing or settlement) owned by a given party.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2018-09-17T08:21:26.946+05:30")
@Document(indexName = "financialaccount", type = "account")
public class FinancialAccount   {
  private String baseType = null;

  private String schemaLocation = null;

  private String type = null;

  private Money creditLimit = null;

  private String description = null;

  private String href = null;

  @Id
  private String id = null;

  private String lastModified = null;

  private String name = null;

  private String state = null;

  private List<RelatedPartyRef> relatedParty = new ArrayList<RelatedPartyRef>();

  private List<AccountTaxExemption> taxExemption = new ArrayList<AccountTaxExemption>();

  private List<Contact> contact = new ArrayList<Contact>();

  private List<AccountBalance> accountBalance = new ArrayList<AccountBalance>();

  private List<AccountRelationship> accountRelationship = new ArrayList<AccountRelationship>();

  public FinancialAccount baseType(String baseType) {
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

  public FinancialAccount schemaLocation(String schemaLocation) {
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
  public FinancialAccount creditLimit(Money creditLimit) {
    this.creditLimit = creditLimit;
    return this;
  }

   /**
   * The maximum amount of money that may be charged on an account
   * @return creditLimit
  **/
  @ApiModelProperty(value = "The maximum amount of money that may be charged on an account")
  public Money getCreditLimit() {
    return creditLimit;
  }

  public void setCreditLimit(Money creditLimit) {
    this.creditLimit = creditLimit;
  }

  public FinancialAccount description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Detailed description of the party account
   * @return description
  **/
  @ApiModelProperty(value = "Detailed description of the party account")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public FinancialAccount href(String href) {
    this.href = href;
    return this;
  }

   /**
   * Unique reference of the account
   * @return href
  **/
  @ApiModelProperty(value = "Unique reference of the account")
  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public FinancialAccount id(String id) {
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

  public FinancialAccount lastModified(String lastModified) {
    this.lastModified = lastModified;
    return this;
  }

   /**
   * Date of last modification of the account
   * @return lastModified
  **/
  @ApiModelProperty(value = "Date of last modification of the account")
  public String getLastModified() {
    return lastModified;
  }

  public void setLastModified(String lastModified) {
    this.lastModified = lastModified;
  }

  public FinancialAccount name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name of the account
   * @return name
  **/
  @ApiModelProperty(required = true, value = "Name of the account")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public FinancialAccount state(String state) {
    this.state = state;
    return this;
  }

   /**
   * Contains the lifecycle state such as: Active, Closed, Suspended and so on.
   * @return state
  **/
  @ApiModelProperty(value = "Contains the lifecycle state such as: Active, Closed, Suspended and so on.")
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public FinancialAccount type(String type) {
    this.type = type;
    return this;
  }

   /**
   * A categorization of an account, such as individual, joint, and so forth, whose instances share some of the same characteristics. Note: for flexibility we use a String here but an implementation may use an enumeration with a limited list of valid values.
   * @return type
  **/
  @ApiModelProperty(value = "A categorization of an account, such as individual, joint, and so forth, whose instances share some of the same characteristics. Note: for flexibility we use a String here but an implementation may use an enumeration with a limited list of valid values.")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public FinancialAccount relatedParty(List<RelatedPartyRef> relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  public FinancialAccount addRelatedPartyItem(RelatedPartyRef relatedPartyItem) {
    this.relatedParty.add(relatedPartyItem);
    return this;
  }

   /**
   * Get relatedParty
   * @return relatedParty
  **/
  @ApiModelProperty(value = "")
  public List<RelatedPartyRef> getRelatedParty() {
    return relatedParty;
  }

  public void setRelatedParty(List<RelatedPartyRef> relatedParty) {
    this.relatedParty = relatedParty;
  }

  public FinancialAccount taxExemption(List<AccountTaxExemption> taxExemption) {
    this.taxExemption = taxExemption;
    return this;
  }

  public FinancialAccount addTaxExemptionItem(AccountTaxExemption taxExemptionItem) {
    this.taxExemption.add(taxExemptionItem);
    return this;
  }

   /**
   * Get taxExemption
   * @return taxExemption
  **/
  @ApiModelProperty(value = "")
  public List<AccountTaxExemption> getTaxExemption() {
    return taxExemption;
  }

  public void setTaxExemption(List<AccountTaxExemption> taxExemption) {
    this.taxExemption = taxExemption;
  }

  public FinancialAccount contact(List<Contact> contact) {
    this.contact = contact;
    return this;
  }

  public FinancialAccount addContactItem(Contact contactItem) {
    this.contact.add(contactItem);
    return this;
  }

   /**
   * Get contact
   * @return contact
  **/
  @ApiModelProperty(value = "")
  public List<Contact> getContact() {
    return contact;
  }

  public void setContact(List<Contact> contact) {
    this.contact = contact;
  }

  public FinancialAccount accountBalance(List<AccountBalance> accountBalance) {
    this.accountBalance = accountBalance;
    return this;
  }

  public FinancialAccount addAccountBalanceItem(AccountBalance accountBalanceItem) {
    this.accountBalance.add(accountBalanceItem);
    return this;
  }

   /**
   * Get accountBalance
   * @return accountBalance
  **/
  @ApiModelProperty(value = "")
  public List<AccountBalance> getAccountBalance() {
    return accountBalance;
  }

  public void setAccountBalance(List<AccountBalance> accountBalance) {
    this.accountBalance = accountBalance;
  }

  public FinancialAccount accountRelationship(List<AccountRelationship> accountRelationship) {
    this.accountRelationship = accountRelationship;
    return this;
  }

  public FinancialAccount addAccountRelationshipItem(AccountRelationship accountRelationshipItem) {
    this.accountRelationship.add(accountRelationshipItem);
    return this;
  }

   /**
   * Get accountRelationship
   * @return accountRelationship
  **/
  @ApiModelProperty(value = "")
  public List<AccountRelationship> getAccountRelationship() {
    return accountRelationship;
  }

  public void setAccountRelationship(List<AccountRelationship> accountRelationship) {
    this.accountRelationship = accountRelationship;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FinancialAccount financialAccount = (FinancialAccount) o;
    return Objects.equals(this.baseType, financialAccount.baseType) &&
        Objects.equals(this.schemaLocation, financialAccount.schemaLocation) &&
        Objects.equals(this.type, financialAccount.type) &&
        Objects.equals(this.creditLimit, financialAccount.creditLimit) &&
        Objects.equals(this.description, financialAccount.description) &&
        Objects.equals(this.href, financialAccount.href) &&
        Objects.equals(this.id, financialAccount.id) &&
        Objects.equals(this.lastModified, financialAccount.lastModified) &&
        Objects.equals(this.name, financialAccount.name) &&
        Objects.equals(this.state, financialAccount.state) &&
        Objects.equals(this.type, financialAccount.type) &&
        Objects.equals(this.relatedParty, financialAccount.relatedParty) &&
        Objects.equals(this.taxExemption, financialAccount.taxExemption) &&
        Objects.equals(this.contact, financialAccount.contact) &&
        Objects.equals(this.accountBalance, financialAccount.accountBalance) &&
        Objects.equals(this.accountRelationship, financialAccount.accountRelationship);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, type, creditLimit, description, href, id, lastModified, name, state, type, relatedParty, taxExemption, contact, accountBalance, accountRelationship);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FinancialAccount {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    creditLimit: ").append(toIndentedString(creditLimit)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    lastModified: ").append(toIndentedString(lastModified)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
    sb.append("    taxExemption: ").append(toIndentedString(taxExemption)).append("\n");
    sb.append("    contact: ").append(toIndentedString(contact)).append("\n");
    sb.append("    accountBalance: ").append(toIndentedString(accountBalance)).append("\n");
    sb.append("    accountRelationship: ").append(toIndentedString(accountRelationship)).append("\n");
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

