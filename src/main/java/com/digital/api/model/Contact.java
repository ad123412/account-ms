package com.digital.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.ArrayList;
import java.util.List;



/**
 * An individual or an organization used as a contact point for a given account and accessed via some contact medium.
 **/

/**
 * An individual or an organization used as a contact point for a given account and accessed via some contact medium.
 */
@ApiModel(description = "An individual or an organization used as a contact point for a given account and accessed via some contact medium.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2018-09-17T08:21:26.946+05:30")
@Document(indexName = "account", type = "contact")
public class Contact   {

  @Id
  private String id;

  private String baseType = null;

  private String schemaLocation = null;

  private String type = null;

  private String contactName = null;

  private String contactType = null;

  private String partyRoleType = null;

  private TimePeriod validFor = null;

  private List<ContactMedium> contactMedium = new ArrayList<ContactMedium>();

  private RelatedPartyRef relatedParty = null;

  public Contact baseType(String baseType) {
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

  public Contact schemaLocation(String schemaLocation) {
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

  public Contact type(String type) {
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

  public Contact contactName(String contactName) {
    this.contactName = contactName;
    return this;
  }

   /**
   * A displayable name for that contact
   * @return contactName
  **/
  @ApiModelProperty(value = "A displayable name for that contact")
  public String getContactName() {
    return contactName;
  }

  public void setContactName(String contactName) {
    this.contactName = contactName;
  }

  public Contact contactType(String contactType) {
    this.contactType = contactType;
    return this;
  }

   /**
   * Type of contact (primary, secondary...)
   * @return contactType
  **/
  @ApiModelProperty(required = true, value = "Type of contact (primary, secondary...)")
  public String getContactType() {
    return contactType;
  }

  public void setContactType(String contactType) {
    this.contactType = contactType;
  }

  public Contact partyRoleType(String partyRoleType) {
    this.partyRoleType = partyRoleType;
    return this;
  }

   /**
   * Identifies what kind of party role type is linked to the contact (a account manager...)
   * @return partyRoleType
  **/
  @ApiModelProperty(value = "Identifies what kind of party role type is linked to the contact (a account manager...)")
  public String getPartyRoleType() {
    return partyRoleType;
  }

  public void setPartyRoleType(String partyRoleType) {
    this.partyRoleType = partyRoleType;
  }

  public Contact validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

   /**
   * Validity period of that contact
   * @return validFor
  **/
  @ApiModelProperty(required = true, value = "Validity period of that contact")
  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public Contact contactMedium(List<ContactMedium> contactMedium) {
    this.contactMedium = contactMedium;
    return this;
  }

  public Contact addContactMediumItem(ContactMedium contactMediumItem) {
    this.contactMedium.add(contactMediumItem);
    return this;
  }

   /**
   * Get contactMedium
   * @return contactMedium
  **/
  @ApiModelProperty(value = "")
  public List<ContactMedium> getContactMedium() {
    return contactMedium;
  }

  public void setContactMedium(List<ContactMedium> contactMedium) {
    this.contactMedium = contactMedium;
  }

  public Contact relatedParty(RelatedPartyRef relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

   /**
   * Get relatedParty
   * @return relatedParty
  **/
  @ApiModelProperty(value = "")
  public RelatedPartyRef getRelatedParty() {
    return relatedParty;
  }

  public void setRelatedParty(RelatedPartyRef relatedParty) {
    this.relatedParty = relatedParty;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Contact contact = (Contact) o;
    return Objects.equals(this.baseType, contact.baseType) &&
        Objects.equals(this.schemaLocation, contact.schemaLocation) &&
        Objects.equals(this.type, contact.type) &&
        Objects.equals(this.contactName, contact.contactName) &&
        Objects.equals(this.contactType, contact.contactType) &&
        Objects.equals(this.partyRoleType, contact.partyRoleType) &&
        Objects.equals(this.validFor, contact.validFor) &&
        Objects.equals(this.contactMedium, contact.contactMedium) &&
        Objects.equals(this.relatedParty, contact.relatedParty);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, type, contactName, contactType, partyRoleType, validFor, contactMedium, relatedParty);
  }

  @Override
  public String toString() {
    return "Contact{" +
            "id='" + id + '\'' +
            ", baseType='" + baseType + '\'' +
            ", schemaLocation='" + schemaLocation + '\'' +
            ", type='" + type + '\'' +
            ", contactName='" + contactName + '\'' +
            ", contactType='" + contactType + '\'' +
            ", partyRoleType='" + partyRoleType + '\'' +
            ", validFor=" + validFor +
            ", contactMedium=" + contactMedium +
            ", relatedParty=" + relatedParty +
            '}';
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

