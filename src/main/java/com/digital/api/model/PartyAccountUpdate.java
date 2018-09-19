package com.digital.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;



/**
 * Account used for billing or for settlement purposes concerning a given party (an organization or an individual). Skipped properties: id,href,id,href,accountBalance
 **/

/**
 * Account used for billing or for settlement purposes concerning a given party (an organization or an individual). Skipped properties: id,href,id,href,accountBalance
 */
@ApiModel(description = "Account used for billing or for settlement purposes concerning a given party (an organization or an individual). Skipped properties: id,href,id,href,accountBalance")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2018-09-17T08:21:26.946+05:30")

public class PartyAccountUpdate   {
  private String baseType = null;

  private String schemaLocation = null;

  private String type = null;

  private Money creditLimit = null;

  private String description = null;

  private DateTime lastModified = null;

  private String name = null;

  private String state = null;

  private String paymentStatus = null;

  private BillStructure billStructure = null;

  private List<PaymentPlan> paymentPlan = new ArrayList<PaymentPlan>();

  private FinancialAccountRef financialAccount = null;

  private PaymentMethodRef defaultPaymentMethod = null;

  private List<RelatedPartyRef> relatedParty = new ArrayList<RelatedPartyRef>();

  private List<AccountTaxExemption> taxExemption = new ArrayList<AccountTaxExemption>();

  private List<Contact> contact = new ArrayList<Contact>();

  private List<AccountRelationship> accountRelationship = new ArrayList<AccountRelationship>();

  public PartyAccountUpdate baseType(String baseType) {
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

  public PartyAccountUpdate schemaLocation(String schemaLocation) {
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
  **/
  @ApiModelProperty(value = "Generic attribute containing the name of the resource class type")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public PartyAccountUpdate creditLimit(Money creditLimit) {
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

  public PartyAccountUpdate description(String description) {
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

  public PartyAccountUpdate lastModified(DateTime lastModified) {
    this.lastModified = lastModified;
    return this;
  }

   /**
   * Date of last modification of the account
   * @return lastModified
  **/
  @ApiModelProperty(value = "Date of last modification of the account")
  public DateTime getLastModified() {
    return lastModified;
  }

  public void setLastModified(DateTime lastModified) {
    this.lastModified = lastModified;
  }

  public PartyAccountUpdate name(String name) {
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

  public PartyAccountUpdate state(String state) {
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

  public PartyAccountUpdate type(String type) {
    this.type = type;
    return this;
  }

   /**
   * A categorization of an account, such as individual, joint, and so forth, whose instances share some of the same characteristics. Note: for flexibility we use a String here but an implementation may use an enumeration with a limited list of valid values.
   * @return type

  @ApiModelProperty(value = "A categorization of an account, such as individual, joint, and so forth, whose instances share some of the same characteristics. Note: for flexibility we use a String here but an implementation may use an enumeration with a limited list of valid values.")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
    **/
  public PartyAccountUpdate paymentStatus(String paymentStatus) {
    this.paymentStatus = paymentStatus;
    return this;
  }

   /**
   * The condition of the account, such as due, paid, in arrears.
   * @return paymentStatus
  **/
  @ApiModelProperty(value = "The condition of the account, such as due, paid, in arrears.")
  public String getPaymentStatus() {
    return paymentStatus;
  }

  public void setPaymentStatus(String paymentStatus) {
    this.paymentStatus = paymentStatus;
  }

  public PartyAccountUpdate billStructure(BillStructure billStructure) {
    this.billStructure = billStructure;
    return this;
  }

   /**
   * Get billStructure
   * @return billStructure
  **/
  @ApiModelProperty(value = "")
  public BillStructure getBillStructure() {
    return billStructure;
  }

  public void setBillStructure(BillStructure billStructure) {
    this.billStructure = billStructure;
  }

  public PartyAccountUpdate paymentPlan(List<PaymentPlan> paymentPlan) {
    this.paymentPlan = paymentPlan;
    return this;
  }

  public PartyAccountUpdate addPaymentPlanItem(PaymentPlan paymentPlanItem) {
    this.paymentPlan.add(paymentPlanItem);
    return this;
  }

   /**
   * Get paymentPlan
   * @return paymentPlan
  **/
  @ApiModelProperty(value = "")
  public List<PaymentPlan> getPaymentPlan() {
    return paymentPlan;
  }

  public void setPaymentPlan(List<PaymentPlan> paymentPlan) {
    this.paymentPlan = paymentPlan;
  }

  public PartyAccountUpdate financialAccount(FinancialAccountRef financialAccount) {
    this.financialAccount = financialAccount;
    return this;
  }

   /**
   * Get financialAccount
   * @return financialAccount
  **/
  @ApiModelProperty(value = "")
  public FinancialAccountRef getFinancialAccount() {
    return financialAccount;
  }

  public void setFinancialAccount(FinancialAccountRef financialAccount) {
    this.financialAccount = financialAccount;
  }

  public PartyAccountUpdate defaultPaymentMethod(PaymentMethodRef defaultPaymentMethod) {
    this.defaultPaymentMethod = defaultPaymentMethod;
    return this;
  }

   /**
   * Get defaultPaymentMethod
   * @return defaultPaymentMethod
  **/
  @ApiModelProperty(value = "")
  public PaymentMethodRef getDefaultPaymentMethod() {
    return defaultPaymentMethod;
  }

  public void setDefaultPaymentMethod(PaymentMethodRef defaultPaymentMethod) {
    this.defaultPaymentMethod = defaultPaymentMethod;
  }

  public PartyAccountUpdate relatedParty(List<RelatedPartyRef> relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  public PartyAccountUpdate addRelatedPartyItem(RelatedPartyRef relatedPartyItem) {
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

  public PartyAccountUpdate taxExemption(List<AccountTaxExemption> taxExemption) {
    this.taxExemption = taxExemption;
    return this;
  }

  public PartyAccountUpdate addTaxExemptionItem(AccountTaxExemption taxExemptionItem) {
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

  public PartyAccountUpdate contact(List<Contact> contact) {
    this.contact = contact;
    return this;
  }

  public PartyAccountUpdate addContactItem(Contact contactItem) {
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

  public PartyAccountUpdate accountRelationship(List<AccountRelationship> accountRelationship) {
    this.accountRelationship = accountRelationship;
    return this;
  }

  public PartyAccountUpdate addAccountRelationshipItem(AccountRelationship accountRelationshipItem) {
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
    PartyAccountUpdate partyAccountUpdate = (PartyAccountUpdate) o;
    return Objects.equals(this.baseType, partyAccountUpdate.baseType) &&
        Objects.equals(this.schemaLocation, partyAccountUpdate.schemaLocation) &&
        Objects.equals(this.type, partyAccountUpdate.type) &&
        Objects.equals(this.creditLimit, partyAccountUpdate.creditLimit) &&
        Objects.equals(this.description, partyAccountUpdate.description) &&
        Objects.equals(this.lastModified, partyAccountUpdate.lastModified) &&
        Objects.equals(this.name, partyAccountUpdate.name) &&
        Objects.equals(this.state, partyAccountUpdate.state) &&
        Objects.equals(this.type, partyAccountUpdate.type) &&
        Objects.equals(this.paymentStatus, partyAccountUpdate.paymentStatus) &&
        Objects.equals(this.billStructure, partyAccountUpdate.billStructure) &&
        Objects.equals(this.paymentPlan, partyAccountUpdate.paymentPlan) &&
        Objects.equals(this.financialAccount, partyAccountUpdate.financialAccount) &&
        Objects.equals(this.defaultPaymentMethod, partyAccountUpdate.defaultPaymentMethod) &&
        Objects.equals(this.relatedParty, partyAccountUpdate.relatedParty) &&
        Objects.equals(this.taxExemption, partyAccountUpdate.taxExemption) &&
        Objects.equals(this.contact, partyAccountUpdate.contact) &&
        Objects.equals(this.accountRelationship, partyAccountUpdate.accountRelationship);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, type, creditLimit, description, lastModified, name, state, type, paymentStatus, billStructure, paymentPlan, financialAccount, defaultPaymentMethod, relatedParty, taxExemption, contact, accountRelationship);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PartyAccountUpdate {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    creditLimit: ").append(toIndentedString(creditLimit)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    lastModified: ").append(toIndentedString(lastModified)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    paymentStatus: ").append(toIndentedString(paymentStatus)).append("\n");
    sb.append("    billStructure: ").append(toIndentedString(billStructure)).append("\n");
    sb.append("    paymentPlan: ").append(toIndentedString(paymentPlan)).append("\n");
    sb.append("    financialAccount: ").append(toIndentedString(financialAccount)).append("\n");
    sb.append("    defaultPaymentMethod: ").append(toIndentedString(defaultPaymentMethod)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
    sb.append("    taxExemption: ").append(toIndentedString(taxExemption)).append("\n");
    sb.append("    contact: ").append(toIndentedString(contact)).append("\n");
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

